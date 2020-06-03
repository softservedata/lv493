package com.softserve.edu.greencity.rest.entity;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.softserve.edu.greencity.rest.data.User;
import com.softserve.edu.greencity.ui.data.Languages;

public class RegisterUserEntity {

	private List<Error400Entity> error400Entity;
	//
    private int userId;
    private String email;
    private String lang;
    private String username;
    private String password;
    private boolean ownRegistrations;
    //
    private String name;
    private String message;
    //
    //private VerifyEmailLinkAndId verifyEmailLinkAndId;    
    //
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    //
//    public void setVerifyEmailLinkAndId(VerifyEmailLinkAndId verifyEmailLinkAndId) {
//        this.verifyEmailLinkAndId = verifyEmailLinkAndId;
//    }
    
//    public VerifyEmailLinkAndId getVerifyEmailLinkAndId() {
//        return verifyEmailLinkAndId;
//    }
    
    public RegisterUserEntity() {
        this.email = "";
        this.lang = "";
        this.username ="";
        this.password = "";
        this.name = "";
        this.message = "";
        this.error400Entity = null;
    }

    public RegisterUserEntity(Languages language, User userData) {
        this.email = "";
        this.lang = language.toString();
        this.username = userData.getName();
        this.password = userData.getPassword();
        this.name = "";
        this.message = "";
        this.error400Entity = null;
    }

    public RegisterUserEntity(int userId, String name, String email,
            boolean ownRegistrations) {
        this.userId = userId;
        this.email = email;
        this.username = name;
        this.ownRegistrations = ownRegistrations;
        this.name = "";
        this.message = "";
        this.error400Entity = null;
    }

    public RegisterUserEntity(String name, String email, String message) {
        this.userId = -1;
        this.email = email;
        this.username = "";
        this.ownRegistrations = false;
        this.name = name;
        this.message = message;
        this.error400Entity = null;
    }
    
    public RegisterUserEntity(String name, String message) {
        this.userId = -1;
        this.email = "";
        this.username = "";
        this.ownRegistrations = false;
        this.name = "";
        this.message = message;
        this.error400Entity = null;
    }

    public List<Error400Entity> getError400Entity() {
        return error400Entity;
    }

    public void setError400Entity(List<Error400Entity> error400Entity) {
    	this.error400Entity = error400Entity;
    }
    
    public int getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public String getLang() {
        return lang;
    }

    public String getUserName() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isOwnRegistrations() {
        return ownRegistrations;
    }

    
    @Override
    public String toString() {
        return "RegisterUserEntity [userId=" + userId + ", email=" + email
                + ", username=" + username + ", password=" + password
                + ", ownRegistrations=" + ownRegistrations
                + error400Entity + "]";
    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }
    
}