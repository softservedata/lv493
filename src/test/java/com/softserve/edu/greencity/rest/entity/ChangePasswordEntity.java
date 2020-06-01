package com.softserve.edu.greencity.rest.entity;

public class ChangePasswordEntity {
    private String confirmPassword;
    private String password;
    private String token;

    public ChangePasswordEntity(String confirmPassword, String password, String token) {
        this.confirmPassword = confirmPassword;
        this.password = password;
        this.token = token;
    }

    public ChangePasswordEntity() {
        this.confirmPassword = "";
        this.password = "";
        this.token = "";
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
