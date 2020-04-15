package com.okstrishch.edu;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
import org.testng.annotations.Test;

import com.okstrishch.edu.comparator.Sorting;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SecondNg extends Sorting {
    public WebDriver driver;

    @BeforeSuite
    public void setUp() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeClass
    public void testOpenWindow() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @BeforeMethod
    public void openApp() {
        driver.get("http://192.168.1.7/opencart/upload/");

    }

    @Test
    public void checkDesktopsList() {

        driver.findElement(By.xpath("//a[text()='Desktops']")).click();
        driver.findElement(By.xpath("//div[@class='dropdown-menu']//a[@class='see-all']")).click();
        driver.findElement(By.xpath("//*[@id='list-view']")).click();
        WebElement chkList = driver.findElement(By.cssSelector("#list-view.btn.btn-default.active"));
        Assert.assertTrue(chkList.isDisplayed());
        Assert.assertTrue(
                driver.findElement(By.xpath("//div[@class='product-layout product-list col-xs-12']")).isDisplayed());

    }

    @Test
    public void checkDesktopsGrid() {
        driver.findElement(By.xpath("//a[text()='Desktops']")).click();
        driver.findElement(By.xpath("//div[@class='dropdown-menu']//a[@class='see-all']")).click();
        driver.findElement(By.xpath("//button[@id='grid-view']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//button[@class='btn btn-default active']")).isDisplayed());
        Assert.assertTrue(driver
                .findElement(
                        By.xpath("//div[@class='product-layout product-grid col-lg-4 col-md-4 col-sm-6 col-xs-12']"))
                .isDisplayed());
    }

    @Test
    public void showCheckElement() {
        driver.findElement(By.xpath("//input[@name='search']")).click();
        driver.findElement(By.xpath("//input[@name='search']")).sendKeys("%");
        driver.findElement(By.xpath("//div[@id='search']/span/button")).click();
        driver.findElement(By.xpath("//select[@id='input-limit']")).click();
        List<WebElement> objShow = driver.findElements(By.xpath("//select[@id='input-limit']"));
        for (WebElement objShowLink : objShow) {
            String strObjShowLink = objShowLink.getText();
            System.out.println("Check 'Show': " + strObjShowLink);

        }
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    @Test
    public void sortByCheck() {
        driver.findElement(By.xpath("//input[@name='search']")).click();
        driver.findElement(By.xpath("//input[@name='search']")).sendKeys("%");
        driver.findElement(By.xpath("//div[@id='search']/span/button")).click();
        driver.findElement(By.xpath("//select[@id='input-sort']")).click();
        List<WebElement> objSort = driver.findElements(By.xpath("//select[@id='input-sort']"));
        for (WebElement objSortLink : objSort) {
            String strObjSortLink = objSortLink.getText();
            System.out.println("Check 'Sort By': " + strObjSortLink);
        }

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    @Test(priority = 1)
    public void checkThatPageIsCompletelyLoaded() {

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        Assert.assertEquals("complete", javascriptExecutor.executeScript("return document.readyState"));
    }

    @Test
    public void choseGoods() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.findElement(By.xpath("//a[text()='Desktops']")).click();
        driver.findElement(By.xpath("//div[@class='dropdown-menu']//a[@class='see-all']")).click();
        WebElement Element = driver.findElement(By.xpath("//a[10]"));
        js.executeScript("arguments[0].scrollIntoView();", Element);
        driver.findElement(By.xpath("//a[10]")).click();
        WebElement sortElement = driver.findElement(By.id("input-sort"));
        Select sortSelect = new Select(sortElement);
        sortSelect.selectByVisibleText("Name (A - Z)");
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='input-sort']/option[2]")).isDisplayed());

    }

    @Test
    public void sortDesctopsPriceLowToHigh() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.findElement(By.xpath("//a[text()='Desktops']")).click();
        driver.findElement(By.xpath("//div[@class='dropdown-menu']//a[@class='see-all']")).click();
        driver.findElement(By.xpath("//*[@id='list-view']")).click();
        Select sortSelect = new Select(driver.findElement(By.id("input-sort")));
        sortSelect.selectByVisibleText("Price (Low > High)");
        js.executeScript("window.scrollBy(0, 2000)");
        List<WebElement> products = driver.findElements(By.cssSelector("div.product-layout"));
        Assert.assertTrue(isSortedByIncrease(getPrices(products)));

    }

    @Test
    public void searchSortByShow() {
        driver.findElement(By.xpath("//input[@name='search']")).click();
        driver.findElement(By.xpath("//input[@name='search']")).sendKeys("%");
        driver.findElement(By.xpath("//div[@id='search']/span/button")).click();
        Select searchSortBy = new Select(driver.findElement(By.id("input-sort")));
        searchSortBy.selectByVisibleText("Name (Z - A)");
        Select searchShow = new Select(driver.findElement(By.id("input-limit")));
        searchShow.selectByVisibleText("25");
        driver.findElement(By.xpath("//select[@name='category_id']")).click();
        driver.findElement(By.xpath("//select/option[@value='20']")).click();
        driver.findElement(By.id("button-search")).click();
        Assert.assertTrue(
                driver.findElement(By.xpath("//select[@id='input-sort']/option[text()='Default']")).isSelected());
        Assert.assertTrue(driver.findElement(By.xpath("//select[@id='input-limit']/option[text()='15']")).isSelected());

    }

    @AfterMethod
    public void afterMethod() {

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
