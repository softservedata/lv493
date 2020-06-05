package com.softserve.edu.greencity.rest.data;

import java.util.ArrayList;
import java.util.List;

import com.softserve.edu.greencity.rest.entity.VerifyEmailEntity;

/**
 * VerifyEmail class for supporter VerifyEmailEntity (verify email by email token).
 */
public class VerifyEmail {

    private String text;
    private String status;
    
    /**
     * Constructor
     * @param text String
     * @param status String
     */
    public VerifyEmail(String text, String status) {
        this.text = text;
        this.status = status;
    }

    // setters
    /**
     * Setter a 'text' field.
     * @param text String
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Setter a 'status' field.
     * @param status String
     */
    public void setStatus(String status) {
        this.status = status;
    }
    
    // getters
    /**
     * Getter a 'text' field.
     * @return String
     */
    public String getText() {
        return text;
    }
    
    /**
     * Getter a 'status' field.
     * @return String
     */
    public String getStatus() {
        return status;
    }
    
// static factory
    
    /**
     * converToVerifyEmail() method witch creates a VerifyEmail instance.
     * @param verifyEmailEntity
     * @return VerifyEmail
     */
    public static VerifyEmail converToVerifyEmail(VerifyEmailEntity verifyEmailEntity) {
        return new VerifyEmail(verifyEmailEntity.getMessage(), verifyEmailEntity.getStatus());
    }
    
    /**
     * converToVerifyEmailList() witch create a list of VerifyEmail instances.
     * @param verifyEmailEntities
     * @return List<VerifyEmail>
     */
    public static List<VerifyEmail> converToVerifyEmailList(List<VerifyEmailEntity> verifyEmailEntities) {
        List<VerifyEmail> result = new ArrayList<>();
        for (VerifyEmailEntity verifyEmailEntity : verifyEmailEntities) {
            result.add(converToVerifyEmail(verifyEmailEntity));
        }
        return result;
    }
}
