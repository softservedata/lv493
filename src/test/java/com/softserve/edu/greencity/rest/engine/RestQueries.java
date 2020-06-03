package com.softserve.edu.greencity.rest.engine;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.softserve.edu.greencity.rest.data.IgnoreError400;
import com.softserve.edu.greencity.rest.dto.MethodParameters;
import com.softserve.edu.greencity.rest.dto.RestHttpMethods;
import com.softserve.edu.greencity.rest.dto.RestUrl;
import com.softserve.edu.greencity.rest.entity.BaseEntity;
import com.softserve.edu.greencity.rest.entity.ErrorEntity;
import com.softserve.edu.greencity.rest.entity.ResponseCodeEntity;

public abstract class RestQueries<TGET, TPOST, TPUT, TDELETE, TPATCH> extends RestCrud {
	private final String CONVERT_OBJECT_ERROR = "ConvertToObject Error. Service Returned\n%s";
	private final int HTTP_RESPONSE_CODE_300 = 300;
	//
	// TODO Get Class<T> from <T>
	private Map<RestHttpMethods, Type> entityParameters;
	private Map<RestHttpMethods, Type> listEntityParameters;
	//
	private Gson gson;

	protected RestQueries(RestUrl restUrl) {
		super(restUrl);
		gson = new Gson();
		initParameters();
	}
	
	private void initParameters() {
		entityParameters = new HashMap<>();
		listEntityParameters = new HashMap<>();
		for (RestHttpMethods currentHttpMethod : RestHttpMethods.values()) {
			entityParameters.put(currentHttpMethod, null);
			listEntityParameters.put(currentHttpMethod, null);
		}
	}

	protected void addEntityParameters(RestHttpMethods httpMethod, Class<?> classValue) {
		entityParameters.put(httpMethod, classValue);
	}
	
	protected void addListEntityParameters(RestHttpMethods httpMethod, Type typeValue) {
		listEntityParameters.put(httpMethod, typeValue);
	}
	
	private boolean isIgnoreError(String json) {
		boolean result = false;
		if ((json != null) && (json.length() > 0)) {
			for (IgnoreError400 currentMassage : IgnoreError400.values()) {
				if (json.contains(currentMassage.toString())) {
					result = true;
					break;
				}
			}
		}
		return result;	
	}
	
	private void validateParameter(RestHttpMethods httpMethod, Map<RestHttpMethods, Type> parameter) {
		if (parameter.get(httpMethod) == null) {
			throwException(httpMethod.toString());
		}
	}
	
	private void validateJson(String json) {
		//System.out.println("***json = " + json);
		ResponseCodeEntity responseCodeEntity = null;
		if (json.charAt(0) == '{') {
			responseCodeEntity = convertToEntity(json, new TypeToken<ResponseCodeEntity>(){});
			//responseCodeEntity = convertToEntity(json, ResponseCodeEntity.class);
		} else {
			responseCodeEntity = convertToEntity(json, new TypeToken<List<ResponseCodeEntity>>(){}).get(0);
		}
		//System.out.println("***responseCodeEntity = " + responseCodeEntity);
		if ((!isIgnoreError(json)) 
				&& ((responseCodeEntity == null) || (responseCodeEntity.getResponsecode() >= HTTP_RESPONSE_CODE_300))) {
			int responseCode = (responseCodeEntity == null) ? 0 : responseCodeEntity.getResponsecode();
			ErrorEntity errorEntity = convertToEntity(json, new TypeToken<ErrorEntity>(){});
			//ErrorEntity errorEntity = convertToEntity(json, ErrorEntity.class);
			throwException(CONVERT_OBJECT_ERROR, errorEntity.toString(), responseCode);
		}
	}
	
//	private <T> T convertToEntity(String json, Class<T> clazz) {
//		return gson.fromJson(json, clazz);
//	}
	
	private <T> T convertToEntity(String json, Type type) {
		//return gson.fromJson(json, typeToken.getType());
		return gson.fromJson(json, type);
	}

	private <T> T convertToEntity(String json, TypeToken<T> typeToken) {
		//return gson.fromJson(json, typeToken.getType());
		return gson.fromJson(json, typeToken.getType());
	}

	// Entity - - - - - - - - - - - - - - - - - - - -

	public TGET httpGetAsEntity(MethodParameters methodParameters) {
		validateParameter(RestHttpMethods.GET, entityParameters);
		String json = httpGetAsText(methodParameters);
		validateJson(json);
		//return convertToEntity(json, new TypeToken<TGET>(){});
		//return convertToEntity(json, classTGET);
		return convertToEntity(json, entityParameters.get(RestHttpMethods.GET));
	}
	
