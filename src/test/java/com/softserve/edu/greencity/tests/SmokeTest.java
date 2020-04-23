package com.softserve.edu.greencity.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.greencity.data.Languages;
import com.softserve.edu.greencity.pages.guest.HomePage;
import com.softserve.edu.greencity.pages.guest.TopPart;

public class SmokeTest extends GreencityTestRunner {

	@DataProvider
	public Object[][] validData() {
		return new Object[][] {
			//{ SearchItemRepository.getMacItem(), SearchRefineRepository.getPriceDescUsd() },
			{ Languages.UKRAINIAN }
			};
	}

	@Test(dataProvider = "validData")
	public void checkElements(Languages languages) {
		// Steps
		HomePage homepage = loadApplication()
				.switchLanguage(languages);
		presentationSleep();
		//
		/*-
		System.out.println("is menu Home text: " 
				+ homepage.getMainMenuDropdown().getMenuHomeText());
		//
		System.out.println("is menu Home: " 
				+ homepage.getMainMenuDropdown().isDisplayedMenuHome());
		System.out.println("is menu EcoNews: " 
				+ homepage.getMainMenuDropdown().isDisplayedMenuEcoNews());
		System.out.println("is menu NaviconButton: " 
				+ homepage.getMainMenuDropdown().isDisplayedNaviconButton());
		*/
		//
		homepage = homepage
				.navigateMenuEconews()
				.navigateMenuTipsTricks()
				.navigateMenuMap()
				.navigateMenuMyCabinet()
				.navigateMenuAbout()
				.navigateMenuHome();
		//
//		TopPart tp = homepage;
//		tp = tp.navigateMenuEconews();
//		presentationSleep(2);
//		tp = tp.navigateMenuTipsTricks();
//		presentationSleep(2);
//		tp = tp.navigateMenuMyCabinet();
//		presentationSleep(2);
//		tp = tp.navigateMenuMap();
		//
		// Check
//		Assert.assertEquals(homepage.getLanguageSwitcherText(),
//				Languages.UKRAINIAN.toString());
		//
		// Return to Previous State
		presentationSleep();
	}
}
