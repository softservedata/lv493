package com.softserve.edu.greencity.ui.pages.cabinet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GoalComponent {

    private WebElement goalLayout;

    private WebElement checkMarkCheckbox;
    private String goalTitle;

    private WebElement editNewGoalButton;
    private WebElement deleteNewGoalButton;

    public GoalComponent(WebElement goalLayout) {
        this.goalLayout = goalLayout;
        initElements();
    }

    private void initElements() {
        //checkMarkCheckbox = goalLayout.findElement(By.cssSelector(".check-mark"));
       //goalTitle = goalLayout.findElement(By.cssSelector(".goal-text")).getText();
    }

    // Page Object

    // goalLayout

    public WebElement getGoalLayout() {
        return goalLayout;
    }

    public boolean isDisplayedGoalLayout() {
        return getGoalLayout().isDisplayed();
    }

    // checkMarkCheckbox

    public WebElement getCheckMarkCheckbox() {
       // return checkMarkCheckbox;
        return goalLayout.findElement(By.cssSelector(".check-mark"));
    }

    public void clickCheckMarkCheckbox() {
        getCheckMarkCheckbox().click();
    }

    public boolean isDisplayedCheckMarkCheckbox() {
        return getCheckMarkCheckbox().isDisplayed();
    }

    // goalName

    public String getGoalTitle() {
        //return goalTitle;
        return goalLayout.findElement(By.cssSelector(".goal-text")).getText();
    }

    // editNewGoalButton

    public WebElement getEditNewGoalButton() {
        return goalLayout.findElement(By.cssSelector(".fa-edit"));
    }

    public void clickEditNewGoalButton() {
        getEditNewGoalButton().click();
    }

    public boolean isDisplayedEditNewGoalButton() {
        return getEditNewGoalButton().isDisplayed();
    }

    // deleteGoalButton

    public WebElement getDeleteNewGoalButton() {
        return goalLayout.findElement(By.cssSelector(".close.edit-button"));
    }

    public void clickDeleteNewGoalButton() {
        getDeleteNewGoalButton().click();
    }

    public boolean isDisplayedDeleteNewGoalButton() {
        return getDeleteNewGoalButton().isDisplayed();
    }

    // goalNameField

    public WebElement getGoalNameField() {
        return goalLayout.findElement(By.cssSelector(".add-goal-input"));
    }

    public String getGoalNameFieldText() {
        return getGoalNameField().getText();
    }

    public void clearGoalNameField() {
        getGoalNameField().clear();
    }

    public void clickGoalNameField() {
        getGoalNameField().click();
    }

    public void setGoalNameField(String text) {
        getGoalNameField().sendKeys(text);
    }

    public boolean isDisplayedGoalNameField() {
        return getGoalNameField().isDisplayed();
    }


    // Functional

    public boolean isSelectedCheckMarkCheckbox() {
        return goalLayout.findElement(By.cssSelector("input")).isSelected();
    }


    // Business Logic

    /**
     * Set title to current newly created goal.
     * @param title
     * @return GoalComponent
     */
    public GoalComponent setNewTitle(String title) {
        clickEditNewGoalButton();
        clickGoalNameField();
        clearGoalNameField();
        setGoalNameField(title);
        clickEditNewGoalButton();
        return this;
    }

    /**
     * Select current goal.
     * @return GoalComponent
     */
    public GoalComponent select() {
        if (!isSelectedCheckMarkCheckbox()) {
           clickCheckMarkCheckbox();
        }
        return this;
    }

    /**
     * Deselect current goal.
     * @return GoalComponent
     */
    public GoalComponent deselect() {
        if (isSelectedCheckMarkCheckbox()) {
            clickCheckMarkCheckbox();
        }
        return this;
    }
}
