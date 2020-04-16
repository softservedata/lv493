package tests;

import data.GiftCertificateRepository;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.Wait;

public class AddGiftCertificateTest extends BaseTest {

    private final String productName = "MacBook";

    @DataProvider
    public Object[][] giftCertificateDataProvider() {
        return GiftCertificateRepository.getDefault();
    }

    /**
     * Test: User can add Gift Certificate code.
     * Test with positive and negative input data
     *
     * @param certificateCode
     * @param certificateStatus
     */
    @Test(dataProvider = "giftCertificateDataProvider")
    public void addGiftCertificateTest(final String certificateStatus, final String certificateCode) {
        System.out.println(certificateCode);
        search(productName);
        addToCart(productName);
        openShoppingCart();
        Wait.waitUntilIsClickable(driver.findElement(By.xpath("//*[@id='accordion']//a[@href='#collapse-voucher']")));
        driver.findElement(By.xpath("//*[@id='accordion']//a[@href='#collapse-voucher']")).click();
        driver.findElement(By.cssSelector("#input-voucher")).click();
        driver.findElement(By.cssSelector("#input-voucher")).clear();
        driver.findElement(By.cssSelector("#input-voucher")).sendKeys(certificateCode);
        driver.findElement(By.cssSelector("#button-voucher")).click();
        WebElement alert = driver.findElement(By.xpath("//div[contains(@class, 'alert')]"));
        Assert.assertTrue(alert.getText().contains(certificateStatus));
        if (certificateStatus.equals("Success")) {
            // TODO
        }
       /* try {
            takeScreenShot(driver);
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
    }
}
