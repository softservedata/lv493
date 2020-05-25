package com.softserve.edu.greencity.rest.tools;

public class GreenCity400Exception extends GreenCityCommonException {
	private static final long serialVersionUID = 1L;

	public GreenCity400Exception() {
		super();
	}

	public GreenCity400Exception(Exception e) {
		super(e);
	}
	
	public GreenCity400Exception(String message) {
		super(message);
	}
	
	public GreenCity400Exception(String message, Exception e) {
		super(message, e);
	}
}
