package com.softserve.edu;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AcademyTest {

	@Test
	public void unsuccessfulLogin() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");
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
}
