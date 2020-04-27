package com.softserve.edu.greencity.ui.data;
public final class UserRepository {

    private UserRepository() {
    }

    public static UserData getDefaultUserCredentials() {
        return new UserData();
    }
    
    public static UserData getGoogleUserCredentials() {
        return new UserData("sergtaqc@gmail.com", "123456");
    }
}