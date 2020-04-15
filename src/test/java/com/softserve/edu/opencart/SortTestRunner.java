package com.softserve.edu.opencart;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class SortTestRunner {
	protected WebDriver driver;

	@BeforeSuite
	public void beforeSuite() {
		WebDriverManager.chromedriver().setup();
	}

	@BeforeClass
	public void setUpBeforeClass() throws Exception {
		System.out.println("@BeforeClass");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.manage().window().maximize();
	}

	@AfterClass(alwaysRun = true)
	public void tearDownAfterClass() throws Exception {
		System.out.println("@AfterClass");
		Thread.sleep(1000); // For Presentation Only
		if (driver != null) {
			driver.quit();
		}
	}

	@BeforeMethod
	public void setUp() throws Exception {
		System.out.println("\t@BeforeMethod method");
		driver.get("http://taqc-opencart.epizy.com/");
//		driver.manage().window().maximize();
		Thread.sleep(1000); // For Presentation Only
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws Exception {
		System.out.println("\t@AfterMethod method");
		if (!result.isSuccess()) {
			//System.out.println("Test " + testName + " ERROR");
			System.out.println("Test " + result.getName() + " ERROR");
			// Take Screenshot, save sourceCode, save to log, prepare report, Return to previous state, logout, etc.
			driver.get("http://taqc-opencart.epizy.com/");
		}
		// logout, get(urlLogout), delete cookie, delete cache
	}

}
