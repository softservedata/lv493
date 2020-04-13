package sergii.kryvenko.selenium.testng;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import sergii.kryvenko.selenium.AppTest;

public class OpenCartTestNG {

    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeSuite
    public void beforeSuite() throws MalformedURLException {

        // BrowserStack

//        String browserStackUsername = System.getenv("BROWSERSTACK_USERNAME");
//        String browserStackAccess_key = System
//                .getenv("BROWSERSTACK_ACCESS_KEY");
//        String URL = "https://" + browserStackUsername + ":"
//                + browserStackAccess_key + "@hub-cloud.browserstack.com/wd/hub";
//        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setCapability("browser", "Chrome");
//        caps.setCapability("browser_version", "80.0");
//        caps.setCapability("os", "Windows");
//        caps.setCapability("os_version", "10");
//        caps.setCapability("resolution", "1024x768");
//        caps.setCapability("name", "Bstack-[Java] Open Cart Test_09.04.20");
//        caps.setCapability("browserstack.local", "true");
//        caps.setCapability("browserstack.localIdentifier",
//                "Test_OpenCrat_09.04.20");

        // SauceLab

        String sauceUserName = System.getenv("SAUCE_USERNAME");
        String sauceAccessKey = System.getenv("SAUCE_ACCESS_KEY");

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("username", sauceUserName);
        caps.setCapability("accessKey", sauceAccessKey);
        caps.setCapability("browserName", "Chrome");
        caps.setCapability("version", "80.0");
        caps.setCapability("platformName", "Windows");
        caps.setCapability("platformVersion", "10");
        caps.setCapability("name", "SauceLab: Open Cart Test2_12.04.20");
        String URL = "https://ondemand.eu-central-1.saucelabs.com:443/wd/hub";
//

        //
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        // BrowserStack, SauceLab
//        driver = new RemoteWebDriver(new URL(URL), caps);

    }

    /**
     * Below we are performing 2 critical actions. Quitting the driver and
     * passing the test result to Sauce Labs user interface.
     * @param result
     */
    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        driver.quit();

    }

    @BeforeTest
    @Parameters(value = "waitTime")
    public void beforeTest(int waitTime) {
        driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, waitTime);
    }

    @BeforeClass
    @Parameters(value = "url")
    public void beforeClass(String url) {
        String siteURL = "http://" + url + "/opencart/upload/";
        driver.get(siteURL);
//      driver.manage().window().maximize();
        driver.findElement(
                By.cssSelector("#top-links a[href*='route=account/account']"))
                .click();

        // logging
        {
            String login = System.getenv("OPENCART_LOGIN");
            String password = System.getenv("OPENCART_PASSWORD");

            driver.findElement(
                    By.cssSelector("#top-links a[href*='route=account/login']"))
                    .click();

            driver.findElement(By.id("input-email")).click();
            driver.findElement(By.id("input-email")).clear();
            driver.findElement(By.id("input-email")).sendKeys(login);

            driver.findElement(By.id("input-password")).click();
            driver.findElement(By.id("input-password")).clear();
            driver.findElement(By.id("input-password")).sendKeys(password);

            driver.findElement(By.id("input-password")).submit();
            System.out.println("@Logging");

        }
    }

    @AfterClass
    @Parameters(value = "waitTime")
    public void afterClass(int waitTime) {

        // logout
        {
            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            wait.until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector("#top-links a[class='dropdown-toggle']")));
            driver.manage().timeouts().implicitlyWait(waitTime,
                    TimeUnit.SECONDS);
            driver.findElement(
                    By.cssSelector("#top-links a[class='dropdown-toggle']"))
                    .click();
            driver.findElement(By
                    .cssSelector("#top-links a[href*='route=account/logout']"))
                    .click();
            System.out.println("@Logout");
        }
    }

    @BeforeMethod
    @Parameters(value = "waitTime")
    public void beforeMethod(int waitTime) {

        // return to begin page
        {
            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            wait.until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector("img[title='Your Store']")));
            driver.manage().timeouts().implicitlyWait(waitTime,
                    TimeUnit.SECONDS);
            driver.findElement(By.cssSelector("img[title='Your Store']"))
                    .click();
            System.out.println("@Open begins page");
        }
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {

        // return to begin page
        {
            wait.until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector("img[title='Your Store']")));
            driver.findElement(By.cssSelector("img[title='Your Store']"))
                    .click();
            System.out.println("@Open begins page");
        }

        // Quitting the driver and passing the test result to Sauce Labs user
        // interface.
