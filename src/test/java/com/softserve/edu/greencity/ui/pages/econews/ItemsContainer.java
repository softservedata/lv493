package com.softserve.edu.greencity.ui.pages.econews;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ItemsContainer {
	//
	private WebDriver driver;
	//
	private List<ItemComponent> itemComponents;
	private WebElement foundItems;
	
	public ItemsContainer(WebDriver driver) {
		this.driver = driver;
		initElements();
	}

	private void initElements() {
		
		foundItems = driver.findElement(By.xpath("//p[@class=\"ng-star-inserted\"]"));
		itemComponents = new ArrayList<>();
		 for (WebElement current : driver.findElements(By.xpath("//div[@class=\"container\"]//ul[contains(@class, \"list\")]/li'")))
	        {
			 itemComponents.add(new ItemComponent(current));
	        }
	}
	

	// Page Object

    //itemComponents
    public List<ItemComponent> getItemComponents() {
    	return itemComponents;
    }

	// Functional

    public int getItemComponentsCount(){
        return getItemComponents().size();
    }

    public List<String> getItemComponentsHeader() {  //header
        List<String> itemComponentsHeader = new ArrayList<>();
        for(ItemComponent cur : getItemComponents()) {
        	itemComponentsHeader.add(cur.getHeaderText());
        }
        return itemComponentsHeader;
    }

   
	// Business Logic
}
