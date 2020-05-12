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


public class DeleteHabitCardsTests extends GreencityTestRunner {

    @BeforeMethod
    public void beforeMethod() {
        logger.info("Start before method for " +  getClass().getSimpleName());
        logger.info("Sign in with " + UserRepository.get().temporary().toString());
        loadApplication()
            .navigateMenuMyCabinet(UserRepository.get().temporary());

        logger.info("Add " + HabitCardRepository.get().saveBagsCard().toString());
        loadMyCabinetPage()
            .gotoCreateHabitDropdown()
            .addHabitCard(HabitCardRepository.get().saveBagsCard())
            .saveCreateHabitDropdown()
            .refresh();
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        logger.info("Start after method for " + getClass().getSimpleName());

        loadCreateHabitDropdown().saveCreateHabitDropdown();

        logger.info("Sign out");
        loadMyCabinetPage()
            .signout();
    }

	@DataProvider
    public Object[][] habitCardDataProvider() {
        return new Object[][] {
            {HabitCardRepository.get().saveBagsCard() }
            };
    }

    @Test(dataProvider = "habitCardDataProvider")
    public void deleteAndConfirmHabitCardTest(HabitCard card) {
        logger.info("Start test deleteAndConfirmHabitCardTest");
        CreateHabitDropdown page = loadMyCabinetPage()
                .gotoCreateHabitDropdown();

        logger.info("Delete and confirm " + card.toString());
        page.deleteAndConfirmHabitCard(card)
            .saveCreateHabitDropdown()
            .gotoCreateHabitDropdown();

        logger.info("Assert if habit card is deleted");
        Assert.assertFalse(page.isChosenHabitCard(card), "Habit card is chosen:");
    }

    @Test(dataProvider = "habitCardDataProvider")
    public void deleteAndCancelHabitCardTest(HabitCard card) {
        logger.info("Start test deleteAndCancelHabitCardTest");
        CreateHabitDropdown page = loadMyCabinetPage()
                .gotoCreateHabitDropdown();

        logger.info("Delete and cancel " + card.toString());
        page.deleteAndCancelHabitCard(card)
            .saveCreateHabitDropdown()
            .gotoCreateHabitDropdown();

        logger.info("Assert if habit card is not deleted");
        Assert.assertTrue(page.isChosenHabitCard(card), "Habit card is not chosen");

        logger.info("Delete");
        page.deleteAndConfirmHabitCard(card);
    }
}