//        ((JavascriptExecutor) driver).executeScript("sauce:job-result="
//                + (result.isSuccess() ? "passed" : "failed"));
    }

    @DataProvider(name = "Data-Provider-Function")
    public Object[][] parameterIntTestProvider() {
        return new Object[][] { { new String("MacBook") },
                { new String("iPhone") } };
    }

    /**
     * Add to shopping cart item from home page.
     * @param nameItem
     * @param waitTime sec.
     */
    @Test(dataProvider = "Data-Provider-Function")
    public void addItem(String nameItem) {

        System.out.println(
                "--------------------------Begin add " + nameItem + " to cart");
        String xpathForAddToCart = "//a[text()='" + nameItem
                + "']/../../following-sibling::div/button[contains(@onclick, 'cart.add')]";
        String cssSelectorToAlert = "div[class*='alert']";
        driver.findElement(By.xpath(xpathForAddToCart)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(cssSelectorToAlert)));
        String alert = driver.findElement(By.cssSelector(cssSelectorToAlert))
                .getText();
        System.out.println("\t@ " + alert);
        Assert.assertTrue(alert.contains("Success"));
        Assert.assertTrue(alert.contains(nameItem));

    }

    /**
     * Change in shopping cart quantity items on 5.
     * @param nameItem
     */
    @Test(dataProvider = "Data-Provider-Function")
    public void changeQuantityItemInCart(String nameItem) {

        System.out.println("---------------Go to shoping cart--");
        String xpathForTextBoxQuantity = "//img[@title='" + nameItem
                + "']/../../following-sibling::td//input[@type='text']";
        String xpathForButtonUpdate = "//img[@title='" + nameItem
                + "']/../../following-sibling::td//button[@data-original-title='Update']";
        String cssSelectorToAlert = "div[class*='alert']";

        driver.findElement(
                By.cssSelector("#top-links a[title*='Shopping Cart']")).click();
        // finding field with quantity
        System.out.println(
                "---------------Change quantity " + nameItem + " to 5");
        driver.findElement(By.xpath(xpathForTextBoxQuantity)).clear();
        driver.findElement(By.xpath(xpathForTextBoxQuantity)).sendKeys("5");
        driver.findElement(By.xpath(xpathForButtonUpdate)).click();

        String alert = driver.findElement(By.cssSelector(cssSelectorToAlert))
                .getText();
        System.out.println("\t@ " + alert);
        Assert.assertTrue(alert.contains("Success"));

        int currentQuantity = Integer
                .parseInt(driver.findElement(By.xpath(xpathForTextBoxQuantity))
                        .getAttribute("value"));
        Assert.assertEquals(5, currentQuantity);

    }

    /**
     * Search item and add to cart.
     * @param itemToSearch
     * @param waitTime sec
     */
    @Test
    @Parameters(value = { "itemToSearch", "waitTime" })
    public void serachAndAddItem(String itemToSearch, int waitTime) {

        System.out.println("---------------Search and add " + itemToSearch
                + " to shoping cart--");
        driver.findElement(By.cssSelector("input[name='search']")).click();
        driver.findElement(By.cssSelector("input[name='search']"))
                .sendKeys(itemToSearch);
        driver.findElement(By.cssSelector("#search button[type='button']"))
                .click();

        String xpathForAddToCart = "//a[text()='" + itemToSearch
                + "']/../../following-sibling::div/button[contains(@onclick, 'cart.add')]";
        String cssSelectorToAlert = "div[class*='alert']";
        driver.findElement(By.xpath(xpathForAddToCart)).click();
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(cssSelectorToAlert)));
        driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
        String alert = driver.findElement(By.cssSelector(cssSelectorToAlert))
                .getText();
        System.out.println("\t@ " + alert);
        Assert.assertTrue(alert.contains("Success"));
        Assert.assertTrue(alert.contains(itemToSearch));

    }

    /**
     * Delete in shopping cart item position.
     * @param itemToDelete
     * @param waitTime sec
     */
    @Test
    @Parameters(value = { "itemToDelete", "waitTime" })
    public void deleteItemPosition(String itemToDelete, int waitTime) {

        System.out.println("---------------Remove " + itemToDelete
                + " from shoping cart--");
        String xpathForButtonRemove = "//div[@class='table-responsive']//a[text()='"
                + itemToDelete
                + "']/../following-sibling::td//button[@data-original-title='Remove']";
        boolean actual = false;

        driver.findElement(
                By.cssSelector("#top-links a[title*='Shopping Cart']")).click();
        //
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath(xpathForButtonRemove)));
        // finding button 'remove' and clicking
        driver.findElement(By.xpath(xpathForButtonRemove)).click();

        // if wanted element is present on the page
        try {
        wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.xpath(xpathForButtonRemove))));
        } catch (NoSuchElementException e) {
        }
        driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);

        // find all presents elements and match with the item to delete
        List<WebElement> elements = driver.findElements(By.xpath(
                "//div[@class='table-responsive']//tbody/tr//a[contains(text(), .)]"));
        for (WebElement element : elements) {
            String presentItem;
            presentItem = element.getText().trim();
            if (presentItem.equalsIgnoreCase(itemToDelete)) {
                actual = true;
                break;
            }
        }
        if (!actual) {
            System.out.println("-----------------Item " + itemToDelete
                    + " successfully removed");
        }
        Assert.assertFalse(actual);
    }

    /**
     * Use coupon (-15%) and check sum.
     * @param couponCode
     */
    @Test
    @Parameters(value = "couponCode")
    public void useCoupon(String couponCode) {

        System.out.println("---------------Use coupon --");
        String cssSelectorToAlert = "div[class*='alert']";
        driver.findElement(
                By.cssSelector("#top-links a[title*='Shopping Cart']")).click();

        // Opened 'accordion' and entering a coupon's number in the textbox
        driver.findElement(By.cssSelector("a[href*='coupon']")).click();
        driver.findElement(By.cssSelector("input[name='coupon']")).clear();
        driver.findElement(By.cssSelector("input[name='coupon']"))
                .sendKeys(couponCode);
        driver.findElement(By.cssSelector("input[value='Apply Coupon']"))
                .click();
        String alert = driver.findElement(By.cssSelector(cssSelectorToAlert))
                .getText();
        System.out.println("--------------" + alert);
        Assert.assertTrue(alert
                .contains("Success: Your coupon discount has been applied!"));

        // Check number of coupon and sum discount
        String sumSubTotalString = driver.findElement(By.xpath(
                "//strong[text()='Sub-Total:']/../following-sibling::td[1]"))
                .getText();
        float sumSubTotal = Float
                .parseFloat(sumSubTotalString.replaceAll("[$,]", ""));
        System.out.println("------------------sumSubTotal = " + sumSubTotal);

        String couponString = driver
                .findElement(By.xpath("//strong[text()='Coupon (" + couponCode
                        + "):']/../following-sibling::td[1]"))
                .getText();
        float sumDiscountCoupon = Float
                .parseFloat(couponString.replaceAll("[$-,]", ""));
        System.out.println(
                "------------------sumDiscountCoupon = " + sumDiscountCoupon);
        float expected = (float) (-sumSubTotal * 0.15);
        System.out.println("---------------expected = " + expected);

        Assert.assertEquals(expected, sumDiscountCoupon, 0.01);

        {
            // print Total Sums
            String xpathTotalSums = "//strong[text()='Sub-Total:']/../../../tr";
            List<WebElement> elementTotalSums = driver
                    .findElements(By.xpath(xpathTotalSums));
            for (WebElement webElement : elementTotalSums) {
                int numElementDollar = webElement.getText().indexOf("$");
                System.out.print(
                        webElement.getText().substring(0, numElementDollar - 1)
                                + " ");
                System.out.println(Float.parseFloat(
                        webElement.getText().substring(numElementDollar + 1)
                                .replaceAll("[,]", "")));
            }

        }

    }

    /**
     * Use gift certificate (1000$) and check sum.
     * @param certificateCode
     */
    @Test
    @Parameters(value = "certificateCode")
    public void useCertificate(String certificateCode) {

        System.out.println("---------------Use gift certificate--");
        String cssSelectorToAlert = "div[class*='alert']";
        driver.findElement(
                By.cssSelector("#top-links a[title*='Shopping Cart']")).click();

        // Opened 'accordion' and entering a certificate's number in the textbox
        driver.findElement(By.cssSelector("a[href*='voucher']")).click();
        driver.findElement(By.cssSelector("input[name='voucher']")).clear();
        driver.findElement(By.cssSelector("input[name='voucher']"))
                .sendKeys(certificateCode);
        driver.findElement(
                By.cssSelector("input[value='Apply Gift Certificate']"))
                .click();
        String alert = driver.findElement(By.cssSelector(cssSelectorToAlert))
                .getText();
        System.out.println("--------------" + alert);
        Assert.assertTrue(alert.contains(
                "Success: Your gift certificate discount has been applied!"));

        // Check number of certificate and sum discount
        String sumSubTotalString = driver.findElement(By.xpath(
                "//strong[text()='Sub-Total:']/../following-sibling::td[1]"))
                .getText();
        float sumSubTotal = Float
                .parseFloat(sumSubTotalString.replaceAll("[$,]", ""));
        System.out.println("------------------sumSubTotal = " + sumSubTotal);

        String certificateString = driver
                .findElement(By.xpath("//strong[text()='Gift Certificate ("
                        + certificateCode + "):']/../following-sibling::td[1]"))
                .getText();
        float sumDiscountCertificate = Float
                .parseFloat(certificateString.replaceAll("[$-,]", ""));
        System.out.println("------------------sumDiscountCertificate = "
                + sumDiscountCertificate);
        float expected = (float) (-1000.00);
        System.out.println("---------------expected = " + expected);

        Assert.assertEquals(expected, sumDiscountCertificate, 0.01);

        {
            // print Total Sums
            String xpathTotalSums = "//strong[text()='Sub-Total:']/../../../tr";
            List<WebElement> elementTotalSums = driver
                    .findElements(By.xpath(xpathTotalSums));
            for (WebElement webElement : elementTotalSums) {
                int numElementDollar = webElement.getText().indexOf("$");
                System.out.print(
                        webElement.getText().substring(0, numElementDollar - 1)
                                + " ");
                System.out.println(Float.parseFloat(
                        webElement.getText().substring(numElementDollar + 1)
                                .replaceAll("[,]", "")));
            }

        }

    }

    /**
     * Fill Estimate Shipping & Taxes in shopping cart.
     */
    @Test
    public void fillEstimateShipping() {

        System.out.println(
                "---------------Fill Estimate Shipping & Taxes in shopping cart--");
        String cssSelectorToAlert = "div[class*='alert']";

        String selectedCountry = "Ukraine";
        String xpathPrintCountry = "//select[@id='input-country']//option[text()='"
                + selectedCountry + "']";

        String selectedRegion = "Kyiv";
        String xpathPrintRegion = "//select[@id='input-zone']//option[text()='"
                + selectedRegion + "']";

        String postCode = "12345";

        driver.findElement(
                By.cssSelector("#top-links a[title*='Shopping Cart']")).click();

        // Opened 'accordion' and filled need values
        try {
            driver.findElement(By.cssSelector("a[href*='shipping']")).click();

            // selected need country
            driver.findElement(By.id("input-country")).click();
            new Select(driver.findElement(By.id("input-country")))
                    .selectByVisibleText(selectedCountry);
            System.out.println("------Selected country is " + driver
                    .findElement(By.xpath(xpathPrintCountry)).getText());

            // selected need region
            new Select(driver.findElement(By.id("input-zone")))
                    .selectByVisibleText(selectedRegion);
            System.out.println("------Selected Region/State is "
                    + driver.findElement(By.xpath(xpathPrintRegion)).getText());

            // filled the postcode
            driver.findElement(By.name("postcode")).click();
            driver.findElement(By.name("postcode")).clear();
            driver.findElement(By.name("postcode")).sendKeys(postCode);
            System.out.println("------Entered Post Code is " + driver
                    .findElement(By.name("postcode")).getAttribute("value"));

            driver.findElement(By.id("button-quote")).click();

            // chose "shipping method" in alert
            driver.findElement(By.name("shipping_method")).click();
            driver.findElement(By.id("button-shipping")).click();
            String alert = driver
                    .findElement(By.cssSelector(cssSelectorToAlert)).getText();
            System.out.println("\t@ " + alert);
            Assert.assertTrue(alert.contains("Success"));

        } catch (NoSuchElementException e) {
            System.err
                    .println("Field 'Estimate Shipping & Taxes' doesn't exist");
        }
    }

    /**
     * Finishing fill order.
     * @param waitTime sec
     */
    @Test
    @Parameters(value = "waitTime")
    public void finishOrder(int waitTime) {
        System.out.println("---------------Finishing fill order--");
        String firstName = "John";
        String lastName = "Shepard";
        String company = "freelancer";
        String address1 = "USA";
        String address2 = "England";
        String city = "London";
        String postcode = "123456";
        String country = "United Kingdom";
        String region = "Cambridgeshire";
        String commentInOrder = "Comments About Your Order";

        String productName1 = "iPhone";
        String productName2 = "MacBook";

        driver.findElement(By.cssSelector("a[href*='route=checkout/checkout']"))
                .click();

        // Step 2: Billing Details
        // chose radiobutton 'I want to use a new address'
        driver.findElement(
                By.cssSelector("#collapse-payment-address input[value='new']"))
                .click();
        driver.findElement(By.id("input-payment-firstname"))
                .sendKeys(firstName);
        {
            driver.findElement(By.id("input-payment-lastname")).clear();
            driver.findElement(By.id("input-payment-company")).clear();
            driver.findElement(By.id("input-payment-address-1")).clear();
            driver.findElement(By.id("input-payment-address-2")).clear();
            driver.findElement(By.id("input-payment-city")).clear();
            driver.findElement(By.id("input-payment-postcode")).clear();
        }
        driver.findElement(By.id("input-payment-lastname")).sendKeys(lastName);
        driver.findElement(By.id("input-payment-company")).sendKeys(company);
        driver.findElement(By.id("input-payment-address-1")).sendKeys(address1);
        driver.findElement(By.id("input-payment-address-2")).sendKeys(address2);
        driver.findElement(By.id("input-payment-city")).sendKeys(city);
        driver.findElement(By.id("input-payment-postcode")).sendKeys(postcode);

        // selected need country
        driver.findElement(By.id("input-payment-country")).click();
        new Select(driver.findElement(By.id("input-payment-country")))
                .selectByVisibleText(country);

        // selected need region
        new Select(driver.findElement(By.id("input-payment-zone")))
                .selectByVisibleText(region);

        // button 'Continue'
        driver.findElement(By.id("button-payment-address")).click();

        // Step 3: Delivery Details
        // chose radiobutton 'I want to use a new address'
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By
                .cssSelector("#collapse-shipping-address input[value='new']")));
        driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
        driver.findElement(
                By.cssSelector("#collapse-shipping-address input[value='new']"))
                .click();
        {
            driver.findElement(By.id("input-shipping-firstname")).clear();
            driver.findElement(By.id("input-shipping-lastname")).clear();
            driver.findElement(By.id("input-shipping-company")).clear();
            driver.findElement(By.id("input-shipping-address-1")).clear();
            driver.findElement(By.id("input-shipping-address-2")).clear();
            driver.findElement(By.id("input-shipping-city")).clear();
            driver.findElement(By.id("input-shipping-postcode")).clear();
        }
        {
            driver.findElement(By.id("input-shipping-firstname"))
                    .sendKeys(firstName);
            driver.findElement(By.id("input-shipping-lastname"))
                    .sendKeys(lastName);
            driver.findElement(By.id("input-shipping-company"))
                    .sendKeys(company);
            driver.findElement(By.id("input-shipping-address-1"))
                    .sendKeys(address1);
            driver.findElement(By.id("input-shipping-address-2"))
                    .sendKeys(address2);
            driver.findElement(By.id("input-shipping-city")).sendKeys(city);
            driver.findElement(By.id("input-shipping-postcode"))
                    .sendKeys(postcode);
        }

        // selected need country
        driver.findElement(By.id("input-shipping-country")).click();
        new Select(driver.findElement(By.id("input-shipping-country")))
                .selectByVisibleText(country);

        // selected need region
        new Select(driver.findElement(By.id("input-shipping-zone")))
                .selectByVisibleText(region);

        // button 'Continue'
        driver.findElement(By.id("button-shipping-address")).click();

        // Step 4: Delivery Method. Add Comments
