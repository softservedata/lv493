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
    ECO_NEWS_DTO("addEcoNewsDtoRequest"),
    IMAGE_PATH("imagePath"),
    SOURCE("source"),
    TAGS("tags"),
    TEXT("text"),
    TITLE("title"),
    BEARER("Bearer "),
    //
    DISCOUNT_DTO("discountDto"),
    DISCOUNT_MAX("discountMax"),
    DISCOUNT_MIN("discountMin"),
    SPECIFICATION("specification"),
    //NAME("name"),
    DISTANCE_FROM_USER_DTO("distanceFromUserDto"),
    DISTANCE("distance"),
    LAT("lat"),
    LNG("lng"),
    MAP_BOUNDS_DTO("mapBoundsDto"),
    NORTH_EAST_LAT("northEastLat"),
    NORTH_EAST_LNG("northEastLng"),
    SOUTH_WEST_LAT("southWestLat"),
    SOUTH_WEST_LNG("southWestLng"),
    SEARCH_REG("searchReg"),
    STATUS("status"),
    TIME("time");

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
