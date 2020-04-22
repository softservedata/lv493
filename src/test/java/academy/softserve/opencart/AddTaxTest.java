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

public class AddTaxTest {

    WebDriver driver;

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        WebDriverManager.chromedriver().setup();

    }

    @BeforeClass(alwaysRun = true)
    public void beforeClass(ITestContext context)  {
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

    @BeforeMethod
    public void beforeMethod(ITestContext context)  {
        driver.get(context.getAttribute("address").toString());
        //driver.manage().window().maximize();

        //go to admin page
        driver.findElement(By.id("input-username")).click();
        driver.findElement(By.id("input-username")).sendKeys(context.getAttribute("login").toString());

        driver.findElement(By.id("input-username")).click();
        driver.findElement(By.id("input-password")).sendKeys(context.getAttribute("password").toString());

        driver.findElement(By.id("input-password")).sendKeys(Keys.ENTER);

      //go to tax rate page
        Actions builder = new Actions(driver);
        Action mouseOver = builder
                .moveToElement(driver.findElement(By.id("menu-system")))
                .moveToElement(driver.findElement(By.xpath("//a[contains(text(), 'Localisation')]")))
                .build();
        mouseOver.perform();

        WebElement activeLocalization = driver.findElement(By.xpath("//a[contains(text(), 'Localisation')]/following-sibling::ul"));

        if(!activeLocalization.getAttribute("class").contentEquals("collapse in")) {
            driver.findElement(By.xpath("//a[contains(text(), 'Localisation')]")).click();
        }

        Action mouseOverTaxes = builder
                .moveToElement(driver.findElement(By.xpath("//a[contains(text(), 'Taxes')]")))
                .build();
        mouseOverTaxes.perform();

        WebElement activeTaxes = driver.findElement(By.xpath("//a[contains(text(), 'Taxes')]/following-sibling::ul"));

        if(!activeTaxes.getAttribute("class").contentEquals("collapse in")) {
            driver.findElement(By.xpath("//a[contains(text(), 'Taxes')]")).click();
        }
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
       driver.findElement(By.cssSelector("a[href*='route=common/logout']")).click();
    }

    @DataProvider
    public Object[][] taxDataProvider() {
        return new Object[][]{
                { "Zone Tax",  "10", "Percentage", "US Tax Zone"}
        };
    }

    @Test(dataProvider = "taxDataProvider", priority = 1)
    public void addTaxRate(final String name, final String rate,final String type, final String zone) {

        driver.findElement( By.cssSelector("a[href*='route=localisation/tax_rate']")).click();

        //add tax rate
        driver.findElement(By.cssSelector("a[href*='route=localisation/tax_rate/add']")).click();

        driver.findElement(By.id("input-name")).click();
        driver.findElement(By.id("input-name")).sendKeys(name);

        driver.findElement(By.id("input-rate")).click();
        driver.findElement(By.id("input-rate")).sendKeys(rate);

        Select types = new Select(driver.findElement(By.id("input-type")));
        types.selectByVisibleText(type);

        Select zones = new Select(driver.findElement(By.id("input-geo-zone")));
        zones.selectByVisibleText(zone);

        driver.findElement(By.cssSelector("button[data-original-title ='Save']")).click();

        //check
        WebElement alert = driver.findElement(By.xpath("//div[contains(@class, 'alert')]"));
        Assert.assertTrue(alert.getText().contains("Success"));
    }



    @DataProvider
    public Object[][] taxClassDataProvider() {
        return new Object[][]{
                { "Zone Taxable Goods",  "Zone taxed goods", "Zone Tax", "Shipping Address"}
        };
    }

    @Test(dataProvider = "taxClassDataProvider", priority = 2)
    public void addTaxClasses(final String name, final String description,final String rate, final String basedOn) {

        driver.findElement( By.cssSelector("a[href*='route=localisation/tax_class']")).click();

        //add  tax class
        driver.findElement(By.cssSelector("a[href*='route=localisation/tax_class/add']")).click();

        driver.findElement(By.id("input-title")).click();
        driver.findElement(By.id("input-title")).sendKeys(name);

        driver.findElement(By.id("input-description")).click();
        driver.findElement(By.id("input-description")).sendKeys(description);

        driver.findElement(By.cssSelector("button[data-original-title ='Add Rule']")).click();

        Select taxRate = new Select(driver.findElement(By.cssSelector("select[name*='tax_rate_id']")));
        taxRate.selectByVisibleText(rate);

        Select basedOnElements = new Select(driver.findElement(By.cssSelector("select[name*='based']")));
        basedOnElements.selectByVisibleText(basedOn);

        driver.findElement(By.cssSelector("button[data-original-title ='Save']")).click();

        //check
        WebElement alert = driver.findElement(By.xpath("//div[contains(@class, 'alert')]"));
        Assert.assertTrue(alert.getText().contains("Success"));
    }
    @Test(dataProvider = "taxClassDataProvider", priority = 6)
    public void deleteTaxClasses(final String name, final String description,final String rate, final String basedOn) {

        driver.findElement( By.cssSelector("a[href*='route=localisation/tax_class']")).click();

        //delete  tax class
        driver.findElement(By.xpath( "//td[text() = \'"+ name +"\'] / preceding-sibling::td/input")).click();
        driver.findElement(By.cssSelector("button[data-original-title='Delete']")).click();
        driver.switchTo().alert().accept();

        //check
        WebElement alert = driver.findElement(By.xpath("//div[contains(@class, 'alert')]"));
        Assert.assertTrue(alert.getText().contains("Success"));
    }

    @Test( dataProvider = "taxDataProvider", priority = 7)
    public void deleteTaxRate(final String name, final String rate,final String type, final String zone) {

        driver.findElement( By.cssSelector("a[href*='route=localisation/tax_rate']")).click();

        //delete tax rate
        driver.findElement(By.xpath( "//td[text() = 'Zone Tax'] / preceding-sibling::td/input")).click();
        driver.findElement(By.cssSelector("button[data-original-title='Delete']")).click();
        driver.switchTo().alert().accept();

        //check
        WebElement alert = driver.findElement(By.xpath("//div[contains(@class, 'alert')]"));
        Assert.assertTrue(alert.getText().contains("Success"));
    }
}
