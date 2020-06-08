package com.softserve.edu.greencity.rest.tests;


import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.softserve.edu.greencity.rest.data.User;
import com.softserve.edu.greencity.rest.data.UserRepository;
import com.softserve.edu.greencity.rest.data.econews.ExpectedResponce;
import com.softserve.edu.greencity.rest.data.econews.NewsRepository;
import com.softserve.edu.greencity.rest.data.econews.PageParameterRepository;
import com.softserve.edu.greencity.rest.data.econews.PageParameters;
import com.softserve.edu.greencity.rest.entity.econewsEntity.NewsEntity;
import com.softserve.edu.greencity.rest.entity.econewsEntity.PageEntity;
import com.softserve.edu.greencity.rest.entity.econewsEntity.TagsEntity;
import com.softserve.edu.greencity.rest.services.EconewsUserService;
import com.softserve.edu.greencity.rest.tools.VerifyUtils;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

/**
 * Class contain test for eco news page
 * @author lv-493
 *
 */
public class EcoNewsTest extends GreencityRestTestRunner {
	
	@DataProvider
	public Object[][] users() {
		return new Object[][] { { UserRepository.get().temporary() }};
	}
	
	@DataProvider
	public Object[][] news() {
		return new Object[][] { { UserRepository.get().temporary(),  NewsRepository.get().getResponceCode()} };
	}
	

	@DataProvider
	public Object[][] econews() {
		return new Object[][] { { UserRepository.get().temporary(), PageParameterRepository.getNews() } };
	}
	
	/**
	 * Check tags
	 * @param user
	 * @param expectedResponce
	 */
	@Description("Check Tags that system returns")
	@Severity(SeverityLevel.NORMAL)
	@Parameters({"Loggined User", "responce"})
	@Epic("EcoNews")
	@Test(dataProvider = "news")
	public void checkAllTags(User user, ExpectedResponce expectedResponce) {
		
		logger.info("Start checkAllTags(" + user + ")");
		EconewsUserService tagsService = loadApplication()
				.successfulUserLogin(user)
				.gotoEconewsUserService();
		
		TagsEntity tagsEntity = tagsService.getTags();

		logger.info("tagsEntity = " + tagsEntity);
		Assert.assertEquals(tagsEntity.getResponsecode(), 
				expectedResponce.getResponcecode(), "Test checkAllTags: the tag names do not match");
	}
	
	/**
	 * Get three random news
	 * @param user
	 */
	@Description("Return three NewsItem for topic \"May be interesting for you\"")
	@Severity(SeverityLevel.NORMAL)
	@Parameters({"Loggined User"})
	@Epic("EcoNews")
	@Test(dataProvider = "users")
	public void checkFreshNews(User user) {
		
		logger.info("Start test checkFreshNews(" + user + ")");
		EconewsUserService newsService = loadApplication()
				.successfulUserLogin(user)
				.gotoEconewsUserService();
		
		List<NewsEntity> newsEntity = newsService.getNewsEntity();
		logger.info("newsEntity" + newsEntity);
		Assert.assertTrue(VerifyUtils.verifyClass(newsEntity));

	}
	
	/** return EcoNews page with news by number of page & number of news
	 * 
	 * @param user
	 * @param pageParameters
	 */
	@Description("Return page with news")
	@Severity(SeverityLevel.CRITICAL)
	@Parameters({"Loggined User", "PageParameters: page's number & new's number" })
	@Epic("EcoNews")
	@Test(dataProvider = "econews")
	public void checkhNews(User user, PageParameters pageParameters) {
		
		logger.info("Start checkFreshNews(" + user + ")");
		
		EconewsUserService pageService = loadApplication()
				.successfulUserLogin(user)
				.gotoEconewsUserService();
		
		PageEntity pageEntity = pageService.getPageEntity(pageParameters);
		logger.info("pageEntity" + pageEntity );
		
		Assert.assertTrue(VerifyUtils.verifyClass(pageEntity.getPage())  );
    
	}

}
