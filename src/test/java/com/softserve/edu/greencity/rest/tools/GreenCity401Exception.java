package com.softserve.edu.greencity.rest.tools;

public class GreenCity401Exception extends GreenCityCommonException {
    private static final long serialVersionUID = 1L;
    //
    private static final String AUTHENTICATION_401_EXCEPTION_MESSAGE = "Authorize first.";
    //

    public GreenCity401Exception() {
        super();
    }

    public GreenCity401Exception(Exception e) {
        super(e);
    }

    public GreenCity401Exception(String message) {
        super(message);
    }

    public GreenCity401Exception(String message, Exception e) {
        super(message, e);
    }
}
