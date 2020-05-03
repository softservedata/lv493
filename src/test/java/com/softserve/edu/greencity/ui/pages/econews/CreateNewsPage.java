package com.softserve.edu.greencity.ui.pages.econews;

import com.softserve.edu.greencity.ui.data.NewsData;
import com.softserve.edu.greencity.ui.data.NewsFilter;
import com.softserve.edu.greencity.ui.pages.common.TopPart;
import com.softserve.edu.greencity.ui.tools.UploadFileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author lv-493 Taqc/Java
 */
public class CreateNewsPage extends TopPart {

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
    private WebElement continueEditingButton;
    private WebElement cancelEditingButton;

    //description fields
    private WebElement titleDescription;
    private WebElement tagsDescription;
    private WebElement sourceDescription;
    private WebElement contentDescription;
    private WebElement pictureDescription;

    /**
     * @param driver
     */
    public CreateNewsPage(WebDriver driver) {
        super(driver);
        initElements();
    }


    private void initElements() {
        // init main elements
        dropArea = driver.findElement(By.cssSelector("div.text-wrapper"));
        titleField = driver.findElement(By.cssSelector("input[formcontrolname='title']"));
        sourceField = driver.findElement(By.cssSelector("div[formarrayname='tags']+label > input"));
        tagsButtons = driver.findElements(By.cssSelector("div.tags > button"));
        //contentField = driver.findElement(By.xpath("//div[@class = 'textarea-wrapper']/textarea")); //to choose
        contentField = driver.findElement(By.cssSelector("div.textarea-wrapper > textarea"));
        dateField = driver.findElement(By.cssSelector("div.date > p:first-child > span"));
        authorField = driver.findElement(By.cssSelector("div.date > :nth-child(2n) > span"));
        cancelButton = driver.findElement(By.cssSelector("div.submit-buttons > :first-child"));
        // driver.findElement(By.cssSelector("div.submit-buttons > :first-child+button")); //to choose
        previewButton = driver.findElement(By.cssSelector("div.submit-buttons > :nth-child(2n)"));
        publishButton = driver.findElement(By.cssSelector("div.submit-buttons > button[type='submit']"));

        // init description fields
        titleDescription = driver.findElement(By.cssSelector("input[formcontrolname='title'] + span"));
        tagsDescription = driver.findElement(By.cssSelector("div.tags > button + p"));
        sourceDescription = driver.findElement(By.cssSelector("div[formarrayname='tags']+label > input + span"));
        contentDescription = driver.findElement(By.cssSelector("p.textarea-description"));
        pictureDescription = driver.findElement(By.xpath("//div[@class = 'text-wrapper']/../../div/../span"));
    }

    private void initIFrameElements() {
        continueEditingButton = driver.findElement(By.cssSelector("div.continue-btn > button"));
        cancelEditingButton = driver.findElement(By.cssSelector("button.primary-global-button"));
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
        selectedTagsButtons = driver.findElements(By.cssSelector("div.tags > button.filters-color"));
        return selectedTagsButtons;
    }

    // titleDescription and warning
    public WebElement getTitleDescription() {
        return titleDescription;
    }

    public boolean isTitleDescriptionWarning() {
        return getTitleField().getAttribute("class").contains("invalid");
    }

    // tagsDescription and warning
    public WebElement getTagsDescription() {
        return tagsDescription;
    }

    public boolean isTagsDescriptionWarning() {
        return getTagsDescription().getAttribute("class").contains("warning");
    }

    // sourceDescription and warning
    public WebElement getSourceDescription() {
        return sourceDescription;
    }

    public boolean isSourceDescriptionWarning() {
        return getSourceDescription().getAttribute("class").contains("warning");
    }

    // contentDescription and warning
    public WebElement getContentDescription() {
        return contentDescription;
    }

    public boolean isContentDescriptionWarning() {
        return getContentField().getAttribute("class").contains("invalid");
    }

    // pictureDescription and warning
    public WebElement getPictureDescription() {
        return pictureDescription;
    }

    public boolean isPictureDescriptionWarning() {
        return getPictureDescription().getAttribute("class").contains("warning-color");
    }

    // Functional
    public Set<String> getTagsNames(List<WebElement> selectedTagsButtons) {
        Set<String> hashSet = new HashSet<>();
        for (WebElement current : selectedTagsButtons) {
            hashSet.add(current.getText());
        }
        System.out.println(hashSet);
        return hashSet;
    }

    public WebElement getWebElementByTagName(NewsFilter newsfilter) {
        WebElement tag = getTagsButtons().stream()
                .filter((element) -> element.getText().contains(newsfilter.toString()))
                .findFirst().get();
        return tag;
    }

    public boolean isTagActive(NewsFilter newsfilter) {
        return getWebElementByTagName(newsfilter).getAttribute("class").contains("clicked-filter-button");
    }

    public void selectTag(NewsFilter newsfilter) {
        if (!isTagActive(newsfilter)) {
            getWebElementByTagName(newsfilter).click();
        }
    }

    public void selectTags(List<NewsFilter> tags) {
        if (tags.size() > 0) {
            for (NewsFilter current : tags) {
                selectTag(current);
            }
        }
    }

    // Business Logic

    // Drop and upload file
    public void uploadFile(WebElement dropArea, String path) { // Business Logic or Functional or PageObject
        UploadFileUtils.DropFile(new File(path), dropArea, 0, 0);
    }

    public CreateNewsPage fillAllNewsFields(NewsData newsData) {
        selectTags(newsData.getTags());
        System.out.println("isTagsDescriptionWarning " + isTagsDescriptionWarning());

        clearTitleField();
        setTitleField(newsData.getTitle());
        clearContentField();
        setContentField(newsData.getContent());
        System.out.println(newsData.getTags());
        clearSourceField();
        setSourceField(newsData.getSource());
        uploadFile(dropArea, newsData.getFilePath());

        System.out.println(getTagsNames(getSelectedTagsButtons()));
        System.out.println("isTitleDescriptionWarning " + isTitleDescriptionWarning());
        System.out.println("isContentDescriptionWarning " + isContentDescriptionWarning());
        System.out.println("isSourceDescriptionWarning " + isSourceDescriptionWarning());
        System.out.println("isContentDescriptionWarning " + isContentDescriptionWarning());
        System.out.println("isTagsDescriptionWarning " + isTagsDescriptionWarning());
        System.out.println("isPictureDescriptionWarning" + isPictureDescriptionWarning());

        return this;
    }

    public PreViewPage openPreViewPage() {
        clickPreviewButton();
        return new PreViewPage(driver);
    }

    public EconewsPage publishNews() {
        clickPublishButton(); // Button doesn't work
        return new EconewsPage(driver);
    }

    public EconewsPage cancelNewsCreating() {
        clickCancelButton();
        initIFrameElements();
        cancelEditingButton.click();
        return new EconewsPage(driver);
    }

    public CreateNewsPage continueNewsCreating() {
        clickCancelButton();
        initIFrameElements();
        continueEditingButton.click();
        return this;
    }
}
