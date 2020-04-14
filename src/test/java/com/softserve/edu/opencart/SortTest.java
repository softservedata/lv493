package com.softserve.edu.opencart;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SortTest extends SortTestRunner {

	@DataProvider
	public Object[][] validDataProvider() {
		return new Object[][] { { null } };
	}

	// @Test
	public void checkSort(String searchText) throws Exception {
		// Steps
		driver.findElement(By.cssSelector("#search > input")).click();
		driver.findElement(By.cssSelector("#search > input")).clear();
		driver.findElement(By.cssSelector("#search > input")).sendKeys("%");
		Thread.sleep(1000); // For Presentation Only
		//
		driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
		//
		Select sortSelect = new Select(driver.findElement(By.id("input-sort")));
		sortSelect.selectByVisibleText("Price (High > Low)");
		//
		List<WebElement> products = driver.findElements(By.cssSelector("div.product-layout"));
		//
		// System.out.println(isSortedByDesc(getPrices(products)));
		Assert.assertTrue(isSortedByDesc(getPrices(products)));
		//
		Thread.sleep(4000); // For Presentation Only
		driver.quit();
	}
}
