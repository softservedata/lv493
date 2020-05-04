package com.softserve.edu.greencity.ui.pages.cabinet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.greencity.ui.data.Goal;
import com.softserve.edu.greencity.ui.data.HabitItem;
import com.softserve.edu.greencity.ui.pages.common.TopPart;


public class MyCabinetPage extends TopPart {
    private String packagesCount;
    private String glassesCount;

    private WebElement manageGoalsButton;
    private WebElement addNewHabitButton;

    private HabitsContainer habitsContainer;

    private MyGoalsContainer goalsContainer;

    private ManageGoalsDropdown manageGoalsDropdown;
    private CreateHabitDropdown createHabitDropdown;

    public MyCabinetPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
       // packagesCount = driver.findElement(By.cssSelector("img[src*='package'] + h4 span")).getText();
       // glassesCount = driver.findElement(By.cssSelector("img[src*='coffe'] + h4 span")).getText();

        manageGoalsButton = driver.findElement(By.cssSelector("div.add-goal-button-container button.add-goal-button"));
        addNewHabitButton = driver.findElement(By.cssSelector("button.btn.btn-success"));
    }


    // Page Object

    // packagesCount

    private String getPackagesCount() {
        return packagesCount;
    }

    // glassesCount

    private String getGlassesCount() {
        return glassesCount;
    }

    // manageGoalsButton

    private WebElement getManageGoalsButton() {
        return manageGoalsButton;
    }

    private void clickManageGoalsButton() {
        getManageGoalsButton().click();
    }

    //habitsContainer

    private HabitsContainer getHabitsContainer() {
        return new HabitsContainer(driver);
    }

    //goalsContainer

    private MyGoalsContainer getGoalsContainer() {
        return new MyGoalsContainer(driver);
    }

    // addNewHabitButton

    private WebElement getAddNewHabitButton() {
        return addNewHabitButton;
    }

    private void clickAddNewHabitButton() {
        getAddNewHabitButton().click();
    }


    // Functional


    // Business Logic

    /**
     * Go to ManageGoalsDropdown.
     * @return ManageGoalsDropdown
     */
    public ManageGoalsDropdown gotoManageGoalsDropdown() {
        clickManageGoalsButton();
        return new ManageGoalsDropdown(driver);
    }

    /**
     * Go to NewHabitDropdown.
     * @return NewHabitDropdown
     */
    public CreateHabitDropdown gotoCreateHabitDropdown() {
        clickAddNewHabitButton();
        return new CreateHabitDropdown(driver);
    }

    /**
     * Select goal. Mark as done.
     * @param goal
     * @return MyCabinetPage
     */
    public MyCabinetPage doGoal(Goal goal) {
        getGoalsContainer().selectGoal(goal);
        return new MyCabinetPage(driver);
    }

    /**
     * Deselect goal.
     * @param goal
     * @return MyCabinetPage
     */
    public MyCabinetPage undoGoal(Goal goal) {
        getGoalsContainer().deselectGoal(goal);
        return new MyCabinetPage(driver);
    }

    /**
     * Show more goals if it more than 3 one.
     * @return
     */
    public MyCabinetPage showMoreGoals() {
        getGoalsContainer().showMoreGoals();
        return new MyCabinetPage(driver);
    }

    /**
     * Show less goals if it less than 3 one.
     * @return
     */
    public MyCabinetPage showLessGoals() {
        getGoalsContainer().showLessGoals();
        return new MyCabinetPage(driver);
    }

    /**
     * Add all info about habit for current day.
     * @param habit
     * @return MyCabinetPage
     */
    public MyCabinetPage addTodaysHabitInfo(HabitItem habit) {
        getHabitsContainer().addHabitInfo(habit);
        return new MyCabinetPage(driver);

    }


}