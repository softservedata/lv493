package com.softserve.edu.greencity.rest.entity;

/**
 * VerifyEmail entity class.
 */
public class VerifyEmailEntity {

    private String message;
    private String status;
    private String token;
    private int user_id;

    /**
     * Default constructor.
     */
    public VerifyEmailEntity() {
        this.message = "";
        this.status = "";
        this.token = "";
        this.user_id = -1;
    }

    /**
     * Constructor.
     * @param text String
     */
    public VerifyEmailEntity(String text) {
        this.message = text;
        this.status = "";
        this.token = "";
        this.user_id = -1;
    }

    /**
     * Constructor.
     * @param token String
     * @param user_id int
     */
    public VerifyEmailEntity(String token, int user_id) {
        this.message = "";
        this.status = "";
        this.token = token;
        this.user_id = user_id;
    }

    /**
     * Constructor.
     * @param message String
     * @param status String
     * @param token String
     * @param user_id int
     */
    public VerifyEmailEntity(String message, String status, String token, int user_id) {
        this.message = message;
        this.status = status;
        this.token = token;
        this.user_id = user_id;
    }

    public String getMessage() {
        return message;
    }

    public String getStatus() {
        return status;
    }

    public String getToken() {
        return token;
    }

    public int getUser_id() {
        return user_id;
    }

    @Override
    public String toString() {
        return "VerifyEmailEntity [text=" + message + ", status=" + status + ", token=" + token + ", user_id=" + user_id + "]";
    }

}
