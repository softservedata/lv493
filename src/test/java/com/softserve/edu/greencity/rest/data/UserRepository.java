package com.softserve.edu.greencity.rest.data;

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

	public User temporary2() {
        return new User("yoren18521@aprimail.com", "JXHIASJAwrSgncoJIpPg", "A475asd123*");
    }
	
	/**
     * Gives random credentials:
     * email - "";
     * first name - random 20 letters;
     * password - "A475asd123*";
     * @return User
     */
    public User temporaryUserCredentialsForRegistration() {
        return new User("", Randomizer.getRamdomString20Letters(), "A475asd123*");
    }
    
    /**
     * Credentials for already existing user (Jira Story: SC-184/GC-468; Test GC-528)
     * email "gceurzwfejqtiguoku@ttirv.net";
     * name "Sergii_Test"
     * password "A475asd123*".
     * @return UserData
     */
    public User alreadyExistingUserCredentials() {
        return new User("gceurzwfejqtiguoku@ttirv.net", "Sergii_Test", "A475asd123*");
    }
	
}
