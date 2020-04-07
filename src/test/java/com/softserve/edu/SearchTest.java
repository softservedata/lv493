package com.softserve.edu;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchTest {
	private static WebDriver driver;

	@BeforeClass
	public void setUpBeforeClass() throws Exception {
		System.out.println("@BeforeClass");
		//System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",
				SearchTest.class.getResource("/chromedriver-windows-32bit.exe").getPath());
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.manage().window().maximize();
	}

	@AfterClass
	public void tearDownAfterClass() throws Exception {
		System.out.println("@AfterClass");
		Thread.sleep(1000); // For Presentation Only
		driver.quit();
	}

	@BeforeMethod
	public void setUp() throws Exception {
		System.out.println("\t@BeforeMethod method");
		driver.get("http://taqc-opencart.epizy.com/");
		Thread.sleep(1000); // For Presentation Only
//		driver.manage().window().maximize();
		Thread.sleep(1000); // For Presentation Only
	}

	@AfterMethod
	public void tearDown() throws Exception {
		System.out.println("\t@AfterMethod method");
		// logout, get(urlLogout), delete cookie, delete cache
	}

	private WebElement getElementByName(String name) {
		WebElement result = null;
		List<WebElement> containers = driver.findElements(By.cssSelector("div.product-layout.product-grid"));
		for (WebElement current : containers) {
			if (current.findElement(By.cssSelector("h4 > a")).getText().equals(name)) {
				result = current;
				break;
			}
		}
		if (result == null) {
			// Develop Custom Exception
			throw new RuntimeException("WebElement by title/name: " + name + " not found");
		}
		return result;
	}

	// @Test
	public void checkVisible() throws Exception {
		System.out.println("\t\t@Test findByCss()");
		// Choose Curency
		WebElement currency = driver.findElement(By.cssSelector("button.btn.btn-link.dropdown-toggle"));
		currency.click();
		Thread.sleep(1000); // For Presentation Only
		WebElement usd = driver.findElement(By.cssSelector("[name='USD']"));
		Thread.sleep(1000); // For Presentation Only
		System.out.println("Opened usd.isEnabled() = " + usd.isEnabled());
		System.out.println("Opened usd.isDisplayed() = " + usd.isDisplayed());
		Thread.sleep(1000); // For Presentation Only
		currency.click();
		System.out.println("Closed usd.isEnabled() = " + usd.isEnabled());
		System.out.println("Closed usd.isDisplayed() = " + usd.isDisplayed());
	}

	// @Test
	public void findByCss() throws Exception {
		System.out.println("\t\t@Test findByCss()");
		// Precondition
		// Choose Curency
		driver.findElement(By.cssSelector("button.btn.btn-link.dropdown-toggle")).click();
		Thread.sleep(1000); // For Presentation Only
		driver.findElement(By.cssSelector("[name='USD']")).click();
		Thread.sleep(1000); // For Presentation Only
		//
		// Steps
		driver.findElement(By.cssSelector("#search > input")).click();
		driver.findElement(By.cssSelector("#search > input")).clear();
		driver.findElement(By.cssSelector("#search > input")).sendKeys("mac");
		Thread.sleep(1000); // For Presentation Only
		//
		driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
		Thread.sleep(1000); // For Presentation Only
		//
		// driver.findElement(By.cssSelector("a:contains('MacBook')")).click(); // ERROR
		// WebElement temp =
		// driver.findElement(By.cssSelector("div.product-layout.product-grid div:has(>
		// h4 > a[href*='id=43']) > p[class='price']")); // Error
		// WebElement price1 = driver.findElement(By.cssSelector("#content >
		// div:nth-child(8) > div:nth-child(2) > div > div:nth-child(2) > div.caption >
		// p.price")); //Ok
		// Search a $("div.product-layout.product-grid h4 > a")
		// Search h4 $("div.product-layout.product-grid h4:has(> a)")
		// Search Price $("div.product-layout.product-grid h4:has(> a[href*='id=43']) +
		// p + p")
		// Search Price $("div.product-layout.product-grid div:has(> h4 >
		// a[href*='id=43']) > p[class='price']")
		//
		// Check
		// WebElement price =
		// driver.findElement(By.cssSelector("div.product-layout.product-grid div:has(>
		// h4 > a[href*='id=43']) > p.price")); // id=43 Hardcode Invalid Solution
		WebElement price = getElementByName("MacBook").findElement(By.cssSelector("p.price"));
		Assert.assertTrue(price.getText().contains("$602.00"));
		//
		// Return to Previous State
		driver.findElement(By.cssSelector("#logo .img-responsive")).click();
		Thread.sleep(1000); // For Presentation Only
	}

	// @Test
	public void loginByCss() throws Exception {
		System.out.println("\t\t@Test loginByCss()");
		// Precondition
		// Click My Account Button
		driver.findElement(By.cssSelector("a[title='My Account']")).click(); // "#top a[href*='route=account/account']"
		Thread.sleep(1000); // For Presentation Only
		// Click login Button
		driver.findElement(By.cssSelector("#top-links a[href*='account/login']")).click();
		Thread.sleep(1000); // For Presentation Only
		//
		// Steps
		// Type Login Email
		driver.findElement(By.cssSelector("#input-email")).click();
		driver.findElement(By.cssSelector("#input-email")).clear();
		driver.findElement(By.cssSelector("#input-email")).sendKeys("hahaha@gmail.com");
		Thread.sleep(1000); // For Presentation Only
		//
		// Type Password
		// driver.findElement(By.id("input-password")).click();
		driver.findElement(By.cssSelector("#input-password")).click();
		driver.findElement(By.cssSelector("#input-password")).clear();
		driver.findElement(By.cssSelector("#input-password")).sendKeys("qwerty");
		Thread.sleep(1000); // For Presentation Only
		//
		// Click Login Button
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		Thread.sleep(1000); // For Presentation Only
		//
		// Goto Edit Account
		driver.findElement(By.cssSelector("#column-right a[href*='account/edit']")).click();
		Thread.sleep(1000); // For Presentation Only
		//
		// Read Email WebElement
		// WebElement price = driver.findElement(By.id("input-email"));
		WebElement email = driver.findElement(By.cssSelector("#input-email"));
		Thread.sleep(1000); // For Presentation Only
		//
		// Check
		Assert.assertEquals("hahaha@gmail.com", email.getAttribute("value"));
		//
		// Return to Previous State
		// Click My Account Button
		driver.findElement(By.cssSelector("a[title='My Account']")).click();
		Thread.sleep(1000); // For Presentation Only
		// Click Logout Button
		driver.findElement(By.cssSelector("#top-links a[href*='account/logout']")).click();
		Thread.sleep(1000); // For Presentation Only
		// Click Continue Button
		driver.findElement(By.cssSelector("#content a[href*='common/home']")).click();
		Thread.sleep(1000); // For Presentation Only
	}

	// @Test
	public void findByXPath() throws Exception {
		System.out.println("\t\t@Test findByXPath()");
		// Precondition
		// Choose Curency
		driver.findElement(By.xpath("//button[@class='btn btn-link dropdown-toggle']")).click();
		Thread.sleep(1000); // For Presentation Only
		driver.findElement(By.xpath("//button[@name='EUR']")).click();
		Thread.sleep(1000); // For Presentation Only
		//
		// Steps
		// Type Search Field
		driver.findElement(By.xpath("//input[@name='search']")).click();
		driver.findElement(By.xpath("//input[@name='search']")).clear();
		driver.findElement(By.xpath("//input[@name='search']")).sendKeys("mac");
		Thread.sleep(1000); // For Presentation Only
		//
		// Click Search Button
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
		Thread.sleep(1000); // For Presentation Only
		//
		// Check
//		WebElement price = driver
//				.findElement(By.xpath("//a[text()='MacBook']/../following-sibling::p[@class='price']"));
		WebElement axe = driver.findElement(By.xpath("//a[text()='MacBook']"));
		WebElement price = axe.findElement(By.xpath("./../following-sibling::p[@class='price']"));
		Assert.assertTrue(price.getText().contains("472.33"));
		//
		// Return to Previous State
		driver.findElement(By.xpath("//img[contains(@src, '/logo.png')]")).click();
		Thread.sleep(1000); // For Presentation Only
	}

	// @Test
	public void loginByXPath() throws Exception {
		System.out.println("\t\t@Test loginByXPath()");
		// Precondition
		// Click My Account Button
		driver.findElement(By.xpath("//a[@title='My Account']")).click();
		Thread.sleep(1000); // For Presentation Only
		// Click login Button
		driver.findElement(By.xpath("//a[contains(@href, 'account/login')]")).click();
		Thread.sleep(1000); // For Presentation Only
		//
		// Steps
		// Type Login Email
		driver.findElement(By.xpath("//input[@id='input-email']")).click();
		driver.findElement(By.xpath("//input[@id='input-email']")).clear();
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("hahaha@gmail.com");
		Thread.sleep(1000); // For Presentation Only
		//
		// Type Password
		// driver.findElement(By.id("input-password")).click();
		driver.findElement(By.xpath("//input[@id='input-password']")).click();
		driver.findElement(By.xpath("//input[@id='input-password']")).clear();
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("qwerty");
		Thread.sleep(1000); // For Presentation Only
		//
		// Click Login Button
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(1000); // For Presentation Only
		//
		// Goto Edit Account
		driver.findElement(By.xpath("//aside//a[contains(@href, 'account/edit')]")).click();
		Thread.sleep(1000); // For Presentation Only
		//
		// Read Email WebElement
		// WebElement price = driver.findElement(By.id("input-email"));
		WebElement email = driver.findElement(By.xpath("//input[@type='email']"));
		Thread.sleep(1000); // For Presentation Only
		//
		// Check
		Assert.assertEquals("hahaha@gmail.com", email.getAttribute("value"));
		//
		// Return to Previous State
		// Click My Account Button
		driver.findElement(By.xpath("//a[@title='My Account']")).click();
		Thread.sleep(1000); // For Presentation Only
		// Click Logout Button
		driver.findElement(By.xpath("//a[contains(@href, 'account/logout')]")).click();
		Thread.sleep(1000); // For Presentation Only
		// Click Continue Button
		driver.findElement(By.xpath("//div[@id='content']//a[contains(@href, 'common/home')]")).click();
		Thread.sleep(1000); // For Presentation Only
	}

	@Test
	public void checkCart() throws Exception {
		System.out.println("\t\t@Test checkCart()");
		// Precondition
		//
		// Steps
		// Add to Cart
		driver.findElement(By.xpath("//a[text()='MacBook']/../../following-sibling::div/button[contains(@onclick, 'cart.add')]")).click();
		//Thread.sleep(1000); // For Presentation Only
		//
		// Check
		WebElement alert = driver.findElement(By.xpath("//div[contains(@class, 'alert')]"));
		Assert.assertTrue(alert.getAttribute("class").contains("success"));
		Assert.assertTrue(alert.getText().contains("Success"));
		Assert.assertTrue(alert.getText().contains("MacBook"));
		Thread.sleep(1000); // For Presentation Only
		//
		// Steps
		// Add to Cart
		driver.findElement(By.xpath("//a[text()='iPhone 3']/../../following-sibling::div/button[contains(@onclick, 'cart.add')]")).click();
		//Thread.sleep(1000); // For Presentation Only
		//
		// Check
		WebElement alert1 = driver.findElement(By.xpath("//div[contains(@class, 'alert')]"));
		Thread.sleep(1000); // For Presentation Only
		System.out.println("alert.getText(): " + alert1.getText()); // Error, Element not present in DOM
		Assert.assertTrue(alert1.getAttribute("class").contains("success"));
		Assert.assertTrue(alert1.getText().contains("Success"));
		Assert.assertTrue(alert1.getText().contains("iPhone 3"));
		Thread.sleep(1000); // For Presentation Only
		//
		// Steps
		// Goto Cart
		driver.findElement(By.xpath("//div[@id='top-links']//a[contains(@href, 'route=checkout/cart')]")).click();
		Thread.sleep(1000); // For Presentation Only
		//
		// Update Quantity
		driver.findElement(By.xpath("//div[@id='content']//a[text()='MacBook']/../following-sibling::td//input")).click();
		driver.findElement(By.xpath("//div[@id='content']//a[text()='MacBook']/../following-sibling::td//input")).clear();
		driver.findElement(By.xpath("//div[@id='content']//a[text()='MacBook']/../following-sibling::td//input")).sendKeys("2");
		Thread.sleep(1000); // For Presentation Only
		//
		// Update Button
		driver.findElement(By.xpath("//div[@id='content']//a[text()='MacBook']/../following-sibling::td//button[@data-original-title='Update']")).click();
		Thread.sleep(1000); // For Presentation Only
		//
		// Delete iPhone 3
		driver.findElement(By.xpath("//div[@id='content']//a[text()='iPhone 3']/../following-sibling::td//button[@data-original-title='Remove']")).click();
		Thread.sleep(4000); // For Presentation Only
		//
	}
}
