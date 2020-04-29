package com.softserve.edu.greencity.ui.pages.econews;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.greencity.ui.data.Languages;
import com.softserve.edu.greencity.ui.data.NewsFilter;
import com.softserve.edu.greencity.ui.pages.common.MainMenuDropdown;
import com.softserve.edu.greencity.ui.pages.common.TopPart;

/**
 * 
 * @author lv-493 Taqc/Java
 *
 */
public class EconewsPage extends TopPart {
	
	
	private List<WebElement> filtersList;
	private WebElement createNewsButton;
	private WebElement gridView;
	private WebElement listView;
	private ItemsContainer itemsContainer;

	public EconewsPage(WebDriver driver) {
		super(driver);
		initElements();
	}

	private void initElements() {
		
		filtersList = driver.findElements(By.xpath("//ul[@class=\"ul-eco-buttons\"]/a/li"));
		createNewsButton = driver.findElement(By.id("create-button"));
		itemsContainer = new ItemsContainer(driver);
		gridView = driver.findElement(By.xpath("//div[contains(@class, \"gallery-view\")]"));
		listView = driver.findElement(By.xpath("//div[contains(@class, \"list-view\")]/div"));;
	}

	// Page Object
	
	//gridViev
	
	protected WebElement getGridView() {
        return gridView;
    }
    
	public boolean IsActiveGridView() {
   	 return getGridView().getAttribute("class").contains("active");
   }
	
    public void clickGridView() {
    	if(!IsActiveGridView()) {
        getGridView().click();
    	}
    }
    
  //listViev
	
    protected WebElement getListView() {
          return listView;
      }
    
    protected boolean IsActiveListView() { 
        return getListView().getAttribute("class").contains("active");
      }
    
    public void clickListView() {
    	if(!IsActiveListView()) {
    		 getListView().click();
    	}
      }
 
	//createNewsButton
	
	protected WebElement getCreateNewsButton() {
        return createNewsButton;
    }

    protected String getCreateNewsButtonText() {
        return getCreateNewsButton().getText();
    }
    
    protected void clickCreateNewsButton() {
        getCreateNewsButton().click();
    }
    
	
    // itemsContainer
	
 	public ItemsContainer getItemsContainer() {
 		return itemsContainer;
 	}
 	
 	//filtersList
 	
 	public List<WebElement> getFiltersList() {
 		return filtersList;
 	}
	// Functional
 	
 	//TODO  deselect filters; 
 	
 	/**
 	 * method allows to check which filters are choosen
 	 * @return activeFilters
 	 */
 	public List<WebElement> checkActiveFilters() {
 		List<WebElement> activeFilters = new ArrayList<>();
 		for(WebElement curr : getFiltersList()) {
 			if(curr.getAttribute("class").contains("clicked-filter-button")) {
 			activeFilters.add(curr);
 			}
 		}
 		return activeFilters;
 	}
 	
 	public WebElement getWebElementByFilterName(NewsFilter newsfilter) {
		return driver.findElement(By.xpath("//li[contains(text(),\"" + newsfilter.toString() + "\")]"));
	}
 	
 	public boolean filterIsActive(NewsFilter newsfilter) {
 		return getWebElementByFilterName(newsfilter).getAttribute("class").contains("clicked-filter-button");
 	}
 	
 	public void chooseOneFilter(NewsFilter newsfilter)  {
 		if(!filterIsActive(newsfilter)) {
 			getWebElementByFilterName(newsfilter).click();
 		}
 	}
 	
 	public void chooseFilters(NewsFilter...newsfilters) {
 		for(NewsFilter cur : newsfilters) {
 			chooseOneFilter(cur);
 		}			
 	}
 	
 	// Business Logic
 	
 	/**
 	 * Method allows to choose type of news, which will be displayed on the EcoNews Page
 	 * @param list of NewsFilter's
 	 * @return EconewsPage
 	 */
 	public EconewsPage selectFilters(NewsFilter...newsfilters) {
 		chooseFilters(newsfilters);
		return new EconewsPage(driver);
	}
 	
	
 	/**
 	 * Choose language
 	 * @param language
 	 * @return EconewsPage
 	 */
	public EconewsPage switchLanguage(Languages language) {
		chooseLanguage(language);
		return new EconewsPage(driver);
	}
	
	/**
	 * News are displayed as grid
	 * @return  EconewsPage
	 */
	public EconewsPage switchToGridViev() {
			clickGridView();
		return new EconewsPage(driver);
	}
	
	/**
	 * News are displaeyd as list
	 * @return  EconewsPage
	 */
	public EconewsPage switchToListViev() {
		clickListView();
		return new EconewsPage(driver);
	}
	
}
