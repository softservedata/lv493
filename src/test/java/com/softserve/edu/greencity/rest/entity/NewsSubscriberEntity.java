package com.softserve.edu.greencity.rest.entity;

public class NewsSubscriberEntity  {
    
    private String email;
    
    public NewsSubscriberEntity() {
    email = "";
}
    public NewsSubscriberEntity(String email) {
        this.email = email;  
    }
   
    public String getEmail() {
        return email;
    }
        
    @Override
    public String toString() {
        return "NewsSubscriberEntity [email=" + email +"]";
    }
    
//    @Override
//  public String toString() {
//  return email;
//}
    

    
    
}
