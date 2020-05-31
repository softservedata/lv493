package com.softserve.edu.greencity.rest.tools;

public class GreenCity403Exception extends GreenCityCommonException {
    private static final long serialVersionUID = 1L;
    //
    private static final String SOME_403_EXCEPTION_MESSAGE = "message";
    //

    public GreenCity403Exception() {
        super();
    }

    public GreenCity403Exception(Exception e) {
        super(e);
    }

    public GreenCity403Exception(String message) {
        super(message);
    }

    public GreenCity403Exception(String message, Exception e) {
        super(message, e);
    }
}
