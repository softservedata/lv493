package com.softserve.edu.greencity.ui.tools;

import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public final class GetMail10MinTools {

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

//    public final static String URL = "https://www.minuteinbox.com/";
//    public final static String URL = "https://10minutemail.net/";
    public final static String URL = "https://temp-mail.org/ru/";
    private final String MAIL_GEEN_CITY = "mailgreencity1@gmail.com";

    public GetMail10MinTools(WebDriver driver) {
        System.out.println("GetMail10MinTools initElements()");
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        initElements();
    }

    // init elements
    private void initElements() {
        title = driver.getTitle();
        deleteButton = driver.findElement(By.cssSelector("#click-to-delete"));
    }

    // Page Object
    //
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
        refreshButton = driver.findElement(By.id("click-to-refresh"));
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
                By.cssSelector("div.input-box-col.hidden-xs-sm button"));
        return tempEmailField;
    }

    private void clickTempEmailField() {
        getTempEmailField().click();
    }

    private String getTempEmailFieldText()
            throws Exception, Exception, Exception {
        clickTempEmailField();
//        System.out.println(
//                "(String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor): "
//                        + (String) Toolkit.getDefaultToolkit()
//                                .getSystemClipboard()
//                                .getData(DataFlavor.stringFlavor));
        return (String) Toolkit.getDefaultToolkit().getSystemClipboard()
                .getData(DataFlavor.stringFlavor);
    }

    private boolean isDisplayedTempEmailField() {
        return getTempEmailField().isDisplayed();
    }

//    emailButton
    private WebElement getEmailButton() {
        emailButton = driver.findElement(
                By.xpath("//a[text()='Verify your email address']"));
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
        verifyEmailButton = driver.findElement(
                By.cssSelector("a[href*='greencity.azurewebsites.net']"));
        return verifyEmailButton;
    }

    private void clickVerifyEmailButton() {
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
        verifyEmailButton = driver
                .findElement(By.cssSelector("table td p + p")); // for small
                                                                // size window
        return verifyEmailURL;
    }

    private String getVerifyEmailURLText() {
        return getVerifyEmailURL().getText();
    }

    private boolean isDisplayedVerifyEmailURL() {
        return getVerifyEmailURL().isDisplayed();
    }

    // Functional

    private String getEmail() {
        if (isDisplayedTempEmailField()) {
            try {
                return getTempEmailFieldText();
            } catch (Exception e) {
                // TODO Auto-generated catch block
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

    private void openMail() {
        while (!isDisplayedEmailButton()) {
            refreshMail();
        }
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
        if (isDisplayedVerifyEmailURL()) {
            return getVerifyEmailURLText();
        } else {
            return "verify URL not found";
        }
    }

    // Business Logic
    public GetMail10MinTools openNewTabGetMail10MinTools() {
        driver.get(URL);
        return this;
    }

    public String getTempEmail() {
        getNewMail();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return getEmail();
    }

    public void verifyEmail() {
        openMail();
//        String verifyEmail = getVerifyURL();
        clickVerifyButton();
//        return verifyEmail;
    }

}
