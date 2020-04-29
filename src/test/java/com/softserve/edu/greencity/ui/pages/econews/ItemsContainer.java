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
	private WebElement foundItems;
	
	public ItemsContainer(WebDriver driver) {
		this.driver = driver;
		initElements();
	}

	private void initElements() {
		
		foundItems = driver.findElement(By.xpath("//p[@class=\"ng-star-inserted\"]"));
		itemComponents = new ArrayList<>();
		 for (WebElement current : driver
				 .findElements(By.xpath("//div[@class=\"container\"]//ul[contains(@class, \"list\")]/li"))) {
			 itemComponents.add(new ItemComponent(driver, current));
	        }
	}
	
	// Page Object
	
	//foundItems
	
	protected WebElement getFoundItems() {
        return foundItems;
    }

    protected String getFoundItemsText() {
        return getFoundItems().getText();
    }

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

    public int getNumberOfItemComponent() {
    
    	String pattern = "\\d+";
    	String text = getFoundItemsText();
    	Pattern p = Pattern.compile(pattern);	
    	Matcher m = p.matcher(text);
    	
    	if(m.find()) {
    		return Integer.valueOf(text.substring(m.start(), m.end()));
    	}
    	return -1;
    }

	// Business Logic
}
