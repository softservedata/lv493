package com.softserve.edu.greencity.ui.tests;

import com.softserve.edu.greencity.ui.pages.econews.CreateNewsPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.greencity.ui.data.Languages;
import com.softserve.edu.greencity.ui.pages.home.HomePage;

import java.util.concurrent.TimeUnit;

public class SmokeTest1 {

    protected WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeClass
    public void setUpBeforeClass() throws Exception {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        //driver.manage().window().setSize(new Dimension(640, 480));
        //driver.manage().window().setSize(new Dimension(480, 640));
    }

    @Test
    public void checkElements() throws InterruptedException {
        // Steps
        driver.get("https://ita-social-projects.github.io/GreenCityClient/#/create-news");
        CreateNewsPage createNewsPage = new CreateNewsPage(driver);
        createNewsPage.uploadFile();
        Thread.sleep(10000);
    }
}
