package com.softserve.edu.greencity.rest.tests;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.greencity.rest.data.User;
import com.softserve.edu.greencity.rest.data.UserGoal;
import com.softserve.edu.greencity.rest.data.UserRepository;
import com.softserve.edu.greencity.rest.services.LogginedUserService;
import com.softserve.edu.greencity.rest.services.MyCabinetService;

public class SmokeTest extends GreencityRestTestRunner {

	@DataProvider
	public Object[][] users() {
		return new Object[][] { { UserRepository.get().temporary() } };
	}

	//@Test(dataProvider = "users")
	public void checkLogin(User user) {
		logger.info("Start checkLogin(" + user + ")");
		LogginedUserService logginedUserService = loadApplication()
				.successfulUserLogin(user);
		System.out.println("logginedUserEntity = "
				+ logginedUserService.getLogginedUserEntity());
		Assert.assertEquals(logginedUserService.getLogginedUserEntity().getName(),
				user.getName());
	}
	
	@Test(dataProvider = "users")
	public void checkUserGoals(User user) {
		logger.info("Start checkUserGoals(" + user + ")");
		MyCabinetService myCabinetService = loadApplication()
				.successfulUserLogin(user)
				.gotoMyCabinetService();
		System.out.println("logginedUserEntity = "
				+ myCabinetService.getLogginedUserEntity());
		List<UserGoal> userGoals = myCabinetService.userGoals();
		System.out.println("userGoals = "+ userGoals);
//		Assert.assertEquals(logginedUserService.getLogginedUserEntity().getName(),
//				user.getName());
	}
}
