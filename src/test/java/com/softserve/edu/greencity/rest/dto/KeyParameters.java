package com.softserve.edu.greencity.rest.dto;

public enum KeyParameters {

	EMAIL("email"),
    PASSWORD("password"),
    ACCEPT("accept"),
    AUTHORIZATION("Authorization"),
    LANGUAGE("language"),
    LANG("lang"),
    USER_ID("userId"),
    NAME("name"),
    BEARER("Bearer ");

    private String key;

    private KeyParameters(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        //return String.valueOf(key);
    	return key;
    }
}
