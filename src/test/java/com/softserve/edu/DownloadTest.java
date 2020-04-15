package com.softserve.edu;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DownloadTest {
	
	@Test
	public void downloadTest () {
	  WebDriverManager.firefoxdriver().setup();
	  String baseUrl = "http://demo";
	  WebDriver driver = new FirefoxDriver();

	  driver.get(baseUrl);
	  WebElement downloadButton = driver.findElement(By.id("messenger-download"));
	  String sourceLocation = downloadButton.getAttribute("href");
	  String wget_command = "cmd /c C:\\Wget\\wget.exe -P D: --no-check-certificate " + sourceLocation;

	  
		  Process exec;
		try {
			exec = Runtime.getRuntime().exec(wget_command);
			int exitVal = exec.waitFor();
			 System.out.println("Exit value: " + exitVal);
		} catch (IOException | InterruptedException e) {
			
			e.printStackTrace();
		} 
		 
	  
	  driver.quit();
	}
}
