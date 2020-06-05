package com.softserve.edu.greencity.rest.entity;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.softserve.edu.greencity.rest.data.User;
import com.softserve.edu.greencity.rest.data.VerifyEmailLinkAndId;
import com.softserve.edu.greencity.rest.data.jira.testcases.GC532Data;
import com.softserve.edu.greencity.ui.data.Languages;

/**
 * Register User entity class.
 */
public class RegisterUserEntity {

    // base response fields
    private int userId;
    private String name;
    private String email;
    private boolean ownRegistrations;
    // helpful fields
    private String lang;
    private String username;
    private String password;
    private String message;
    private int response;
    private String httpsAfterVerify;
    //
    private List<GC532Data> resultGC532Data;
    //
    private VerifyEmailLinkAndId verifyEmailLinkAndId;
    //
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * Constructor.
     * @param resultGC532DataList List<GC532Data>
     */
    public RegisterUserEntity(List<GC532Data> resultGC532DataList) {
        this.email = "";
        this.lang = "";
        this.username = "";
        this.password = "";
        this.name = "";
        this.message = "";
        this.resultGC532Data = resultGC532DataList;
    }

    /**
     * Default constructor.
     */
    public RegisterUserEntity() {
        this.email = "";
        this.lang = "";
        this.username = "";
        this.password = "";
        this.name = "";
        this.message = "";
        this.resultGC532Data = new ArrayList<>();
    }

    /**
     * Constructor.
     * @param language Languages enum.
     * @param userData User
     */
    public RegisterUserEntity(Languages language, User userData) {
        this.email = "";
        this.lang = language.toString();
        this.username = userData.getName();
        this.password = userData.getPassword();
        this.name = "";
        this.message = "";
        this.resultGC532Data = new ArrayList<>();
    }

    /**
     * Constructor.
     * @param userId int
     * @param name String
     * @param email String
     * @param ownRegistrations boolean
     */
    public RegisterUserEntity(int userId, String name, String email, boolean ownRegistrations) {
        this.userId = userId;
        this.email = email;
        this.username = name;
        this.ownRegistrations = ownRegistrations;
        this.name = "";
        this.message = "";
        this.resultGC532Data = new ArrayList<>();
    }

    /**
     * Constructor.
     * @param name String
     * @param email String
     * @param message String
     */
    public RegisterUserEntity(String name, String email, String message) {
        this.userId = -1;
        this.email = email;
        this.username = "";
        this.ownRegistrations = false;
        this.name = name;
        this.message = message;
        this.resultGC532Data = new ArrayList<>();
    }

    /**
     * Constructor.
     * @param message String
     */
    public RegisterUserEntity(String message) {
        this.email = "";
        this.userId = -1;
        this.lang = "";
        this.username = "";
        this.password = "";
        this.ownRegistrations = false;
        this.name = "";
        this.message = message;
        this.resultGC532Data = new ArrayList<>();
    }

    //
    public void setVerifyEmailLinkAndId(VerifyEmailLinkAndId verifyEmailLinkAndId) {
        this.verifyEmailLinkAndId = verifyEmailLinkAndId;
    }
    
    public void setHttpsAfterVerify(String httpsAfterVerify) {
        this.httpsAfterVerify = httpsAfterVerify;
    }
    
    //
    public List<GC532Data> getGC532DataList() {
        return resultGC532Data;
    }
    public VerifyEmailLinkAndId getVerifyEmailLinkAndId() {
        return verifyEmailLinkAndId;
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

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }

    public String getUsername() {
        return username;
    }

    public int getResponse() {
        return response;
    }

    public String getHttpsAfterVerify() {
        return httpsAfterVerify;
    }

    @Override
    public String toString() {
        return "RegisterUserEntity [userId=" + userId + ", email=" + email + ", username=" + username + ", password=" + password
                + ", ownRegistrations=" + ownRegistrations + "]";
    }


}
