package com.softserve.edu.greencity.rest.dto;

public enum KeyParameters {

	EMAIL("email"),
    PASSWORD("password"),
    NAME("name"),

    ACCEPT("accept"),
    AUTHORIZATION("Authorization"),

    BEARER("Bearer "),

    LANGUAGE("language"),
    LANG("lang"),
    ECO_NEWS_DTO("addEcoNewsDtoRequest"),

    USER_ID("userId"),
    GOAL_ID("goalId"),
    IDS("ids"),
    FACT_ID("factId"),
    HABIT_ID("habitId"),
    HABIT_STATISTIC_ID("habitStatisticId"),
    ID("id"),
    AMOUNT_OF_ITEMS("amountOfItems"),
    HABIT_RATE("habitRate"),
    CREATED_ON("createdOn")

    ;

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
