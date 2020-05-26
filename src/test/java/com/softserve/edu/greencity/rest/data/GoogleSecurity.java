package com.softserve.edu.greencity.rest.data;

import java.util.ArrayList;
import java.util.List;

import com.softserve.edu.greencity.rest.entity.GoogleSecurityEntity;

public class GoogleSecurity {

    private String text;
    private String status;
    
    public GoogleSecurity(String text, String status) {
        this.text = text;
        this.status = status;
    }

    // setters
    public void setText(String text) {
        this.text = text;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    // getters
    public String getText() {
        return text;
    }
    
    public String getStatus() {
        return status;
    }
    
// static factory
    
    public static GoogleSecurity converToGoogleSecurity(GoogleSecurityEntity googleSecurityEntity) {
        return new GoogleSecurity(googleSecurityEntity.getText(), googleSecurityEntity.getStatus());
    }
    
    public static List<GoogleSecurity> converToGoogleSecurityList(List<GoogleSecurityEntity> googleSecurityEntities) {
        List<GoogleSecurity> result = new ArrayList<>();
        for (GoogleSecurityEntity googleSecurityEntity : googleSecurityEntities) {
            result.add(converToGoogleSecurity(googleSecurityEntity));
        }
        return result;
    }
}
