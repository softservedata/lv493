package com.softserve.edu.greencity.ui.pages.econews;

import org.openqa.selenium.*;

import com.softserve.edu.greencity.ui.pages.common.TopPart;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author lv-493 Taqc/Java
 */
public class CreateNewsPage extends TopPart {

    private WebDriver driver;
    //
    private WebElement titleField;
    private List<WebElement> tagsButtons;
    private List<WebElement> selectedTagsButtons;
    private WebElement sourceField;
    private WebElement contentField;
    private WebElement dateField;
    private WebElement authorField;
    private WebElement cancelButton;
    private WebElement previewButton;
    private WebElement publishButton;
    private WebElement dropArea;
    //private WebElement pictureField;

    public CreateNewsPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        // init elements
        dropArea = driver.findElement(By.cssSelector("div.text-wrapper"));
//        titleField = driver.findElement(By.cssSelector("label > input:first"));
//        sourceField = driver.findElement(By.cssSelector("div[formarrayname='tags']+label > input"));
//        tagsButtons = driver.findElements(By.cssSelector("div.tags > button"));
//        contentField = driver.findElement(By.xpath("//div[@class = 'textarea-wrapper']/textarea"));
//        dateField = driver.findElement(By.cssSelector("div.date:first-child"));
//        authorField = driver.findElement(By.cssSelector("div.date:last-child"));
//        cancelButton = driver.findElement(By.cssSelector("div.submit-buttons > :first-child"));
//        // driver.findElement(By.cssSelector("div.submit-buttons > :first-child+button")); //to choose
//        previewButton = driver.findElement(By.cssSelector("div.submit-buttons > :nth-child(2n)"));
//        publishButton = driver.findElement(By.cssSelector("div.submit-buttons > button[type='submit']"));
    }

    // Page Object

    //titleField
    public WebElement getTitleField() {
        return titleField;
    }

    public String getTitleFieldText() {
        return getTitleField().getText();
    }

    public void clearTitleField() {
        getTitleField().clear();
    }

    public void clickTitleField() {
        getTitleField().click();
    }

    public void setTitleField(String text) {
        getTitleField().sendKeys(text);
    }

    //sourceField
    public WebElement getSourceField() {
        return sourceField;
    }

    public String getSourceFieldText() {
        return getSourceField().getText();
    }

    public void clearSourceField() {
        getSourceField().clear();
    }

    public void clickSourceField() {
        getSourceField().click();
    }

    public void setSourceField(String text) {
        getSourceField().sendKeys(text);
    }

    //contentField

    public WebElement getContentField() {
        return contentField;
    }

    public String getContentFieldText() {
        return getContentField().getText();
    }

    public void clearContentField() {
        getContentField().clear();
    }

    public void clickContentField() {
        getContentField().click();
    }

    public void setContentField(String text) {
        getContentField().sendKeys(text);
    }

    //tagsButtons
    public List<WebElement> getTagsButtons() {
        return tagsButtons;
    }

    //dateField
    public WebElement getDateField() {
        return dateField;
    }

    public String getDateFieldText() {
        return getDateField().getText();
    }

    //authorField
    public WebElement getAuthorField() {
        return authorField;
    }

    public String getAuthorFieldText() {
        return getAuthorField().getText();
    }

    //cancelButton;
    public WebElement getCancelButton() {
        return cancelButton;
    }

    public void clickCancelButton() {
        getCancelButton().click();
    }

    //previewButton

    public WebElement getPreviewButton() {
        return previewButton;
    }

    public void clickPreviewButton() {
        getPreviewButton().click();
    }

    //publishButton

    public WebElement getPublishButton() {
        return publishButton;
    }

    public void clickPublishButton() {
        getPublishButton().click();
    }

    //selectedTagsButtons

    public List<WebElement> getSelectedTagsButtons() {
        selectedTagsButtons = driver.findElements(By.cssSelector("div.tags > button[class='ng-star-inserted filters-color']"));
        return selectedTagsButtons;
    }

    // Functional

    //
    public String getValue(String text) { // tools > RegexUtils
        //text = "Date: April 26, 2020";
        final Matcher matcher = Pattern.compile("[a-zA-Z]: ").matcher(text);
        if (matcher.find()) {
            System.out.println(text.substring(matcher.end()).trim());
        }
        return text.substring(matcher.end()).trim();
    }

    public String getCurrentDate() { //tools > DateUtil > static
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = new DateTimeFormatterBuilder().appendPattern("MMMM dd, yyyy").toFormatter();
        return date.format(formatter);
    }

    public void uploadFile() {
// drop the file
        DropFile(new File("C:\\Users\\mJana\\Pictures\\1.jpg"), dropArea, 0, 0);
    }

    public static void DropFile(File filePath, WebElement target, int offsetX, int offsetY) {
        if (!filePath.exists())
            throw new WebDriverException("File not found: " + filePath.toString());

        WebDriver driver = ((RemoteWebElement) target).getWrappedDriver();
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, 30);

        String JS_DROP_FILE =
                "var target = arguments[0]," +
                        "    offsetX = arguments[1]," +
                        "    offsetY = arguments[2]," +
                        "    document = target.ownerDocument || document," +
                        "    window = document.defaultView || window;" +
                        "" +
                        "var input = document.createElement('INPUT');" +
                        "input.type = 'file';" +
                        "input.style.display = 'none';" +
                        "input.onchange = function () {" +
                        "  var rect = target.getBoundingClientRect()," +
                        "      x = rect.left + (offsetX || (rect.width >> 1))," +
                        "      y = rect.top + (offsetY || (rect.height >> 1))," +
                        "      dataTransfer = { files: this.files };" +
                        "" +
                        "  ['dragenter', 'dragover', 'drop'].forEach(function (name) {" +
                        "    var evt = document.createEvent('MouseEvent');" +
                        "    evt.initMouseEvent(name, !0, !0, window, 0, 0, 0, x, y, !1, !1, !1, !1, 0, null);" +
                        "    evt.dataTransfer = dataTransfer;" +
                        "    target.dispatchEvent(evt);" +
                        "  });" +
                        "" +
                        "  setTimeout(function () { document.body.removeChild(input); }, 25);" +
                        "};" +
                        "document.body.appendChild(input);" +
                        "return input;";

        WebElement input = (WebElement) jse.executeScript(JS_DROP_FILE, target, offsetX, offsetY);
        input.sendKeys(filePath.getAbsoluteFile().toString());
        wait.until(ExpectedConditions.stalenessOf(input));
    }

    // Business Logic


    //
    public CreateNewsPage chooseTags() {
        // clickPreviewButton();
        return this;
    }

    public PreViewPage openPreViewPage() {
        clickPreviewButton();
        return new PreViewPage(driver);
    }
}
