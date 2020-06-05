package com.softserve.edu.greencity.rest.entity;

public class NewsSubscriberUnsubscribeEntity {
    private int number;
    private String message;
   
    public NewsSubscriberUnsubscribeEntity() {
        number = -1;
        message = "";
       
    }

    public NewsSubscriberUnsubscribeEntity(int number) {
        this.number = number;
      
    }
    public NewsSubscriberUnsubscribeEntity(String  message) {
        this. message =  message;     
    }

    public int getNumber() {
        return number;
    }
    
    public String getMessage() {
        return message;
    }
    @Override
    public String toString() {
        return "NewsSubscriberUnsubscribeEntity [number= " + number + "message= " + message + "]";
    }
}
