package com.softserve.edu.greencity.rest.dto;

public enum KeyParameters {

	EMAIL("email"),
    PASSWORD("password"),
    CONFIRM_PASSWORD("confirmPassword"),
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
    FAVOURITE_PLACE_ID("placeId"),
	PLACE_STATUS("status"),
    CONTENT_TYPE("Content-Type"),

    //places
    
    DISCOUNT_DTO("discountDto"),
    DISCOUNT_MAX("discountMax"),
    DISCOUNT_MIN("discountMin"),
    SPECIFICATION("specification"),
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
    TIME("time"),
    //
    GOAL_ID("goalId"),
    IDS("ids"),
    FACT_ID("factId"),
    HABIT_ID("habitId"),
    HABIT_STATISTIC_ID("habitStatisticId"),
    AMOUNT_OF_ITEMS("amountOfItems"),
    HABIT_RATE("habitRate"),
    CREATED_ON("createdOn"),
    //
    UNSUBSCRIBE_TOKEN("unsubscribeToken");

    
    
    
    
    
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