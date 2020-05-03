package com.softserve.edu.greencity.ui.data;

/**
 * User Repository class.
 * @author Serg
 */
public final class UserRepository {

    private UserRepository() {
    }

    /**
     * Default user credentials:
     * firstName "John";
     * lastName "Wilson";
     * email "rjjztqsiayuieydfuy@awdrt.org";
     * password "A475asd123*".
     * @return UserData
     */
    public static UserData getDefaultUserCredentials() {
        return new UserData("John", "Wilson", "rjjztqsiayuieydfuy@awdrt.org", "A475asd123*");
    }
    
    /**
     * GoogleUserCredentials:
     * email "sergtaqc@gmail.com";
     * password "123456".
     * @return UserData
     */
    public static UserData getGoogleUserCredentials() {
        return new UserData("sergtaqc@gmail.com", "123456");
    }
    
    /**
     * WrongUserCredentials1:
     * firstName "Asdfqwe";
     * lastName "Qwerzxc";
     * email "123asd@zxc";
     * password "123Adff890*".
     * @return UserData
     */
    public static UserData getWrongUserCredentials1() {
        return new UserData("Asdfqwe", "Qwerzxc", "123asd@zxc", "123Adff890");
    }
    
    /**
     * WrongUserCredentials2:
     * firstName "A.";
     * lastName "22222222222222";
     * email "asdsd.1312";
     * password "".
     * @return UserData
     */
    public static UserData getWrongUserCredentials2() {
        return new UserData("A.", "22222222222222", "asdsd.1312", "");
    }
}
