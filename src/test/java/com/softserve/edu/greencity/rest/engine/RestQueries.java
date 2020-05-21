package com.softserve.edu.greencity.rest.engine;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.softserve.edu.greencity.rest.dto.MethodParameters;
import com.softserve.edu.greencity.rest.dto.RestUrl;
import com.softserve.edu.greencity.rest.entity.ErrorEntity;
import com.softserve.edu.greencity.rest.entity.LogginedUserEntity;
import com.softserve.edu.greencity.rest.entity.ResponseCodeEntity;


public abstract class RestQueries<TGET, TPOST, TPUT, TDELETE, TPATCH> extends RestCrud {
	private final String CONVERT_OBJECT_ERROR = "ConvertToObject Error. Service Returned\n%s";
	private final int HTTP_RESPONSE_CODE_300 = 300;
	//
	private Gson gson;

	protected RestQueries(RestUrl restUrl) {
		super(restUrl);
		gson = new Gson();
	}

	private void validateJson(String json) {
		System.out.println("***json = " + json);
		ResponseCodeEntity responseCodeEntity = convertToEntity(json, new TypeToken<ResponseCodeEntity>(){});
		System.out.println("***responseCodeEntity = " + responseCodeEntity);
		if (responseCodeEntity.getResponsecode() >= HTTP_RESPONSE_CODE_300) {
			ErrorEntity errorEntity = convertToEntity(json, new TypeToken<ErrorEntity>(){});
			throwException(CONVERT_OBJECT_ERROR, errorEntity.toString());
		}
	}
	
	private <T> T convertToEntity(String json, TypeToken<T> typeToken) {
		//return gson.fromJson(json, typeToken.getType());
		return gson.fromJson(json, typeToken.getType());
	}

	// Entity - - - - - - - - - - - - - - - - - - - -

	public TGET httpGetAsEntity(MethodParameters methodParameters) {
		String json = httpGetAsText(methodParameters);
		validateJson(json);
		return convertToEntity(json, new TypeToken<TGET>(){});
	}

	public LogginedUserEntity httpPostAsEntity(MethodParameters methodParameters) {
		String json = httpPostAsText(methodParameters);
		validateJson(json);
		//TPOST temp = convertToEntity(json, new TypeToken<TPOST>(){});
		LogginedUserEntity temp = gson.fromJson(json, LogginedUserEntity.class);
		System.out.println("***temp.class= " + temp.getClass());
		System.out.println("***temp= " + temp);
		//return convertToEntity(json, new TypeToken<TPOST>(){});
		return temp;
	}

	public TPUT httpPutAsEntity(MethodParameters methodParameters) {
		String json = httpPutAsText(methodParameters);
		validateJson(json);
		return convertToEntity(json, new TypeToken<TPUT>(){});
	}

	public TDELETE httpDeleteAsEntity(MethodParameters methodParameters) {
		String json = httpDeleteAsText(methodParameters);
		validateJson(json);
		return convertToEntity(json, new TypeToken<TDELETE>(){});
	}

	public TPATCH httpPatchAsEntity(MethodParameters methodParameters) {
		String json = httpPatchAsText(methodParameters);
		validateJson(json);
		return convertToEntity(json, new TypeToken<TPATCH>(){});
	}

	// List Entity - - - - - - - - - - - - - - - - - - - -

	protected List<TGET> httpGetAsListEntity(MethodParameters methodParameters) {
		String json = httpGetAsText(methodParameters);
		validateJson(json);
		return convertToEntity(json, new TypeToken<List<TGET>>(){});
	}
	
	 public List<TPOST> httpPostAsListEntity(MethodParameters methodParameters) {
			String json = httpPostAsText(methodParameters);
			validateJson(json);
			return convertToEntity(json, new TypeToken<List<TPOST>>(){});
		}
	 
	 public List<TPUT> httpPutAsListEntity(MethodParameters methodParameters) {
			String json = httpPutAsText(methodParameters);
			validateJson(json);
			return convertToEntity(json, new TypeToken<List<TPUT>>(){});
		}
	 
	 public List<TDELETE> httpDeleteAsListEntity(MethodParameters methodParameters) {
			String json = httpDeleteAsText(methodParameters);
			validateJson(json);
			return convertToEntity(json, new TypeToken<List<TDELETE>>(){});
		}
	 
	 public List<TPATCH> httpPatchAsListEntity(MethodParameters methodParameters) {
			String json = httpPatchAsText(methodParameters);
			validateJson(json);
			return convertToEntity(json, new TypeToken<List<TPATCH>>(){});
		}
}
