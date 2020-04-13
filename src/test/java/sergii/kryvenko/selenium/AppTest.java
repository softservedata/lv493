package sergii.kryvenko.selenium;

import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Unit test for site http://taqc-opencart.epizy.com/.
 */
public class AppTest {

    private static String login;
    private static String password;
    private static String couponCode;
    private static String certificateCode;
    private static String siteURL = "http://192.168.88.128/opencart/upload/";
    private static WebDriver driver;
    private static WebDriverWait wait;
    private static String file = "file.txt";

    @BeforeClass
    public static void setUpBeforeClass() {
        Properties props = new Properties();
        try {
            props.load(AppTest.class
                    .getResourceAsStream("credentials.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        login = props.getProperty("opencart.login");
        password = props.getProperty("opencart.password");
        couponCode = props.getProperty("opencart.coupon");
        certificateCode = props.getProperty("opencart.certificate");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 5);
    }

    @AfterClass
    public static void tearDownAfterClass() {
        driver.quit();
    }

    @Before
    public void setUp() throws Exception {
        driver.get(siteURL);
//        driver.manage().window().maximize();
        driver.findElement(
                By.cssSelector("#top-links a[href*='route=account/account']"))
                .click();

        // logging
        {
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

        // return to begin page
        {
            driver.findElement(By.xpath("// img[@title='Your Store']")).click();
            System.out.println("@Open begins page");
        }
    }

    @After
    public void tearDown() throws Exception {
        // logout, get(urlLogout), delete cookie, delete cache

        // logout
        {
            wait.until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector("#top-links a[class='dropdown-toggle']")));
            driver.findElement(
                    By.cssSelector("#top-links a[class='dropdown-toggle']"))
                    .click();
            driver.findElement(By
                    .cssSelector("#top-links a[href*='route=account/logout']"))
                    .click();
            System.out.println("@Logout");
        }
    }

    /**
     * Add to shopping cart 'MacBook'.
     */
    @Test
    public void addMacBook() {

        System.out.println(
                "--------------------------Begin add MackBook to cart");
        String nameItem = "MacBook";
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
        Assert.assertTrue(alert.contains("MacBook"));

    }

    /**
     * Add to shopping cart 'iPhone'.
     */
    @Test
    public void addIPhone() {

        System.out
                .println("--------------------------Begin add iPhone to cart");
        String nameItem = "iPhone";
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
        Assert.assertTrue(alert.contains("iPhone"));
    }

    /**
     * Change in shopping cart quantity 'MacBook' items on 15.
     */
    @Test
    public void changeQuantityMacBookInCart() {

        System.out.println("---------------Go to shoping cart--");
        String nameItem = "MacBook";
        String xpathForTextBoxQuantity = "//img[@title='" + nameItem
                + "']/../../following-sibling::td//input[@type='text']";
        String xpathForButtonUpdate = "//img[@title='" + nameItem
                + "']/../../following-sibling::td//button[@data-original-title='Update']";
        String xpathForButtonRemove = "//img[@title='" + nameItem
                + "']/../../following-sibling::td//button[@data-original-title='Remove']";
        String cssSelectorToAlert = "div[class*='alert']";

        driver.findElement(
                By.cssSelector("#top-links a[title*='Shopping Cart']")).click();
        // finding field with quantity
        driver.findElement(By.xpath(xpathForTextBoxQuantity)).clear();
        driver.findElement(By.xpath(xpathForTextBoxQuantity)).sendKeys("15");
        driver.findElement(By.xpath(xpathForButtonUpdate)).click();

        String alert = driver.findElement(By.cssSelector(cssSelectorToAlert))
                .getText();
        System.out.println("\t@ " + alert);
        Assert.assertTrue(alert.contains("Success"));

        int currentQuantity = Integer
                .parseInt(driver.findElement(By.xpath(xpathForTextBoxQuantity))
                        .getAttribute("value"));
        Assert.assertEquals(15, currentQuantity);

    }

    /**
     * Delete in shopping cart 'iPhone' position.
     */
    @Test
    public void deleteIPhonePosition() {

        System.out.println("---------------Remove iPhone from shoping cart--");
        String nameItem = "iPhone";
        String xpathForTextBoxQuantity = "//img[@title='" + nameItem
                + "']/../../following-sibling::td//input[@type='text']";
        String xpathForButtonUpdate = "//img[@title='" + nameItem
                + "']/../../following-sibling::td//button[@data-original-title='Update']";
        String xpathForButtonRemove = "//img[@title='" + nameItem
                + "']/../../following-sibling::td//button[@data-original-title='Remove']";

        driver.findElement(
                By.cssSelector("#top-links a[title*='Shopping Cart']")).click();
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath(xpathForButtonRemove)));
        // finding button 'remove' and clicking
        driver.findElement(By.xpath(xpathForButtonRemove)).click();

