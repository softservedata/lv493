package com.softserve.edu.greencity.rest.tests;

import java.util.List;

import com.softserve.edu.greencity.rest.entity.econewsEntity.TagsEntity;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.greencity.rest.data.User;
import com.softserve.edu.greencity.rest.data.UserRepository;
import com.softserve.edu.greencity.rest.data.econews.PageParameterRepository;
import com.softserve.edu.greencity.rest.data.econews.PageParameters;
import com.softserve.edu.greencity.rest.entity.econewsEntity.PageEntity;
import com.softserve.edu.greencity.rest.services.EconewsUserService;


public class EcoNewsTest extends GreencityRestTestRunner {
	
	@DataProvider
	public Object[][] users() {
		return new Object[][] { { UserRepository.get().temporary() } };
	}
	

	@DataProvider
	public Object[][] econews() {
		return new Object[][] { { UserRepository.get().temporary(), PageParameterRepository.getNews() } };
	}
	
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
