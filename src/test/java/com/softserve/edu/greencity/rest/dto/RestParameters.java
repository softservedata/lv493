package com.softserve.edu.greencity.rest.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestParameters {
	private Map<KeyParameters, String> parameters;
	private Map<KeyParameters, List<String>> listParameters;
	private Map<KeyParameters, Object> objectParameters;
	private List<Map<KeyParameters, Object>> stackKeys;
	private String directJson;

	public RestParameters() {
		parameters = new HashMap<>();
		listParameters = new HashMap<>();
		objectParameters = new HashMap<>();
		stackKeys = new ArrayList<>();
		stackKeys.add(objectParameters);
		directJson = null;
	}

	public RestParameters addParameter(KeyParameters key, String value) {
		parameters.put(key, value);
		return this;
	}

	public RestParameters addListParameter(KeyParameters key, String value) {
		List<String> list = listParameters.get(key);
		if (list == null) {
			list = new ArrayList<>();
			list.add(value);
			listParameters.put(key, list);
		} else {
			list.add(value);
		}
		return this;
	}

	public RestParameters addObjectParameter(KeyParameters key, Object value) {
		stackKeys.get(0).put(key, value);
		return this;
	}

	public RestParameters addObjectListParameter() {
		//stackKeys.get(0).put(key, listParameters);
		Map<KeyParameters, Object> currentMap;
		if (stackKeys.size() == 0) {
			currentMap = objectParameters;
		} else {
			currentMap = stackKeys.get(0);
		}
		for (KeyParameters currentKey : listParameters.keySet()) {
			currentMap.put(currentKey, listParameters.get(currentKey));
		}
		return this;
	}
	
	public RestParameters addNewObjectParameter(KeyParameters key) {
		Map<KeyParameters, Object> newMap = new HashMap<>();
		Map<KeyParameters, Object> currentMap;
		if (stackKeys.size() == 0) {
			currentMap = objectParameters;
		} else {
			currentMap = stackKeys.get(0);
		}
		//stackKeys.get(0).put(key, newMap);
		currentMap.put(key, newMap);
		stackKeys.add(0, newMap);
		return this;
	}

	public RestParameters buildCurrentObjectParameter() {
		stackKeys.remove(0);
		return this;
	}
	
	public RestParameters addDirectJsonParameter(String directJson) {
		this.directJson = directJson;
		return this;
	}
	
	public String getParameter(KeyParameters key) {
		return parameters.get(key);
	}

	public List<String> getListParameter(KeyParameters key) {
		return listParameters.get(key);
	}

	@SuppressWarnings("unchecked")
	public Object getObjectParameter(KeyParameters... keys) {
		Object result = objectParameters;
		for (int i = 0; i < keys.length; i++) {
			if (result instanceof Map) {
				result = ((Map<KeyParameters, Object>) result).get(keys[i]);
			} else {
				result = null;
				break;
			}
		}
		return result;
	}

	public Map<KeyParameters, String> getAllParameters() {
		return parameters;
	}

	public Map<KeyParameters, List<String>> getAllListParameters() {
		return listParameters;
	}

	public Map<KeyParameters, Object> getObjectParameters() {
		return objectParameters;
	}

	public String getDirectJsonParameter() {
		return directJson;
	}
}
