package com.softserve.edu.greencity.rest.entity;

public class VerifyEmailEntity {

    private String message;
    private String status;
    private String token;
    private String user_id;

    public VerifyEmailEntity() {
        this.message = "";
        this.status = "";
        this.token = "";
        this.user_id = "";
    }

    public VerifyEmailEntity(String text) {
        this.message = text;
        this.status = "";
        this.token = "";
        this.user_id = "";
    }
    
    public VerifyEmailEntity(String token, String user_id) {
        this.message = "";
        this.status = "";
        this.token = token;
        this.user_id = user_id;
    }
    
    

    public VerifyEmailEntity(String message, String status, String token, String user_id) {
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

    public String getUser_id() {
        return user_id;
    }

    @Override
    public String toString() {
        return "VerifyEmailEntity [text=" + message + ", status=" + status + ", token=" + token + ", user_id=" + user_id + "]";
    }

}
