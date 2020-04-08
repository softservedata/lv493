package com.softserve.edu;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AcademyTest {
	
	@BeforeSuite
	public void beforeSuite() {
		WebDriverManager.chromedriver().setup();
		//WebDriverManager.firefoxdriver().setup();
		//System.out.println("@BeforeSuite class SecondNg beforeSuite()");
	}
	
	//@Test
	public void unsuccessfulLogin() throws Exception {
		//System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://softserve.academy/");
		Thread.sleep(2000); // For Presentaion ONLY.
		//
		driver.findElement(By.linkText("Log in")).click();
		Thread.sleep(2000); // For Presentaion ONLY.
		//
//		driver.findElement(By.id("username")).click();
//		driver.findElement(By.id("username")).clear();
//		driver.findElement(By.id("username")).sendKeys("hahaha");
//		Thread.sleep(2000); // For Presentaion ONLY.
		//
		/*
		WebElement username = driver.findElement(By.id("username"));
		username.click();
		username.clear();
		username.sendKeys("hahaha");
		Thread.sleep(2000); // For Presentaion ONLY.
		//
		// Code...
		driver.navigate().refresh();
		//
		username.click(); // Runtime Error
		username.clear();
		username.sendKeys("hahaha2");
		*/
		//
		driver.findElement(By.id("username")).click();
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("hahaha");
		Thread.sleep(2000); // For Presentaion ONLY.
		//
		// Code...
		driver.navigate().refresh();
		//
		driver.findElement(By.id("username")).click();
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("hahaha2");
		Thread.sleep(2000); // For Presentaion ONLY.
		//
		//
		driver.findElement(By.id("password")).click();
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("hahaha");
		Thread.sleep(2000); // For Presentaion ONLY.
		//
		//driver.findElement(By.id("loginbtn")).click();
		Thread.sleep(2000); // For Presentaion ONLY.
		//
//		WebElement button = driver.findElement(By.cssSelector(".btn.btn-primary.btn-block"));
//		button.click();
		//
//		WebElement button = driver.findElement(By.cssSelector(".btn.btn-primari.btn-block"));
//		button.click();
		//
//		List<WebElement> buttons = driver.findElements(By.cssSelector(".btn.btn-primary"));
//		System.out.println("buttons.size(): " + buttons.size());
//		buttons.get(0).click();
		//
		/*
		//List<WebElement> buttons = driver.findElements(By.cssSelector(".btn.btn-primari"));
		List<WebElement> buttons = driver.findElements(By.cssSelector(".btn.btn-primary"));
		System.out.println("buttons.size(): " + buttons.size());
		if (buttons.size() > 0) {
			buttons.get(0).click();
		}
		*/
		//
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement button = (WebElement)js.executeScript("return document.getElementById('loginbtn');");
		button.click();
		//
		// *
		WebElement alert = driver.findElement(By.cssSelector("div.alert.alert-danger"));
		System.out.println("Message: " + alert.getText());
		Thread.sleep(2000); // For Presentaion ONLY.
		//
		String expected = "Invalid login, please try again";
		Assert.assertTrue(alert.getText().contains(expected));
		// */
		// driver.close();
		driver.quit();
	}
	
	@Test
	public void checkScroll() throws Exception {
//		System.setProperty("webdriver.chrome.driver",
//				this.getClass().getResource("/chromedriver-windows-32bit.exe").getPath());
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(1000); // For Presentation Only
		//
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://selenium.dev/downloads/");
		Thread.sleep(1000); // For Presentation Only
		//
		WebElement linkProject = driver.findElement(By.cssSelector(".button-container a"));
		//
		// Scrolling by Action class
//		Actions action = new Actions(driver);		
//		action.moveToElement(linkProject).perform();
//		Thread.sleep(1000); // For Presentation Only
		//
		// Scrolling by JavaScript injection
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", linkProject);
		Thread.sleep(10000); // For Presentation Only
		//
		Thread.sleep(4000); // For Presentation Only
		driver.quit();
	}
}
