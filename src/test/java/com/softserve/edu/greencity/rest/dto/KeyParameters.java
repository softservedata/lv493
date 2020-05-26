package com.softserve.edu.greencity.rest.dto;

public enum KeyParameters {

	EMAIL("email"),
    PASSWORD("password"),
    ACCEPT("accept"),
    AUTHORIZATION("Authorization"),
    LANGUAGE("language"),
    LANG("lang"),
    ID_TOKEN("idToken"),
    TOKEN("token"),
    USER_ID("userId"),
    USER_ID2("user_id"),
    NAME("name"),
    BEARER("Bearer "),
    PAGE("page"),
	SIZE("size");

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
