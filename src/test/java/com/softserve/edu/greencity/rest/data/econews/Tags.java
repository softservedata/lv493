package com.softserve.edu.greencity.rest.data.econews;

public enum Tags {
    NEWS("news"),
    EVENTS("events"),
    EDUCATION("education"),
    INITIATIVES("initiatives"),
    ADS("ads");

    private String tags;

    private Tags(String tag) {
        this.tags = tag;
    }

    @Override
    public String toString() {
        return tags;
    }
}
