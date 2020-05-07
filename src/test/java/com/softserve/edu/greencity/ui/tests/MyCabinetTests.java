package com.softserve.edu.greencity.ui.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.greencity.ui.data.HabitCard;
import com.softserve.edu.greencity.ui.data.HabitCardRepository;
import com.softserve.edu.greencity.ui.data.User;
import com.softserve.edu.greencity.ui.data.UserRepository;
import com.softserve.edu.greencity.ui.pages.cabinet.CreateHabitDropdown;


public class MyCabinetTests extends GreencityTestRunner {


	@DataProvider
    public Object[][] habitCardDataProvider() {
        return new Object[][] {
            {HabitCardRepository.getSaveBagsCard(), UserRepository.get().temporary()}
            };
    }

    //Test(dataProvider = "habitCardDataProvider")
    public void addHabitCardTest(HabitCard card, User user) {
        CreateHabitDropdown page = loadApplication()
                .navigateMenuMyCabinet(user)
                .gotoCreateHabitDropdown()
                .addHabitCard(card)
                .saveCreateHabitDropdown()
                .refresh()
                .gotoCreateHabitDropdown();

        Assert.assertTrue(page.isChosenHabitCard(card));

        page.deleteAndConfirmHabitCard(card)
            .saveCreateHabitDropdown()
            .signout();
    }

    //@Test(dataProvider = "habitCardDataProvider")
    public void deleteAndConfirmHabitCardTest(HabitCard card, User user) {
        CreateHabitDropdown page = loadApplication()
                .navigateMenuMyCabinet(user)
                .gotoCreateHabitDropdown()
                .addHabitCard(card)
                .saveCreateHabitDropdown()
                .refresh()
                .gotoCreateHabitDropdown()
                .deleteAndConfirmHabitCard(card)
                .saveCreateHabitDropdown()
                .gotoCreateHabitDropdown();

        Assert.assertFalse(page.isChosenHabitCard(card));

        page.closeCreateHabitDropdown()
            .signout();
    }

    //@Test(dataProvider = "habitCardDataProvider")
    public void deleteAndCancelHabitCardTest(HabitCard card, User user) {
        CreateHabitDropdown page = loadApplication()
                .navigateMenuMyCabinet(user)
                .gotoCreateHabitDropdown()
                .addHabitCard(card)
                .saveCreateHabitDropdown()
                .refresh()
                .gotoCreateHabitDropdown()
                .deleteAndCancelHabitCard(card)
                .saveCreateHabitDropdown()
                .refresh()
                .gotoCreateHabitDropdown();

        Assert.assertTrue(page.isChosenHabitCard(card));

        page.deleteAndConfirmHabitCard(card)
            .saveCreateHabitDropdown()
            .signout();
    }


    @DataProvider
    public Object[][] userDataProvider() {
        return new Object[][] {
            {UserRepository.get().temporary()}
            };
    }

    @Test(dataProvider = "userDataProvider")
    public void deleteAloneHabitCardTest(User user) {
        CreateHabitDropdown page = loadApplication()
                .navigateMenuMyCabinet(user)
                .gotoCreateHabitDropdown()
                .deleteAlonelHabitCard();

       Assert.assertTrue(page.isVisibleWarning());

       page.closeCreateHabitDropdown()
           .signout();
    }


}
