package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.Wait;

public class AddCouponTest extends BaseTest {

    private final String productName = "MacBook";

    @DataProvider
    public Object[][] couponDataProvider() {
        return new Object[][]{
                {"Success: Your coupon discount has been applied!", "2222"},
                {"Warning: Please enter a coupon code!", ""},
                {"Warning: Coupon is either invalid, expired or reached its usage limit!", "2222dfgg"}
        };
    }

    /**
     * Test: User is able to apply a valid coupon.
     * Test with positive and negative input data
     * @param couponStatus
     * @param couponCode
     */
    @Test(dataProvider = "couponDataProvider")
    public void addCouponTest(final String couponStatus, final String couponCode) {
        search(productName);
        addToCart(productName);
        openShoppingCart();
        Wait.waitUntilIsClickable(driver.findElement(By.xpath("//*[@id='accordion']//a[@href='#collapse-coupon']")));
        driver.findElement(By.xpath("//*[@id='accordion']//a[@href='#collapse-coupon']")).click();
        driver.findElement(By.xpath("//*[@id=\"input-coupon\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"input-coupon\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"input-coupon\"]")).sendKeys(couponCode);
        driver.findElement(By.cssSelector("#button-coupon")).click();
        WebElement alert = driver.findElement(By.xpath("//div[contains(@class, 'alert')]"));
        Assert.assertTrue(alert.getText().contains(couponStatus));
       /* try {
            takeScreenShot(driver);
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
    }
}
