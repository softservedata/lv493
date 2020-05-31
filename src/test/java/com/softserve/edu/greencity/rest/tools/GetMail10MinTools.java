package com.softserve.edu.greencity.rest.tools;

import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Gives temporary email for registration and verify email.
 * @author Serg
 */
public final class GetMail10MinTools {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private WebDriver driver;
    private WebDriverWait wait;
    //
    private WebElement tempEmailField;
    private WebElement deleteButton;
    private WebElement refreshButton;
    private WebElement emailButton;
    private WebElement verifyEmailButton;
    private WebElement verifyEmailURL;
    //
    public String title;
    private String verifyURL;
    private String httpsAfterVerify;
    //
    public static final DataFlavor byteFlavor = new DataFlavor(byte[].class, "Byte Flavor");

    public final static String URL = "https://www.minuteinbox.com/"; // not working
//    public final static String URL = "https://10minutemail.net/"; // not working
    /**
     * Site URL for temporary email.
     */
//    public final static String URL = "https://temp-mail.org/ru/"; // working

    /**
     * To determine the desired letter, which gets in the mail from GreenCity
     * back-end.
     */
    private final String MAIL_GEEN_CITY = "mailgreencity1@gmail.com";

    /**
     * Constructor
     * @param driver WebDriver
     */
    public GetMail10MinTools(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 300);
        initElements();
        httpsAfterVerify = "";
    }

    // init elements
    private void initElements() {
        logger.debug("start initElements() in GetMail10MinTools");
        title = driver.getTitle();
//        deleteButton = driver.findElement(By.cssSelector("#click-to-delete")); // for https://temp-mail.org/ru/
        deleteButton = driver.findElement(By.cssSelector("ul[class='nav nav-tabs'] a[href*='delete']")); // for
                                                                                                         // https://www.minuteinbox.com/
    }

    // Page Object
    //
    /**
     * Returns a page title of the website.
     * @return String
     */
    public String getTitleWebSite() {
        return title;
    }

    // deleteButton
    private WebElement getDeleteButton() {
        return deleteButton;
    }

    private void clickDeleteButton() {
        getDeleteButton().click();
    }

    private String getDeleteButtonText() {
        return getTempEmailField().getText();
    }

    private boolean isDisplayedDeleteButton() {
        return getDeleteButton().isDisplayed();
    }

    // refreshButton
    private WebElement getRefreshButton() {
//        refreshButton = driver.findElement(By.id("click-to-refresh")); // for https://temp-mail.org/ru/
        refreshButton = driver.findElement(By.cssSelector("a.btn.btn-refresh.pull-right.refresh")); // for
                                                                                                    // https://www.minuteinbox.com/
        return refreshButton;
    }

    private void clickRefreshButton() {
        getRefreshButton().click();
    }

    private String getRefreshButtonText() {
        return getRefreshButton().getText();
    }

    private boolean isDisplayedRefreshButton() {
        return getRefreshButton().isDisplayed();
    }

//    tempEmailField
    private WebElement getTempEmailField() {
        tempEmailField = driver.findElement(
//                By.cssSelector("div.input-box-col.hidden-xs-sm button")); // for https://temp-mail.org/ru/
                By.cssSelector("div[class*='email-col'] span.animace")); // for https://www.minuteinbox.com/
        return tempEmailField;
    }

    private void clickTempEmailField() {
//        Actions action = new Actions(driver);
//        action.clickAndHold(getTempEmailField()).build().perform();
//        action.release().build().perform();
        getTempEmailField().click();
    }

    private String getTempEmailFieldText() throws Exception, Exception, Exception {
        clickTempEmailField();
        //
//        return (String) Toolkit.getDefaultToolkit().getSystemClipboard()
//                .getData(DataFlavor.stringFlavor); // for https://temp-mail.org/ru/
        return getTempEmailField().getText(); // for https://www.minuteinbox.com/
    }

    private boolean isDisplayedTempEmailField() {
        return getTempEmailField().isDisplayed();
    }

//    emailButton
    private WebElement getEmailButton() {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.presenceOfElementLocated(
//                By.xpath("//a[text()='Verify your email address']"))); // for https://temp-mail.org/ru/
                By.xpath("//td[text()='Verify your email address']"))); // for https://www.minuteinbox.com/
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //
        emailButton = driver.findElement(
//                By.xpath("//a[text()='Verify your email address']")); // for https://temp-mail.org/ru/
                By.xpath("//td[text()='Verify your email address']")); // for https://www.minuteinbox.com/
        return emailButton;
    }

    private void clickEmailButton() {
        getEmailButton().click();
    }

    private String getEmailButtonText() {
        return getEmailButton().getText();
    }

    private boolean isDisplayedEmailButton() {
        return getEmailButton().isDisplayed();
    }

