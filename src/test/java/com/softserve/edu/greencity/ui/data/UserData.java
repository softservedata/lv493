package com.softserve.edu.greencity.ui.data;

/**
 * UserData class.
 * @author Serg
 *
 */
public final class UserData {

    private String email;
    private String password;
    private String firstName;
    private String lastName;

    public UserData(String email, String password) {
        this.email = email;
        this.password = password;
    }
    
    public UserData(String firstName, String lastName, String email,
            String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

}
