package com.softserve.edu.greencity.ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.greencity.ui.data.Languages;
import com.softserve.edu.greencity.ui.data.MapData;
import com.softserve.edu.greencity.ui.pages.map.DiscountRateComponent;
import com.softserve.edu.greencity.ui.pages.map.MapPage;
import com.softserve.edu.greencity.ui.pages.map.PlacesComponent;
import com.softserve.edu.greencity.ui.pages.tipstricks.TipsTricksPage;

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
		TipsTricksPage tipstrickspage = loadApplication()
				.switchLanguage(languages);
		presentationSleep();
		//
		tipstrickspage.navigateMenuMap();
		presentationSleep();
//PlacesComponent test = new PlacesComponent(driver);
MapPage map = new MapPage(driver);
//map.getDiscountRateComponent();
map.searchRequest();
map.clearSearch();
presentationSleep();

System.out.println("GUT");
//test.clearSearch();


//test.clickIsOpenCheckbox();
//presentationSleep();
//
//test.clickApplyFilter();
//presentationSleep();
//
//WebElement searchResult = driver.findElement(By.xpath("//tbody"));
//searchResult.getText();

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
//		tipstrickspage = tipstrickspage
//				.navigateMenuEconews()
//				.navigateMenuTipsTricks()
//				.navigateMenuMap()
//				.navigateMenuMyCabinet()
//				.navigateMenuAbout()
//				.navigateMenuTipsTricks();
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
		//presentationSleep();
	}
}
