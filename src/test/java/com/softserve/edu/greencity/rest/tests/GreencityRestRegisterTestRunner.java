package com.softserve.edu.greencity.rest.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.google.gson.Gson;
import com.softserve.edu.greencity.rest.services.GuestService;
import com.softserve.edu.greencity.rest.tools.GetMail10MinTools;

import io.github.bonigarcia.wdm.WebDriverManager;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public abstract class GreencityRestRegisterTestRunner {
	//
	protected WebDriver driver;
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	protected OkHttpClient client;
	protected RequestBody formBody;
	protected Request request;
	protected Response response;
	protected String textBody;
	protected Gson gson;
	//

	@BeforeSuite
	public void beforeSuite() {
	    WebDriverManager.chromedriver().setup();
	    WebDriverManager.phantomjs().setup();
	}

	@BeforeClass
	public void setUpBeforeClass() throws Exception {
        //
      driver = new PhantomJSDriver(); // working!
      //
        //
//      ChromeOptions options = new ChromeOptions();
//      options.addArguments("--headless"); // Chrome Without UI
//      driver = new ChromeDriver(options);
	    //
//		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//driver.manage().window().setSize(new Dimension(640, 480));
		//driver.manage().window().setSize(new Dimension(480, 640));
	    client = new OkHttpClient();
	    gson = new Gson();
	}

	@AfterClass(alwaysRun = true)
	public void tearDownAfterClass() throws Exception {
//	    presentationSleep(1);
		if (driver != null) {
			driver.quit();
		}
	}

	@BeforeMethod
	public void setUp() throws Exception {
	    driver.get(GetMail10MinTools.URL);
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws Exception {
	    if (!result.isSuccess()) {
            logger.warn("Error Test " + result.getName());
            // TODO Logout
        }
        logger.info("Done Test " + result.getName());
        // logout, delete cookie, delete cache
	}
	
	public GuestService loadApplication() {
        return new GuestService();
    }
}