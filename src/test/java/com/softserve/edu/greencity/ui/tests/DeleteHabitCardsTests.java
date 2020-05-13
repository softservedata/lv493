package com.softserve.edu.greencity.ui.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.softserve.edu.greencity.ui.data.HabitCard;
import com.softserve.edu.greencity.ui.data.HabitCardRepository;
import com.softserve.edu.greencity.ui.data.User;
import com.softserve.edu.greencity.ui.data.UserRepository;
import com.softserve.edu.greencity.ui.pages.cabinet.CreateHabitDropdown;


public class DeleteHabitCardsTests extends GreencityTestRunner {
    private final User user = UserRepository.get().temporary();

    @BeforeMethod
    public void beforeMethod() {
        logger.info("Start before method for " +  getClass().getSimpleName());
        logger.info("Sign in with " + user.toString());
        loadApplication().navigateMenuMyCabinet(user);

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
        loadMyCabinetPage().signout();
    }

	@DataProvider
    public Object[][] habitCardDataProvider() {
        return new Object[][] {
            {HabitCardRepository.get().saveBagsCard() }
            };
    }

    @Test(dataProvider = "habitCardDataProvider")
    public void deleteHabitCardTest(HabitCard card) {
        logger.info("Start test deleteAndCancelHabitCardTest");
        CreateHabitDropdown page = loadMyCabinetPage().gotoCreateHabitDropdown();

        logger.info("Delete and cancel " + card.toString());
        page.deleteAndCancelHabitCard(card);

        SoftAssert softAssertion= new SoftAssert();

        logger.info("Assert if habit card is not deleted");
        softAssertion.assertTrue(page.isChosenHabitCard(card), "Habit card is not chosen:");

        logger.info("Delete and confirm");
        page.deleteAndConfirmHabitCard(card);

        logger.info("Assert if habit card is deleted");
        softAssertion.assertFalse(page.isChosenHabitCard(card), "Habit card is chosen:");

        softAssertion.assertAll();
    }
}
