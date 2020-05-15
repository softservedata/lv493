package com.softserve.edu.greencity.ui.data;

public final class UserRepository {
    
    private static volatile UserRepository instance = null;

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

    public User singInUser() {
        return new User("almyyhvxddxxnoczzt@ttirv.com", "QwertY12!");
    }
    
    public User temporary() {
        return new User("xdknxusqvjeovowpfk@awdrt.com", "Temp", "Temp#001");
    }
    public User first() {
        return new User("rjjztqsiayuieydfuy@awdrt.org", "A475asd123*");
    }

    
 

}
