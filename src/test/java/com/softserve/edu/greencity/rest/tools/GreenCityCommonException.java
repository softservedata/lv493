package com.softserve.edu.greencity.rest.tools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GreenCityCommonException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	//
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

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
