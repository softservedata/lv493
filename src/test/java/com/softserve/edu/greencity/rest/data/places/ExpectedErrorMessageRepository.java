package com.softserve.edu.greencity.rest.data.places;

import com.softserve.edu.greencity.rest.data.User;
import com.softserve.edu.greencity.rest.data.UserRepository;

public class ExpectedErrorMessageRepository {

	private  ExpectedErrorMessageRepository() {
	}

	
	public User getDefault() {
		return temporary();
	}
	
	public User temporary() {
		return new User("xdknxusqvjeovowpfk@awdrt.com", "temp", "Temp#001");
	}
	

}
