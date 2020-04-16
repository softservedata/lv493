package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ConnectionToDatabase;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ChangeQuantityTest extends BaseTest {

    /**
     * Test: Edit quantity for product in Shopping Cart with valid value - available count from database
     * @param productName
     *
     * Positive test
     */
    @Test(dataProvider = "productDataProvider", enabled = true)
    public void editQuantityPositiveTest(final String productName) {
        search(productName);
        addToCart(productName);
        openShoppingCart();
        String availableCount = getQuantity(productName);
        setQuantity(productName, availableCount);
        updateQuantity(productName);

        WebElement alert = driver.findElement(By.xpath("//div[contains(@class, 'alert')]"));
        Assert.assertTrue(alert.getAttribute("class").contains("success"));
        Assert.assertTrue(alert.getText().contains("Success"));

        setQuantity(productName, availableCount);
        updateQuantity(productName);

        String quantityStr = driver.findElement(By.xpath("//div[@id='content']//a[text()='" + productName +
                "']/../following-sibling::td//input")).getAttribute("value");
        String unitPrice = driver.findElement(By.xpath("//a[text()='" + productName +
                "']/../following-sibling::td//input/../../following-sibling::td[1]")).getText();
        String actualPriceStr = driver.findElement(By.xpath("//*[@class=\"table table-bordered\"]" +
                "//*[text()=\"Total:\"]/../following-sibling::td")).getText();

        unitPrice = getPrice(unitPrice);
        actualPriceStr = getPrice(actualPriceStr);
        BigDecimal quantity = new BigDecimal(quantityStr);
        BigDecimal expected = new BigDecimal(unitPrice).multiply(quantity);
        BigDecimal actual = new BigDecimal(actualPriceStr);

        Assert.assertTrue(actual.equals(expected));
    }

    /**
     * Test: Edit quantity for two products and clicking on the Update button of first product
     *
     * @param productName1
     * @param productName2
     */
    @Test(dataProvider = "twoProductsProvider")
    public void editQuantityTwoItemsTest(final String productName1, final String productName2) {
        search(productName1);
        addToCart(productName1);
        search(productName2);
        addToCart(productName2);
        openShoppingCart();
        String quantityProduct1 = driver.findElement(By.xpath("//div[@id='content']//a[text()='" + productName1 +
                "']/../following-sibling::td//input")).getAttribute("value");
        String quantityProduct2 = driver.findElement(By.xpath("//div[@id='content']//a[text()='" + productName2 +
                "']/../following-sibling::td//input")).getAttribute("value");
        setQuantity(productName1, "4");
        setQuantity(productName2, "5");
        updateQuantity(productName1);

        WebElement alert = driver.findElement(By.xpath("//div[contains(@class, 'alert')]"));
        Assert.assertTrue(alert.getAttribute("class").contains("success"));
        Assert.assertTrue(alert.getText().contains("Success"));

        String actualQuantityPr1 = driver.findElement(By.xpath("//div[@id='content']//a[text()='" + productName1 +
                "']/../following-sibling::td//input")).getAttribute("value");
        String actualQuantityPr2 = driver.findElement(By.xpath("//div[@id='content']//a[text()='" + productName2 +
                "']/../following-sibling::td//input")).getAttribute("value");

        Assert.assertNotEquals(actualQuantityPr1, quantityProduct1);
        Assert.assertEquals(actualQuantityPr2, quantityProduct2);
    }

    /**
     * Test: Edit quantity and refresh page without clicking on the Update button
     *
     * @param productName1
     * @param productName2
     */
    @Test(dataProvider = "twoProductsProvider")
    public void editQuantityAndRefresh(final String productName1, final String productName2) {
        search(productName1);
        addToCart(productName1);
        search(productName2);
        addToCart(productName2);
        openShoppingCart();
        String quantityProduct1 = driver.findElement(By.xpath("//div[@id='content']//a[text()='" + productName1 +
                "']/../following-sibling::td//input")).getAttribute("value");
        String quantityProduct2 = driver.findElement(By.xpath("//div[@id='content']//a[text()='" + productName2 +
                "']/../following-sibling::td//input")).getAttribute("value");
        setQuantity(productName1, "4");
        setQuantity(productName2, "5");
        driver.navigate().refresh();
        String actualQuantityPr1 = driver.findElement(By.xpath("//div[@id='content']//a[text()='" + productName1 +
                "']/../following-sibling::td//input")).getAttribute("value");
        String actualQuantityPr2 = driver.findElement(By.xpath("//div[@id='content']//a[text()='" + productName2 +
                "']/../following-sibling::td//input")).getAttribute("value");

        Assert.assertEquals(actualQuantityPr1, quantityProduct1);
        Assert.assertEquals(actualQuantityPr2, quantityProduct2);
    }

    @DataProvider
    public Object[][] quantityDataProvider() {
        return new Object[][]{
                {"940", "HTC Touch HD"},
                {"-5", "HTC Touch HD"},
                {"0", "HTC Touch HD"},
                {"fhg&^%$54", "HTC Touch HD"},
                {"67fcf&^%", "HTC Touch HD"}
        };
    }

    /**
     * Test: Edit quantity for product in Shopping Cart with invalid values
     * (letters, special characters, negative numbers)
     *
     * @param productName
     *
     * Negative test
     */
    @Test(dataProvider = "quantityDataProvider", enabled = true)
    public void changeQuantityNegativeTest(final String value, final String productName) {
        search(productName);
        addToCart(productName);
        openShoppingCart();
        setQuantity(productName, value);
        updateQuantity(productName);
        List<WebElement> alerts = driver.findElements(By.xpath("//div[contains(@class, 'alert-danger')]"));
        Boolean result = false;
        for (WebElement alert:alerts) {
            if (alert.getAttribute("class").contains("alert-danger"));
            result = true;
        }
        Assert.assertTrue(result);
    }

    private void setQuantity(String productName, String value) {
        driver.findElement(By.xpath("//div[@id='content']//a[text()='" + productName +
                "']/../following-sibling::td//input")).click();
        driver.findElement(By.xpath("//div[@id='content']//a[text()='" + productName +
                "']/../following-sibling::td//input")).clear();
        driver.findElement(By.xpath("//div[@id='content']//a[text()='" + productName +
                "']/../following-sibling::td//input")).sendKeys(value);
    }

    private void updateQuantity(String productName) {
        driver.findElement(By.xpath("//div[@id='content']//a[text()='" + productName +
                "']/../following-sibling::td//button[@data-original-title='Update']")).click();
    }

    private String getQuantity(String productName) {
        ConnectionToDatabase connection = new ConnectionToDatabase();
        String query1 = "select oc_product.quantity" +
                " from oc_product join oc_product_description" +
                " on oc_product.product_id = oc_product_description.product_id " +
                "where oc_product_description.name='" + productName + "';";
        String q = "";
        try (ResultSet rs = connection.createStatement().executeQuery(query1)) {
            if (rs.next()) {
                q = rs.getObject("quantity").toString();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return q;
    }
}

