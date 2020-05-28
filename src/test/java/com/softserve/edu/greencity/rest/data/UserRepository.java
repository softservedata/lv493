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
		return admin();
	}

	public User admin() {
        return new User("soyorer682@hubopss.com", "ann", "1!Aaaaaa");
    }

	public User temporary() {
		return new User("xdknxusqvjeovowpfk@awdrt.com", "Temp", "Temp#001");
	}

}
