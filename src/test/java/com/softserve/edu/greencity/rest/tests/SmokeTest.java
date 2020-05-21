package com.softserve.edu.greencity.rest.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.greencity.rest.data.User;
import com.softserve.edu.greencity.rest.data.UserRepository;
import com.softserve.edu.greencity.rest.services.LogginedUserService;

public class SmokeTest extends GreencityRestTestRunner {

	@DataProvider
	public Object[][] users() {
		return new Object[][] { { UserRepository.get().temporary() } };
	}

	@Test(dataProvider = "users")
	public void checkLogin(User user) {
		logger.info("Start checkLogin(" + user + ")");
		LogginedUserService logginedUserService = loadApplication()
				.successfulUserLogin(user);
		System.out.println("logginedUserEntity = "
				+ logginedUserService.getLogginedUserEntity());
		//Assert.assertEquals(tipstrickspage.getTopUserName(), TopPart.PROFILE_NAME);
	}
}
