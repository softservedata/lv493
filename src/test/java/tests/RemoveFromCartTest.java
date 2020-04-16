package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Wait;

import java.util.List;

public class RemoveFromCartTest extends BaseTest {

    /**
     * Test Remove product from Shopping Cart Page
     * @param productName
     * Positive test
     */
    @Test(dataProvider = "productDataProvider")
    public void RemoveFromShoppingCartTest(final String productName) {
        search(productName);
        addToCart(productName);
        Wait.waitUntilIsClickable(driver.findElement(By.xpath("//div[contains(@class, 'alert')]")));
        WebElement alert = driver.findElement(By.xpath("//div[contains(@class, 'alert')]"));
        Assert.assertTrue(alert.getText().contains("Success"));
        openShoppingCart();
        driver.findElement(By.xpath("//div[@id=\"content\"]//a[text()='" + productName +
                "']/../following-sibling::td//button[@data-original-title=\"Remove\"]")).click();
        String cartButtonText = driver.findElement(By.xpath("//span[@id=\"cart-total\"]")).getText().trim();
        Assert.assertEquals(getCartCount(cartButtonText), "0");
        String message = driver.findElement(By.xpath("//*[@id=\"content\"]/h1/..//p")).getText();
        Assert.assertEquals(message, "Your shopping cart is empty!");
    }

    /**
     * Test Remove product from dropdown
     * @param productName
     *
     * Positive test
     */
    @Test(dataProvider = "productDataProvider")
    public void RemoveFromDropDown(final String productName) {
        search(productName);
        addToCart(productName);
        Wait.waitUntilIsClickable(driver.findElement(By.xpath("//div[contains(@class, 'alert')]")));
        WebElement alert = driver.findElement(By.xpath("//div[contains(@class, 'alert')]"));
        Assert.assertTrue(alert.getText().contains("Success"));
        driver.findElement(By.xpath("//span[@id='cart-total']")).click();
        driver.findElement(By.xpath("//table[@class='table table-striped']//tbody//tr//a[contains(.,'" +
                productName + "')]/../following-sibling::td//i[@class='fa fa-times']")).click();

        openShoppingCart();
        String message = driver.findElement(By.xpath("//*[@id=\"content\"]/h1/..//p")).getText();
        Assert.assertEquals(message, "Your shopping cart is empty!");

        String cartButtonText = driver.findElement(By.xpath("//span[@id=\"cart-total\"]")).getText().trim();
        Assert.assertEquals(getCartCount(cartButtonText), "0");

        driver.findElement(By.xpath("//span[@id='cart-total']")).click();
        WebElement alertMessage = driver.findElement(By.xpath("//ul[@class='dropdown-menu pull-right']//p"));
        Assert.assertTrue(alertMessage.getText().contains("Your shopping cart is empty!"));
    }

    /**
     * Test Remove all products from Shopping cart
     * @param productName1
     * @param productName2
     *
     * Positive test
     */
    @Test(dataProvider = "twoProductsProvider")
    public void removeAllFromShoppingCartTest(final String productName1, final String productName2) {
        search(productName1);
        addToCart(productName1);
        search(productName2);
        addToCart(productName2);
        openShoppingCart();
        removeAllFromShoppingCart();
        String cartButtonText = driver.findElement(By.xpath("//span[@id=\"cart-total\"]")).getText().trim();
        Assert.assertEquals(getCartCount(cartButtonText), "0");
        String message = driver.findElement(By.xpath("//*[@id=\"content\"]/h1/..//p")).getText();
        Assert.assertEquals(message, "Your shopping cart is empty!");
    }

    private void removeAllFromShoppingCart() {
        List<WebElement> searchResult = driver.findElements(By.xpath("//div[@class=\"table-responsive\"]//table//tbody//tr"));
        System.out.println(searchResult.size());
        while (searchResult.size() > 0) {
            Wait.waitUntilIsClickable(searchResult.get(0).findElement(By.xpath("//following-sibling::td//button[@data-original-title=\"Remove\"]")));
            searchResult.get(0).findElement(By.xpath("//following-sibling::td//button[@data-original-title=\"Remove\"]")).click();
            Wait.waitUntilStalenessOf(searchResult.get(0).findElement(By.xpath("//following-sibling::td//button[@data-original-title=\"Remove\"]")));
            searchResult = driver.findElements(By.xpath("//div[@class=\"table-responsive\"]//table//tbody//tr"));
        }
    }
}
