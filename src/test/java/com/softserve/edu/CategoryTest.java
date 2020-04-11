package com.softserve.edu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * Class for testing Categories business logic
 */
public class CategoryTest {

    Properties properties;
    WebDriver driver;

    static String pathToPropertiesFile = "test.properties";


    /**
     * Loading properties for testing from properties file
     * @throws IOException
     */
    @BeforeSuite
    public void loadTestProperties() throws IOException {
        DataProviderClass.saveCategories();
        InputStream input = new FileInputStream(pathToPropertiesFile);

        properties = new Properties();
        properties.load(input);

    }

    /**
     * Starting new WebDriver
     */
    @BeforeSuite
    public void startWebDriver() {
        System.setProperty("webdriver.chrome.driver",
                CategoryTest.class.getResource("/chromedriver-windows-32bit.exe").getPath());

        ChromeOptions options = new ChromeOptions();
        //options.addArguments("headless");


        driver = new ChromeDriver(options);

        driver.manage().deleteAllCookies();
    }

    /**
     * Opening admin page
     */
    @BeforeClass
    public void openAdminPage() {
        driver.get(properties.getProperty("url") + "/admin");
    }

    /**
     * Try to login with credentials from properties file
     */
    @Test
    public void login() {
        driver.findElement(By.id("input-username")).sendKeys(properties.getProperty("login"));
        driver.findElement(By.id("input-password")).sendKeys(properties.getProperty("pass"));

        driver.findElement(By.className("btn-primary")).submit();
        System.out.println();
    }

    /**
     * Opening categories page
     */
    public void openCategoriesPage() {
        driver.findElement(By.id("menu-catalog")).click();

        driver.findElement(By.xpath("//a[contains(text(), 'Categories')]")).click();
    }

    /**
     * Adding new category
     * @param category - parameters which use to create newCategory
     */
    @Test(dependsOnMethods = {"login"},
            dataProvider = "newCategories",
            dataProviderClass = DataProviderClass.class)
    public void addNewCategory(DataProviderClass.CategoryData category) {

        openCategoriesPage();
        /**
         * counting categories before adding
         */
        int categoriesBeforeAdding = driver.findElements(By.xpath("//tbody/tr")).size();

        /**
         * Opening menu of creating category
         */
        driver.findElement(By.className("btn-primary")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        /**
         * Filling all fields of category parameters
         */
        driver.findElement(By.id("input-name1")).sendKeys(category.categoryName);
        driver.findElement(By.className("note-editable")).sendKeys(category.description);
        driver.findElement(By.id("input-meta-title1")).sendKeys(category.metaTagTitle);
        driver.findElement(By.id("input-meta-description1")).sendKeys(category.metaTagDescription);
        driver.findElement(By.id("input-meta-keyword1")).sendKeys(category.metaTagKeyword);

        driver.findElement(By.xpath("//a[contains(text(),'Data')]")).click();

        driver.findElement(By.id("input-parent")).sendKeys(category.parent);
        if(category.isTop) {
            driver.findElement(By.id("input-top")).click();
        }

        /**
         * Submitting creating category
         */
        driver.findElement(By.className("btn-primary")).click();
        /**
         * Checking for adding is successful
         */
        int categoriesAfterAdding = driver.findElements(By.xpath("//tbody/tr")).size();
        int countAddedCategory = driver.findElements(
                By.xpath("//td[contains(text(),'" + category.categoryName +  "')]")).size();

        Assert.assertEquals(countAddedCategory, 1);
        Assert.assertEquals(categoriesAfterAdding, categoriesBeforeAdding + 1,  "Category is not added");


    }

    /**
     * @return names of categories from horizontal menu
     */
    List<String> getCategoriesFromHorizontalMenu() {

        driver.get(properties.getProperty("url"));

        List<WebElement> verticalElements = driver.findElements(
                By.xpath("//ul[@class='nav navbar-nav']/li/a"));

        return verticalElements.stream().map(
                item -> item.getText().replaceAll("\\s\\(.*\\)", "")).collect(Collectors.toList()); //check

    }

    /**
     * @return names of categories from vertical menu
     */
    List<String> getCategoriesFromVerticalMenu() {

        driver.get(properties.getProperty("url"));

        driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[not(@class)]")).click();
        List<WebElement> verticalElements = driver.findElements(By.className("list-group-item"));

        return verticalElements.stream().map(
                item -> item.getText().replaceAll("\\s\\(.*\\)", "")).collect(Collectors.toList()); //check

    }

    /**
     * Deleting categories which was added before
     * @param category - parameters which used to create newCategory
     */
    @Test(dependsOnMethods = {"addNewCategory"},
            dataProvider = "newCategories",
            dataProviderClass = DataProviderClass.class)
    public void deleteCategory(DataProviderClass.CategoryData category) {
        openCategoriesPage();

        driver.findElement(By.xpath("//td[text()='" + category.categoryName + "']/..//input")).click();
        driver.findElement(By.className("btn-danger")).click();
        driver.switchTo().alert().accept();

        int countDeletedCategory = driver.findElements(
                By.xpath("//td[contains(text(),'" + category.categoryName +  "')]")).size();

        Assert.assertEquals(countDeletedCategory, 0);
    }

    /**
     * Log out from admin page
     */
    @AfterClass
    public void logOut() {
        driver.findElement(By.xpath("//span[@class='hidden-xs hidden-sm hidden-md']/..")).click();
    }

    /**
     * Tear down WebDriver
     */
    @AfterSuite
    public void tearDownWebDriver() {
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.quit();
    }
}
