package com.softserve.edu.greencity.rest.tools;

public class GreenCityCommonException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public GreenCityCommonException() {
		super();
	}

	public GreenCityCommonException(Exception e) {
		super(e);
	}
	
	public GreenCityCommonException(String message) {
		super(message);
	}
	
	public GreenCityCommonException(String message, Exception e) {
		super(message, e);
	}
	
}
