package com.softserve.edu.greencity.ui.pages.tipstricks;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.softserve.edu.greencity.ui.pages.econews.ItemComponent;

public class TipsCardsContainer {

    

    private WebDriver driver;

    private List<ItemComponent> itemComponents;

    // button pagination
    private WebElement leftPagination;
    private WebElement rightPagination;

    public TipsCardsContainer(WebDriver driver) {
        this.driver = driver;
        initElements();

    }

    private void initElements() {
        // init elements

        itemComponents = new ArrayList<>();
        for (WebElement current : driver.findElements(By.xpath("//app-tips-card"))) {
            itemComponents.add(new ItemComponent(driver, current));
        }
       
        leftPagination = driver.findElement(By.xpath("//i[@class='arrow fas fa-chevron-left']/.."));
        rightPagination = driver.findElement(By.xpath("//i[@class='arrow fas fa-chevron-right']/.."));

        // rightPagination.getLocation().getX();
    }


    // Page Object
    public List<ItemComponent> getItemComponents() {
        return itemComponents;
    }

    // leftPagination

    public WebElement getleftPagination() {
        
        return leftPagination;
    }

    public void clickleftPagination() {
       getleftPagination().click();
    }

    // rightPagination

    public WebElement getRightPagination() {
        return rightPagination;
    }

    public void clickRightPagination() {
        getRightPagination().click();
    }

    //

    private void scrollTo(WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
    }
    // Functional
    /**
     * @return number ItemComponents is displayed
     */
    public int getItemComponentsCount() {
        return getItemComponents().size();
    }

    public List<String> getItemComponentsParagra() {  
        List<String> itemComponentsParagra = new ArrayList<>();
        for(ItemComponent cur : getItemComponents()) {
            itemComponentsParagra.add(cur.getParagraphCardText());
        }
        return itemComponentsParagra;
    }
    // private String getTipsCards() {
    //
    // for (WebElement objShowLink : tipsCard) {
    // String strObjShowLink = objShowLink.getText();
    // //System.out.println("Check 'Show': " + strObjShowLink);
    // }
    //
    // }
    // public List<WebElement> checkActiveFilters() {
    // List<WebElement> activeFilters = new ArrayList<>();
    // for(WebElement curr : ) {
    // if(curr.getAttribute("class").contains("clicked-filter-button")) {
    // activeFilters.add(curr);
    // }
    // }
    // return activeFilters;
    // }
    // Business Logic
}
