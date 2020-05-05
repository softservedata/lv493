package com.softserve.edu.greencity.ui.data;

/**
 * UserData class.
 * @author Serg
 */
public final class UserData {

    private String email;
    private String password;
    private String firstName;
    private String lastName;

    /**
     * UserData constructor.
     * @param email
     * @param password
     */
    public UserData(String email, String password) {
        this.firstName = "";
        this.lastName = "";
        this.email = email;
        this.password = password;
    }

    /**
     * UserData constructor.
     * @param firstName
     * @param lastName
     * @param email
     * @param password
     */
    public UserData(String firstName, String lastName, String email,
            String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    /**
     * getEmail
     * @return String email
     */
    public String getEmail() {
        return email;
    }

    /**
     * getPassword
     * @return String password
     */
    public String getPassword() {
        return password;
    }

    /**
     * getFirstName
     * @return String firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * getLastName
     * @return String lastName
     */
    public String getLastName() {
        return lastName;
    }

}
