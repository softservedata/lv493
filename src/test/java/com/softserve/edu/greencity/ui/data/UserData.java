package com.softserve.edu.greencity.ui.data;
public final class UserData {

    private String email;
    private String password;
    private String firstName;
    private String lastName;

    public UserData() {
        initUserLoginCredentials();
    }

    public UserData(String firstName, String lastName, String email,
            String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    private void initUserLoginCredentials() {
        this.firstName = "John";
        this.lastName = "Wilson";
        this.email = "rjjztqsiayuieydfuy@awdrt.org";
        this.password = "A475asd123*";
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
