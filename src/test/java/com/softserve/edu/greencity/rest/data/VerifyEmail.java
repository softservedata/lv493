package com.softserve.edu.greencity.rest.data;

import java.util.ArrayList;
import java.util.List;

import com.softserve.edu.greencity.rest.entity.VerifyEmailEntity;

public class VerifyEmail {

    private String text;
    private String status;
    
    public VerifyEmail(String text, String status) {
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
    
    public static VerifyEmail converToVerifyEmail(VerifyEmailEntity verifyEmailEntity) {
        return new VerifyEmail(verifyEmailEntity.getMessage(), verifyEmailEntity.getStatus());
    }
    
    public static List<VerifyEmail> converToGoogleSecurityList(List<VerifyEmailEntity> verifyEmailEntities) {
        List<VerifyEmail> result = new ArrayList<>();
        for (VerifyEmailEntity verifyEmailEntity : verifyEmailEntities) {
            result.add(converToVerifyEmail(verifyEmailEntity));
        }
        return result;
    }
}
