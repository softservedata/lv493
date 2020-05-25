package com.softserve.edu.greencity.rest.entity;

public class SubscribeEntity {
    private String email;
    public SubscribeEntity() {
    email = "";
}
    public SubscribeEntity(String email) {
        this.email = email;
        
    }
   
    public String getEmail() {
        return email;
    }
    
    
}
