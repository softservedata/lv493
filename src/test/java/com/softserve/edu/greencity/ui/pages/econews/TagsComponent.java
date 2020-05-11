package com.softserve.edu.greencity.ui.pages.econews;

import com.softserve.edu.greencity.ui.data.Tag;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Components of CreateNewsPage & EconewsPage
 * Contains WebElemets that define type of news(names of news is in enum Tag)
 * @author lv-492
 */
public class TagsComponent {

    private WebDriver driver;
    private List<WebElement> tags;

    public TagsComponent(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
    	
        // init elements
        tags = driver.findElements(By.cssSelector("div.tags > button"));  //for CreateNewsPage 
        if(tags.size() == 0) {
        	tags = driver.findElements(By.cssSelector("ul.ul-eco-buttons > a > li")); //for EconewsPage
        }
    }

    // Page Object

    protected List<WebElement> getTags() {
        return tags;
    }


    // Functional
    
    protected Set<String> getTagsNames(List<WebElement> selectedTagsButtons) {
        Set<String> tagsNames = new HashSet<>();
        for (WebElement current : selectedTagsButtons) {
            tagsNames.add(current.getText());
        }
        System.out.println(tagsNames);
        return tagsNames;
    }
    
    /**
     * Get WebElement of news type by its name
     * @param Tag
     * @return WebElement
     */
    protected WebElement getWebElementByTagName(Tag newsfilter) {
        WebElement tag = getTags().stream()
                .filter((element) -> element
                .getText().toLowerCase().contains(newsfilter.toString().toLowerCase()))
                .findFirst().get();
        return tag;
    }
    
    /**
     * Check is some WebElement are choosen(clicked first time)
     * @param Tag
     * @return boolean
     */
    protected boolean isTagActive(Tag newsfilter) {
        return getWebElementByTagName(newsfilter)
        		.getAttribute("class")
        		.matches(".*(clicked-filter-button|active).*");
    }
    
    /**
     * Click on some WebElement to choose it(click first time)
     * @param Tag
     * @return boolean
     */
    protected void selectTag(Tag newsfilter) {
        if (!isTagActive(newsfilter)) {
            getWebElementByTagName(newsfilter).click();
        }
    }
    
    /**
     * Click on some WebElement to deselect it(click second time)
     * @param Tag
     * @return boolean
     */
    protected void deselectTag(Tag newsfilter) {
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
