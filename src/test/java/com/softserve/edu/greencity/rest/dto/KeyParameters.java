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
	SIZE("size"),
    ECO_NEWS_DTO("addEcoNewsDtoRequest"),
    IMAGE_PATH("imagePath"),
    SOURCE("source"),
    TEXT("text"),
    TITLE("title"),
    ECONEWS_ID("econewsId"),
    TAGS("tags"),
    ID("id"),
    PLACE_ID("placeId"),
    CONTENT_TYPE("Content-Type");



    private String key;

    private KeyParameters(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
    	return key;
    }
}
