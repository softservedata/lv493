package com.softserve.edu.greencity.rest.dto;

import java.util.HashMap;
import java.util.Map;

public class RestParameters {
	private Map<KeyParameters, String> parameters;

	public RestParameters() {
		parameters = new HashMap<>();
	}

	public RestParameters addParameter(KeyParameters key, String value) {
		parameters.put(key, value);
		return this;
	}

	public String getParameter(KeyParameters key) {
		return parameters.get(key);
	}

	public Map<KeyParameters, String> getAllParameters() {
		return parameters;
	}
}
