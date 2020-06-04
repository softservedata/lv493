package com.softserve.edu.greencity.rest.data;

import java.util.ArrayList;
import java.util.List;

public class AllSubscriberRepository {
    private static AllSubscriberRepository instance = null;
    
    private List<String> email = new ArrayList<>();
    private List<String> unsubscribeToken = new ArrayList<>();
    
    private  AllSubscriberRepository() { 
    }
    
    public static AllSubscriberRepository get() {
        if (instance == null) {
            synchronized (AllSubscriberRepository.class) {
                if (instance == null) {
                    instance = new AllSubscriberRepository();
                }
            }
        }
        return instance;
    }
    
    public List<String> getEmail() {
        return email;
    }
    
    public List<String> getUnsubscribeToken() {
        return unsubscribeToken;
    }
    
    public void setEmail(List<String> email) {
       this.email = email;         
    }
    
    public void setUnsubscribeToken(List<String> unsubscribeToken) {
        this.unsubscribeToken = unsubscribeToken;
    }
    
    public void addSubscriber(String email, String unsubscribeToken) {
        this.email.add(email);
        this.unsubscribeToken.add(unsubscribeToken);
    }
   
     public  AllSubscriber getDefault() {
         return new AllSubscriber("aijkvh@jbuf.com", "2c4ef4ab-cb4e-4ef9-be1d-8f5c04f0b5c2");
     }
    public AllSubscriber random1() {
        return new AllSubscriber("2iv7ji5wfziwi1@test.com", "74ceeddb-8830-4581-b39a-f3e43922b593");
    }
}
