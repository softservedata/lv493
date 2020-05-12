package com.softserve.edu.greencity.ui.pages.map;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PlacesComponent {
	
	private WebDriver driver;
	
	private List <WebElement> searchResults;
	private WebElement searchResult; 


	public PlacesComponent(WebDriver driver) {
		this.driver = driver;
		initElements();
	}

	private void initElements() {
		// init elements
		searchResults = driver.findElements(By.xpath("//tbody/tr/td"));
		searchResult = driver.findElement(By.xpath("//tbody")); //findElements
	    }

	    // Page Object
	  

	    public List <WebElement> getSearchResults() {
	        return searchResults;
	    }

	    public String getSearchResultsText() {
	        return getSearchResults().toString();
	    }

	    public WebElement getSearchResult() {
	        return searchResult;
	    }

	    public String getSearchResultText() {
	        return getSearchResult().getText().replace("\n", " ").replace("  ", " ");
	    }

	    public void clickSearchResult() {
	    	getSearchResult().click();
	    }



}