//    verifyEmailButton
    private WebElement getVerifyEmailButton() {
        driver.switchTo().defaultContent(); // you are now outside both frames
        driver.switchTo().frame("iframeMail");
        //
        verifyEmailButton = driver.findElement(By.cssSelector("a[href*='verifyEmail']"));
        //
        verifyEmailURL = driver.findElement(By.cssSelector("table td p + p")); // for full size window
        verifyURL = verifyEmailURL.getText();
        //
        return verifyEmailButton;
    }

    private void clickVerifyEmailButton(){
        getVerifyEmailButton().click();
    }

    private String getVerifyEmailButtonText() {
        return getVerifyEmailButton().getText();
    }

    private boolean isDisplayedVerifyEmailButton() {
        return getVerifyEmailButton().isDisplayed();
    }

    // verifyEmailURL
    private WebElement getVerifyEmailURL() {
//        driver.switchTo().defaultContent(); // you are now outside both frames
//        driver.switchTo().frame("iframeMail");
        //
//        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("table td p + p"))); // for https://www.minuteinbox.com/
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //
//        verifyEmailURL = driver.findElement(By.cssSelector("table td p + p")); // for full size window
        return verifyEmailURL;
    }

    private String getVerifyEmailURLText() {
        return getVerifyEmailURL().getText();
    }

    private boolean isDisplayedVerifyEmailURL() {
        return getVerifyEmailURL().isDisplayed();
    }

    // Functional
    
    private void takeScreenShot(WebDriver driver) throws IOException {
        String currentTime = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss")
                .format(new Date());
        File scrFile = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile,
                new File("./" + currentTime + "_screenshot.png"));
    }
    
    private void switchToAnotherTab(String currentTab) {
        logger.debug("start switchToAnotherTab()");
        for (String current : driver.getWindowHandles()) {
            logger.info("we're in a TAB: " + current);
            if (!current.equals(currentTab)) {
                logger.info("and switch to TAB: " + current);
                driver.switchTo().window(current);
                break;
            }
        }
    }

    private String getEmail() {
        if (isDisplayedTempEmailField()) {
            try {
                return getTempEmailFieldText();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "field mail not found";
    }

    private void getNewMail() {
        if (isDisplayedDeleteButton()) {
            clickDeleteButton();
        }
    }

    private void refreshMail() {
        if (isDisplayedRefreshButton()) {
            clickRefreshButton();
        }
    }

    // FIXME
    private void openMail() {
        int i = 0;
        do {
            refreshMail();
//            System.out.println("refreshMail");
            if (i == 4) {
                break;
            }
            i++;
        } while (isDisplayedEmailButton());
        if (isDisplayedEmailButton()) {
            clickEmailButton();
        }
    }

    private void clickVerifyButton() {
        if (isDisplayedVerifyEmailButton()) {
            clickVerifyEmailButton();
        }
    }

    private String getVerifyURL() {
        return getVerifyEmailURLText();
    }

    // Business Logic

    /**
     * Returns an email address.
     * @return String
     */
    public String getTempEmail() {
        logger.debug("start getTempEmail()");
        logger.trace("get teporary New Mail");
        getNewMail();
        logger.trace("wait until a teporary New Mail is displayed");
        //
//        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); // for https://temp-mail.org/ru/
//        wait.until(ExpectedConditions
////                .stalenessOf(driver.findElement(By.cssSelector("#mail")))); // for https://temp-mail.org/ru/
//                .stalenessOf(getTempEmailField()));
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // for https://temp-mail.org/ru/
        return getEmail();
    }

    /**
     * Finding the desired letter, opening and clicking on the button 'Verify'.
     */
    public String verifyEmail() {
        logger.debug("start verifyEmail()");
        logger.trace("click on refresh Mail button and open desired mail");
        openMail();
        logger.trace("click on VerifyButton");
        clickVerifyButton();
        //
//        switchToAnotherTab(driver.getWindowHandle());
//        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
//        wait.until(ExpectedConditions.urlContains("/#/welcome")); // for https://www.minuteinbox.com/
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        httpsAfterVerify = driver.getCurrentUrl(); // TODO
//        System.out.println("getTempEmail getCurrentUrl(): " + driver.getCurrentUrl());
        return verifyURL;
    }

    /**
     * Finding the desired letter, opening and get verify Email Url & user Id
     * without
     * @return String
     */
    public String getVerifyUrlInMail() {
        logger.debug("start getVerifyUrlInMail()");
        logger.trace("click on refresh Mail button and open desired mail");
        openMail();
        logger.trace("indicate button and URL link");
        isDisplayedVerifyEmailButton();
        return verifyURL;
    }

    /**
     * Returns current url address after clicking verify button.
     * @return String
     */
    public String getHttpsAfterVerify() {
        return httpsAfterVerify;
    }
}
