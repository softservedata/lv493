package com.softserve.edu.greencity.ui.pages.tipstricks;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.greencity.ui.pages.econews.ItemComponent;

public class TipsCardsContainer {
    
   
	//
	private WebDriver driver;
	//
	private List<ItemComponent> itemComponents;
	private List<WebElement> tipsCard;
	
    //  button pagination
    private WebElement leftPagination;
    private WebElement rightPagination;
    private List<WebElement> coffeeCups;
    private List<WebElement> waterBottle;
    private List<WebElement> spoonKnife;
     
	public TipsCardsContainer(WebDriver driver) {
		this.driver = driver;
		initElements();
		//initComponent();
	}

	private void initElements() {
		// init elements
	    tipsCard = driver.findElements(By.xpath("//app-tips-card"));
	    leftPagination = driver.findElement(By.xpath("//i[@class='arrow fas fa-chevron-left']/.."));
        rightPagination = driver.findElement(By.xpath("//i[@class='arrow fas fa-chevron-right']/.."));
       // coffeeCup = driver.findElements(By.cssSelector("img[src*='coffee-cup']"));
        waterBottle = driver.findElements(By.cssSelector("img[src*='water-bottle']"));
        spoonKnife = driver.findElements(By.cssSelector("img[src*='spoon-knife']"));

        //rightPagination.getLocation().getX();
	}
//	private void initComponent() {
//	    
//	    itemComponents = new ArrayList<>();
//	    for(WebElement current : driver.findElements(By.xpath("//app-tips-card"))) {
//	        itemComponents.add(new ItemComponent(driver, current));
//	    }
//	}

	// Page Object
	public List<ItemComponent> getItemComponents() {
        return itemComponents;
    }
	
	   // leftPagination

    public WebElement getleftPagination() {
        return leftPagination;
    }

    public void clickleftPagination() {
        getleftPagination().click();
    }

    // rightPagination

    public WebElement getRightPagination() {
        return rightPagination;
    }

    public void clickRightPagination() {
        getRightPagination().click();
    }
	
    //
    
	
	// Functional
    
    public int getItemComponentsCount(){
        return getItemComponents().size();
    }
//    private String getTipsCards() {
//
//    for (WebElement objShowLink : tipsCard) {
//        String strObjShowLink = objShowLink.getText();
//        //System.out.println("Check 'Show': " + strObjShowLink);
//    }
//    
//}
//    public List<WebElement> checkActiveFilters() {
//      List<WebElement> activeFilters = new ArrayList<>();
//      for(WebElement curr : ) {
//          if(curr.getAttribute("class").contains("clicked-filter-button")) {
//          activeFilters.add(curr);
//          }
//      }
//      return activeFilters;
//  }
	// Business Logic
}
