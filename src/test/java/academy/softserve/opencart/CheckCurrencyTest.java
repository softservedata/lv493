package academy.softserve.opencart;


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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckCurrencyTest  {
    WebDriver driver;

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        WebDriverManager.chromedriver().setup();
    }


    @BeforeClass(alwaysRun = true)
    public void beforeClass(ITestContext context)  {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        context.setAttribute("storeAddress", "http://192.168.146.128/opencart/upload/index.php");
        context.setAttribute("adminAddress", "http://192.168.146.128/opencart/upload/admin/index.php");
        context.setAttribute("login", "admin");
        context.setAttribute("password", "lv493_Taqc");
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        if (driver != null) {
            driver.quit();
        }
    }

    @BeforeMethod(groups= {"checkCertificate","currencyCompliance","currencyPresence"})
    public void beforeMethod(ITestContext context){
        driver.get(context.getAttribute("storeAddress").toString());
        //driver.manage().window().maximize();
    }

    @DataProvider
    public Object[][] currencyComplianceDataProvider() {
        return new Object[][]{
                { "EUR",  "€", "iPhone"},
                { "GBP", "£", "iPhone" },
                { "USD", "$" , "iPhone"}
        };
    }

    @Test(dataProvider = "currencyComplianceDataProvider" , groups= {"currencyCompliance"})
    public void checkCurrencyInCart(final String currency, final String symbol, final String product){

        // Change currency
        driver.findElement(By.cssSelector("button.btn.btn-link.dropdown-toggle")).click();
        driver.findElement(By.name(currency)).click();

        //Add product to cart
        driver.findElement(By.xpath("//a[text()=\'"+product+"\']/../../following-sibling::div/button[contains(@onclick, 'cart.add')]")).click();

        WebElement cartElement = driver.findElement(By.xpath("//li/p"));

        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        (new WebDriverWait(driver,20)).until(ExpectedConditions.stalenessOf(cartElement));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Check if added
        WebElement alert = driver.findElement(By.xpath("//div[contains(@class, 'alert')]"));

        Assert.assertTrue(alert.getText().contains("Success"));
        Assert.assertTrue(alert.getText().contains(product));

        //Find product in cart
        driver.findElement(By.cssSelector("#cart button")).click();

        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        (new WebDriverWait(driver,20)).until(ExpectedConditions.attributeContains(By.cssSelector("#cart button"), "aria-expanded", "true"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String productPrice = driver.findElement(By.xpath("//table[@class = 'table table-striped']//td[@class='text-right'] / following-sibling::td[@class='text-right'] ")).getText();

        driver.findElement(By.xpath("//table[@class = 'table table-striped']//td/button[contains(@onclick,'cart.remove')]")).click();

        Assert.assertTrue(productPrice.contains(symbol));
    }



    @DataProvider
    public Object[][] certificateDataProvider() {
        return new Object[][]{
                { "Oleh Morozov", "morozov@gmail.com", "200", "EUR"}
        };
    }

    @Test(dataProvider = "certificateDataProvider", groups= {"checkCertificate"})
    public void checkGiftCertificate(final String name, final String email, final String value,final String currency)  {
        //add certificate
        driver.findElement(By.cssSelector("a[href*='account/voucher']")).click();

        driver.findElement(By.id("input-to-name")).click();
        driver.findElement(By.id("input-to-name")).clear();
        driver.findElement(By.id("input-to-name")).sendKeys(name);

        driver.findElement(By.id("input-to-email")).click();
        driver.findElement(By.id("input-to-email")).clear();
        driver.findElement(By.id("input-to-email")).sendKeys(email);

        driver.findElement(By.id("input-from-name")).click();
        driver.findElement(By.id("input-from-name")).clear();
        driver.findElement(By.id("input-from-name")).sendKeys(name);

        driver.findElement(By.id("input-from-email")).click();
        driver.findElement(By.id("input-from-email")).clear();
        driver.findElement(By.id("input-from-email")).sendKeys(email);

        driver.findElement(By.xpath("//label[contains(.,'General')]/input")).click();

        driver.findElement(By.id("input-amount")).click();
        driver.findElement(By.id("input-amount")).clear();
        driver.findElement(By.id("input-amount")).sendKeys(value);

        // safe current currency of certificate
        String certificateCurrency = driver.findElement(By.cssSelector("#form-currency button strong")).getText();

        driver.findElement(By.name("agree")).click();
        driver.findElement(By.cssSelector("input[type='submit']")).click();

        //go to cart page
        driver.findElement(By.cssSelector("div[class='buttons'] a[href*='route=checkout/cart']")).click();

        //change currency
        driver.findElement(By.cssSelector("button.btn.btn-link.dropdown-toggle")).click();
        driver.findElement(By.name(currency)).click();

        //check certificate sum
        String certificate = driver.findElement(By.xpath("//div[@id = 'content']//td[contains(text(),\'"+name+"\')]")).getText();
        Assert.assertTrue(certificate.contains(certificateCurrency));

        //check certificate price
        String priceCurrency = driver.findElement(By.cssSelector("#form-currency button strong")).getText();
        String price = driver.findElement(By.xpath("//div[@id = 'content']//td[contains(text(),\'"+name+"\')]/following-sibling::td[last()]")).getText();

        Assert.assertTrue(price.contains(priceCurrency));

    }

    @BeforeGroups(groups= {"symbolPosition"})
    public void beforeSymbolGroups(ITestContext context)  {
        //go to admin page
        driver.get(context.getAttribute("adminAddress").toString());
        //driver.manage().window().maximize();

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

    @DataProvider
    public Object[][] checkSymbolDataProvider() {
        return new Object[][]{
                { "GBP", "iPhone"},
                { "EUR", "iPhone"}
        };
    }


    @Test(dataProvider = "checkSymbolDataProvider", groups= {"symbolPosition"})
    public void checkCurrencySymbolPosition(final String currency, final String product){
        // view currency
        driver.findElement(By.xpath("//td[text() = \'"+currency+"\'] // following-sibling::td / a")).click();

        String symbolLeft = driver.findElement(By.id("input-symbol-left")).getAttribute("value");
        String symbolRight = driver.findElement(By.id("input-symbol-right")).getAttribute("value");

        driver.findElement(By.cssSelector("a[data-original-title='Cancel']")).click();

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

        //change currency
        driver.findElement(By.cssSelector("button.btn.btn-link.dropdown-toggle")).click();
        driver.findElement(By.name(currency)).click();

        //find product
        String price =  driver.findElement(By.xpath("//a[text()=\'"+product+"\']/../following-sibling::p[@class='price']")).getText().trim();

        //check position
        String pattern = symbolLeft+"(\\d{1,3},)*\\d{1,3}\\.\\d{2}"+symbolRight;

        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(price);

        List<String> prices = new ArrayList<String>();

        while (m.find()) {
            prices.add(price.substring(m.start(), m.end()));
        }

        driver.close();
        driver.switchTo().window(adminTab);

        Assert.assertFalse(prices.isEmpty());
    }

    @DataProvider
    public Object[][] nameСurrencyDataProvider() {
        return new Object[][] { { "UAH" } };
    }

    @Test(dataProvider = "nameСurrencyDataProvider")
    public void checkCurrencyPresence(final String symbol) {

        // check presence
        driver.findElement(
                By.cssSelector("button.btn.btn-link.dropdown-toggle")).click();

        List<WebElement> currencies = driver.findElements(By.cssSelector(
                "button[class='currency-select btn btn-link btn-block']"));
        WebElement currency = currencies.stream()
                .filter(elem -> elem.getAttribute("name").contains(symbol))
                .findAny().orElse(null);
        Assert.assertNotNull(currency);
    }

}
