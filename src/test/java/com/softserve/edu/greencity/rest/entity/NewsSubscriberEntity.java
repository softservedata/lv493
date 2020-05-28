package com.softserve.edu.greencity.rest.entity;



import com.softserve.edu.greencity.rest.tools.Verifaible;

public class NewsSubscriberEntity implements Verifaible {
    
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
        
//    @Override
//    public String toString() {
//        return "NewsSubscriberEntity [email=" + email +"]";
//    }
    
    @Override
  public String toString() {
  return email;
}
    
    @Override
     public boolean isValid() {
         return (email != null);
     }
    
    
}
