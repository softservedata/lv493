package tests;

import data.AppleCinemaOrderData;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Wait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.format.DateTimeFormatter;

public class AddAppleCinemaTest extends BaseTest {

    private final String productName = "Apple Cinema 30\"";

    /**
     * Test: Add Apple Cinema 30" to Shopping Cart
     * by filling all fields in product details page
     *
     * Positive test
     */
    @Test(invocationCount = 1)
    public void addAppleCinemaTest() {
        AppleCinemaOrderData data = new AppleCinemaOrderData("Small", "Checkbox 3",
                "src/test/resources/appleCinema.txt");

        search(productName);

        driver.findElement(By.xpath("//a[text()='" + productName +
                "']/../../following-sibling::div/button[contains(@onclick, 'cart.add')]")).click();

        /*
        WebElement inputFileElement = driver.findElement(By.xpath("//button[starts-with(@id,'button-upload')]" +
                "/following-sibling::input"));
         */

        uploadFileByButton(data.getUploadFileInputValue());

        driver.findElement(By.xpath("//div[@class=\"radio\"]/label[text()[contains(., \""
                + data.getSize() + "\")]]/input")).click();

        driver.findElement(By.xpath("//div[@class=\"checkbox\"]/label[text()[contains(., \'"
                + data.getCheckbox() + "\')]]/input")).click();

        driver.findElement(By.xpath("//input[@placeholder='Text' or @name='option[208]']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Text' or @name='option[208]']")).clear();
        driver.findElement(By.xpath("//input[@placeholder='Text' or @name='option[208]']")).sendKeys(data.getTextField());

        driver.findElement(By.xpath("//option[starts-with(.,'Red')]")).click();

        driver.findElement(By.xpath("//textarea[@placeholder='Textarea' or @id='input-option209']")).click();
        driver.findElement(By.xpath("//textarea[@placeholder='Textarea' or @id='input-option209']")).clear();
        driver.findElement(By.xpath("//textarea[@placeholder='Textarea' or" +
                " @id='input-option209']")).sendKeys(data.getTextAreaField());

        DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        driver.findElement(By.xpath("//div[@class='input-group date']/input")).click();
        driver.findElement(By.xpath("//div[@class='input-group date']/input")).clear();
        driver.findElement(By.xpath("//div[@class='input-group date']/input")).sendKeys(data.getDateField().format(formatterDate));

        DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("HH:mm");
        driver.findElement(By.xpath("//div[@class='input-group time']/input")).click();
        driver.findElement(By.xpath("//div[@class='input-group time']/input")).clear();
        driver.findElement(By.xpath("//div[@class='input-group time']/input")).sendKeys(data.getTimeField().format(formatterTime));

        DateTimeFormatter formatterDateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        driver.findElement(By.xpath("//div[@class='input-group datetime']/input")).click();
        driver.findElement(By.xpath("//div[@class='input-group datetime']/input")).clear();
        driver.findElement(By.xpath("//div[@class='input-group datetime']/input")).sendKeys(data.getDateTimeField().format(formatterDateTime));
        System.out.println(data.getDateTimeField().format(formatterDateTime));

        driver.findElement(By.xpath("//*[@id=\"input-quantity\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"input-quantity\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"input-quantity\"]")).sendKeys(data.getQuantityField());

        driver.findElement(By.cssSelector("#button-cart")).click();

        Wait.waitUntilIsVisible(By.xpath("//div[contains(@class, 'alert')]"));
        WebElement alert = driver.findElement(By.xpath("//div[contains(@class, 'alert-success')]"));
        Assert.assertTrue(alert.getText().contains("Success"));
        Assert.assertTrue(alert.getText().contains(productName));
        Assert.assertTrue(alert.getAttribute("class").contains("success"));
        String cartButtonText = driver.findElement(By.xpath("//span[@id=\"cart-total\"]")).getText().trim();
        Assert.assertEquals(getCartCount(cartButtonText), data.getQuantityField());
    }

    /*
        Upload a File by Using input element.
        Send file's path to attribute 'value'
     */
    private void uploadFileInput(WebElement input, String filePath) {
        File file = new File(filePath);
        String path = file.getAbsolutePath();
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);",
                input, "value", path);
    }

    /*
        Upload a File by Using Robot Class.
        This method is for handling the Windows File Upload dialog, which cannot be handled using Selenium.
     */
    private void uploadFileByButton(String path) {
        File file = new File(path);
        StringSelection absolutePath = new StringSelection(file.getAbsolutePath());
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(absolutePath, null);
        driver.findElement(By.xpath("//button[starts-with(@id,'button-upload')]")).click();
        try {
            Robot robot = new Robot();
            robot.delay(3000);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.delay(1000);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            //driver.switchTo().alert().accept();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
}
