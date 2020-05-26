package com.softserve.edu.greencity.rest.dto;

public enum KeyParameters {

	EMAIL("email"),
    PASSWORD("password"),
    ACCEPT("accept"),
    AUTHORIZATION("Authorization"),
    LANGUAGE("language"),
    LANG("lang"),
    USER_ID("userId"),
    ECONEWS_ID("econewsId"),
    NAME("name"),
    BEARER("Bearer "),
    IMAGE_PATH("imagePath"),
    SOURCE("source"),
    TAGS("tags"),
    TEXT("text"),
    TITLE("title"),
    ADD_ECONEWS_DTO_REQUEST("addEcoNewsDtoRequest"),
    FILE("file"),
    IMAGE("image"),
    MEDIA_TYPE("MediaType"),
    SIZE("size"),
    PAGE("page"),
    TYPE("type"),
    ID("id");;

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
