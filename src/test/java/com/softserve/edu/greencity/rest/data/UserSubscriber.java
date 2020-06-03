package com.softserve.edu.greencity.rest.data;

import com.softserve.edu.greencity.rest.tools.EmailRandom;

public class UserSubscriber {

    private String email;
    EmailRandom emailRendom = new EmailRandom();
    
    public UserSubscriber(){
        this.email = generateEmail();
        
    }
    public UserSubscriber(String email){
        this.email = email;
        
    }
    
    // setters

    public void setEmail(String email) {
        this.email = email;
    }

    // getters

    public String getEmail() {
        return email;
    }
    

    public String generateEmail() {
        email = emailRendom.getEmailRandom();
        return email;
    }
    
    @Override
    public String toString() {
        return "UserSubscriber [email=" + email + "]";
    }
}
