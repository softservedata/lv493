package com.softserve.edu.greencity.rest.engine;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.softserve.edu.greencity.rest.dto.ContentTypes;
import com.softserve.edu.greencity.rest.dto.KeyParameters;
import com.softserve.edu.greencity.rest.dto.MethodParameters;
import com.softserve.edu.greencity.rest.dto.RestHttpMethods;
import com.softserve.edu.greencity.rest.dto.RestParameters;
import com.softserve.edu.greencity.rest.dto.RestUrl;
import com.softserve.edu.greencity.rest.tools.GreenCity400Exception;
import com.softserve.edu.greencity.rest.tools.GreenCity404Exception;
import com.softserve.edu.greencity.rest.tools.GreenCityCommonException;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public abstract class RestCrud {
    protected final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    private final String NOT_SUPPORT_MESSAGE = "Method %s not Support";
    private final String FOR_RESOURCE = " for %s Resource";
    private final String EMPTY_PARAMETER = "Empty Parameter %s";
    private final String EXECUTE_REQUEST_ERROR = "Execute Request Error %s";
    private final String RESPONSEBODY_ERROR = "Error to get text from ResponseBody %s";
    //
    private final String URL_PARAMETERS_SEPARATOR = "?";
    private final String NEXT_PARAMETERS_SEPARATOR = "&";
    private final String KEY_VALUE_SEPARATOR = "=";
    //
    private RestUrl restUrl;
    private OkHttpClient client;

    public RestCrud(RestUrl restUrl) {
        this.restUrl = restUrl;
        client = new OkHttpClient();
    }

    protected RestUrl getRestUrl() {
        return restUrl;
    }

    // protected - - - - - - - - - - - - - - - - - - - -
    protected void throwException(String prefix, String message, int responseCode) {
        String resourceName = this.getClass().getName();
        resourceName = resourceName.substring(resourceName.lastIndexOf(".") + 1);
        String resourceMessage = String.format(FOR_RESOURCE, resourceName);
        String exceptionMessage =  String.format(prefix, message) + resourceMessage;
        LOGGER.error(exceptionMessage);
        // TODO Add Custom Exception
        switch (responseCode) {
            case 0: throw new GreenCityCommonException(exceptionMessage);
            case 400: throw new GreenCity400Exception(exceptionMessage);
            case 404: throw new GreenCity404Exception(exceptionMessage);
            default: throw new GreenCityCommonException(exceptionMessage);
        }
    }
    
    protected void throwException(String prefix, String message) {
        throwException(NOT_SUPPORT_MESSAGE, message, 0);
    }
    
    protected void throwException(String message) {
        throwException(NOT_SUPPORT_MESSAGE, message);
    }

    protected void checkImplementation(RestHttpMethods restUrlKeys) {
        // if (restUrl.GetUrl(restUrlKeys).Length == 0)
        // TODO check List size
        String methodUri = getRestUrl().getUrl(restUrlKeys);
        if ((methodUri == null) || (methodUri.isEmpty())) {
            throwException(restUrlKeys.name());
        }
    }

    // Parameters - - - - - - - - - - - - - - - - - - - -

    // TODO Use class HttpUrl
    private String prepareUrlParameters(String urlTemplate, RestParameters urlParameters) {
        if (urlParameters != null) {
            boolean isFirstParameter = true;
            for (KeyParameters currentKey : urlParameters.getAllParameters().keySet()) {
                if (isFirstParameter) {
                    urlTemplate = urlTemplate + URL_PARAMETERS_SEPARATOR;
                    isFirstParameter = false;
                } else {
                    urlTemplate = urlTemplate + NEXT_PARAMETERS_SEPARATOR;
                }
                urlTemplate = urlTemplate + currentKey + KEY_VALUE_SEPARATOR + urlParameters.getParameter(currentKey);
            }
        }
        return urlTemplate;
    }

    private String preparePathVariables(String urlTemplate, RestParameters pathVariables) {
        String url = urlTemplate;
        if (pathVariables != null) {
            String searchVariable;
            for (KeyParameters currentKey : pathVariables.getAllParameters().keySet()) {
                // TODO Create Const "{", "}"
                searchVariable = "{" + currentKey.toString() + "}";
                if (url.contains(searchVariable)) {
                    // TODO Move to RegexUtils
                    //url = url.replaceFirst(Pattern.quote(searchVariable), pathVariables.getParameter(currentKey));
                    url = url.replace(searchVariable, pathVariables.getParameter(currentKey));
                }
            }
        }
        return url;
    }

    private String prepareJson(RestParameters parameters) {
        // TODO Use Serialization from Entity
        String json = "{";
        if (parameters != null) {
            for (KeyParameters currentKey : parameters.getAllParameters().keySet()) {
                json = json + "\"" + String.valueOf(currentKey) + "\":\"" 
                        + parameters.getParameter(currentKey) + "\",";
            }
            if (json.length() == 1) {
                json = json + "}";
            }
            json = json.substring(0, json.length() -1) + "}";
            if (json.length() < 2) { // TODO
                throwException("prepareJson()");
            }
        }
        return json;
    }
    
    private RequestBody prepareRequestMultipartBody(ContentTypes contentType, FileUploadParameters fileUploadParameters, 
            KeyParameters formDataPartKey, RestParameters formDataPartParameters) {
        if (formDataPartKey == null) {
            throwException(EMPTY_PARAMETER, "formDataPartKey");
        }
        return new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart(fileUploadParameters.getName(),
                        fileUploadParameters.getFilename(),
                        RequestBody.create(MediaType.parse(contentType.toString()),
                                new File(fileUploadParameters.getFilepath())))
                .addFormDataPart(formDataPartKey.toString(), prepareJson(formDataPartParameters)).build();
    }
    
    private RequestBody prepareRequestBodyMediaType(ContentTypes contentType, RestParameters mediaTypeParameters) {
        return RequestBody.create(MediaType.parse(contentType.toString()), prepareJson(mediaTypeParameters));
    }
    
    private RequestBody prepareRequestBody(RestParameters bodyParameters) {
        FormBody.Builder formBodyBuilder = new FormBody.Builder();
        if (bodyParameters != null) {
            for (KeyParameters currentKey : bodyParameters.getAllParameters().keySet()) {
                formBodyBuilder.add(String.valueOf(currentKey), bodyParameters.getParameter(currentKey));
            }
        }
        return formBodyBuilder.build();
    }

    private RequestBody getFormBody(MethodParameters methodParameters) {
        return methodParameters.getFileUploadParameters() != null
                ? prepareRequestMultipartBody(
                        methodParameters.getContentType(),
                        methodParameters.getFileUploadParameters(),
                        methodParameters.getFormDataPartKey(),
                        methodParameters.getFormDataPartParameters())
                : methodParameters.getContentType() != null
                       ? prepareRequestBodyMediaType(methodParameters.getContentType(), methodParameters.getMediaTypeParameters())
                       : prepareRequestBody(methodParameters.getBodyParameters());
    }
    
    private Request.Builder prepareHeader(Request.Builder builder, RestParameters headerParameters) {
        if (headerParameters != null) {
            for (KeyParameters currentKey : headerParameters.getAllParameters().keySet()) {
                builder.header(String.valueOf(currentKey), headerParameters.getParameter(currentKey));
            }
        }
        return builder;
    }
    
    // Request - - - - - - - - - - - - - - - - - - - -

    private Request.Builder prepareRequestBuilder(String requestUrl, RestParameters pathVariables,
            RestParameters urlParameters) {
        if ((requestUrl == null) || (requestUrl.isEmpty())) {
            throwException(EMPTY_PARAMETER, "requestUrl of method prepareRequestBuilder()");
        }
        String url = preparePathVariables(requestUrl, pathVariables);
        url = prepareUrlParameters(url, urlParameters);
        return new Request.Builder().url(url);
    }

    private Response executeRequest(Request request) {
        Response result = null;
        try {
            result = client.newCall(request).execute();
        } catch (IOException e) {
            throwException(EXECUTE_REQUEST_ERROR, request.toString());
        }
        return result;
    }

    private String responseBodyAsText(Response response) {
        String responseText = null;
        try {
            responseText = response.body().string();
        } catch (IOException e) {
            throwException(RESPONSEBODY_ERROR, e.toString());
        }
//      responseText = "{" + "\"responsecode\":\"" + response.code() + "\","
//              + (responseText != null && responseText.length() > 0 ? responseText.substring(1)
//                      : "\"content\":\"null\"}");
        responseText =(responseText != null) && (responseText.length() > 0) && responseText.contains("{")
                ? responseText.replace("{", "{" + "\"responsecode\":\"" + response.code() + "\",")
                : "{" + "\"responsecode\":\"" + response.code() + "\"}";
        return responseText;
    }

    // Http Get - - - - - - - - - - - - - - - - - - - -

    protected Response httpGetAsResponse(MethodParameters methodParameters) {
        checkImplementation(RestHttpMethods.GET);
        return executeRequest(prepareHeader(
                prepareRequestBuilder(getRestUrl().readGetUrlByIndex(methodParameters.getIndex()),
                        methodParameters.getPathVariables(),
                        methodParameters.getUrlParameters()),
                    methodParameters.getHeaderParameters())
                .get().build());
    }

    protected String httpGetAsText(MethodParameters methodParameters) {
        return responseBodyAsText(httpGetAsResponse(methodParameters));
    }

    // Http Post - - - - - - - - - - - - - - - - - - - -

    protected Response httpPostAsResponse(MethodParameters methodParameters) {
        checkImplementation(RestHttpMethods.POST);
        return executeRequest(prepareHeader(
                prepareRequestBuilder(getRestUrl().readPostUrlByIndex(methodParameters.getIndex()),
                    methodParameters.getPathVariables(),
                    methodParameters.getUrlParameters()),
                methodParameters.getHeaderParameters())
            .post(getFormBody(methodParameters)).build());
    }

    protected String httpPostAsText(MethodParameters methodParameters) {
        return responseBodyAsText(httpPostAsResponse(methodParameters));
    }

    // Http Put - - - - - - - - - - - - - - - - - - - -

    protected Response httpPutAsResponse(MethodParameters methodParameters) {
        checkImplementation(RestHttpMethods.PUT);
        return executeRequest(prepareHeader(
                prepareRequestBuilder(getRestUrl().readPutUrlByIndex(methodParameters.getIndex()),
                    methodParameters.getPathVariables(),
                    methodParameters.getUrlParameters()),
                methodParameters.getHeaderParameters())
            .put(getFormBody(methodParameters)).build());
    }

    protected String httpPutAsText(MethodParameters methodParameters) {
        return responseBodyAsText(httpPutAsResponse(methodParameters));
    }

    // Http Delete - - - - - - - - - - - - - - - - - - - -

    protected Response httpDeleteAsResponse(MethodParameters methodParameters) {
        checkImplementation(RestHttpMethods.DELETE);
        return executeRequest(prepareHeader(
                prepareRequestBuilder(getRestUrl().readDeleteUrlByIndex(methodParameters.getIndex()),
                    methodParameters.getPathVariables(),
                    methodParameters.getUrlParameters()),
                methodParameters.getHeaderParameters())
            .delete(getFormBody(methodParameters)).build());
    }

    protected String httpDeleteAsText(MethodParameters methodParameters) {
        return responseBodyAsText(httpDeleteAsResponse(methodParameters));
    }

    // Http Patch - - - - - - - - - - - - - - - - - - - -

    protected Response httpPatchAsResponse(MethodParameters methodParameters) {
        checkImplementation(RestHttpMethods.PATCH);
        return executeRequest(prepareHeader(
                prepareRequestBuilder(getRestUrl().readPatchUrlByIndex(methodParameters.getIndex()),
                    methodParameters.getPathVariables(),
                    methodParameters.getUrlParameters()),
                methodParameters.getHeaderParameters())
            .patch(getFormBody(methodParameters)).build());
    }

    protected String httpPatchAsText(MethodParameters methodParameters) {
        return responseBodyAsText(httpPatchAsResponse(methodParameters));
    }

}