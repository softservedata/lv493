package com.softserve.edu.greencity.rest.entity;

public class NewsSubscriberEntity  {
    
    private String email;
    private String message;
    
    public NewsSubscriberEntity() {
    email = "";
}
    public NewsSubscriberEntity(String email) {
        this.email = email;  
        
    }
   
    public NewsSubscriberEntity(String email, String message) {
		
		this.email = email;
		this.message = message;
	}
	public String getMessage() {
		return message;
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
