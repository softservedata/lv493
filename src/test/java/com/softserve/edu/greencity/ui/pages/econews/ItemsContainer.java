package com.softserve.edu.greencity.ui.pages.econews;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ItemsContainer {
	//
	private WebDriver driver;
	//
	private List<ItemComponent> itemComponents;
	
	public ItemsContainer(WebDriver driver) {
		this.driver = driver;
		initElements();
	}

	private void initElements() {
		
		itemComponents = new ArrayList<>();
		 for (WebElement current : driver
				 .findElements(By.xpath("//div[@class=\"container\"]//ul[contains(@class, \"list\")]/li"))) {
			 itemComponents.add(new ItemComponent(driver, current));
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

    public List<String> getItemComponentsHeader() {  
        List<String> itemComponentsHeader = new ArrayList<>();
        for(ItemComponent cur : getItemComponents()) {
        	itemComponentsHeader.add(cur.getHeaderText());
        }
        return itemComponentsHeader;
    }

	// Business Logic
}
