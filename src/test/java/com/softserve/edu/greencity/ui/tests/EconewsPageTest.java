package com.softserve.edu.greencity.ui.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.greencity.ui.data.NewsData;
import com.softserve.edu.greencity.ui.data.NewsRepository;
import com.softserve.edu.greencity.ui.data.Tag;
import com.softserve.edu.greencity.ui.pages.econews.EconewsPage;
import com.softserve.edu.greencity.ui.pages.econews.OneNewsPage;
import com.softserve.edu.greencity.ui.pages.tipstricks.TipsTricksPage;

public class EconewsPageTest extends GreencityTestRunner {

	@Test(dataProvider = "newsData")
	public void econewsSmokeTest(NewsData news) {

		TipsTricksPage page = loadApplication();
		page.navigateMenuEconews()
		.switchToOneNewsPagebyParameters(news)
		.switchToNextOneNewsPage()
		.switchToEconewsPageBack();
		
	}

	@DataProvider
	public Object[][] newsData() {
		return new Object[][] {
				 {  NewsRepository.getAllFildsNews() }
			 };
	}

	
	@Test(dataProvider = "newsData")
	public void openNewsTest(NewsData news) {
		
		//open onenewspage
		
		OneNewsPage findedeconewspage = loadApplication()
				.navigateMenuEconews()
				.switchToOneNewsPagebyParameters(news);
		
		// check if is appropriate page
		
		Assert.assertEquals(news.getTitle(), findedeconewspage.getTitleText(), 
				"titles of news does not match");	
		
	}
	
	@DataProvider
	public Object[][] newsTags() {
		return new Object[][] {
				 {  NewsRepository.getNewsByTags() }
			 };
	}
	
	@Test(dataProvider = "newsTags")
	public void chooseTags(List<Tag> tags) {
		
		//open onenewspage
		
		EconewsPage page = loadApplication()
				.navigateMenuEconews()
				.selectFilters(tags);
	
		// check if is appropriate numbers of news items
		
		Assert.assertEquals(page.getNumberOfItemComponent(), 
				page.getItemsContainer().getItemComponentsCount(), 
				"Number of news items does not match to required");
		
	}
		
}
