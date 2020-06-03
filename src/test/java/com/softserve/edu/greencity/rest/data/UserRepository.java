package com.softserve.edu.greencity.rest.data;

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
	
	public User getAdminUser() {
        return new User("green.city.marjana@gmail.com", "marJana", "Greencity!1");
    }
	
	public User ashot() {
        return new User("acheuusdukwyhuhfab@ttirv.com", "ashot", "QwertY12!");
    }
	
}
