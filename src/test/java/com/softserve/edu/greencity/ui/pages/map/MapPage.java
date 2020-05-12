package com.softserve.edu.greencity.ui.pages.map;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.greencity.ui.pages.common.TopPart;
/**
 * Map Page class.
 * @author lv493
 */
public class MapPage extends TopPart {

    //filter button
	private WebElement filter;
	//filter input
	private WebElement searchInput; 
	//DiscountRateComponent
	private DiscountRateComponent discountRateComponent;
	//PlacesComponent
	private PlacesComponent placesComponent;
	/**
	 *Constructor
	 * 
	 * @return MapPage
	 */
	public MapPage(WebDriver driver) {
		super(driver);
		initElements();
	}
	/**
	 *Method, that initialize all WebElements on the page
	 * 
	 * @return void
	 */
	private void initElements() {
		// init elements
		//filter button
		filter = driver.findElement(By.id("filter_btn"));
		//search input
		searchInput = driver.findElement(By.xpath("//input[@name='search']"));
		//DiscountRateComponent is initialized with getDiscountRateComponent() method
		//PlacesComponent
		PlacesComponent placesComponent = new PlacesComponent(driver);

	}

	// Page Object
	
	/**
	 *Method, that initialize a discountRateComponent
	 * 
	 * @return discountRateComponent
	 */
	
	public DiscountRateComponent getDiscountRateComponent() {
		if (discountRateComponent == null)
		{
			clickFilter();	
			placesComponent = null;
		}
		
	return	  discountRateComponent = new DiscountRateComponent(driver);
	}	
	/**
	 *Method, that initialize a placesComponent
	 * 
	 * @return placesComponent
	 */
	public PlacesComponent getPlacesComponent() {
		if (placesComponent == null)
		{
			clickFilter();	
			discountRateComponent = null;
		}
		placesComponent = new PlacesComponent(driver);
		return placesComponent;
	}	
	//filter button
	/**
	 *Method, that initialize a WebElement filter
	 * 
	 * @return WebElement
	 */
	public WebElement getFilter() {
        return filter;
    }

    public String getFilterText() {
        return getFilter().getText();
    }

    public void clickFilter() {
    		getFilter().click();
    	
    }
	//filter input
    /**
	 *Method, that initialize a WebElement searchInput
	 * 
	 * @return WebElement
	 */
    public WebElement getSearchInput() {
        return searchInput;
    }

    public String getSearchInputText() {
        return getSearchInput().getText();
    }

    public void clickSearchInput() {
    	getSearchInput().click();
    	
    }
    public void clearSearchInput(){
    	getSearchInput().clear();
    	
    }
	
	// Functional
    
   
    /**
	 *Method, that clears all filters
	 * 
	 * @return void
	 */

    public void clearSearch() {
    	List <WebElement> clearButton =  driver.findElements(By.xpath("//button[@class='btn btn-success btn-sm ng-star-inserted']"));
		if ( (clearButton.size()>0)  && (clearButton.get(0).isDisplayed())) {
			clearButton.get(0).click();
		} else {
			driver.findElement(By.id("filter_btn")).click();
			driver.findElement(By.id("apply_filter_btn")).click();
			driver.findElement(By.xpath("//button[@class='btn btn-success btn-sm ng-star-inserted']")).click();
			}
				
		    
		}
	// Business Logic
    /**
	 *Method, that makes a search request 
	 * 
	 * @return placesComponent
	 */
    public PlacesComponent searchRequest() {
    	  
      	getSearchInput().sendKeys("Pravda");

      	return new PlacesComponent(driver);
      }
    /**
	 *Method, that applies a distance filter 
	 * 
	 * @return PlacesComponent
	 */
   public PlacesComponent applyDistanceFilter() {
	   getDiscountRateComponent().getDistanceInput().sendKeys("10");
	   getDiscountRateComponent().clickApplyFilterButton();
	return new PlacesComponent(driver);
	   
   }
   /**
	 *Method, that applies a distance filter and checks if the restaurants are open
	 * 
	 * @return placesComponent
	 */
   public PlacesComponent applyDistanceFilterForOpen() {
	   getDiscountRateComponent().clickWorkNowCheckbox();	  
	   getDiscountRateComponent().getDistanceInput().sendKeys("10");
	   getDiscountRateComponent().clickApplyFilterButton();
		return new PlacesComponent(driver);
}
   }