package com.softserve.edu.greencity.rest.entity;

public class NewsSubscriberAllEntity {
    //admin
      private String email;
      private String unsubscribeToken;
   
      public NewsSubscriberAllEntity() {
          email = "";
          unsubscribeToken = "";
      }
      
      public NewsSubscriberAllEntity(String email, String unsubscribeToken){
          this.email = email;
          this.unsubscribeToken = unsubscribeToken;
      }
      
      public String getEmail() {
          return email;
      }
      
      public String getUnsubscribeToken() {
          return unsubscribeToken;
      }
      
      public void setEmail(String email) {
          this.email = email;
      }
      
      public void setUnsubscribeToken(String unsubscribeToken) {
          this.unsubscribeToken = unsubscribeToken;
      }
      
      @Override
      public String toString() {
          return "NewsSubscriberAllEntity [email=" + email 
                  +"unsubscribeToken="+ unsubscribeToken +"]";
      }
      
  }
