package com.softserve.edu.greencity.rest.entity;

public class VerifyEmailEntity {

    private String text;
    private String status;
    private String token;
    private String user_id;

    public VerifyEmailEntity() {
        this.text = "";
        this.status = "";
        this.token = "";
        this.user_id = "";
    }

    public VerifyEmailEntity(String text) {
        this.text = text;
        this.status = "";
        this.token = "";
        this.user_id = "";
    }
    
    public VerifyEmailEntity(String token, String user_id) {
        this.text = "";
        this.status = "";
        this.token = token;
        this.user_id = user_id;
    }

    public String getText() {
        return text;
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
        return "VerifyEmailEntity [text=" + text + ", status=" + status + ", token=" + token + ", user_id=" + user_id + "]";
    }

}
