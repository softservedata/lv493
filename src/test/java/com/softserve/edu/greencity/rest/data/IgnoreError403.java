package com.softserve.edu.greencity.rest.data;

public enum IgnoreError403 {

    VERIFY_EMAIL("You should verify the email first, check your email box!");

    private String message;

    private IgnoreError403(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}