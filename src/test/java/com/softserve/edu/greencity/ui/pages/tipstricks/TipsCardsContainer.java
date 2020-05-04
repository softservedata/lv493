package com.softserve.edu.greencity.ui.pages.tipstricks;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.greencity.ui.pages.econews.ItemComponent;

public class TipsCardsContainer {
    
   
	//
	private WebDriver driver;
	//
	//private List<ItemComponent> itemComponents;
	private List<WebElement> tipsCard;
	
    //  button pagination
    private WebElement leftPagination;
    private WebElement rightPagination;
	public TipsCardsContainer(WebDriver driver) {
		this.driver = driver;
		initElements();
	}

	private void initElements() {
		// init elements
	    tipsCard = driver.findElements(By.xpath("//app-tips-card"));
	    leftPagination = driver.findElement(By.xpath("//i[@class='arrow fas fa-chevron-left']/.."));
        rightPagination = driver.findElement(By.xpath("//i[@class='arrow fas fa-chevron-right']/.."));
	}

	// Page Object
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
	
	
	// Functional
    
    

	// Business Logic
}
