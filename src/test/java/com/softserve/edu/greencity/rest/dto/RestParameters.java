package com.softserve.edu.greencity.rest.dto;

import java.util.HashMap;
import java.util.Map;

import com.softserve.edu.greencity.rest.data.IgnoreError400;


public class RestParameters {
	private Map<KeyParameters, String> parameters;
	private Map<IgnoreError400, String> messages;

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
	
	 public RestParameters addMessage(IgnoreError400 message, String value){
	     messages.put(message, value);
	     return this;
	 }
	 
	 public String getMessage(IgnoreError400 message) {
	     return messages.get(message);
	 }
	 
	 public Map<IgnoreError400, String> getAllMessage() {
	     return messages;
	 }
}
