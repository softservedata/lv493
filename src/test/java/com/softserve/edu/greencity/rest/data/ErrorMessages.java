package com.softserve.edu.greencity.rest.data;


public class ErrorMessages {
    private String message;
 
    public ErrorMessages(String message){
        this.message = message;
        
    }
    
    // setters

    public void setMessage(String message) {
        this.message = message;
    }

    // getters

    public String getMessage() {
        return message;
    }
    
    
    @Override
    public String toString() {
        return "ErrorMessages [message=" + message + "]";
    }
  
}

