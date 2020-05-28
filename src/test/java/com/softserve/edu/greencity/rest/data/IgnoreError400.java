package com.softserve.edu.greencity.rest.data;

public enum IgnoreError400 {
   EXIST_EMAIL ("Subscriber with this email address exists in the database."),
   INVALID_EMAIL ("непрвильно сформована email адреса");
    
    
    private String message;
    
    private IgnoreError400(String message) {
        this.message = message;
    }
    
    @Override
    public String toString() {
        return message;
    }
           
}
