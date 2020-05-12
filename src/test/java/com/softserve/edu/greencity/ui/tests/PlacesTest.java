package com.softserve.edu.greencity.ui.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.greencity.ui.data.Languages;
import com.softserve.edu.greencity.ui.pages.map.MapPage;
import com.softserve.edu.greencity.ui.pages.map.PlacesComponent;
import com.softserve.edu.greencity.ui.pages.tipstricks.TipsTricksPage;

public class PlacesTest extends GreencityTestRunner {
  

	 @Test
	  public void searchRequest() {
		    TipsTricksPage tipstrickspage = loadApplication();
		    
		    tipstrickspage.navigateMenuMap();
		    //Navigating to the tested page
		    MapPage map = loadApplication().navigateMenuMap();
		    
		    //Creating of a search request
		
		    PlacesComponent placesComponent = map.searchRequest();
		    
		    //Receiving and saving of search results

		    String actual = placesComponent.getSearchResultText();
		    
		    //Clearing all filters with the current search result
		    
		    map.clearSearch();
		    
		    //Checking for equality of the expected and actual results
		    
			Assert.assertEquals(actual,
			"Pravda");
	  }

}
