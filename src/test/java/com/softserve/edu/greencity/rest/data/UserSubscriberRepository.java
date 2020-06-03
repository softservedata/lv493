package com.softserve.edu.greencity.rest.data;

public class UserSubscriberRepository {

    private UserSubscriberRepository() {  
    }
    

    public UserSubscriber getDefault() {
        return  getSingleEmail();
    }
    
    public static UserSubscriber getSingleEmail() {
        return new UserSubscriber("cakecake25@cake.com");
        
    }
    
    public static UserSubscriber getRandomEmail() {
        return new UserSubscriber();
        
    }
    
    public static UserSubscriber getFaultyEmail() {
        return new UserSubscriber("cake45.com");
    }
}
