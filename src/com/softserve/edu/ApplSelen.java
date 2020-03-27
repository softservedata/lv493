package com.softserve.edu;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ApplSelen {
	public static void main(String[] args) throws Exception {
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
		driver.findElement(By.id("username")).click();
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("hahaha");
		Thread.sleep(2000); // For Presentaion ONLY.
		//
		driver.findElement(By.id("password")).click();
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("hahaha");
		Thread.sleep(2000); // For Presentaion ONLY.
		//
		//driver.findElement(By.id("loginbtn")).click();
		//driver.findElement(By.id("password")).submit();
		driver.findElement(By.id("password")).sendKeys(Keys.ENTER);
		//
		WebElement alert = driver.findElement(By.cssSelector("div.alert.alert-danger"));
		System.out.println("Message: " + alert.getText());
		Thread.sleep(2000); // For Presentaion ONLY.
		//driver.close();
		driver.quit();
	}
}
