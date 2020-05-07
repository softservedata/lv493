package com.softserve.edu.greencity.ui.data;

import com.softserve.edu.greencity.ui.tools.Randomizer;

public final class UserRepository {
    private static volatile UserRepository instance = null;

    private UserRepository() {
    }

    public static UserRepository get() {
        if (instance == null) {
            synchronized (UserRepository.class) {
                if (instance == null) {
                    instance = new UserRepository();
                }
            }
        }
        return instance;
    }

    public User getDefault() {
        return temporary();
    }

    public User temporary() {
        return new User("xdknxusqvjeovowpfk@awdrt.com", "Temp", "Temp#001");
    }
    
    /**
     * Default user credentials:
     * firstName "John";
     * lastName "Wilson";
     * email "rjjztqsiayuieydfuy@awdrt.org";
     * password "A475asd123*".
     * @return UserData
     */
    public static User getDefaultUserCredentials() {
        return new User("John", "Wilson", "rjjztqsiayuieydfuy@awdrt.org", "A475asd123*");
    }
    
    /**
     * GoogleUserCredentials:
     * email "sergtaqc@gmail.com";
     * password "123456".
     * @return UserData
     */
    public static User getGoogleUserCredentials() {
        return new User("sergtaqc@gmail.com", "123456");
    }
    
    /**
     * WrongUserCredentials1:
     * firstName "Asdfqwe";
     * lastName "Qwerzxc";
     * email "123asd@zxc";
     * password "123Adff890*".
     * @return UserData
     */
    public static User getWrongUserCredentials1() {
        return new User("Asdfqwe", "Qwerzxc", "123asd@zxc", "123Adff890");
    }
    
    /**
     * WrongUserCredentials2:
     * firstName "A.";
     * lastName "22222222222222";
     * email "asdsd.1312";
     * password "".
     * @return UserData
     */
    public static User getWrongUserCredentials2() {
        return new User("A.", "22222222222222", "asdsd.1312", "");
    }
    
    public static User getTemporaryUserCredentialsForRegistration() {
        //
        int length = 20;
        boolean useLetters = true;
        boolean useNumbers = false;
        //
        String firstName = Randomizer.getRamdomString(length, useLetters, useNumbers);
        String lastName = Randomizer.getRamdomString(length, useLetters, useNumbers);
        String password = Randomizer.getRamdomPassword();
        return new User(firstName, lastName, "", "A475asd123*");
    }

}