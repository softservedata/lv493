package com.softserve.edu.greencity.ui.data;

public class User {

    private String email;
    private String password;
    private String firstname;
    
    public User(String email, String firstname, String password) {
        this.email = email;
        this.firstname = firstname;
        this.password = password;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;

    }

    // setter
    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    // getter
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
    public String getFirstname() {
        return firstname;
    }
    
    @Override
    public String toString() {
        return "User [email=" + email + ", password=" + password + "]";
    }

}
