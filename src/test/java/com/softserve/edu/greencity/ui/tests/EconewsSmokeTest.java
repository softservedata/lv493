package com.softserve.edu.greencity.ui.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.greencity.ui.data.NewsData;
import com.softserve.edu.greencity.ui.data.NewsRepository;
import com.softserve.edu.greencity.ui.data.Tag;
import com.softserve.edu.greencity.ui.pages.econews.EconewsPage;
import com.softserve.edu.greencity.ui.pages.econews.OneNewsPage;
import com.softserve.edu.greencity.ui.pages.tipstricks.TipsTricksPage;



public class EconewsSmokeTest extends GreencityTestRunner {

	//@Test(dataProvider = "newsData")
	public void econewsSmokeTest(NewsData news) {

		TipsTricksPage page = loadApplication();
		page.navigateMenuEconews()
		.switchToOneNewsPagebyParameters(news)
		.switchToNextOneNewsPagebyNumber(1)
		.switchToEconewsPageBack();

	}

	@DataProvider
	public Object[][] newsData() {
		return new Object[][] {
				 {  NewsRepository.getAllFildsNews() }
			 };
				//{ Languages.ENGLISH } };
	}

	
	//@Test(dataProvider = "newsData")
	public void econewsTest(NewsData news) {
		
		//open onenewspage
		OneNewsPage findedeconewspage = loadApplication()
		.navigateMenuEconews()
		.switchToOneNewsPagebyParameters(news);
		
		// check if is appropriate page
		Assert.assertEquals(news.getTitle(), findedeconewspage.getTitleText(), "message");	
		
	}
	
	@Test
	public void chooseTags() {
		
		//open onenewspage
		EconewsPage page = loadApplication()
		.navigateMenuEconews()
		.selectFilters(Tag.NEWS);
		
		// check if is appropriate page
		Assert.assertEquals(page.getNumberOfItemComponent(), page.getItemsContainer().getItemComponentsCount(), "message");	
		
	}
		
}
