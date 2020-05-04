package com.softserve.edu.greencity.ui.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.greencity.ui.data.Languages;
import com.softserve.edu.greencity.ui.pages.tipstricks.TipsTricksPage;

public class SmokeTest extends GreencityTestRunner {

	//@DataProvider
	public Object[][] validData() {
		return new Object[][] {
			//{ SearchItemRepository.getMacItem(), SearchRefineRepository.getPriceDescUsd() },
			{ Languages.UKRAINIAN }
			};
	}

	//@Test(dataProvider = "validData")
	public void checkElements(Languages languages) {
		// Steps
		TipsTricksPage tipstrickspage = loadApplication()
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
		tipstrickspage = tipstrickspage
				.navigateMenuEconews()
				.navigateMenuTipsTricks()
				.navigateMenuMap()
				.navigateMenuMyCabinet()
				.navigateMenuAbout()
				.navigateMenuTipsTricks();
		//
//		TopPart tp = tipstrickspage;
//		tp = tp.navigateMenuEconews();
//		presentationSleep(2);
//		tp = tp.navigateMenuTipsTricks();
//		presentationSleep(2);
//		tp = tp.navigateMenuMyCabinet();
//		presentationSleep(2);
//		tp = tp.navigateMenuMap();
		//
		// Check
//		Assert.assertEquals(tipstrickspage.getLanguageSwitcherText(),
//				Languages.UKRAINIAN.toString());
		//
		// Return to Previous State
		presentationSleep();
	}
}
