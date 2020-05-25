package com.softserve.edu.greencity.rest.data;

public class UserSubscriber {
    private String email;
    private String status;
    
    public UserSubscriber(String email, String status){
        this.email = email;
        this.status = status;
    }
    
    // setters

    public void setText(String email) {
        this.email = email;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }

    // getters

    public String getText() {
        return email;
    }

    public String getStatus() {
        return status;
    }

    
    //public static UserSubscriber
    //public String getSubscribeEmail() {
        
        
//    }
}