        boolean actual = driver
                .findElement(By.xpath("//img[@title='" + nameItem + "']"))
                .isDisplayed();
        Assert.assertFalse(actual);
    }

    /**
     * Use coupon (-15%) and check sum.
     */
    @Test
    public void useCoupon() {

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

    }

    /**
     * Use gift certificate (1000$) and check sum.
     */
    @Test
    public void useCertificate() {

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

    }

    // Fill Estimate Shipping & Taxes in shopping cart
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

    // Finishing fill order
    @Test
    public void finishOrder() throws Exception {
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
        wait.until(ExpectedConditions.visibilityOfElementLocated(By
                .cssSelector("#collapse-shipping-address input[value='new']")));
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
        driver.findElement(
                By.cssSelector("#collapse-shipping-method input[type='radio']"))
                .click();
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
        driver.findElement(
                By.cssSelector("#collapse-payment-method input[type='radio']"))
                .click();
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
        driver.findElement(By.id("button-confirm")).click();

        String text = driver.findElement(By.xpath("//div[@id='content']/p"))
                .getText();
        System.out.println(text);
    }

    // isn'tworking
    // Add to shopping cart item Apple Cinema 30"

    @Test
    public void addAppleCinema() throws Exception {

        System.out.println(
                "--------------------------Begin add Apple Cinema 30\" to cart");
        String nameItem = "Apple Cinema 30\"";
        String sizeItem = "Medium";
        String checkboxItem = "Checkbox 3";
        String textInOptions = "Some text";
        String colorItem = "Green";
        String textArea = "Some text in Textarea";

        String xpathForAddToCart = "//a[text()='" + nameItem
                + "']/../../following-sibling::div/button[contains(@onclick, 'cart.add')]";
        String cssButtonUploadFile = "#button-upload222";
        String cssSelectorToAlert = "div[class*='alert']";
        String xpathForRadioButton = "//div[@id='input-option218']/div/label[text()[contains(.,'"
                + sizeItem + "')]]";
        String xpathForCheckbox = "//div[@id='input-option223']/div/label[text()[contains(.,'"
                + checkboxItem + "')]]";
        
        driver.findElement(By.xpath(xpathForAddToCart)).click();

        // Fill Available Options
        new Actions(driver)
                .moveToElement(
                        driver.findElement(By.xpath(xpathForRadioButton)))
                .click().perform();

        // radio button
        driver.findElement(By.xpath(xpathForCheckbox)).click();

        // checkbox
        new Actions(driver)
                .moveToElement(driver.findElement(By.id("input-option208")))
                .click().perform();
        driver.findElement(By.id("input-option208")).clear();
        driver.findElement(By.id("input-option208")).sendKeys(textInOptions);

        // selected need color
        driver.findElement(By.id("input-option217")).click();
        List<WebElement> selectColor = driver.findElements(
                By.xpath("//select[@id='input-option217']/option[text()]"));
        for (WebElement text : selectColor) {
            if (text.getText().contains(colorItem)) {
                new Select(driver.findElement(By.id("input-option217")))
                        .selectByVisibleText(text.getText());
            }
            System.out.println(text.getText());
        }

        driver.findElement(By.id("input-option209")).click();
        new Actions(driver)
                .moveToElement(driver.findElement(By.id("input-option209")))
                .click().perform();
        driver.findElement(By.id("input-option209")).clear();
        driver.findElement(By.id("input-option209")).sendKeys(textArea);
        ;

        // upload file
        WebElement upload = driver.findElement(By.id("button-upload222"));
        upload.sendKeys("file.txt");

        try {
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (Exception e) {
        }

        System.out.println("-----------isEmpty(): "
                + driver.findElement(By.xpath("//input[@id='input-option222']"))
                        .getAttribute("value").isEmpty());
        
        // Date & Time
        driver.findElement(By.id("input-option219")).click();
        driver.findElement(By.id("input-option219")).clear();
        driver.findElement(By.id("input-option219")).sendKeys("2020-04-12");
        driver.findElement(By.id("input-option221")).sendKeys("15:15");
        driver.findElement(By.id("input-quantity")).click();
        new Actions(driver)
                .moveToElement(driver.findElement(By.id("input-quantity")))
                .click().perform();
        driver.findElement(By.id("input-quantity")).clear();
        driver.findElement(By.id("input-quantity")).sendKeys("4");
        Thread.sleep(4000); // !!!!!!!!!!!!!
        driver.findElement(By.id("button-cart")).click();
        String alert = driver.findElement(By.cssSelector(cssSelectorToAlert))
                .getText();
        System.out.println("--------------" + alert);
        Assert.assertTrue(alert.contains(
                "Success: You have added Apple Cinema 30\" to your shopping cart!"));
        Thread.sleep(3000);
    }

    // search item and add to cart
    @Test
    public void serachAndAddItem() {
        String nameItem = "Nikon D300";

        driver.findElement(By.cssSelector("input[name='search']")).click();
        driver.findElement(By.cssSelector("input[name='search']"))
                .sendKeys(nameItem);
        driver.findElement(By.cssSelector("#search button[type='button']"))
                .click();

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
}
