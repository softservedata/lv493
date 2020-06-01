package com.softserve.edu.greencity.rest.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.greencity.rest.data.FileUploadProperties;
import com.softserve.edu.greencity.rest.data.FileUploadPropertiesRepository;
import com.softserve.edu.greencity.rest.data.User;
import com.softserve.edu.greencity.rest.data.UserGoal;
import com.softserve.edu.greencity.rest.data.UserGoalRepository;
import com.softserve.edu.greencity.rest.data.UserRepository;
import com.softserve.edu.greencity.rest.entity.NewsEntity;
import com.softserve.edu.greencity.rest.services.EconewsUserService;
import com.softserve.edu.greencity.rest.services.LogginedUserService;
import com.softserve.edu.greencity.rest.services.MyhabitsService;

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
	
	@Test(dataProvider = "userGoals")
	public void checkUserGoals(User user, List<UserGoal> expectedGoals) {
		logger.info("Start checkUserGoals(" + user + ")");
		MyhabitsService myhabitsService = loadApplication()
				.successfulUserLogin(user)
				.gotoMyhabitsService();
		System.out.println("logginedUserEntity = "
				+ myhabitsService.getLogginedUserEntity());
		List<UserGoal> userGoals = myhabitsService.userGoals();
		System.out.println("userGoals = "+ userGoals);
		Assert.assertEquals(userGoals, expectedGoals);
	}
	
	@DataProvider
	public Object[][] userNews() {
		return new Object[][] {
			{ UserRepository.get().temporary(),
				FileUploadPropertiesRepository.get().simpleNews() }
		};
	}
	
	//@Test(dataProvider = "userNews")
	public void checkUploadEconews(User user, FileUploadProperties fileUploadProperties) {
		logger.info("Start checkUploadEconews(" + user + ")");
		EconewsUserService econewsUserService = loadApplication()
				.successfulUserLogin(user)
				.gotoEconewsUserService();
		System.out.println("logginedUserEntity = "
				+ econewsUserService.getLogginedUserEntity());
		NewsEntity newsEntity = econewsUserService.uploadNews(fileUploadProperties);
		System.out.println("newsEntity = "+ newsEntity);
		//Assert.assertEquals(newsEntity, expectedGoals);
	}
}
