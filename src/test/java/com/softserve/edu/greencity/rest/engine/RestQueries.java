package com.softserve.edu.greencity.rest.engine;

import com.google.gson.Gson;
import com.softserve.edu.greencity.rest.dto.MethodParameters;
import com.softserve.edu.greencity.rest.dto.RestUrl;
import com.softserve.edu.greencity.rest.entity.ResponseCodeEntity;


public abstract class RestQueries<TGET, TPOST, TPUT, TDELETE, TPATCH> extends RestCrud {
	// private final String CONVERT_OBJECT_ERROR = "ConvertToObject Error. %s\n%s";
	//
	// TODO Move Converter to class
	private Class<TGET> classTGET;
	private Class<TPOST> classTPOST;
	private Class<TPUT> classTPUT;
	private Class<TDELETE> classTDELETE;
	private Class<TPATCH> classTPATCH;
	private Gson gson;

	protected RestQueries(RestUrl restUrl, Class<TGET> classTGET,
			Class<TPOST> classTPOST, Class<TPUT> classTPUT,
			Class<TDELETE> classTDELETE, Class<TPATCH> classTPATCH) {
		super(restUrl);
		// TODO Get Class<T> from <T>
		this.classTGET = classTGET;
		this.classTPOST = classTPOST;
		this.classTPUT = classTPUT;
		this.classTDELETE = classTDELETE;
		this.classTPATCH = classTPATCH;
		gson = new Gson();
	}

	private boolean validateJson(String json) {
		ResponseCodeEntity responseCodeEntity = convertToEntity(json, ResponseCodeEntity.class);
		return responseCodeEntity.getResponsecode() < 300;
	}
	
	private <T> T convertToEntity(String json, Class<T> classT) {
		return gson.fromJson(json, classT);
	}

	// Entity - - - - - - - - - - - - - - - - - - - -

	protected TGET httpGetAsEntity(MethodParameters methodParameters) {
		return convertToEntity(httpGetAsText(methodParameters), classTGET);
	}

	protected TPOST httpPostAsEntity(MethodParameters methodParameters) {
		return convertToEntity(httpPostAsText(methodParameters), classTPOST);
	}

	protected TPUT httpPutAsEntity(MethodParameters methodParameters) {
		return convertToEntity(httpPutAsText(methodParameters), classTPUT);
	}

	protected TDELETE httpDeleteAsEntity(MethodParameters methodParameters) {
		return convertToEntity(httpDeleteAsText(methodParameters), classTDELETE);
	}

	protected TPATCH httpPatchAsEntity(MethodParameters methodParameters) {
		return convertToEntity(httpPatchAsText(methodParameters), classTPATCH);
	}

	// List Entity - - - - - - - - - - - - - - - - - - - -

	// TODO
	// public List<TGET> httpGetAsObject(MethodParameters methodParameters)
	// public List<TPOST> httpPostAsObject(MethodParameters methodParameters)
	// public List<TPUT> httpPutAsObject(MethodParameters methodParameters)
	// public List<TDELETE> httpDeleteAsObject(MethodParameters methodParameters)
	// public List<TPATCH> httpPatchAsObject(MethodParameters methodParameters)
}
