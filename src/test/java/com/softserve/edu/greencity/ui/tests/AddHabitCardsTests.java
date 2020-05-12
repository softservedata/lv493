package com.softserve.edu.greencity.ui.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.greencity.ui.data.HabitCard;
import com.softserve.edu.greencity.ui.data.HabitCardRepository;
import com.softserve.edu.greencity.ui.data.UserRepository;
import com.softserve.edu.greencity.ui.pages.cabinet.CreateHabitDropdown;


public class AddHabitCardsTests extends GreencityTestRunner {

    @BeforeMethod
    public void beforeMethod() {
        logger.info("Start before method for " +  getClass().getSimpleName());
        logger.info("Sign in with " + UserRepository.get().temporary().toString());
        loadApplication()
        .navigateMenuMyCabinet(UserRepository.get().temporary());
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        logger.info("Start after method for " + getClass().getSimpleName());
        logger.info("Delete " +  HabitCardRepository.get().saveBagsCard().toString());
        loadCreateHabitDropdown()
        .deleteAndConfirmHabitCard(HabitCardRepository.get().saveBagsCard())
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
