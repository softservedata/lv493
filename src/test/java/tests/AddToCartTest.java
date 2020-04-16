package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Wait;

public class AddToCartTest extends BaseTest {

    /**
     * Test: Add single product to Shopping Cart from search result
     * @param productName
     *
     * Positive test
     */
    @Test(dataProvider = "productDataProvider")
    public void addToCartTest(final String productName) {
        search(productName);
        String expectedPrice = addToCartWithPrice(productName);
        WebElement alert = driver.findElement(By.xpath("//div[contains(@class, 'alert')]"));
        Assert.assertTrue(alert.getAttribute("class").contains("success"));
        Assert.assertTrue(alert.getText().contains("Success"));
        Assert.assertTrue(alert.getText().contains(productName));

        String cartButtonText = driver.findElement(By.xpath("//span[@id=\"cart-total\"]")).getText().trim();
        Assert.assertEquals(getCartCount(cartButtonText), "1");
        Assert.assertEquals(getPrice(cartButtonText), getPrice(expectedPrice));

        Wait.waitUntilIsClickableAndClick(driver.findElement(By.xpath("//*[@id='top-links']//a[@title='Shopping Cart']")));
        Wait.waitUntilIsVisible(By.xpath("//*[@class='table table-bordered']//*[text()='Total:']/../following-sibling::td"));
        String actualTotalResult = driver.findElement(By.xpath("//*[@class='table table-bordered']" +
                "//tr[last()]//*[text()='Total:']/../following-sibling::td")).getText();
        Assert.assertEquals(getPrice(actualTotalResult), getPrice(expectedPrice));
    }

    /**
     * Test: Add single product to Shopping Cart from product detail page
     * @param productName
     *
     * Positive test
     */
    @Test(dataProvider = "productDataProvider")
    public void addToCartFromPDPTest(final String productName) {
        search(productName);
        driver.findElement(By.xpath("//div[contains(@class,'caption')]//a[text()='" + productName + "']")).click();
        driver.findElement(By.cssSelector("#button-cart")).click();
        WebElement alert = driver.findElement(By.xpath("//div[contains(@class, 'alert')]"));
        Assert.assertTrue(alert.getAttribute("class").contains("success"));
        Assert.assertTrue(alert.getText().contains("Success"));
        Assert.assertTrue(alert.getText().contains(productName));
        String cartButtonText = driver.findElement(By.xpath("//span[@id=\"cart-total\"]")).getText().trim();
        Assert.assertEquals(getCartCount(cartButtonText), "1");
    }

    /**
     * Test: Add the same item multiple times
     * @param productName
     *
     * Positive test
     */
    @Test(dataProvider = "productDataProvider")
    public void addToCartMultipleTimes(final String productName) {
        search(productName);
        addToCart(productName);
        WebElement alert = driver.findElement(By.xpath("//div[contains(@class, 'alert')]"));
        Assert.assertTrue(alert.getAttribute("class").contains("success"));
        driver.findElement(By.xpath("//div[@class=\"alert alert-success\"]//button[@class=\"close\"]")).click();
        Wait.waitUntilIsInvisible(By.xpath("//div[contains(@class, 'alert')]"));
        addToCart(productName);
        WebElement alert2 = driver.findElement(By.xpath("//div[contains(@class, 'alert')]"));
        Assert.assertTrue(alert2.getAttribute("class").contains("success"));
        driver.findElement(By.xpath("//div[@class=\"alert alert-success\"]//button[@class=\"close\"]")).click();
        openShoppingCart();
        String quantity = driver.findElement(By.xpath("//div[@id='content']//a[text()='" + productName +
                "']/../following-sibling::td//input")).getAttribute("value");
        Assert.assertEquals(quantity, "2");
    }
}
