package com.softserve.edu.greencity.ui.pages.econews;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.softserve.edu.greencity.ui.data.Languages;
import com.softserve.edu.greencity.ui.data.NewsData;
import com.softserve.edu.greencity.ui.data.Tag;
import com.softserve.edu.greencity.ui.pages.common.TopPart;
import com.softserve.edu.greencity.ui.tools.QuantityItems;


/**
 * 
 * @author lv-493 Taqc/Java
 *
 */
public class EconewsPage extends TopPart {
	
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

		int i = 0; 
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List <WebElement> listElements = driver.findElements(By.cssSelector("div[id='list-gallery-content']"));
		
		scrollToElement(getCopyright()); ///
		while (i < listElements.size()) {
			
//			WebDriverWait wait = new WebDriverWait(driver, 5); 
//		    wait.until(ExpectedConditions.elementToBeClickable(listElements.get(i)));

			scrollToElement(listElements.get(i));
			i++;
			listElements = driver.findElements(By.cssSelector("div[id='list-gallery-content']"));	
			}	
	}
	
	private void initElements() {
		
		tagsComponent = new TagsComponent(driver);
		createNewsButton = driver.findElement(By.id("create-button"));
		itemsContainer = new ItemsContainer(driver);
		gridView = driver.findElement(By.cssSelector("div[class*='gallery-view']"));
		listView = driver.findElement(By.cssSelector("div[class*='list-view']"));
		
		foundItems = driver.findElement(By.xpath("//p[@class=\"ng-star-inserted\"]"));
	}

	// Page Object
	
	//tagsComponent
	
	protected TagsComponent getTagsComponent() {
		return tagsComponent;
	}
	
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
 	
 	protected void scrollToElement(WebElement el) {
//	JavascriptExecutor js = (JavascriptExecutor) driver;
//    js.executeScript("arguments[0].scrollIntoView(true);", el);
 		Actions action = new Actions(driver);
 		action.moveToElement(el).perform();
	}
 	
 	 public int getNumberOfItemComponent() {
 	    
//     	String pattern = "\\d+";
//     	String text = getFoundItemsText();
//     	Pattern p = Pattern.compile(pattern);	
 //    	Matcher m = p.matcher(text);    	
 //    	if(m.find()) {
  //   		return Integer.valueOf(text.substring(m.start(), m.end()));
 //    	}
 //    	return -1;
 		 return new QuantityItems().quantityItems(getFoundItemsText());
     }
 	
 	// Business Logic
 	
 	/**
	 * Method allows to choose type of news, which will be displayed on the EcoNews
	 * Page
	 * 
	 * @param list of NewsFilter's
	 * @return EconewsPage
	 */
	public EconewsPage selectFilters(List<Tag> tags) {
		scrollToElement(getTagsComponent().getTags().get(1));
		getTagsComponent().selectTags(tags);
		return new EconewsPage(driver);
	}
 	
	
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
	}
	
	/**
	 * Open CreateNewsPage
	 * @return CreateNewsPage
	 */
	 public CreateNewsPage gotoCreateNewsPage(){
		 	scrollToElement(getCreateNewsButton());
		 	clickCreateNewsButton(); 
		    return new CreateNewsPage(driver);
		  }
}
