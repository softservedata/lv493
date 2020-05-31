package com.softserve.edu.greencity.rest.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;

import com.softserve.edu.greencity.rest.data.User;
import com.softserve.edu.greencity.rest.data.UserRepository;
import com.softserve.edu.greencity.rest.data.myhabits.UserGoal;
import com.softserve.edu.greencity.rest.data.myhabits.UserGoalRepository;
import com.softserve.edu.greencity.rest.services.LogginedUserService;
import com.softserve.edu.greencity.rest.services.myhabits.UserGoalsService;

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

	@DataProvider
	public Object[][] userGoals() {
		return new Object[][] {
			{ UserRepository.get().temporary(), UserGoalRepository.get().typicalGoal() }
		};
	}

	//@Test(dataProvider = "userGoals")
	public void checkUserGoals(User user, List<UserGoal> expectedGoals) {
		logger.info("Start checkUserGoals(" + user + ")");
		UserGoalsService myhabitsService = loadApplication()
				.successfulUserLogin(user)
				.gotoMyhabitsService()
				.gotoUserGoalsService();
		System.out.println("logginedUserEntity = "
				+ myhabitsService.getLogginedUserEntity());
		List<UserGoal> userGoals = myhabitsService.userGoals();
		System.out.println("userGoals = "+ userGoals);
		Assert.assertEquals(userGoals, expectedGoals);
	}
}
