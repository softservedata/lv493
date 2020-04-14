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

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchTest extends  SearchTestRunner {

	By mainSearchInputField = By.xpath("//input[@name=\"search\"]");
	By mainSearchButton = By.xpath("//div[@id=\"search\"]/span/button");
	By findedElements = By.xpath("//div[@id=\"content\"]/div[@class=\"row\"]//h4/a");
	By alertMessage = By.xpath("//input[@id=\"button-search\"]/following-sibling::p");
	By advancedSearchButton = By.id("button-search");

	
	@DataProvider(name = "search-with--description")
	public String[] parameterIntTestProvider() {
		return new String[] { 
				"The 30-inch Apple Cinema HD Display delivers an amazing 2560 x 1600 pixel resolution.",
				"Offering accurate, brilliant color performance",
				"The Cinema HD features a single cable design with elegant breakout for the USB 2.0, FireWire 400 and a pure digital connection using the industry standard Digital Video Interface (DVI) interface. The DVI connection allows for a direct pure-digital connection.",
				"Housed in a new aluminum design, the display has a very thin bezel that enhances visual accuracy. Each display features two FireWire 400 ports and two USB 2.0 ports, making attachment of desktop peripherals, such as iSight, iPod, digital and still cameras, hard drives, printers and scanners, even more accessible and convenient. Taking advantage of the much thinner and lighter footprint of an LCD, the new displays support the VESA (Video Electronics Standards Association) mounting interface standard. Customers with the optional Cinema Display VESA Mount Adapter kit gain the flexibility to mount their display in locations most appropriate for their work environment" };
	}



	@Test
	public void simpleTest(String searchText) throws IOException, InterruptedException {

		driver.findElement(mainSearchInputField).click();
		driver.findElement(mainSearchInputField).clear();
		driver.findElement(mainSearchInputField).sendKeys(searchText);
		driver.findElement(mainSearchButton).click();
		Thread.sleep(3000);
		takeScreenShot(driver);
		List<WebElement> product = driver.findElements(findedElements);
		System.out.println("size " + product.size());
		for (WebElement elem : product) {
			System.out.println(elem.getText());
			Assert.assertTrue(elem.getText().toLowerCase().contains("mac"));
		}
		takeScreenShot(driver);
	}

	// @Test(expectedExceptions = NoSuchElementException.class)
	public void simpleTestNegative() {

		driver.findElement(mainSearchInputField).click();
		driver.findElement(mainSearchInputField).clear();
		driver.findElement(mainSearchInputField).sendKeys("mmm");
		driver.findElement(mainSearchButton).click();
		String expected = "There is no product that matches the search criteria.";
		driver.findElement(findedElements).isEnabled(); //TO Do
		Assert.assertEquals(driver.findElement(alertMessage).getText(), expected);
	}

	// @Test
	public void verifySensCase() {

		driver.findElement(mainSearchInputField).click();
		driver.findElement(mainSearchInputField).clear();
		driver.findElement(mainSearchInputField).sendKeys("MAC");
		driver.findElement(mainSearchButton).click();

		List<WebElement> productLowCase = driver.findElements(findedElements);
		for (WebElement elem : productLowCase) {
			System.out.println(elem.getText());
		}
		// driver.get("http://192.168.171.129/opencart/upload/");
		driver.get("http://taqc-opencart.epizy.com/index.php?route=common/home");

		driver.findElement(mainSearchInputField).click();
		driver.findElement(mainSearchInputField).clear();
		driver.findElement(mainSearchInputField).sendKeys("mac");
		driver.findElement(mainSearchButton).click();

		List<WebElement> productUpperCase = driver.findElements(findedElements);
		for (WebElement elem : productUpperCase) {
			System.out.println(elem.getText());
		}

		Assert.assertTrue(productLowCase.toString().equals(productUpperCase.toString()));

	}

	// @Test
	public void searchInCategories() {

		driver.findElement(mainSearchInputField).click();
		driver.findElement(mainSearchInputField).clear();
		driver.findElement(mainSearchInputField).sendKeys("microsoft");
		driver.findElement(mainSearchButton).click();

		Select select = new Select(driver.findElement(By.name("category_id")));
		List<WebElement> options = select.getOptions();
		for (WebElement elem : options) {
			if (elem.getText().contains("Software")) {
				System.out.println(elem.getText());
				elem.click();
			}
		}
		driver.findElement(advancedSearchButton).click();
		List<WebElement> product = driver.findElements(findedElements);
		System.out.println("size " + product.size());
		for (WebElement el : product) {
			Assert.assertTrue(el.getText().toLowerCase().contains("microsoft"));
			System.out.println(el.getText());
		}

	}

	//@Test(expectedExceptions = NoSuchElementException.class)
	public void searchInCategoriesNegative() throws IOException, InterruptedException {

		driver.findElement(mainSearchInputField).click();
		driver.findElement(mainSearchInputField).clear();
		driver.findElement(mainSearchInputField).sendKeys("mac");
		driver.findElement(mainSearchButton).click();

		Select select = new Select(driver.findElement(By.name("category_id")));
		List<WebElement> options = select.getOptions();
		for (WebElement elem : options) {
			if (elem.getText().contains("Software")) {
				System.out.println(elem.getText());
				elem.click();
			}
		}
		driver.findElement(advancedSearchButton).click();

		String expected = "There is no product that matches the search criteria.";
		driver.findElement(findedElements).isEnabled();

		Assert.assertEquals(driver.findElement(alertMessage).getText(), expected);
	}

	// @Test
	public void searchInSubCategories() {

		driver.findElement(mainSearchInputField).click();
		driver.findElement(mainSearchInputField).clear();
		driver.findElement(mainSearchInputField).sendKeys("Classic");
		driver.findElement(mainSearchButton).click();

		Select select = new Select(driver.findElement(By.name("category_id")));
		List<WebElement> options = select.getOptions();
		for (WebElement elem : options) {
			if (elem.getText().contains("IPod")) {
				System.out.println(elem.getText());
				elem.click();
			}
		}
		driver.findElement(advancedSearchButton);
		List<WebElement> product = driver.findElements(findedElements);
		System.out.println("size " + product.size());
		for (WebElement elem : product) {
			System.out.println(elem.getText().toLowerCase());
			Assert.assertTrue(elem.getText().toLowerCase().contains("ipod"));
		}
	}

	// @Test(expectedExceptions = NoSuchElementException.class)
	public void searchInSubCategoriesNedativ() {

		driver.findElement(mainSearchInputField).click();
		driver.findElement(mainSearchInputField).clear();
		driver.findElement(mainSearchInputField).sendKeys("Classic");
		driver.findElement(mainSearchButton).click();

		Select select = new Select(driver.findElement(By.name("category_id")));
		List<WebElement> options = select.getOptions();
		for (WebElement elem : options) {
			if (elem.getText().contains("IPod")) {
				System.out.println(elem.getText());
				elem.click();
			}
		}
		driver.findElement(advancedSearchButton);

		String expected = "There is no product that matches the search criteria.";
		driver.findElement(findedElements).isEnabled();
		Assert.assertEquals(
				driver.findElement(By.xpath("//input[@id=\"button-search\"]/following-sibling::p")).getText(),
				expected);

	}

	// @Test(dataProvider = "search-with--description")
	public void searchInDescription(String description) {

		driver.findElement(mainSearchInputField).click();
		driver.findElement(mainSearchInputField).clear();
		driver.findElement(mainSearchInputField).sendKeys("samsung");
		driver.findElement(mainSearchButton).click();

		driver.findElement(By.id("description")).click();
		driver.findElement(By.xpath("//input[@id=\"input-search\"]")).clear();
		driver.findElement(By.xpath("//input[@id=\"input-search\"]")).sendKeys(description);
		// "Offering accurate, brilliant color performance, the Cinema HD");

		driver.findElement(advancedSearchButton).click();

		List<WebElement> product = driver.findElements(findedElements); // "//div[@id=\"content\"]/div[@class=\"row\"]//h4/following-sibling::p"));
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
			driver.navigate().back();
		}
		System.out.println("The lendth of search query is " + description.length());
	}

	

}
