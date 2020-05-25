package com.softserve.edu.greencity.rest.tools;

public class GreenCity404Exception extends GreenCityCommonException {
	private static final long serialVersionUID = 1L;

	public GreenCity404Exception() {
		super();
	}

	public GreenCity404Exception(Exception e) {
		super(e);
	}
	
	public GreenCity404Exception(String message) {
		super(message);
	}
	
	public GreenCity404Exception(String message, Exception e) {
		super(message, e);
	}
}
