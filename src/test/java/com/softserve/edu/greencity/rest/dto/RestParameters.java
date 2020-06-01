package com.softserve.edu.greencity.rest.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestParameters {
	private Map<KeyParameters, String> parameters;
	private Map<KeyParameters, List<String>> listParameters;

	public RestParameters() {
		parameters = new HashMap<>();
		listParameters = new HashMap<>();
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

	public String getParameter(KeyParameters key) {
		return parameters.get(key);
	}

	public List<String> getListParameter(KeyParameters key) {
		return listParameters.get(key);
	}

	public Map<KeyParameters, String> getAllParameters() {
		return parameters;
	}

	public Map<KeyParameters, List<String>> getAllListParameters() {
		return listParameters;
	}
}
