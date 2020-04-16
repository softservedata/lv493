package com.softserve.edu;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.softserve.edu.data.InvalidValuesSearchCategoriesRepo;
import com.softserve.edu.data.SearchInCategoriesRepository;
import com.softserve.edu.data.SearchItem;


import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchTest extends  SearchTestRunner {

	private final String mainSearchInputField = "//input[@name=\"search\"]";
	private final String mainSearchButton = "//div[@id=\"search\"]/span/button";
	private final String findedElements = "//div[@id=\"content\"]/div[@class=\"row\"]//h4/a";
	private final String alertMessage ="//input[@id=\"button-search\"]/following-sibling::p";
	private final String advancedSearchButton = "button-search";
	private final String ERROR_MESSAGE = "There is no product that matches the search criteria.";

	
	@DataProvider(name = "search-with--description")
	public String[] parameterIntTestProvider() {
		return new String[] { 
				"The 30-inch Apple Cinema HD Display delivers an amazing 2560 x 1600 pixel resolution.",
				"Offering accurate, brilliant color performance",
				"The Cinema HD features a single cable design with elegant breakout for the USB 2.0, FireWire 400 and a pure digital connection using the industry standard Digital Video Interface (DVI) interface. The DVI connection allows for a direct pure-digital connection.",
				"Housed in a new aluminum design, the display has a very thin bezel that enhances visual accuracy. Each display features two FireWire 400 ports and two USB 2.0 ports, making attachment of desktop peripherals, such as iSight, iPod, digital and still cameras, hard drives, printers and scanners, even more accessible and convenient. Taking advantage of the much thinner and lighter footprint of an LCD, the new displays support the VESA (Video Electronics Standards Association) mounting interface standard. Customers with the optional Cinema Display VESA Mount Adapter kit gain the flexibility to mount their display in locations most appropriate for their work environment" };
	}


	@DataProvider
	public Object[][] validDataProvider() {
		return new Object[][] {
				{ SearchInCategoriesRepository.searchAllCategories()} 
		};
	}
	
	/*
	 * Search product by its name
	 */
	//@Test(dataProvider = "validDataProvider")
	public void simpleTest(SearchItem searchItem) throws IOException, InterruptedException {

		driver.findElement(By.xpath(mainSearchInputField)).click();
		driver.findElement(By.xpath(mainSearchInputField)).clear();
		driver.findElement(By.xpath(mainSearchInputField)).sendKeys(searchItem.getSearchText());
		driver.findElement(By.xpath(mainSearchButton)).click();
		
		takeScreenShot(driver);
		List<WebElement> product = driver.findElements(By.xpath(findedElements));
		System.out.println("size " + product.size());
		for (WebElement elem : product) {
			System.out.println(elem.getText());
			Assert.assertTrue(elem.getText().toLowerCase().contains(searchItem.getSearchText()));
		}
		takeScreenShot(driver);
	}
	
	@DataProvider
	public Object[][] inValidSearcValue() {
		return new Object[][] {
				{InvalidValuesSearchCategoriesRepo.searchAllCategories()} 
		};
	}
	
	/*
	 * Search product by its name, if that product does not exist
	 * 
	 */
//	@Test(dataProvider = "inValidSearcValue", 
//		  expectedExceptions = NoSuchElementException.class)
	public void simpleTestNegative(SearchItem searchItem) {

		driver.findElement(By.xpath(mainSearchInputField)).click();
		driver.findElement(By.xpath(mainSearchInputField)).clear();
		driver.findElement(By.xpath(mainSearchInputField)).sendKeys(searchItem.getSearchText());
		driver.findElement(By.xpath(mainSearchButton)).click();
		
		Assert.assertTrue(driver.findElement(By.xpath(findedElements)).isEnabled()); 
		Assert.assertEquals(driver.findElement( By.xpath(alertMessage)).getText(), ERROR_MESSAGE);
	}
	
	/*
	 * Checking input field is sensetiwe in case
	 * 
	 */
	//@Test(dataProvider = "validDataProvider")
	public void verifySensCase(SearchItem searchItem) {

		driver.findElement(By.xpath(mainSearchInputField)).click();
		driver.findElement(By.xpath(mainSearchInputField)).clear();
		driver.findElement(By.xpath(mainSearchInputField)).sendKeys(searchItem.getSearchText().toLowerCase());
		driver.findElement(By.xpath(mainSearchButton)).click();

		List<WebElement> productLowCase = driver.findElements(By.xpath(findedElements));
		for (WebElement elem : productLowCase) {
			System.out.println(elem.getText());
		}
		// driver.get("http://192.168.171.129/opencart/upload/");
		//driver.get("http://taqc-opencart.epizy.com/index.php?route=common/home");
		driver.get("http://34.65.1.160/opencart/upload/");

		driver.findElement(By.xpath(mainSearchInputField)).click();
		driver.findElement(By.xpath(mainSearchInputField)).clear();
		driver.findElement(By.xpath(mainSearchInputField)).sendKeys(searchItem.getSearchText().toUpperCase());
		driver.findElement(By.xpath(mainSearchButton)).click();

		List<WebElement> productUpperCase = driver.findElements(By.xpath(findedElements));
		for (WebElement elem : productUpperCase) {
			System.out.println(elem.getText());
		}

		Assert.assertTrue(productLowCase.toString().equals(productUpperCase.toString()));

	}

	@DataProvider
	public Object[][] categories() {
		return new Object[][] {
				{ SearchInCategoriesRepository.searchCategoryCameras()},
			    { SearchInCategoriesRepository.searchCategoryComponents()},
				{ SearchInCategoriesRepository.searchCategoryDesctops()},
				{ SearchInCategoriesRepository.searchCategoryLaptops()},
				{ SearchInCategoriesRepository.searchCategoryMp3Players()},
				{ SearchInCategoriesRepository.searchCategoryPhones()},
				{ SearchInCategoriesRepository.searchCategoryTablets()}
		};
	}
	
	/*
	 * Search product by its name & category
	 * 
	 */
	//@Test(dataProvider = "categories")
	public void searchInCategories(SearchItem searchItem) {

		driver.findElement(By.xpath(mainSearchInputField)).click();
		driver.findElement(By.xpath(mainSearchInputField)).clear();
		driver.findElement(By.xpath(mainSearchInputField)).sendKeys(searchItem.getSearchText());
		driver.findElement(By.xpath(mainSearchButton)).click();
		
		Select select = new Select(driver.findElement(By.name("category_id")));
		List<WebElement> options = select.getOptions();
		for (WebElement elem : options) {
			if (elem.getText().contains(searchItem.getCategories().getCategorieseName())) {
				System.out.println(elem.getText());
				elem.click();
			}
		}
		driver.findElement(By.name("sub_category")).click();
		driver.findElement(By.id(advancedSearchButton)).click();
		List<WebElement> product = driver.findElements(By.xpath(findedElements));
		
		for (WebElement el : product) {
			Assert.assertTrue(el.getText().toLowerCase().contains(searchItem.getSearchText()));
		}
		Assert.assertNotNull(product.size());
	}

	@DataProvider
	public Object[][] categoriesNegative() {
		return new Object[][] {
				{ InvalidValuesSearchCategoriesRepo.searchCategoryCameras()},
			    { InvalidValuesSearchCategoriesRepo.searchCategoryComponents()},
				{ InvalidValuesSearchCategoriesRepo.searchCategoryDesctops()},
				{ InvalidValuesSearchCategoriesRepo.searchCategoryLaptops()},
				{ InvalidValuesSearchCategoriesRepo.searchCategoryMp3Players()},
				{ InvalidValuesSearchCategoriesRepo.searchCategoryPhones()},
				{ InvalidValuesSearchCategoriesRepo.searchCategoryTablets()}
		};
	}
	
	/*
	 * Search product by its name & category, when invalid value is entered
	 * 
	 */
	//@Test(expectedExceptions = NoSuchElementException.class,
	//		dataProvider = "categoriesNegative")
	public void searchInCategoriesNegative(SearchItem searchItem) throws IOException, InterruptedException {

		driver.findElement(By.xpath(mainSearchInputField)).click();
		driver.findElement(By.xpath(mainSearchInputField)).clear();
		driver.findElement(By.xpath(mainSearchInputField)).sendKeys(searchItem.getSearchText());
		driver.findElement(By.xpath(mainSearchButton)).click();

		Select select = new Select(driver.findElement(By.name("category_id")));
		List<WebElement> options = select.getOptions();
		for (WebElement elem : options) {
			if (elem.getText().contains(searchItem.getCategories().getCategorieseName())) {
				System.out.println(elem.getText());
				elem.click();
			}
		}
		driver.findElement(By.name("sub_category")).click();
		driver.findElement(By.id(advancedSearchButton)).click();

		Assert.assertTrue(driver.findElement(By.xpath(findedElements)).isEnabled());
		Assert.assertEquals(driver.findElement(By.xpath(alertMessage)).getText(), ERROR_MESSAGE);
	}
	
	@DataProvider
	public Object[][] subCategories() {
		return new Object[][] {
			{ SearchInCategoriesRepository.searchSubCategoryMac() },
			{ SearchInCategoriesRepository.searchSubCategoryMacbook() },
			{ SearchInCategoriesRepository.searchSubCategoryPC() },
		};	
	}
	/*
	 * Search product by its name & subcategory
	 * 
	 */
	//@Test(dataProvider = "subCategories")
	public void searchInSubCategories(SearchItem searchItem) {

		driver.findElement(By.xpath(mainSearchInputField)).click();
		driver.findElement(By.xpath(mainSearchInputField)).clear();
		driver.findElement(By.xpath(mainSearchInputField)).sendKeys(searchItem.getSearchText());
		driver.findElement(By.xpath(mainSearchButton)).click();

		Select select = new Select(driver.findElement(By.name("category_id")));
		List<WebElement> options = select.getOptions();
		for (WebElement elem : options) {
			if (elem.getText().contains(searchItem.getCategories().getCategorieseName())) {
				System.out.println(elem.getText());
				elem.click();
			}
		}
		driver.findElement(By.id(advancedSearchButton));
		List<WebElement> product = driver.findElements(By.xpath(findedElements));
		System.out.println(product.size());
		for (WebElement elem : product) {
			Assert.assertTrue(elem.getText().toLowerCase().contains(searchItem.getSearchText()));
		}
		Assert.assertTrue(product.size() > 0);
	}
	
	@DataProvider
	public Object[][] subCategoriesNegative() {
		return new Object[][] {
			{ InvalidValuesSearchCategoriesRepo.searchSubCategoryMac() },
			{ InvalidValuesSearchCategoriesRepo.searchSubCategoryMacbook() },
			{ InvalidValuesSearchCategoriesRepo.searchSubCategoryPC() }
		};	
	}
	
	/*
	 * Search product by its name & subcategory when invalid value is entered
	 * 
	 */
	 @Test(expectedExceptions = NoSuchElementException.class,
			 dataProvider = "subCategoriesNegative")
	public void searchInSubCategoriesNedativ(SearchItem searchItem) {

		driver.findElement(By.xpath(mainSearchInputField)).click();
		driver.findElement(By.xpath(mainSearchInputField)).clear();
		driver.findElement(By.xpath(mainSearchInputField)).sendKeys(searchItem.getSearchText());
		driver.findElement(By.xpath(mainSearchButton)).click();

		Select select = new Select(driver.findElement(By.name("category_id")));
		List<WebElement> options = select.getOptions();
		for (WebElement elem : options) {
			if (elem.getText().contains(searchItem.getCategories().getCategorieseName())) {
				System.out.println(elem.getText());
				elem.click();
			}
		}
		driver.findElement(By.id(advancedSearchButton));
		Assert.assertTrue(driver.findElement(By.xpath(findedElements)).isEnabled());
		Assert.assertEquals(
				driver.findElement(By.xpath("//input[@id=\"button-search\"]/following-sibling::p")).getText(),
				ERROR_MESSAGE);

	}
	
    /*
     * search product by its description
     */
	// @Test(dataProvider = "search-with--description")
	public void searchInDescription(String description) {

		driver.findElement(By.xpath(mainSearchInputField)).click();
		driver.findElement(By.xpath(mainSearchInputField)).clear();
		driver.findElement(By.xpath(mainSearchInputField)).sendKeys("samsung");
		driver.findElement(By.xpath(mainSearchButton)).click();

		driver.findElement(By.id("description")).click();
		driver.findElement(By.xpath("//input[@id=\"input-search\"]")).clear();
		driver.findElement(By.xpath("//input[@id=\"input-search\"]")).sendKeys(description);
		// "Offering accurate, brilliant color performance, the Cinema HD");

		driver.findElement(By.id(advancedSearchButton)).click();

		List<WebElement> product = driver.findElements(By.xpath(findedElements)); // "//div[@id=\"content\"]/div[@class=\"row\"]//h4/following-sibling::p"));
		System.out.println("size " + product.size());
		for (WebElement elem : product) {
			System.out.println(elem.getText());
			elem.click();
			List<WebElement> descriptions = driver.findElements(By.xpath("//div[@id=\"tab-description\"]/p/font/font"));
			String s = "";
			for (WebElement element : descriptions) {
				System.out.println(element.getText());
				s = s + (element.getText());
			}
			Assert.assertTrue(s.toLowerCase().contains("ima"));
			// ((JavascriptExecutor) driver).executeScript("window.history.go(-1)");
			//driver.navigate().back();
		}
		System.out.println("The lendth of search query is " + description.length());
	}

	

}
