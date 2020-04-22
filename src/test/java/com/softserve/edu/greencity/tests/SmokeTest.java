package com.softserve.edu.greencity.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.greencity.data.Languages;
import com.softserve.edu.greencity.pages.guest.HomePage;

public class SmokeTest extends GreencityTestRunner {

	@DataProvider
	public Object[][] validDataProvider() {
		return new Object[][] {
			//{ SearchItemRepository.getMacItem(), SearchRefineRepository.getPriceDescUsd() },
			//{ SearchItemRepository.getMacItem(), SearchRefineRepository.getExTaxPriceDescUsd() }
			};
	}

	@Test//(dataProvider = "validDataProvider")
	public void checkElements() {
		// Steps
		HomePage homepage = loadApplication()
				.switchLanguage(Languages.UKRAINIAN);
		presentationSleep();
		//
		System.out.println("is menu Home text: " 
				+ homepage.getMainMenuDropdown().getMenuHomeText());
		//
		System.out.println("is menu Home: " 
				+ homepage.getMainMenuDropdown().isDisplayedMenuHome());
		System.out.println("is menu EcoNews: " 
				+ homepage.getMainMenuDropdown().isDisplayedMenuEcoNews());
		System.out.println("is menu NaviconButton: " 
				+ homepage.getMainMenuDropdown().isDisplayedNaviconButton());
		//
		//homepage.getMainMenuDropdown().clickMenuHome();
		//
		// Check
		Assert.assertEquals(homepage.getLanguageSwitcherText(),
				Languages.UKRAINIAN.toString());
		//
		// Return to Previous State
		presentationSleep();
	}
}
