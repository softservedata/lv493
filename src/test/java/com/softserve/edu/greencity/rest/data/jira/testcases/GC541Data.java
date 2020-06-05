package com.softserve.edu.greencity.rest.data.jira.testcases;

import com.softserve.edu.greencity.rest.data.User;

/**
 * GC541Data class (Jira Story: SC-184/GC-468; Test GC-541).
 */
public class GC541Data {

    // user credentials
    private String email;
    private String userName;
    private String password;
    //
    // actual results
    private int responseCode; // TODO
    private String name;
    private String message;
    //
    // expected results
    public static final int EXPECTED_RESPONSE_CODE = 400;
    public static final String EXPECTED_NAME = "password";
    public static final String EXPECTED_MESSAGE = "Password has contain at least one character";

    //
    /**
     * Default constructor.
     */
    public GC541Data() {
        this.email = "";
        this.userName = "";
        this.password = "";
        this.responseCode = -1;
        this.name = "";
        this.message = "";
    }

    /**
     * Constructor.
     * @param user User
     */
    public GC541Data(User user) {
        this.email = user.getEmail();
        this.userName = user.getName();
        this.password = user.getPassword();
        this.responseCode = -1;
        this.name = "";
        this.message = "";
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

    public int getResponseCode() {
        return responseCode;
    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
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

    public GC541Data setResponseCode(int responseCode) {
        this.responseCode = responseCode;
        return this;
    }

    public GC541Data setName(String name) {
        this.name = name;
        return this;
    }

    public GC541Data setMessage(String message) {
        this.message = message;
        return this;
    }

    @Override
    public String toString() {
        return "GC541Data [email=" + email + ", userName=" + userName + ", password=" + password + "]\n"
                + "Actual results: name = " + name + "; message = " + message
                + "\nExpected results: name = " + EXPECTED_NAME + "; message = "
                + EXPECTED_MESSAGE;
    }

}
