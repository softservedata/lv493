package com.softserve.edu.greencity.ui.pages.econews;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.greencity.ui.data.Languages;
import com.softserve.edu.greencity.ui.pages.common.MainMenuDropdown;
import com.softserve.edu.greencity.ui.pages.common.TopPart;

/**
 * 
 * @author lv-493 Taqc/Java
 *
 */
public class EconewsPage extends TopPart {
	
	//filters
	private List<WebElement> filtersList;
	//private WebElement typeOfNewsFilter;
	private WebElement newsFilter;
	private WebElement eventsFilter;
	private WebElement courcesFilter;
	private WebElement initiativesFilter;
	private WebElement adsFilter;
	
	private WebElement createNewsButton;
	
	private WebElement gridViev;
	private WebElement listViev;
	
	private ItemsContainer itemsContainer;

	public EconewsPage(WebDriver driver) {
		super(driver);
		initElements();
	}

	private void initElements() {
		
		filtersList = driver.findElements(By.xpath("//ul[@class=\"ul-eco-buttons\"]/a/li"));
		//typeOfNewsFilter = driver.findElement(By.xpath("//ul[@class=\"ul-eco-buttons\"]"));
		
		newsFilter = driver.findElement(By.xpath("//li[contains(text(), \"news\")]"));
		eventsFilter = driver.findElement(By.xpath("//li[contains(text(), \"events\")]"));
		courcesFilter = driver.findElement(By.xpath("//li[contains(text(), \"courses\")]"));
		initiativesFilter = driver.findElement(By.xpath("//li[contains(text(), \"initiatives\")]"));
		adsFilter = driver.findElement(By.xpath("//li[contains(text(), \"ads\")]"));
		
		createNewsButton = driver.findElement(By.id("create-button"));
		itemsContainer = new ItemsContainer(driver);
		
		gridViev = driver.findElement(By.xpath("//div[contains(@class, \"gallery-view\")]"));
		listViev = driver.findElement(By.xpath("//div[contains(@class, \"list-view\")]"));;
	}

	// Page Object
	
	//gridViev
	
	public WebElement getGridViev() {
        return gridViev;
    }
    
    public void clickGridViev() {
        getGridViev().click();
    }
    
    public boolean gridVievIsActive() {
    	 return getGridViev().getAttribute("class").contains("active");
    }
    
  //listViev
	
  	public WebElement getListViev() {
          return listViev;
      }
      
      public void clickListViev() {
          getListViev().click();
      }
      
      public boolean listVievIsActive() {
        return getListViev().getAttribute("class").contains("active");
      }

	//createNewsButton
	
	public WebElement getCreateNewsButton() {
        return createNewsButton;
    }

    public String getCreateNewsButtonText() {
        return getCreateNewsButton().getText();
    }
    
    public void clickCreateNewsButton() {
        getCreateNewsButton().click();
    }
    
	//newsFilter
	
	public WebElement getNewsFilter() {
        return newsFilter;
    }

    public String getNewsFilterText() {
        return getNewsFilter().getText();
    }
    
    public void clickNewsFilter() {
        getNewsFilter().click();
    }
    
    //eventsFilter
    
    public WebElement getEventsFilter() {
        return eventsFilter;
    }

    public String getEventsFilterText() {
        return getEventsFilter().getText();
    }
    
    public void clickEventsFilter() {
        getEventsFilter().click();
    }
    
    //courcesFilter
    
    public WebElement getCourcesFilter() {
        return courcesFilter;
    }

    public String getCourcesFilterText() {
        return getCourcesFilter().getText();
    }
    
    public void clickCourcesFilter() {
        getCourcesFilter().click();
    }
    
    //initiativesFilter
    
    public WebElement getInitiativesFilter() {
        return initiativesFilter;
    }

    public String getInitiativesFilterText() {
        return getInitiativesFilter().getText();
    }
    
    public void clickInitiativesFilter() {
        getInitiativesFilter().click();
    }
    
    //adsFilter
    
    public WebElement getAdsFilter() {
        return adsFilter;
    }

    public String getAdsFilterText() {
        return getAdsFilter().getText();
    }
    
    public void clickAdsFilter() {
        getAdsFilter().click();
    }
    
    // mainMenuDropdown
	
 	public ItemsContainer getItemsContainer() {
 		return itemsContainer;
 	}

	// Functional

	// Business Logic

	public EconewsPage switchLanguage(Languages language) {
		chooseLanguage(language);
		return new EconewsPage(driver);
	}
}
