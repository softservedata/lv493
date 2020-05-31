package com.softserve.edu.greencity.rest.data;

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
