package com.softserve.edu.greencity.rest.data.jira.testcases;

import com.softserve.edu.greencity.rest.entity.RegisterUserEntity;

public class GC531Data {

    // user credentials
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
    public static final int EXPECTED_RESPONSE_CODE = 201;
    public static final String EXPECTED_NAME = "Yuriy";
    public static final String EXPECTED_PASSWORD = "12345Awerty_";
    public static final String EXPECTED_URL_AFTER_VERIFY = "/#/welcome";
    public static final boolean EXPECTED_OWNREGISTRATIONS = true;

    //
    public GC531Data() {
        this.userId = -1;
        this.email = "";
        this.userName = "";
        this.password = "";
        this.responseCode = -1;
        this.message = "";
        this.ownRegistrations = false;
        this.httpsAfterVerify = "";
    }

    public GC531Data(RegisterUserEntity registerUserEntity) {
        this.userId = registerUserEntity.getUserId();
        this.email = registerUserEntity.getEmail();
        this.userName = registerUserEntity.getName();
        this.password = registerUserEntity.getPassword();
        this.responseCode = -1;
        this.message = registerUserEntity.getMessage();
        this.ownRegistrations = registerUserEntity.isOwnRegistrations();
        this.httpsAfterVerify = registerUserEntity.getHttpsAfterVerify();
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

    public boolean isOwnRegistrations() {
        return ownRegistrations;
    }

    public int getUserId() {
        return userId;
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

    public void setOwnRegistrations(boolean ownRegistrations) {
        this.ownRegistrations = ownRegistrations;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setHttpsAfterVerify(String httpsAfterVerify) {
        this.httpsAfterVerify = httpsAfterVerify;
    }

    @Override
    public String toString() {
        return "GC531Data [email=" + email + ", userName=" + userName + ", password=" + password + ", userId=" + userId
                + ", ownRegistrations=" + ownRegistrations + "]";
    }

}
