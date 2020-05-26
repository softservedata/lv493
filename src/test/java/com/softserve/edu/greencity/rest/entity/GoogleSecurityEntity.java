package com.softserve.edu.greencity.rest.entity;

public class GoogleSecurityEntity {

    private int id;
    private String name;
    private String accessToken;
    private String refreshToken;
    private boolean ownRegistrations;
    private String text;
    private String status;

    public GoogleSecurityEntity() {
        this.id = -1;
        this.name = "";
        this.accessToken = "";
        this.refreshToken = "";
        this.ownRegistrations = false;
    }
    
    public GoogleSecurityEntity(String text, String status) {
        this.id = -1;
        this.name = "";
        this.accessToken = "";
        this.refreshToken = "";
        this.ownRegistrations = false;
        this.text = text;
        this.status = status;
    }

    public GoogleSecurityEntity(int id, String name, String accessToken,
            String refreshToken, boolean ownRegistrations) {
        this.id = id;
        this.name = name;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.ownRegistrations = ownRegistrations;
    }


    @Override
    public String toString() {
        return "GoogleSecurityEntity [id=" + id + ", name=" + name
                + ", accessToken=" + accessToken + ", refreshToken="
                + refreshToken + ", ownRegistrations=" + ownRegistrations + "]";
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public boolean isOwnRegistrations() {
        return ownRegistrations;
    }

    public String getText() {
        return text;
    }

    public String getStatus() {
        return status;
    }

}
