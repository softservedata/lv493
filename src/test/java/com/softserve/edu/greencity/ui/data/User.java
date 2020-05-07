package com.softserve.edu.greencity.ui.data;

public class User {
    //
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    
    public User(String email, String password) {
        this.email = email;
        this.firstName = "";
        this.lastName = "";
        this.password = password;
    }

    public User(String email, String firstname, String password) {
        this.email = email;
        this.firstName = firstname;
        this.lastName = "";
        this.password = password;
    }

    public User(String firstName, String lastName, String email,
            String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    // setters

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstname) {
        this.firstName = firstname;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // getters

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

}
