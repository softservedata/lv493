package com.softserve.edu.greencity.ui.pages.cabinet;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.softserve.edu.greencity.ui.data.Habit;
import com.softserve.edu.greencity.ui.data.HabitCard;


public class HabitCardsContainer {

    private final String AVAILABLE_HABIT_CARD_CONTAINER_SELECTOR = "div.available-to-choose-list";
    private final String CHOSEN_HABIT_CARD_CONTAINER_SELECTOR = "div.already-chosen-list";

    private WebDriver driver;

    private List<HabitCardComponent> availableHabitCardComponents;
    private List<HabitCardComponent> chosenHabitCardComponents;

    public HabitCardsContainer(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        (new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("app-habit-card")));

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

    // deleteWarning

    public WebElement getDeleteWarning() {
        return driver.findElement(By.cssSelector(".deletion-hint"));
    }

    public boolean isVisibleDeleteMessageWarning() {
        return getDeleteWarning().isDisplayed();
    }


    // Functional

    public int getAvailableHabitCardCount() {
        return getAvailableHabitCardComponents().size();
    }

    public int getChosenHabitCardCount() {
        return getChosenHabitCardComponents().size();
    }

    public  HabitCardComponent findChosenHabitCardByHabit(Habit habit) {
        getChosenHabitCardComponents()
        .forEach(card -> System.out.println(card.getHabitCardTitle()));
         HabitCardComponent c = getChosenHabitCardComponents().stream()
                 .filter(card -> card.getHabitCardTitle().contains(habit.toString()))
                 .findAny().orElse(null);
         System.out.println(c);
         return c;
     }

    public  HabitCardComponent findAvailableHabitCardByHabit(Habit habit) {
        return getAvailableHabitCardComponents().stream()
                 .filter(card -> card.getHabitCardTitle().contains(habit.toString()))
                 .findAny().orElse(null);
     }

    public  HabitCardComponent getAloneHabitCard() {
        return getChosenHabitCardComponents().get(0);
    }

    public void moveHabitCard(HabitCardComponent habit, String destinationSelector) {
        WebElement destination = driver.findElement(By.cssSelector(destinationSelector));
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
        HabitCardComponent habit = findChosenHabitCardByHabit(card.getHabit());
        if(habit !=null) {
            habit.delete().confirm();
        }
        return new HabitCardsContainer(driver);
    }

    /**
     * Delete and cancel deleting habit card from chosen cards.
     * @param card
     * @return HabitCardsContainer
     */
    public HabitCardsContainer deleteAndCancelHabitCard(HabitCard card) {
        HabitCardComponent habit = findChosenHabitCardByHabit(card.getHabit());
        if (habit != null) {
            habit.delete().cancel();
        }
        return this;
    }

    /**
     * Move habit card from available to chosen cards.
     * @param card
     * @return HabitCardsContainer
     */
    public HabitCardsContainer addHabitCard(HabitCard card) {
        HabitCardComponent habit = findAvailableHabitCardByHabit(card.getHabit());
        if (habit != null) {
            moveHabitCard(habit, CHOSEN_HABIT_CARD_CONTAINER_SELECTOR);
        }
        return new HabitCardsContainer(driver);
    }

}
