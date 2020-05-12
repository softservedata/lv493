package com.softserve.edu.greencity.ui.pages.map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DiscountRateComponent {
	
	private WebDriver driver;
	
	
	private WebElement workNowCheckbox;
	private WebElement applyFilterButton;
	private WebElement distanceInput;
	private WebElement slider;
	

	public DiscountRateComponent(WebDriver driver) {
		this.driver = driver;
		initElements();
	}

	private void initElements() {
		// init elements
		workNowCheckbox = driver.findElement(By.id("is_open_checkbox")); 
		applyFilterButton = driver.findElement(By.id("apply_filter_btn")); 
	    distanceInput = driver.findElement(By.xpath("//div/input[@aria-label='Distance']"));
		slider = driver.findElement(By.xpath("//span[@role='slider']"));
	}

	// Page Object
	
    
    public WebElement getWorkNowCheckbox() {
        return workNowCheckbox;
    }

    public String getWorkNowCheckboxText() {
        return getWorkNowCheckbox().getText();
    }

    public void clickWorkNowCheckbox(){
    	getWorkNowCheckbox().click();
    	
    }
    public void isSelectedWorkNowCheckbox() {
    	workNowCheckbox.isSelected();
    	}
    
    public WebElement getApplyFilterButton() {
        return applyFilterButton;
    }

    public String getApplyFilterButtonText() {
        return getApplyFilterButton().getText();
    }

    public void clickApplyFilterButton(){
    	getApplyFilterButton().click();
    	
    }
    public WebElement getDistanceInput() {
        return distanceInput;
    }

    public String getDistanceInputText() {
        return getDistanceInput().getText();
    }

    public void clickDistanceInput(){
    	getDistanceInput().click();
    	
    }
    public void clearDistanceInput(){
    	getDistanceInput().clear();
    	
    }
    public WebElement getSlider() {
        return slider;
    }

    public String getSliderText() {
        return getSlider().getText();
    }

    public void clickSlider() {
    	getSlider().click();
    	
    }
 
}