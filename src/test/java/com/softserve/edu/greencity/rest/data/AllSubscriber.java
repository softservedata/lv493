package com.softserve.edu.greencity.rest.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.softserve.edu.greencity.rest.entity.NewsSubscriberAllEntity;
import com.softserve.edu.greencity.rest.tools.Verifiable;

public class AllSubscriber implements Comparable<AllSubscriber>, Verifiable{
   
    private String email;
    private String unsubscribeToken;
 
    public AllSubscriber() {
        email = "";
        unsubscribeToken = "";
    }
    
    public AllSubscriber(String email, String unsubscribeToken){
        this.email = email;
        this.unsubscribeToken = unsubscribeToken;
    }
    
    //setters
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setUnsubscribeToken(String unsubscribeToken) {
        this.unsubscribeToken = unsubscribeToken;
    }
    
    //getters
    
    public String getEmail() {
        return email;
    }
    
    public String getUnsubscribeToken() {
        return unsubscribeToken;
    }
    
    @Override
    public int compareTo(AllSubscriber allSubscriber) {
        return getEmail().compareTo(allSubscriber.getEmail());
    }
    
    @Override
    public int hashCode() {
     final int prime = 31;
     int result = 1;
     result = prime * result + ((email == null) ? 0 : email.hashCode());
     result = prime * result + ((unsubscribeToken == null) ? 0 : unsubscribeToken.hashCode());
     return result;
    }
 
    @Override
    public boolean equals(Object obj) {
     if (this == obj) {
         return true;
     }
     if ((obj == null) || (getClass() != obj.getClass())) {
         return false;
     }
     AllSubscriber other = (AllSubscriber) obj;
     if (((email == null) && (other.email != null) 
             || (email != null) && (other.email == null))
             && (!email.equals(other.email))) {
         return false;
     }
     if (((unsubscribeToken == null) && (other.unsubscribeToken  != null) 
             || (unsubscribeToken != null) && (other.unsubscribeToken == null))
             && (!unsubscribeToken.equals(other.unsubscribeToken))) {
         return false;
     }
     return true;
 }
    
    @Override
    public String toString() {
        return "AllSubscriber [email=" + email 
                +" unsubscribeToken="+ unsubscribeToken +"]";
    }
    
    //static factory
    
    public static AllSubscriber converToAllSubscriber(NewsSubscriberAllEntity newsSubscriberAllEntity) {
        return new AllSubscriber(newsSubscriberAllEntity.getEmail(),newsSubscriberAllEntity.getUnsubscribeToken());
    }
    
    public static List<AllSubscriber> converToAllSubscriberList(List<NewsSubscriberAllEntity> newsSubscriberAllEntities) {
        List<AllSubscriber> result = new ArrayList<>();
        for(NewsSubscriberAllEntity newsSubscriberAllEntity : newsSubscriberAllEntities) {
            result.add(converToAllSubscriber(newsSubscriberAllEntity)); 
        }
        Collections.sort(result);
        return result;
    }
    
    @Override
    public boolean isValid() {
        return (email != null) && (unsubscribeToken != null);
    }
}
