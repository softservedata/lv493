package com.softserve.edu.greencity.rest.data;

/**
 * Enum class for getting User dto by principal (email) from access token
 * (Notification witch working now for the only condition).
 */
public enum EmailNotification {

    DISABLED("DISABLED");

    private String status;

    private EmailNotification(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return status;
    }

}
