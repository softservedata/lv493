package com.softserve.edu.greencity.ui.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.greencity.ui.data.HabitCard;
import com.softserve.edu.greencity.ui.data.HabitCardRepository;
import com.softserve.edu.greencity.ui.data.User;
import com.softserve.edu.greencity.ui.data.UserRepository;
import com.softserve.edu.greencity.ui.pages.cabinet.CreateHabitDropdown;


public class AddHabitCardsTests extends GreencityTestRunner {
    private final User user = UserRepository.get().temporary();
    private HabitCard habitCard;

    @BeforeMethod
    public void beforeMethod() {
        logger.info("Start before method for " +  getClass().getSimpleName());
        logger.info("Sign in with " + user.toString());
        loadApplication()
        .navigateMenuMyCabinet(user);
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        logger.info("Start after method for " + getClass().getSimpleName());
        logger.info("Delete " + habitCard.toString());
        loadCreateHabitDropdown()
        .deleteAndConfirmHabitCard(habitCard)
        .saveCreateHabitDropdown();

        logger.info("Sign out");
        loadMyCabinetPage()
        .signout();
    }

	@DataProvider
    public Object[][] habitCardDataProvider() {
        return new Object[][] {
            {HabitCardRepository.get().saveBagsCard()}
            };
    }

    @Test(dataProvider = "habitCardDataProvider")
    public void addHabitCardTest(HabitCard card) {
        habitCard = card;
        logger.info("Start test addHabitCardTest");
        CreateHabitDropdown page = loadMyCabinetPage()
                .gotoCreateHabitDropdown();

        logger.info("Add " + card.toString());
        page.addHabitCard(card)
            .saveCreateHabitDropdown()
            .refresh()
            .gotoCreateHabitDropdown();

        logger.info("Assert if habit card is added");
        Assert.assertTrue(page.isChosenHabitCard(card), "Habit card is not chosen:");
    }

}
