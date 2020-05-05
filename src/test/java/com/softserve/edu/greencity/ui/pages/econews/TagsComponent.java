package com.softserve.edu.greencity.ui.pages.econews;

import com.softserve.edu.greencity.ui.data.Tag;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TagsComponent {

    private WebDriver driver;
    private List<WebElement> tagsButtons;
    private WebElement tagsDescription;

    public TagsComponent(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        // init elements
        tagsButtons = driver.findElements(By.cssSelector("div.tags > button"));
       // tagsDescription = driver.findElement(By.cssSelector("div.tags > button + p"));
    }

    // Page Object

    public List<WebElement> getTagsButtons() {
        return tagsButtons;
    }

    public List<WebElement> getSelectedTagsButtons() {
        List<WebElement> selectedTagsButtons = driver.findElements(By.cssSelector("div.tags > button.filters-color"));
        return selectedTagsButtons;
    }

    // tagsDescription and warning
    public WebElement getTagsDescription() {
        return tagsDescription;
    }

    public boolean isTagsDescriptionWarning() {
        return getTagsDescription().getAttribute("class").contains("warning");
    }

    // Functional
    public Set<String> getTagsNames(List<WebElement> selectedTagsButtons) {
        Set<String> tagsNames = new HashSet<>();
        for (WebElement current : selectedTagsButtons) {
            tagsNames.add(current.getText());
        }
        System.out.println(tagsNames);
        return tagsNames;
    }

    public WebElement getWebElementByTagName(Tag newsfilter) {
        WebElement tag = getTagsButtons().stream()
                .filter((element) -> element.getText().contains(newsfilter.toString()))
                .findFirst().get();
        return tag;
    }

    public boolean isTagActive(Tag newsfilter) {
        return getWebElementByTagName(newsfilter).getAttribute("class").contains("clicked-filter-button");
    }

    public void selectTag(Tag newsfilter) {
        if (!isTagActive(newsfilter)) {
            getWebElementByTagName(newsfilter).click();
        }
    }

    public void selectTags(List<Tag> tags) {
        if (tags.size() > 0) {
            for (Tag current : tags) {
                selectTag(current);
            }
        }
    }
    // Business Logic

}
