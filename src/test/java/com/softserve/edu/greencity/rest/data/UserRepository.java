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
		return new User("xdknxusqvjeovowpfk@awdrt.com", "temp", "Temp#001");
	}
	

	public User temporaryInvalidEmail() {
		return new User("xdknxusqvpfk@awdrt.com", "temp", "Tempпше згдд#001");
	}
	
	/**
	 * Gives user's credentials:
	 * email - "yoren18521@aprimail.com";
     * first name - "JXHIASJAwrSgncoJIpPg";
     * password - "A475asd123*";
	 * @return User
	 */
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
     * name "Maksym"
     * password "A475asd123*".
     * @return UserData
     */
    public User alreadyExistingUserCredentials() {
//        return new User("gceurzwfejqtiguoku@ttirv.net", "Sergii_Test", "A475asd123*");
        return new User("gceurzwfejqtiguoku@ttirv.net", "Maksym", "A475asd123*");
    }

	public User getAdminUser() {
		return new User("green.city.marjana@gmail.com", "marJana", "Greencity!1");
	}
	
	 public User ashot() {
         return new User("acheuusdukwyhuhfab@ttirv.com", "ashot", "QwertY12!");
     }
	/**
	 * User Credentials for checking email
	 * email "usertest4228501@gmail.com";
	 * name "Qwerty42?"
	 * password "Qwerty42?".
	 * @return UserData
	 */
	public User emailUserCredentials() {
		return new User("usertest4228501@gmail.com", "Qwerty42?", "Qwerty42?");
	}
	/**
	 * Not exist user credentials
	 * email "xdknxowpfk@awdrt.com";
	 * name "temp"
	 * password "Tem#001".
	 * @return UserData
	 */
	public User wrongUserCredentials() {
		return new User("xdknxowpfk@awdrt.com", "temp", "Tem#001");
	}
	 
	/**
     * Credentials for Jira Story: GC-184/GC-468; Test GC-531
     * email - "";
     * first name - "Yuriy";
     * password - "12345Awerty_";
     * @return User
     */
    public User userForUserStory184TestCase531() {
        return new User("", "Yuriy", "12345Awerty_");
    }
    
    /**
     * Credentials for Jira Story: GC-184/GC-468; Test GC-532
     * email - "";
     * first name - "";
     * password - "";
     * @return User
     */
    public User userForUserStory184TestCase532() {
        return new User("", "", "");
    }
	
	/**
     * Bad user credentials (Jira Story: SC-184/GC-468; Test GC-534)
     * email invalid "";
     * name "Sergii_Test534";
     * password "A475asd123*".
     * @return UserData
     */
    public User userForUserStory184TestCase534() {
        return new User("", "Sergii_Test534", "A475asd123*");
    }
    
    /**
     * Bad user credentials (Jira Story: SC-184/GC-468; Test GC-535)
     * email "qtiguoku@ttirv.net";
     * name "Sergii_Test535";
     * password invalid "".
     * @return UserData
     */
    public User userForUserStory184TestCase535() {
        return new User("qtiguoku@ttirv.net", "Sergii_Test535", "");
    }
    
    /**
     * Bad user credentials (Jira Story: SC-184/GC-468; Test GC-536)
     * email "qtiguokuttirv.net";
     * name "Sergii_Test536";
     * password "Aasdas_123".
     * @return UserData
     */
    public User userForUserStory184TestCase536() {
        return new User("qtiguokuttirv.net", "Sergii_Test536", "Aasdas_123");
    }
    
    /**
     * Bad user credentials (Jira Story: SC-184/GC-468; Test GC-537)
     * email "qtiguoku@ttirv.net";
     * name "Sergii_Test536";
     * password invalid "2Ab_".
     * @return UserData
     */
    public User userForUserStory184TestCase537() {
        return new User("qtiguoku@ttirv.net", "Sergii_Test537", "2Ab_");
    }
    
    /**
     * Bad user credentials (Jira Story: SC-184/GC-468; Test GC-540)
     * email valid random 20 symbols;
     * name invalid random 27 symbols;
     * password valid "Aasdas_123".
     * @return UserData
     */
    public User userForUserStory184TestCase540() {
        int quantituSymbols = 27;
        return new User(Randomizer.getRndomEmail20Symbols(), Randomizer.getRamdomStringLetters1(quantituSymbols), "Aasdas_123");
    }
    
    /**
     * Bad user credentials (Jira Story: SC-184/GC-468; Test GC-541)
     * email "qtiguoku@ttirv.net";
     * name "Sergii_Test541";
     * password invalid "copter20".
     * @return UserData
     */
    public User userForUserStory184TestCase541() {
        return new User("qtiguoku@ttirv.net", "Sergii_Test541", "copter20");
    }

}
