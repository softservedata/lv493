package com.softserve.edu.opencart;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WishListTest {

	private ChromeDriver driver;

	@BeforeSuite
	public void beforeSuite() {
		WebDriverManager.chromedriver().setup();

	}

	@BeforeClass
	public void setUpBeforeClass() throws Exception {
		System.out.println("@BeforeClass");

	}

	@AfterClass
	public void tearDownAfterClass() throws Exception {
		System.out.println("@AfterClass");
	}

	@BeforeMethod
	public void setUp() throws Exception {
		System.out.println("\t@BeforeMethod method");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Thread.sleep(1000); // For Presentation Only
	}

	@AfterMethod
	public void tearDown() throws Exception {
		System.out.println("\t@AfterMethod method");
		// logout, get(urlLogout), delete cookie, delete cache

		driver.get("http://192.168.133.130/opencart/upload/index.php?route=account/logout");
		Thread.sleep(1000);

		driver.quit();
	}

	@Test
	public void addToWishListTest() throws Exception {

		driver.get("http://192.168.133.130/opencart/upload/index.php?route=account/login");
		// E-mail input
		driver.findElement(By.id("input-email")).click();
		driver.findElement(By.id("input-email")).clear();
		driver.findElement(By.id("input-email")).sendKeys("stepan.westimpex@gmail.com");
		Thread.sleep(2000);
		// Password input
		driver.findElement(By.id("input-password")).click();
		driver.findElement(By.id("input-password")).clear();
		driver.findElement(By.id("input-password")).sendKeys("pasword");
		driver.findElement(By.xpath("//form/input[@class='btn btn-primary']")).click();
		Thread.sleep(2000);
        //Some page with products
		driver.get("http://192.168.133.130/opencart/upload/index.php?route=product/category&path=57");
		// Adding products to Wish List
		driver.findElement(By.xpath("//div/button[@data-original-title='Add to Wish List']")).click();
		WebElement alert = driver.findElement(By.cssSelector("div.alert.alert-success"));
		System.out.println("Message: " + alert.getText());
		Thread.sleep(2000);

		// Check WishList contents
		driver.findElement(By.id("wishlist-total")).click();
		Thread.sleep(2000);

	}

	@Test
	public void removeFromWishListTest() throws Exception {

		driver.get("http://192.168.133.130/opencart/upload/index.php?route=account/login");
		// E-mail input
		driver.findElement(By.id("input-email")).click();
		driver.findElement(By.id("input-email")).clear();
		driver.findElement(By.id("input-email")).sendKeys("stepan.westimpex@gmail.com");
		Thread.sleep(2000);
		// Password input
		driver.findElement(By.id("input-password")).click();
		driver.findElement(By.id("input-password")).clear();
		driver.findElement(By.id("input-password")).sendKeys("pasword");
		driver.findElement(By.xpath("//form/input[@class='btn btn-primary']")).click();
		Thread.sleep(2000);
		// Some page with products
		driver.get("http://192.168.133.130/opencart/upload/index.php?route=product/category&path=57");
        //Adding products to Wish List
		driver.findElement(By.xpath("//div/button[@data-original-title='Add to Wish List']")).click();
		WebElement alert = driver.findElement(By.cssSelector("div.alert.alert-success"));
		System.out.println("Message: " + alert.getText());
		Thread.sleep(2000);

		// Check WishList contents
		driver.findElement(By.id("wishlist-total")).click();
		Thread.sleep(2000);

		// Remove from WishList
		driver.findElement(By.xpath("//a[@data-original-title='Remove']")).click();

		WebElement alert1 = driver.findElement(By.cssSelector("div.alert.alert-success"));
		System.out.println("Message: " + alert1.getText());
		Thread.sleep(2000);
	}

}