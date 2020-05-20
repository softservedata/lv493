package com.softserve.edu.greencity.rest.engine;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.softserve.edu.greencity.rest.dto.ContentTypes;
import com.softserve.edu.greencity.rest.dto.KeyParameters;
import com.softserve.edu.greencity.rest.dto.MethodParameters;
import com.softserve.edu.greencity.rest.dto.RestHttpMethods;
import com.softserve.edu.greencity.rest.dto.RestParameters;
import com.softserve.edu.greencity.rest.dto.RestUrl;

import okhttp3.FormBody;
import okhttp3.MediaType;
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

	protected void throwException(String prefix, String message) {
		String resourceName = this.getClass().getName();
		resourceName = resourceName.substring(resourceName.lastIndexOf(".") + 1);
		String resourceMessage = String.format(FOR_RESOURCE, resourceName);
		String exceptionMessage =  String.format(prefix, message) + resourceMessage;
		LOGGER.error(exceptionMessage);
		// TODO Develop Custom Exception
		throw new RuntimeException(exceptionMessage);
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

	private RequestBody prepareRequestBody(RestParameters bodyParameters) {
		FormBody.Builder formBodyBuilder = new FormBody.Builder();
		if (bodyParameters != null) {
			for (KeyParameters currentKey : bodyParameters.getAllParameters().keySet()) {
				formBodyBuilder.add(String.valueOf(currentKey), bodyParameters.getParameter(currentKey));
			}
		}
		return formBodyBuilder.build();
	}

	private RequestBody prepareRequestBodyMediaType(ContentTypes contentType, RestParameters mediaTypeParameters) {
		// TODO Use Serialization
		String json = "{";
		if (mediaTypeParameters != null) {
			for (KeyParameters currentKey : mediaTypeParameters.getAllParameters().keySet()) {
				json = json + "\"" + String.valueOf(currentKey) + "\":\"" 
						+ mediaTypeParameters.getParameter(currentKey) + "\",";
			}
			json = json.substring(0, json.length() -1) + "}";
			if (json.length() < 2) {
				throwException("prepareRequestBodyMediaType()");
			}
		}
		return RequestBody.create(MediaType.parse(contentType.toString()),json);
	}

	private RequestBody getFormBody(MethodParameters methodParameters) {
		return methodParameters.getContentType() != null
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
			responseText = "{" + "\"responsecode\":\"" + response.code() + "\","
					+ (responseText != null && responseText.length() > 0 ? responseText.substring(1)
							: "\"content\":\"null\"}");
		} catch (IOException e) {
			throwException(RESPONSEBODY_ERROR, e.toString());
		}
		return responseText;
	}

	// Http Get - - - - - - - - - - - - - - - - - - - -

	protected Response httpGetAsResponse(MethodParameters methodParameters) {
		checkImplementation(RestHttpMethods.GET);
		return executeRequest(prepareRequestBuilder(getRestUrl().readPostUrlByIndex(methodParameters.getIndex()),
				methodParameters.getPathVariables(),
				methodParameters.getUrlParameters())
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
