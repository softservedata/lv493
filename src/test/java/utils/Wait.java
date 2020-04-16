package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {

    public static void waitUntilIsClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(Application.getDriver(), 8, 50);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitUntilStalenessOf(WebElement element) {
        WebDriverWait wait = new WebDriverWait(Application.getDriver(), 8, 50);
        wait.until(ExpectedConditions.stalenessOf(element));
    }

    public static void waitUntilIsClickableAndClick(WebElement element) {
        WebDriverWait wait = new WebDriverWait(Application.getDriver(), 8, 50);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public static void waitUntilIsSelected(WebElement element) {
        WebDriverWait wait = new WebDriverWait(Application.getDriver(), 8, 50);
        wait.until(ExpectedConditions.elementToBeSelected(element));
    }

    public static void waitUntilIsVisible(By elementLocator) {
        WebDriverWait wait = new WebDriverWait(Application.getDriver(), 8, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
    }
    public static void waitUntilIsInvisible(By elementLocator) {
        WebDriverWait wait = new WebDriverWait(Application.getDriver(), 8, 50);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(elementLocator));
    }
}