//        driver.findElement(
//                By.cssSelector("#collapse-shipping-method input[type='radio']"))
//                .click();
        System.out.println("\tFlat Rate: " + driver
                .findElement(By
                        .xpath("//div[@id='collapse-shipping-method']//label"))
                .getText());
        driver.findElement(By.cssSelector(
                "#collapse-shipping-method textarea[name='comment']")).click();
        driver.findElement(By.cssSelector(
                "#collapse-shipping-method textarea[name='comment']"))
                .sendKeys(commentInOrder + " about Delivery Method");

        // button 'Continue'
        driver.findElement(By.id("button-shipping-method")).click();

        // Step 5: Payment Method. Add Comments
//        driver.findElement(
//                By.cssSelector("#collapse-payment-method input[type='radio']"))
//                .click();
        System.out.println("\tPayment method: " + driver
                .findElement(
                        By.xpath("//div[@id='collapse-payment-method']//label"))
                .getText());
        driver.findElement(By.cssSelector(
                "#collapse-payment-method textarea[name='comment']")).click();
        driver.findElement(By.cssSelector(
                "#collapse-payment-method textarea[name='comment']"))
                .sendKeys(commentInOrder + " about Payment Method");

        // checkbox 'Terms & Conditions'
        driver.findElement(By
                .cssSelector("#collapse-payment-method input[type='checkbox']"))
                .click();

        // button 'Continue'
        driver.findElement(By.id("button-payment-method")).click();

        // Step 6: Confirm Order
        {
            // print position with 'iPhone'
            String xpathProduct1 = "//div[@id='collapse-checkout-confirm']//a[text()='"
                    + productName1 + "']/../../td";
            List<WebElement> elementProduct1 = driver
                    .findElements(By.xpath(xpathProduct1));
            System.out
                    .print("Product Name: " + elementProduct1.get(0).getText());
            System.out.print("\tModel: " + elementProduct1.get(1).getText());
            System.out.print("\tQuantity: " + elementProduct1.get(2).getText());
            System.out
                    .print("\tUnit Price: " + elementProduct1.get(3).getText());
            System.out.println("\tTotal: " + elementProduct1.get(4).getText());
        }
        {
            // print position with 'MacBook'
            String xpathProduct2 = "//div[@id='collapse-checkout-confirm']//a[text()='"
                    + productName2 + "']/../../td";
            List<WebElement> elementProduct2 = driver
                    .findElements(By.xpath(xpathProduct2));
            System.out
                    .print("Product Name: " + elementProduct2.get(0).getText());
            System.out.print("\tModel: " + elementProduct2.get(1).getText());
            System.out.print("\tQuantity: " + elementProduct2.get(2).getText());
            System.out
                    .print("\tUnit Price: " + elementProduct2.get(3).getText());
            System.out.println("\tTotal: " + elementProduct2.get(4).getText());
        }
        {
            // print Total Sums
            String xpathTotalSums = "//strong[text()='Sub-Total:']/../../../tr";
            List<WebElement> elementTotalSums = driver
                    .findElements(By.xpath(xpathTotalSums));
            for (WebElement webElement : elementTotalSums) {
                int numElementDollar = webElement.getText().indexOf("$");
                System.out.print(
                        webElement.getText().substring(0, numElementDollar - 1)
                                + " ");
                System.out.println(Float.parseFloat(
                        webElement.getText().substring(numElementDollar + 1)
                                .replaceAll("[,]", "")));
            }

        }

        // button 'Confirm Order'
//        driver.findElement(By.id("button-confirm")).click();
//
//        String text = driver.findElement(By.xpath("//div[@id='content']/p"))
//                .getText();
//        System.out.println(text);
    }
}
