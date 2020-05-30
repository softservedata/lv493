package com.softserve.edu.greencity.rest.data;

public enum IgnoreError401 {

    AUTHORIZE_FIRST("Authorize first.");

    private String message;

    private IgnoreError401(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}