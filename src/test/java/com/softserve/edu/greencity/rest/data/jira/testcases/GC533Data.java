package com.softserve.edu.greencity.rest.data.jira.testcases;

import com.softserve.edu.greencity.rest.data.User;
import com.softserve.edu.greencity.rest.entity.RegisterUserEntity;

/**
 * GC533Data class (Jira Story: SC-184/GC-468; Test GC-533).
 */
public class GC533Data {

    /// user credentials
    private String email;
    private String userName;
    private String password;
    private int userId;
    //
    // actual results
    private int responseCode; // TODO
    private String message;
    private boolean ownRegistrations;
    private String httpsAfterVerify;
    //
    // expected results
    public static final int EXPECTED_RESPONSE_CODE = 401;
    public static final String EXPECTED_MESSAGE = "Bad email or password";

    //
    /**
     * Default constructor.
     */
    public GC533Data() {
        this.email = "";
        this.userName = "";
        this.password = "";
        this.responseCode = -1;
        this.message = "";
    }

    /**
     * Constructor.
     * @param user User
     */
    public GC533Data(User user) {
        this.email = user.getEmail();
        this.userName = user.getName();
        this.password = user.getPassword();
        this.responseCode = -1;
        this.message = "";
    }

    /**
     * Constructor.
     * @param registerUserEntity RegisterUserEntity
     */
    public GC533Data(RegisterUserEntity registerUserEntity) {
        this.userId = registerUserEntity.getUserId();
        this.email = registerUserEntity.getEmail();
        this.userName = registerUserEntity.getName();
        this.password = registerUserEntity.getPassword();
        this.responseCode = -1;
        this.message = registerUserEntity.getMessage();
        this.ownRegistrations = registerUserEntity.isOwnRegistrations();
        this.httpsAfterVerify = registerUserEntity.getHttpsAfterVerify();
    }
    
    /**
     * Constructor.
     * @param message String
     */
    public GC533Data(String message) {
        this.message = message;
    }

    // getters
    public String getEmail() {
        return email;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public int getUserId() {
        return userId;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public String getMessage() {
        return message;
    }

    public boolean isOwnRegistrations() {
        return ownRegistrations;
    }

    public String getHttpsAfterVerify() {
        return httpsAfterVerify;
    }

    // setters
    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setOwnRegistrations(boolean ownRegistrations) {
        this.ownRegistrations = ownRegistrations;
    }

    public void setHttpsAfterVerify(String httpsAfterVerify) {
        this.httpsAfterVerify = httpsAfterVerify;
    }

    @Override
    public String toString() {
        return "GC533Data [email=" + email + ", userName=" + userName + ", password=" + password + ", ownRegistrations="
                + ownRegistrations + "]";
    }

}
