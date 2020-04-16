package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Wait;

public class OpenShoppingCartTest extends BaseTest {

    private final String productName = "MacBook";

    /**
     * Test: Verify that the user is redirected to the Shopping Cart page
     * after clicking on the Shopping Cart link in top-links.
     *
     * Positive test
     */
    @Test()
    public void openShoppingCartTopLinks(){
        driver.findElement(By.xpath("//*[@id='top-links']//a[@title='Shopping Cart']")).click();
        String message = driver.findElement(By.xpath("//*[@id=\"content\"]/h1/..//p")).getText();
        Assert.assertEquals(message, "Your shopping cart is empty!");
    }

    /**
     * Test: Verify that the user is redirected to the  Shopping Cart page after
     * clicking on the View Cart link in DropDown (Shopping Cart is not empty).
     *
     * Positive test
     */
    @Test()
    public void openShoppingCartDropDown() throws InterruptedException {
        search(productName);
        addToCart(productName);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[@id='cart-total']")).click();
        driver.findElement(By.xpath("//*[@class='dropdown-menu pull-right']//a[contains(@href,'checkout/cart')]")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/form/div")).isDisplayed());
    }

    /**
     * Test: Verify that the user is redirected to the  Shopping Cart page
     * after clicking on the Checkout link in top-links when Shopping Cart is empty.
     *
     * Positive test
     */
    @Test()
    public void openCartByCheckoutTopLinks(){
        driver.findElement(By.xpath("//*[@id=\"logo\"]/a/img")).click();

        driver.findElement(By.xpath("//*[@id='top-links']//a[@title='Checkout']")).click();
        String message = driver.findElement(By.xpath("//*[@id=\"content\"]/h1/..//p")).getText();
        Assert.assertEquals(message, "Your shopping cart is empty!");
    }

    /**
     * Test: Verify that the user is redirected to the  Shopping Cart page after
     * clicking on the Shopping Cart link in Alert message.
     *
     * Positive test
     */
    @Test()
    public void openCartAlertMessage(){
        //driver.findElement(By.xpath("//*[@id=\"logo\"]/a/img")).click();
        search(productName);
        addToCart(productName);
        Wait.waitUntilIsClickable(driver.findElement(By.xpath("//div[contains(@class, 'alert')]")));
        WebElement alert = driver.findElement(By.xpath("//div[contains(@class, 'alert')]"));
        Assert.assertTrue(alert.getText().contains("Success"));
        alert.findElement(By.xpath("//div[contains(@class, \"alert\")]//a[contains(@href,\"checkout/cart\")]")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='content']/h1")).isDisplayed());
    }


}
