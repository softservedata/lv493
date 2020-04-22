package academy.softserve.opencart;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddCurrencyTest {
    WebDriver driver;

    @BeforeSuite( alwaysRun = true)
    public void beforeSuite() {
        WebDriverManager.chromedriver().setup();

    }

    @BeforeClass(alwaysRun = true)
    public void beforeClass(ITestContext context) {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        context.setAttribute("address", "http://192.168.146.128/opencart/upload/admin/index.php");
        context.setAttribute("login", "admin");
        context.setAttribute("password", "lv493_Taqc");
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        if (driver != null) {
            driver.quit();
        }
    }

    @BeforeMethod( alwaysRun = true)
    public void beforeMethod(ITestContext context){
        driver.get(context.getAttribute("address").toString());
        //driver.manage().window().maximize();

        //go to admin page
        driver.findElement(By.id("input-username")).click();
        driver.findElement(By.id("input-username")).sendKeys(context.getAttribute("login").toString());

        driver.findElement(By.id("input-username")).click();
        driver.findElement(By.id("input-password")).sendKeys(context.getAttribute("password").toString());

        driver.findElement(By.id("input-password")).sendKeys(Keys.ENTER);

        //Find currencies page
        Actions builder = new Actions(driver);
        Action mouseOver = builder.moveToElement(driver.findElement(By.id("menu-system"))).build();
        mouseOver.perform();

        driver.findElement(By.xpath("//a[contains(text(), 'Localisation')]")).click();

        driver.findElement(By.cssSelector("a[href*='route=localisation/currency']")).click();
    }

    @AfterMethod
    public void afterMethod() {
        driver.findElement(By.cssSelector("a[href*='route=common/logout']")).click();
    }

    @DataProvider
    public Object[][] currencyDataProvider() {
        return new Object[][] { { "Ukraine Hryvnia", "UAH", "27.42" }, };
    }

    @Test(dataProvider = "currencyDataProvider")
    public void addCurrency(String currency, String symbol, String value) {

        // Add currency
        driver.findElement( By.cssSelector("a[href*='route=localisation/currency/add']")).click();

        driver.findElement(By.id("input-title")).click();
        driver.findElement(By.id("input-title")).sendKeys(currency);

        driver.findElement(By.id("input-code")).click();
        driver.findElement(By.id("input-code")).sendKeys(symbol);

        driver.findElement(By.id("input-symbol-right")).click();
        driver.findElement(By.id("input-symbol-right")).sendKeys(symbol);

        driver.findElement(By.id("input-decimal-place")).click();
        driver.findElement(By.id("input-decimal-place")).sendKeys("2");

        driver.findElement(By.id("input-value")).click();
        driver.findElement(By.id("input-value")).sendKeys(value);

        Select status = new Select(driver.findElement(By.id("input-status")));
        status.selectByVisibleText("Enabled");

        driver.findElement(By.id("input-value")).submit();

        // Check if added
        WebElement alert = driver.findElement(By.xpath("//div[contains(@class, 'alert')]"));
        Assert.assertTrue(alert.getText().contains("Success"));

    }

    @DataProvider
    public Object[][] nameСurrencyDataProvider() {
        return new Object[][] { { "UAH" } };
    }

    @Test(dataProvider = "nameСurrencyDataProvider")
    public void deleteCurrency(final String currency) {

        // Delete currency
        driver.findElement(By.xpath("//td[text() = \'" + currency
                + "\'] / preceding-sibling::td/input")).click();
        driver.findElement(
                By.cssSelector("button[data-original-title='Delete']")).click();
        driver.switchTo().alert().accept();

        // Check if deleted
        WebElement alert = driver
                .findElement(By.xpath("//div[contains(@class, 'alert')]"));
        Assert.assertTrue(alert.getText().contains("Success"));
    }


}
