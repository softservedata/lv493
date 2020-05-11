package com.softserve.edu.greencity.ui.pages.econews;

import java.util.List;
import java.util.concurrent.TimeUnit;

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
	private WebElement foundItems;

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
//		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
//				Wait wait = new FluentWait<WebDriver>(driver)
//				.withTimeout(50, TimeUnit.SECONDS)
//				.pollingEvery(3, TimeUnit.SECONDS)
//				.ignoring(NoSuchElementException.class);
//		WebDriverWait wait = new WebDriverWait(driver,30);
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.bottom-part")));
//		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
//		visibility("div.bottom-part");
//		List <WebElement> listElements = driver.findElements(By.cssSelector("div[id='list-gallery-content']"));
//		WebDriverWait wait = new WebDriverWait(driver, 5); 
//	    wait.until(ExpectedConditions.elementToBeClickable(listElements.get(i)));

		scrollToElement(getCopyright()); ///

		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

//		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
//		Wait wat = new FluentWait<WebDriver>(driver)
//				.withTimeout(50, TimeUnit.SECONDS)
//				.pollingEvery(3, TimeUnit.SECONDS)
//				.ignoring(NoSuchElementException.class);
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		List <WebElement> listElements = driver.findElements(By.cssSelector("div[id='list-gallery-content']"));
		while (i < listElements.size()) {

			try {
				Thread.sleep(2000);
				} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
/*
 * driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); Wait wt = new
 * FluentWait<WebDriver>(driver) .withTimeout(50, TimeUnit.SECONDS)
 * .pollingEvery(3, TimeUnit.SECONDS) .ignoring(NoSuchElementException.class);
 * 
 * driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 */
			scrollToElement(listElements.get(i));
			i++;
			listElements = driver.findElements(By.cssSelector("div[id='list-gallery-content']"));	
			}	
	}

	public void visibility() {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
//		Wait wait = new FluentWait<WebDriver>(driver)
//				.withTimeout(50, TimeUnit.SECONDS)
//				.pollingEvery(3, TimeUnit.SECONDS)
//				.ignoring(NoSuchElementException.class);
		WebDriverWait wait = new WebDriverWait(driver, 30);
//		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locator)));
//		wait.until(ExpectedConditions.visibilityOfAllElements(elements)
		wait.until(ExpectedConditions.textToBePresentInElement(foundItems, getFoundItemsText()));
//		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
//		            public Boolean apply(WebDriver driver) {
//		                return getFoundItemsText().contains
//		                		(String.valueOf(getItemsContainer().getItemComponentsCount()));

//		             }
//		});
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	private void initElements() {

		tagsComponent = new TagsComponent(driver);
		createNewsButton = driver.findElement(By.id("create-button"));
		itemsContainer = new ItemsContainer(driver);
		gridView = driver.findElement(By.cssSelector("div[class*='gallery-view']"));
		listView = driver.findElement(By.cssSelector("div[class*='list-view']"));

		foundItems = driver.findElement(By.xpath("//p[@class=\"ng-star-inserted\"]"));
//		visibility();
	}

	// Page Object

	// tagsComponent

	protected TagsComponent getTagsComponent() {
		return tagsComponent;
	}

	// foundItems
	protected WebElement getFoundItems() {
		return foundItems;
	}

	protected String getFoundItemsText() {
		return getFoundItems().getText();
	}

	// gridViev

	protected WebElement getGridView() {
		return gridView;
	}

	public boolean isActiveGridView() {
		return getGridView().getAttribute("class").contains("active");
	}

	public void clickGridView() {
		if (!isActiveGridView()) {
			scrollToElement(getGridView());
			getGridView().click();
		}
	}

	// listViev

	protected WebElement getListView() {
		return listView;
	}

	public boolean isActiveListView() {
		return getListView().getAttribute("class").contains("active");
	}

	public void clickListView() {
		if (!isActiveListView()) {
			scrollToElement(getListView());
			getListView().click();
		}
	}

	// createNewsButton

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
		// Matcher m = p.matcher(text);
		// if(m.find()) {
		// return Integer.valueOf(text.substring(m.start(), m.end()));
		// }
		// return -1;
		return new QuantityItems().quantityItems(getFoundItemsText());
	}

//		private void waitComplite() {
//			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
//			WebDriverWait wait = new WebDriverWait(driver, 15);
//			wait.until(driver1 -> ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
//					.equals("complete"));
//			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		}

	// Business Logic

	/**
	 * Method allows to choose type of news, which will be displayed on the EcoNewsPage 
	 * @param List<Tag> tags
	 * @return EconewsPage
	 */
	public EconewsPage selectFilters(List<Tag> tags) {

		scrollToElement(getTagsComponent().getTags().get(1));
		getTagsComponent().selectTags(tags);
		return new EconewsPage(driver);
	}
	
	/**
	 * Method allows to choose type of news, which will be displayed on the EcoNewsPage 
	 * @param List<Tag> tags
	 * @return EconewsPage
	 */
	public EconewsPage deselectFilters(List<Tag> tags) {

		scrollToElement(getTagsComponent().getTags().get(1));
		getTagsComponent().deselectTags(tags);
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
	 * @return EconewsPage
	 */
	public EconewsPage switchToGridViev() {
		clickGridView();
		return new EconewsPage(driver);
	}

	/**
	 * News are displaeyd as list
	 * 
	 * @return EconewsPage
	 */
	public EconewsPage switchToListViev() {
		clickListView();
		return new EconewsPage(driver);
	}

	/**
	 * Open OneNewsPage
	 * 
	 * @param int
	 * @return OneNewsPage
	 */
	public OneNewsPage switchToOneNewsPagebyNumber(int number) {
		scrollToElement(itemsContainer.chooseNewsByNumber(number).getIitle());
		itemsContainer.chooseNewsByNumber(number).clickIitle();
		return new OneNewsPage(driver);
	}

	/**
	 * Open OneNewsPage
	 * 
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
	public CreateNewsPage gotoCreateNewsPage() {
		scrollToElement(getCreateNewsButton());
		clickCreateNewsButton();
		return new CreateNewsPage(driver);
	}
}
