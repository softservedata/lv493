package com.softserve.edu.greencity.ui.pages.cabinet;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.softserve.edu.greencity.ui.data.HabitCard;


public class HabitCardsContainer {

    private WebDriver driver;

    private List<HabitCardComponent> availableHabitCardComponents;
    private List<HabitCardComponent> chosenHabitCardComponents;

    private final String CANNOT_DELETE_MESSAGE = "You can't delete your last habit";

    public HabitCardsContainer(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        chosenHabitCardComponents = new ArrayList<HabitCardComponent>();
        driver.findElements(By.cssSelector("div.already-chosen-habits app-habit-card"))
            .forEach(card -> chosenHabitCardComponents.add(new HabitCardComponent(card)));

        availableHabitCardComponents = new ArrayList<HabitCardComponent>();
        driver.findElements(By.cssSelector("div.available-to-choose app-habit-card"))
            .forEach(card -> availableHabitCardComponents.add(new HabitCardComponent(card)));
    }


    // Page Object

    // availableHabitCardComponents

    public List<HabitCardComponent> getAvailableHabitCardComponents() {
        return availableHabitCardComponents;
    }

    // chosenHabitCardComponents

    public List<HabitCardComponent> getChosenHabitCardComponents() {
        return chosenHabitCardComponents;
    }


    // Functional

    public long getAvailableHabitCardCount() {
        return getAvailableHabitCardComponents().size();
    }

    public long getChosenHabitCardCount() {
        return getChosenHabitCardComponents().size();
    }

    public  HabitCardComponent findAvailableHabitCardByTitle(String title) {
       return getAvailableHabitCardComponents().stream()
                .filter(card -> card.getHabitCardTitle().contains(title))
                .findAny()
                .orElse(null);
    }

    public  HabitCardComponent findChosenHabitCardByTitle(String title) {
        return getChosenHabitCardComponents().stream()
                 .filter(card -> card.getHabitCardTitle().contains(title))
                 .findAny()
                 .orElse(null);
     }

    public void moveHabitCard(HabitCardComponent habit, WebElement destination) {
        Actions action = new Actions(driver);
        action.clickAndHold(habit.getHabitCardLayout())
                .moveToElement(destination)
                .click(destination)
                .release()
                .build().perform();

    }

    // Business Logic

    /**
     * Delete and confirm deleting habit card from chosen cards.
     * @param card
     * @return HabitCardsContainer
     */
    public HabitCardsContainer deleteAndConfirmHabitCard(HabitCard card) {
        HabitCardComponent habit = findChosenHabitCardByTitle(card.getHabit().toString());
        if(habit !=null) {
            habit.confirmDeleting();
        }
        return new HabitCardsContainer(driver);
    }

    /**
     * Delete and cancel deleting habit card from chosen cards.
     * @param card
     * @return HabitCardsContainer
     */
    public HabitCardsContainer deleteAndCancelHabitCard(HabitCard card) {
        HabitCardComponent habit = findChosenHabitCardByTitle(card.getHabit().toString());
        if (habit != null) {
            habit.cancelDeleting();
        }
        return this;
    }

    /**
     * Move habit card from available to chosen cards.
     * @param card
     * @return HabitCardsContainer
     */
    public HabitCardsContainer addHabitCard(HabitCard card) {
        HabitCardComponent habit = findAvailableHabitCardByTitle(card.getHabit().toString());
        if (habit != null) {
            moveHabitCard(habit, driver.findElement(By.cssSelector("div.already-chosen-habits")));
        }
        return new HabitCardsContainer(driver);
    }

    /**
     * Remove habit card from chosen to available cards.
     * @param card
     * @return HabitCardsContainer
     */
    public HabitCardsContainer cancelAddHabitCard(HabitCard card) {
        HabitCardComponent habit = findChosenHabitCardByTitle(card.getHabit().toString());
        if (habit != null) {
            moveHabitCard(habit, driver.findElement(By.cssSelector("div.available-to-choose")));
        }

//      driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
//      (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.available-to-choose app-habit-card")));
//      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return new HabitCardsContainer(driver);
    }

}
