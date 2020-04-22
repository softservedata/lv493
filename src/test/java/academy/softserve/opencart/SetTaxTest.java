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

public class SetTaxTest {
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

      //go to product page

        Actions builder = new Actions(driver);
        Action mouseOver = builder
                .moveToElement(driver.findElement(By.id("menu-catalog")))
                .build();
        mouseOver.perform();

        driver.findElement(By.xpath("//a[contains(text(), 'Products')]")).click();

    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
       driver.findElement(By.cssSelector("a[href*='route=common/logout']")).click();
    }

    @DataProvider
    public Object[][] productsTaxDataProvider() {
        return new Object[][]{
                { "iPhone", "Taxable Goods"}
        };
    }

    @Test(dataProvider = "productsTaxDataProvider", priority = 3)
    public void setTax(final String name, final String tax) {
        //set tax to product
        driver.findElement(By.xpath("//td[contains(text(), \'"+ name + "\')]/following-sibling::td//a")).click();

        driver.findElement(By.cssSelector("a[href='#tab-data']")).click();

        Select taxClass = new Select(driver.findElement(By.id("input-tax-class")));
        taxClass.selectByVisibleText(tax);

        driver.findElement(By.cssSelector("button[data-original-title ='Save']")).click();

        //check
        WebElement alert = driver.findElement(By.xpath("//div[contains(@class, 'alert')]"));
        Assert.assertTrue(alert.getText().contains("Success"));
    }

    @Test(dataProvider = "productsResetTaxDataProvider", priority = 5)
    public void resetTax(final String name, final String tax) {

        //reset tax
        driver.findElement(By.xpath("//td[contains(text(),\'"+name+"\')]/following-sibling::td//a")).click();

        driver.findElement(By.cssSelector("a[href='#tab-data']")).click();

        Select taxClass = new Select(driver.findElement(By.id("input-tax-class")));
        taxClass.selectByVisibleText(tax);

        driver.findElement(By.cssSelector("button[data-original-title ='Save']")).click();

        //check
        WebElement alert = driver.findElement(By.xpath("//div[contains(@class, 'alert')]"));
        Assert.assertTrue(alert.getText().contains("Success"));
    }

}
