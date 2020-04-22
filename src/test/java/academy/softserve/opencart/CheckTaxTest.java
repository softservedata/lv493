package academy.softserve.opencart;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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

public class CheckTaxTest {
    WebDriver driver;

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        WebDriverManager.chromedriver().setup();

    }

    @BeforeClass(alwaysRun = true)
    public void beforeClass(ITestContext context)  {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        context.setAttribute("address", "http://192.168.146.128/opencart/upload/index.php");
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

        //log in
        driver.findElement(By.cssSelector("a[title='My Account']")).click();
        driver.findElement(By.cssSelector("a[href*='route=account/login']")).click();

    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        driver.findElement(By.cssSelector("a[title='My Account']")).click();
        driver.findElement(By.cssSelector("a[href*='route=account/logout']")).click();
    }

    @DataProvider
    public Object[][] productsDataProvider() {
        return new Object[][]{
                {"annaiv@gmail.com",  "1111", "iPhone" , "10"},
                {"morozov@gmail.com",  "1111", "iPhone" , "0"},
        };
    }

    @Test(dataProvider = "productsDataProvider", priority = 4)
    public void CheckTax(final String login,final String password,final String product,final String tax) {

        driver.findElement(By.id("input-email")).click();
        driver.findElement(By.id("input-email")).clear();
        driver.findElement(By.id("input-email")).sendKeys(login);

        driver.findElement(By.id("input-password")).click();
        driver.findElement(By.id("input-password")).clear();
        driver.findElement(By.id("input-password")).sendKeys(password);
        driver.findElement(By.id("input-password")).submit();

        //check product
        driver.findElement(By.cssSelector("#logo a[href*='common/home']")).click();

        String price =  driver.findElement(By.xpath("//a[text()=\'"+product+"\']/../following-sibling::p[@class='price']")).getText().trim();

        String patternPrice = "(\\d{1,3},)*\\d{1,3}\\.\\d{2}";

        Pattern p = Pattern.compile(patternPrice);
        Matcher m = p.matcher(price);

        List<BigDecimal> prices = new ArrayList<BigDecimal>();
         while (m.find()) {
            prices.add(new BigDecimal(price.substring(m.start(), m.end()).replace(",", "")));
        }
         BigDecimal t = new BigDecimal(tax);
         BigDecimal taxedProduct = prices.get(1).add(prices.get(1).multiply(t).divide(BigDecimal.valueOf(100)));

        Assert.assertEquals(prices.get(0), taxedProduct);
    }

}
