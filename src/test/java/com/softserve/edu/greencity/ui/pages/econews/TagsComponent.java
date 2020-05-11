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
    private List<WebElement> tags;

    public TagsComponent(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        // init elements
        tags = driver.findElements(By.cssSelector("div.tags > button"));
        if(tags.size() == 0) {
        	tags = driver.findElements(By.cssSelector("ul.ul-eco-buttons > a > li"));
        }
    }

    // Page Object

    public List<WebElement> getTags() {
        return tags;
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
        WebElement tag = getTags().stream()
                .filter((element) -> element
                .getText().toLowerCase().contains(newsfilter.toString().toLowerCase()))
                .findFirst().get();
        return tag;
    }

    public boolean isTagActive(Tag newsfilter) {
        return getWebElementByTagName(newsfilter)
        		.getAttribute("class")
        		.matches(".*(clicked-filter-button|active).*");
    }

    public void selectTag(Tag newsfilter) {
        if (!isTagActive(newsfilter)) {
            getWebElementByTagName(newsfilter).click();
        }
    }
    
    public void deselectTag(Tag newsfilter) {
        if (isTagActive(newsfilter)) {
            getWebElementByTagName(newsfilter).click();
        }
    }

    public void selectTags(List<Tag> tags) {
             for (Tag current : tags) {
                selectTag(current);
            }
    }
    
    public void deselectTags(List<Tag> tags) {
            for (Tag current : tags) {
                deselectTag(current);
            }
        
    }
    // Business Logic

}
