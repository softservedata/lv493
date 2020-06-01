package com.softserve.edu.greencity.rest.entity;

/**
 * UserDtoEntity class. Get User dto by principal (email) from access token
 */
public class UserDtoEntity {

    private String name;
    private String emailNotification;

    /**
     * Default constructor.
     */
    public UserDtoEntity() {
        this.name = "";
        this.emailNotification = "";
    }

    /**
     * Constructor.
     * @param name String
     * @param emailNotification String
     */
    public UserDtoEntity(String name, String emailNotification) {
        this.name = name;
        this.emailNotification = emailNotification;
    }

    public String getName() {
        return name;
    }

    public String getEmailNotification() {
        return emailNotification;
    }

    @Override
    public String toString() {
        return "UserDtoEntity [name=" + name + ", emailNotification=" + emailNotification + "]";
    }

}
