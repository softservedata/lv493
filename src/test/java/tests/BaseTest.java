package tests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import utils.Application;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class BaseTest {
    private final String TIME_TEMPLATE = "yyyy-MM-dd_HH-mm-ss";
    public WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = Application.getDriver();
        driver.get("http://192.168.182.132/opencart/upload/");
        //  driver.get("http://taqc-opencart.epizy.com/index.php?route=common/home");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void deleteAllCookies() {
        driver.manage().deleteAllCookies();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        Application.closeDriver();
    }

    @DataProvider
    public Object[] productDataProvider() {
        return new Object[]{
                "MacBook", "HTC Touch HD", "iPod Nano"};
    }

    @DataProvider
    public Object[][] twoProductsProvider() {
        return new Object[][]{
                {"MacBook", "HTC Touch HD"},
                {"iPod Classic", "iPod Nano"}
        };
    }
    public void search(String search) {
        driver.findElement(By.cssSelector("#search > input")).click();
        driver.findElement(By.cssSelector("#search > input")).clear();
        driver.findElement(By.cssSelector("#search > input")).sendKeys(search);
        driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
    }

    public String addToCartWithPrice(String productName) {
        String expectedPrice = driver.findElement(By.xpath("//a[text()='" + productName + "']/../following-sibling::p[@class=\"price\"]")).getText();
        driver.findElement(By.xpath("//a[text()='" + productName + "']/../../following-sibling::div/button[contains(@onclick, 'cart.add')]")).click();
        return expectedPrice;
    }

    public void addToCart(String productName) {
        driver.findElement(By.xpath("//a[text()='" + productName + "']/../../following-sibling::div/button[contains(@onclick, 'cart.add')]")).click();
    }

    public void openShoppingCart() {
        driver.get("http://192.168.182.132/opencart/upload/index.php?route=checkout/cart");
    }

    public String getCartCount(String cartStatus) {
        String pattern = "^\\d+";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(cartStatus);
        m.find();
        return cartStatus.substring(m.start(), m.end());
    }

    public String getPrice(String cartStatus) {
        String pattern = "(\\d{1,3},)*\\d{1,3}\\.\\d{2}";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(cartStatus);
        m.reset();
        m.find();
        String price = cartStatus.substring(m.start(), m.end());
        price = price.replace(",", "");
        return price;
    }

    public void takeScreenShot(WebDriver driver) throws IOException {
        String currentTime = new SimpleDateFormat(TIME_TEMPLATE).format(new Date());
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("./target/" + currentTime + "_screenshot.png"));
    }
}