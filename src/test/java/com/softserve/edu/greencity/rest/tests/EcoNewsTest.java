package com.softserve.edu.greencity.rest.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.greencity.rest.data.User;
import com.softserve.edu.greencity.rest.data.UserRepository;
import com.softserve.edu.greencity.rest.data.econews.PageParameterRepository;
import com.softserve.edu.greencity.rest.data.econews.PageParameters;
import com.softserve.edu.greencity.rest.entity.econewsEntity.PageEntity;
import com.softserve.edu.greencity.rest.services.EconewsUserService;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;


public class EcoNewsTest extends GreencityRestTestRunner {
	
	@DataProvider
	public Object[][] users() {
		return new Object[][] { { UserRepository.get().temporary() } };
	}
	

	@DataProvider
	public Object[][] econews() {
		return new Object[][] { { UserRepository.get().temporary(), PageParameterRepository.getNews() } };
	}
	
	@Epic("AllureTest")
	@Feature("Login_Application_Test FEATURE")
	//@Test(dataProvider = "users")
	public void checkAllTags(User user) {
		logger.info("Start checkAllTags(" + user + ")");
		EconewsUserService tagsService = loadApplication()
				.successfulUserLogin(user)
				.gotoEconewsUserService();
		System.out.println("logginedUserEntity = "
				+ tagsService.getLogginedUserEntity());
		String tagsEntity = tagsService.getTags();
//		String[] tagsEntity = tagsService.getTags();
		System.out.println("***tagsEntity = "+ tagsEntity);
//		Assert.assertEquals(logginedUserService.getLogginedUserEntity().getName(),
//				user.getName());
	}
	
	@Description("Test Description: class LoginLogoutTest; verifyLifeTimeToken()")
	@Severity(SeverityLevel.CRITICAL)
	@Story("testApp2 STORY")
	@Issue("LVATQAOMS-776")
	@Link(name = "allure", type = "mylink")
	@Link("https://softserve.academy/")
	@Test(dataProvider = "users")
	public void checkFreshNews(User user) {
		logger.info("Start checkFreshNews(" + user + ")");
		EconewsUserService newsService = loadApplication()
				.successfulUserLogin(user)
				.gotoEconewsUserService();
		System.out.println("newsService  = "
				+ newsService.getLogginedUserEntity());
//		List<NewsItems> newsItems = newsService.getNewsEntity();
		//List<NewsEntity> newsEntity = newsService.getNewsEntity();
	//	System.out.println("***newsEntity = "+  newsEntity);
				
	//	Assert.assertTrue(VerifyUtils.verifyClass(newsEntity));

	}
	
	@Test(dataProvider = "econews")
	public void checkhNews(User user, PageParameters pageParameters) {
		logger.info("Start checkFreshNews(" + user + ")");
		EconewsUserService pageService = loadApplication()
				.successfulUserLogin(user)
				.gotoEconewsUserService();
		System.out.println("newsService  = "
				+ pageService.getLogginedUserEntity());
//		List<NewsItems> newsItems = newsService.getNewsEntity();
		PageEntity pageEntity = pageService.getPageEntity(pageParameters);
//		System.out.println("***pageEntity = "+  pageEntity);
    
	}

}
