package com.softserve.edu.greencity.ui.pages.cabinet;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.softserve.edu.greencity.ui.data.Goal;
import com.softserve.edu.greencity.ui.data.Habit;
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
        waitForPageLoading();
        initElements();
    }

    private void waitForPageLoading() {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        (new WebDriverWait(driver, 10)).until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));

//        (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("app-advice")));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    private void initElements() {
        packagesCount = driver.findElement(By.cssSelector("img[src*='package'] + h4 span")).getText();
        glassesCount = driver.findElement(By.cssSelector("img[src*='coffe'] + h4 span")).getText();

        manageGoalsButton = driver.findElement(By.cssSelector("div.add-goal-button-container button.add-goal-button"));
        addNewHabitButton = driver.findElement(By.cssSelector("button.btn.btn-success"));

        habitsContainer = new HabitsContainer(driver);
        goalsContainer = new MyGoalsContainer(driver);
    }

    // Page Object

    // packagesCount

    public String getPackagesCount() {
        return packagesCount;
    }

    // glassesCount

    public String getGlassesCount() {
        return glassesCount;
    }

    // manageGoalsButton

    public WebElement getManageGoalsButton() {
        return manageGoalsButton;
    }

    public void clickManageGoalsButton() {
        getManageGoalsButton().click();
    }

    // habitsContainer

    public HabitsContainer getHabitsContainer() {
        return habitsContainer;
    }

    // goalsContainer

    public MyGoalsContainer getGoalsContainer() {
        return goalsContainer;
    }

    // addNewHabitButton

    public WebElement getAddNewHabitButton() {
        return addNewHabitButton;
    }

    private void clickAddNewHabitButton() {
        getAddNewHabitButton().click();
    }


    // Functional

    public boolean isAvailableHabit(Habit habit) {
        return getHabitsContainer().findHabitComponent(habit) != null ? true : false;
    }

    public HabitComponent getHabitComponent(Habit habit) {
        return getHabitsContainer().findHabitComponent(habit);
    }

    public boolean isAvailableGoal(Goal goal) {
        return getGoalsContainer().findGoal(goal) != null ? true : false;
    }

    public GoalComponent getGoalComponent(Goal goal) {
        return getGoalsContainer().findGoal(goal);
    }

    public MyCabinetPage refresh() {
        driver.navigate().refresh();
        return new MyCabinetPage(driver);
    }

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