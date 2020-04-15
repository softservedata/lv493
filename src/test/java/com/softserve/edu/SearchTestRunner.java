/**
 * 
 */
package com.softserve.edu;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author Kristina
 *
 */
public abstract class SearchTestRunner {
	
	protected WebDriver driver;
	private final static String TIME_TEMPLATE = "yyyy-MM-dd_HH-mm-ss";
	
	@BeforeSuite
	public void beforeSuite() {
		WebDriverManager.chromedriver().setup();
	}
	
	@BeforeClass
	//@Parameters("browser")
	public void setUpBeforeClass() throws Exception {
		/*-if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("HtmlUnit")) {
			driver = new HtmlUnitDriver();
			((HtmlUnitDriver) driver).setJavascriptEnabled(false);
		} else if (browser.equalsIgnoreCase("opera")) {
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
		} else if (browser.equalsIgnoreCase("phantomjs")) {
			WebDriverManager.phantomjs().setup();
			driver = new PhantomJSDriver();
		} else {
			throw new Exception("Browser is not correct");
		} */

		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");
		// driver.System.setProperty("webdriver.chrome.driver",
		// SearchTest.class.getResource("/chromedriver-windows-32bit.exe").getPath());
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@BeforeMethod
	public void beforeMethod() {
		
		driver.manage().window().maximize();
		//driver.get("http://34.65.1.160/opencart/upload/");
		driver.get("http://192.168.171.129/opencart/upload/");
		 //driver.get("http://taqc-opencart.epizy.com/index.php?route=common/home");
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		if (driver != null) {
			driver.quit();
			}
	}
	
	protected void takeScreenShot(WebDriver driver) throws IOException {

		String currentTime = new SimpleDateFormat(TIME_TEMPLATE).format(new Date());
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("./" + currentTime + driver.getClass()  + "_.png"));
	}

}
