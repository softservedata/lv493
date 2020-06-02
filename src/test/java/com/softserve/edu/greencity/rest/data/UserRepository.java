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
		return new User("xdknxusqvjeovowpfk@awdrt.com", "temp", "Temp#001");
	}

	public User wrongUserCredentials() {
		return new User("xdknxowpfk@awdrt.com", "temp", "Tem#001");
	}
}
