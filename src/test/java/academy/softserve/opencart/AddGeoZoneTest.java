package academy.softserve.opencart;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
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

public class AddGeoZoneTest {
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

        //go to geo zone page
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

        driver.findElement( By.cssSelector("a[href*='route=localisation/geo_zone']")).click();

    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
       driver.findElement(By.cssSelector("a[href*='route=common/logout']")).click();
    }

    @DataProvider
    public Object[][] zoneDataProvider() {
        return new Object[][]{
                { "US Tax Zone",  "US Tax", "United States", "Ohio"}
        };
    }

    @Test(dataProvider = "zoneDataProvider", priority = 0)
    public void addGeoZone(final String name, final String description,final String country, final String zone) {

        //add geo zone
        driver.findElement(By.xpath("//a[@data-original-title='Add New']")).click();

        driver.findElement(By.id("input-name")).click();
        driver.findElement(By.id("input-name")).sendKeys(name);

        driver.findElement(By.id("input-description")).click();
        driver.findElement(By.id("input-description")).sendKeys(description);

        driver.findElement( By.cssSelector("button[data-original-title = 'Add Geo Zone']")).click();

        Select countries = new Select(driver.findElement(By.cssSelector("select[onchange*='country']")));
        countries.selectByVisibleText(country);

        Select zones = new Select(driver.findElement(By.cssSelector("select[name*='zone_id']")));
        zones.selectByVisibleText(zone);

        driver.findElement(By.cssSelector("button[data-original-title ='Save']")).click();

        //check
        WebElement alert = driver.findElement(By.xpath("//div[contains(@class, 'alert')]"));
        Assert.assertTrue(alert.getText().contains("Success"));

    }

    @Test(dataProvider = "zoneDataProvider", priority = 8)
    public void deleteGeoZone(final String name, final String description,final String country, final String zone) {
        //delete geo zone
        driver.findElement( By.cssSelector("a[href*='route=localisation/geo_zone']")).click();

        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        (new WebDriverWait(driver, 20))
        .until(ExpectedConditions.presenceOfElementLocated(By.xpath( "//td[text() = \'"+name+"\'] / preceding-sibling::td/input")));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.xpath( "//td[text() = \'"+name+"\'] / preceding-sibling::td/input"))
                .click();
        driver.findElement(By.cssSelector("button[data-original-title='Delete']")).click();
        driver.switchTo().alert().accept();

        //check
        WebElement alert = driver.findElement(By.xpath("//div[contains(@class, 'alert')]"));
        Assert.assertTrue(alert.getText().contains("Success"));

    }
}
