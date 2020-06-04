package com.softserve.edu.greencity.rest.entity;

public class NewsSubscriberUnsubscribeEntity {
    private int number;
   
    public NewsSubscriberUnsubscribeEntity() {
        number = -1;
       
    }

    public NewsSubscriberUnsubscribeEntity(int number) {
        this.number = number;
      
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "NewsSubscriberUnsubscribeEntity [number= " + number + "]";
    }
}
