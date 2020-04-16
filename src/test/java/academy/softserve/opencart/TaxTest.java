package academy.softserve.opencart;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

public class TaxTest {
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

    @DataProvider
    public Object[][] taxDataProvider() {
        return new Object[][]{
                { "Zone Tax",  "10", "Percentage", "US Tax Zone"}
        };
    }

    @Test(dataProvider = "taxDataProvider", priority = 1)
    public void addTaxRate(final String name, final String rate,final String type, final String zone) {
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
        //go to  tax classes page
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

    @DataProvider
    public Object[][] productsTaxDataProvider() {
        return new Object[][]{
                { "iPhone", "Zone Taxable Goods"}
        };
    }

    @Test(dataProvider = "productsTaxDataProvider", priority = 3)
    public void setTax(final String name, final String tax) {
        //go to products page
        Actions builder = new Actions(driver);
        Action mouseOver = builder
                .moveToElement(driver.findElement(By.id("menu-catalog")))
                .build();
        mouseOver.perform();

        driver.findElement(By.xpath("//a[contains(text(), 'Products')]")).click();

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



    @DataProvider
    public Object[][] productsDataProvider() {
        return new Object[][]{
                {"annaiv@gmail.com",  "1111", "iPhone" , "10"},
                {"morozov@gmail.com",  "1111", "iPhone" , "0"},
        };
    }

    @Test(dataProvider = "productsDataProvider", priority = 4)
    public void CheckTax(final String login,final String password,final String product,final String tax) {

        // go to store
        String adminTab = driver.getWindowHandle();
        driver.findElement(By.xpath("//i[@class='fa fa-home fa-lg']/..")).click();
        driver.findElement(By.xpath("//a[text()='Your Store']")).click();

        // switch to new tab
        for (String tab : driver.getWindowHandles()) {
            if (!tab.equals(adminTab)) {
                driver.switchTo().window(tab);
                break;
            }
        }

        //log in
        driver.findElement(By.cssSelector("a[title='My Account']")).click();
        driver.findElement(By.cssSelector("a[href*='route=account/login']")).click();


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

        driver.findElement(By.cssSelector("a[title='My Account']")).click();
        driver.findElement(By.cssSelector("a[href*='route=account/logout']")).click();

        driver.close();
        driver.switchTo().window(adminTab);

        Assert.assertEquals(prices.get(0), taxedProduct);
    }



    @DataProvider
    public Object[][] productsResetTaxDataProvider() {
        return new Object[][]{
                { "iPhone", "Taxable Goods"}
        };
    }


    @Test(dataProvider = "productsResetTaxDataProvider", priority = 5)
    public void resetTax(final String name, final String tax) {
        //go to product page

        Actions builder = new Actions(driver);
        Action mouseOver = builder
                .moveToElement(driver.findElement(By.id("menu-catalog")))
                .build();
        mouseOver.perform();

        driver.findElement(By.xpath("//a[contains(text(), 'Products')]")).click();

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



    @Test(dataProvider = "taxClassDataProvider", priority = 6)
    public void deleteTaxClasses(final String name, final String description,final String rate, final String basedOn) {
        //go to  tax classes page
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

        driver.findElement( By.cssSelector("a[href*='route=localisation/tax_rate']")).click();

        //delete tax rate
        driver.findElement(By.xpath( "//td[text() = 'Zone Tax'] / preceding-sibling::td/input")).click();
        driver.findElement(By.cssSelector("button[data-original-title='Delete']")).click();
        driver.switchTo().alert().accept();

        //check
        WebElement alert = driver.findElement(By.xpath("//div[contains(@class, 'alert')]"));
        Assert.assertTrue(alert.getText().contains("Success"));
    }

    @Test(dataProvider = "zoneDataProvider", priority = 8)
    public void deleteGeoZone(final String name, final String description,final String country, final String zone) {

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
