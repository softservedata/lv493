package com.softserve.edu.greencity.ui.pages.econews;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.softserve.edu.greencity.ui.data.Languages;
import com.softserve.edu.greencity.ui.data.NewsData;
import com.softserve.edu.greencity.ui.data.Tag;
import com.softserve.edu.greencity.ui.pages.common.TopPart;


/**
 * 
 * @author lv-493 Taqc/Java
 *
 */
public class EconewsPage extends TopPart {
	
	
	//private List<WebElement> tagsList;
	private TagsComponent tagsComponent;
	private WebElement createNewsButton;
	private WebElement gridView;
	private WebElement listView;
	private ItemsContainer itemsContainer;
	private WebElement foundItems; //move from ItemsContainer

	public EconewsPage(WebDriver driver) {
		super(driver);
		visualiseElements();
		initElements();
		
	}
	
	private void visualiseElements() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int i = 0; 
		List <WebElement> listElements = driver.findElements(By.cssSelector("div[id='list-gallery-content']"));
		scrollToElement(getCopyright()); ///
		while (i < listElements.size()) {
			
			//WebDriverWait wait = new WebDriverWait(driver, 5); 
		    //wait.until(ExpectedConditions.elementToBeClickable(listElements.get(i)));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println("element " + listElements.get(i).getText() + "   i ="  + i);
			scrollToElement(listElements.get(i));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			i++;
			listElements = driver.findElements(By.cssSelector("div[id='list-gallery-content']"));	
			}	
	}
	
	private void initElements() {
		
		tagsComponent = new TagsComponent(driver);
		//tagsList = driver.findElements(By.xpath("//ul[@class=\"ul-eco-buttons\"]/a/li"));
		createNewsButton = driver.findElement(By.id("create-button"));
		itemsContainer = new ItemsContainer(driver);
		gridView = driver.findElement(By.cssSelector("div[class*='gallery-view']"));
		listView = driver.findElement(By.cssSelector("div[class*='list-view']"));
		foundItems = driver.findElement(By.xpath("//p[@class=\"ng-star-inserted\"]"));
	}

	// Page Object
	
	//foundItems
	protected WebElement getFoundItems() {
        return foundItems;
    }

    protected String getFoundItemsText() {
        return getFoundItems().getText();
    }

	//gridViev
	
	protected WebElement getGridView() {
        return gridView;
    }
    
	public boolean IsActiveGridView() {
   	 return getGridView().getAttribute("class").contains("active");
   }
	
    public void clickGridView() {
    	if(!IsActiveGridView()) {
    		scrollToElement(getGridView());
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
    		scrollToElement(getListView());
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
 	
 	//tagsList
 	
//	public List<WebElement> getTagsList() {
// 		return tagsList;
// 	}
 	
	// Functional
 	
 	protected void scrollToElement(WebElement el) {
	//	JavascriptExecutor js = (JavascriptExecutor) driver;
    //    js.executeScript("arguments[0].scrollIntoView(true);", el);
 		Actions action = new Actions(driver);
 		action.moveToElement(el).perform();
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
 	
 	//TODO  deselect filters; 
 	
// 	/**
// 	 * method allows to check which filters are choosen
// 	 * @return activeFilters
// 	 */
// 	public List<WebElement> checkActiveFilters() {
// 		List<WebElement> activeFilters = new ArrayList<>();
 //		for(WebElement curr : getTagsButtons()) {
 //			if(curr.getAttribute("class").contains("clicked-filter-button")) {
// 			activeFilters.add(curr);
 //			}
// 		}
 //		return activeFilters;
 //	}
 	
 	public WebElement getWebElementByTagName(Tag newsfilter) {
		return driver.findElement(By.xpath("//app-eco-news//div[@class='wrapper']//li[contains(text(),'" + newsfilter.toString() + "')]"));
	}
 	
 	public boolean isActiveTag(Tag newsfilter) {
 		return getWebElementByTagName(newsfilter).getAttribute("class").contains("clicked-filter-button");
 	}
 	
 	public void chooseOneTag(Tag newsfilter)  {
 		if(!isActiveTag(newsfilter)) {
 			getWebElementByTagName(newsfilter).click();
 		}
 	}
 	
 	public void chooseTags(Tag...newsfilters) {
 		for(Tag cur : newsfilters) {
 			chooseOneTag(cur);
 		}			
 	}
 	
 	// Business Logic
 	
 //	/**
 //	 * Method allows to choose type of news, which will be displayed on the EcoNews Page
 //	 * @param list of NewsFilter's
 //	 * @return EconewsPage
 //	 */
 //	public EconewsPage selectFilters(Tag...newsfilters) {
 //		scrollToElement(getTagsList().get(1));
 //		chooseTags(newsfilters);
//		return new EconewsPage(driver);
//	}
 	
	
 	/**
 	 * Choose language
 	 * @param Languages
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
	
	/**
	 * Open OneNewsPage 
	 * @param int
	 * @return  OneNewsPage
	 */
	public OneNewsPage switchToOneNewsPagebyNumber(int number) {
		scrollToElement(itemsContainer.chooseNewsByNumber(number).getIitle());
		itemsContainer.chooseNewsByNumber(number).clickIitle();
		return new OneNewsPage(driver);
	}
	
	/**
	 * Open OneNewsPage
	 * @param OneNewsData 
	 * @return OneNewsPage
	 */
	public OneNewsPage switchToOneNewsPagebyParameters(NewsData news) {
		scrollToElement(itemsContainer.findItemComponentByParameters(news).getIitle());
		itemsContainer.clickItemComponentOpenPage(news);
		return new OneNewsPage(driver);
	
	//TODO method for authorization 
	}
	
	 public CreateNewsPage gotoCreateNewsPage(){
		 	scrollToElement(getCreateNewsButton());
		 	clickCreateNewsButton(); 
		    return new CreateNewsPage(driver);
		  }
}
