package com.softserve.edu.greencity.ui.pages.cabinet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.greencity.ui.data.Goal;


public class ManageGoalsDropdown {
    private WebDriver driver;

    private ManageGoalsContainer goalsContainer;

    private WebElement addNewGoalButton;
    private WebElement  updateGoalsButton;
    private WebElement closeButton;

    public ManageGoalsDropdown(WebDriver driver) {
        this.driver = driver;
        initElements();

    }

    private void initElements() {
        goalsContainer = new ManageGoalsContainer(driver);

        updateGoalsButton = driver.findElement(By.cssSelector("div.modal-content button.add-goal-button"));
        addNewGoalButton = driver.findElement(By.cssSelector("mdb-icon.plus.far"));
        closeButton = driver.findElement(By.cssSelector("button.close"));
    }

    // Page Object

    // addGoalButton

    public WebElement getAddNewGoalButton() {
        return addNewGoalButton;
    }

    public String getAddNewGoalButtonText() {
        return getAddNewGoalButton().getText();
    }

    public void clickAddNewGoalButton() {
        getAddNewGoalButton().click();
    }

    public boolean isDisplayedAddNewGoalButton() {
        return getAddNewGoalButton().isDisplayed();
    }

    // updateGoalsButton

    public WebElement getUpdateGoalsButton() {
        return updateGoalsButton;
    }

    public String getUpdateGoalsButtonText() {
        return getUpdateGoalsButton().getText();
    }

    public void clickUpdateGoalsButton() {
        getUpdateGoalsButton().click();
    }

    public boolean isDisplayedUpdateGoalsButton() {
        return getUpdateGoalsButton().isDisplayed();
    }

    // closeButton

    public WebElement getCloseButton() {
        return closeButton;
    }

    public String getCloseButtonText() {
        return getCloseButton().getText();
    }

    public void clickCloseButton() {
        getCloseButton().click();
    }

    public boolean isDisplayedCloseButton() {
        return getCloseButton().isDisplayed();
    }

    //goalsContainer

    public ManageGoalsContainer getGoalsContainer() {
        return goalsContainer;
    }


    // Functional

    private ManageGoalsDropdown createNewGoal() {
        clickAddNewGoalButton();
        return new ManageGoalsDropdown(driver);
    }

    // Business Logic



    /**
     * Save changes from  ManageGoalsDropdown.
     * @return MyCabinetPage
     */
    public MyCabinetPage updateManageGoalsDropdown() {
        if(isDisplayedUpdateGoalsButton()) {
            clickUpdateGoalsButton();
        }
        return new MyCabinetPage(driver);
    }

    /**
     * Close ManageGoalsDropdown without saving changes.
     * @return MyCabinetPage
     */
    public MyCabinetPage closeManageGoalsDropdown() {
        //do not close
        if(isDisplayedUpdateGoalsButton()) {
            clickCloseButton();
        }
        return new MyCabinetPage(driver);
    }

    /**
     * Add goal to My Goals.
     * @param goal
     * @return ManageGoalsDropdown
     */
    public ManageGoalsDropdown selectGoal(Goal goal) {
        getGoalsContainer().selectGoal(goal);
        return new ManageGoalsDropdown(driver);
    }

    /**
     * Delete goal from My Goals.
     * @param goal
     * @return ManageGoalsDropdown
     */
    public ManageGoalsDropdown deselectGoal(Goal goal) {
        getGoalsContainer().deselectGoal(goal);
        return new ManageGoalsDropdown(driver);
    }

    /**
     * Delete goal created by user.
     * @param goal
     * @return ManageGoalsDropdown
     */
    public ManageGoalsDropdown deleteGoal(Goal goal) {
        getGoalsContainer().deleteGoalComponent(goal);
        return new ManageGoalsDropdown(driver);
    }

    /**
     * Delete newly created goal.
     * @return ManageGoalsDropdown
     */
    public ManageGoalsDropdown deleteNewGoal() {
        getGoalsContainer().deleteNewGoalComponent();
        return new ManageGoalsDropdown(driver);
    }

    /**
     * Create new goal (selected by default).
     * @param goal
     * @return ManageGoalsDropdown
     */
    public ManageGoalsDropdown addNewGoal(Goal goal) {
        createNewGoal().getGoalsContainer().setNewGoalComponentTitle(goal);
        return new ManageGoalsDropdown(driver);
    }

}