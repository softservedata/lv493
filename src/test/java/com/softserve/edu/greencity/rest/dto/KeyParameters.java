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
    IMAGE("image"),
    TAGS("tags"),
    ID("id"),
	ADVICE_ID("adviceId"),
    PLACE_ID("id"),
	PLACE_STATUS("status"),
    HABIT_ID("habitId"),
    CONTENT_TYPE("Content-Type"),
    
    //places
    DISCOUNT_DTO("discountDto"),
    DISTANCE_FROM_USER_DTO ("distanceFromUserDto"),
    MAP_BOUNDS_DTO ("mapBoundsDto"),
    SEARCH_REG ("searchReg"),
    STATUS ("status"),
    TIME ("time");


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