	private String updateJson(String json) {
		if (json.contains("[") && json.contains("news")) {
			return "{\"base\":" + json + "}";
		} //else if () {}
		return json;
	}
	
	public TPOST httpPostAsEntity(MethodParameters methodParameters) {
		//validateParameter(RestHttpMethods.POST, entityParameters);
		//String json = httpPostAsText(methodParameters);
		//String json = "[{\"name\":\"password\",\"message\":\"mustnotbeblank\"},{\"name\":\"name\",\"message\":\"mustnotbeblank\"}]";
		//
		//		String json = "[{}]";
		//		json = "{\"error400Entity\":" + json + "}";
		//
		String json = "[\"news\",\"news2\",\"news3\"]";
		json = updateJson(json);
		//json = "{\"base\":" + json + "}";
		////validateJson(json);
		//return convertToEntity(json, classTPOST);
		////return convertToEntity(json, entityParameters.get(RestHttpMethods.POST));
		//
		//return convertToEntity(json, RegisterUserEntity.class);
		//return convertToEntity(json, new GenericConverter<List<String>>(){}.getGenericType());
		return convertToEntity(json, BaseEntity.class);
	}

	public TPUT httpPutAsEntity(MethodParameters methodParameters) {
		validateParameter(RestHttpMethods.PUT, entityParameters);
		String json = httpPutAsText(methodParameters);
		validateJson(json);
		//return convertToEntity(json, classTPUT);
		return convertToEntity(json, entityParameters.get(RestHttpMethods.PUT));
	}

	public TDELETE httpDeleteAsEntity(MethodParameters methodParameters) {
		validateParameter(RestHttpMethods.DELETE, entityParameters);
		String json = httpDeleteAsText(methodParameters);
		validateJson(json);
		//return convertToEntity(json, classTDELETE);
		return convertToEntity(json, entityParameters.get(RestHttpMethods.DELETE));
	}

	public TPATCH httpPatchAsEntity(MethodParameters methodParameters) {
		validateParameter(RestHttpMethods.PATCH, entityParameters);
		String json = httpPatchAsText(methodParameters);
		validateJson(json);
		//return convertToEntity(json, classTPATCH);
		return convertToEntity(json, entityParameters.get(RestHttpMethods.PATCH));
	}

	// List Entity - - - - - - - - - - - - - - - - - - - -

	public List<TGET> httpGetAsListEntity(MethodParameters methodParameters) {
		validateParameter(RestHttpMethods.GET, listEntityParameters);
		String json = httpGetAsText(methodParameters);
		//System.out.println("*** json GET:" + json);
		validateJson(json);
		//return convertToEntity(json, new TypeToken<List<?>>() {});
		//return convertToEntity(json, typeTGET);
		return convertToEntity(json, listEntityParameters.get(RestHttpMethods.GET));
	}

	public List<TPOST> httpPostAsListEntity(MethodParameters methodParameters) {
		validateParameter(RestHttpMethods.POST, listEntityParameters);
		String json = httpPostAsText(methodParameters);
		validateJson(json);
		//return convertToEntity(json, new TypeToken<List<TPOST>>() {});
		//return convertToEntity(json, typeTPOST);
		return convertToEntity(json, listEntityParameters.get(RestHttpMethods.POST));
	}

	public List<TPUT> httpPutAsListEntity(MethodParameters methodParameters) {
		validateParameter(RestHttpMethods.PUT, listEntityParameters);
		String json = httpPutAsText(methodParameters);
		validateJson(json);
		//return convertToEntity(json, new TypeToken<List<TPUT>>() {});
		//return convertToEntity(json, typeTDELETE);
		return convertToEntity(json, listEntityParameters.get(RestHttpMethods.PUT));
	}

	public List<TDELETE> httpDeleteAsListEntity(MethodParameters methodParameters) {
		validateParameter(RestHttpMethods.DELETE, listEntityParameters);
		String json = httpDeleteAsText(methodParameters);
		validateJson(json);
		//return convertToEntity(json, new TypeToken<List<TDELETE>>() {});
		//return convertToEntity(json, typeTDELETE);
		return convertToEntity(json, listEntityParameters.get(RestHttpMethods.DELETE));
	}

	public List<TPATCH> httpPatchAsListEntity(MethodParameters methodParameters) {
		validateParameter(RestHttpMethods.PATCH, listEntityParameters);
		String json = httpPatchAsText(methodParameters);
		validateJson(json);
		//return convertToEntity(json, new TypeToken<List<TPATCH>>() {});
		//return convertToEntity(json, typeTPATCH);
		return convertToEntity(json, listEntityParameters.get(RestHttpMethods.PATCH));
	}
}
