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
	
	 public User user1() {
         return new User("acheuusdukwyhuhfab@ttirv.com", "User1", "QwertY12!");
     }
}
