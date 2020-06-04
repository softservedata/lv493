package com.softserve.edu.greencity.rest.data;

public enum IgnoreError403 {

    MESSAGE("message"),
    FORBIDDEN ("You don't have authorities.");

    private String message;

    private IgnoreError403(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
