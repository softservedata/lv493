package com.softserve.edu.greencity.rest.data;

import java.util.ArrayList;
import java.util.List;

import com.softserve.edu.greencity.rest.entity.GoogleSecurityEntity;

/**
 * GoogleSecurity class for supporter GoogleSecurityEntity (authentication by Google).
 */
public class GoogleSecurity {

    private String text;
    private String status;
    
    /**
     * Constructor.
     * @param text String
     * @param status String
     */
    public GoogleSecurity(String text, String status) {
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
     * converToGoogleSecurity() method witch creates a GoogleSecurity instance.
     * @param googleSecurityEntity
     * @return GoogleSecurity
     */
    public static GoogleSecurity converToGoogleSecurity(GoogleSecurityEntity googleSecurityEntity) {
        return new GoogleSecurity(googleSecurityEntity.getText(), googleSecurityEntity.getStatus());
    }
    
    /**
     * converToGoogleSecurityList() witch create a list of GoogleSecurity instances.
     * @param googleSecurityEntities
     * @return List<GoogleSecurity>
     */
    public static List<GoogleSecurity> converToGoogleSecurityList(List<GoogleSecurityEntity> googleSecurityEntities) {
        List<GoogleSecurity> result = new ArrayList<>();
        for (GoogleSecurityEntity googleSecurityEntity : googleSecurityEntities) {
            result.add(converToGoogleSecurity(googleSecurityEntity));
        }
        return result;
    }
}
