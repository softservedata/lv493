package com.softserve.edu.greencity.ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.softserve.edu.greencity.ui.pages.map.DiscountRateComponent;
import com.softserve.edu.greencity.ui.pages.map.MapPage;
import com.softserve.edu.greencity.ui.pages.map.PlacesComponent;
import com.softserve.edu.greencity.ui.pages.tipstricks.TipsTricksPage;

public class MapPageTest extends GreencityTestRunner {
  
  @Test
  public void applyDistanceFilter() {
	  TipsTricksPage tipstrickspage = loadApplication();
	  tipstrickspage.navigateMenuMap();
	  //Navigating to the tested page
	  MapPage map = loadApplication().navigateMenuMap();
	  
	  //Filter applying, receiving and saving of search results

	  String actual = map.applyDistanceFilter().getSearchResultText();
	  
	  //Clearing all filters with the current search result

	  map.clearSearch();
	  
	  //Checking for equality of the expected and actual results
	  
	  Assert.assertEquals(actual, 
			"Forum Victoria Gardens Pravda Malevych Kryivka");
      }
  
  @Test
  public void applyDistanceFilterForOpen() {
	  TipsTricksPage tipstrickspage = loadApplication();
	  tipstrickspage.navigateMenuMap();
	  //Navigating to the tested page
	  MapPage map = loadApplication().navigateMenuMap();
	  
	  //Two filters applying, receiving and saving of search results

	  String actual = map.applyDistanceFilterForOpen().getSearchResultText();
	  
	  //Clearing all filters with the current search result

	  map.clearSearch();
	  
	  //Checking for equality of the expected and actual results
	  
	  Assert.assertEquals(actual,
				"Forum Victoria Gardens Pravda Malevych Kryivka");
  }

}