package com.softserve.edu.greencity.ui.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.softserve.edu.greencity.ui.data.UserRepository;
import com.softserve.edu.greencity.ui.pages.cabinet.CreateHabitDropdown;


public class CheckHabitCardTests extends GreencityTestRunner {

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
        logger.info("Sign out");
        loadCreateHabitDropdown()
        .saveCreateHabitDropdown()
        .signout();
    }

    @Test
    public void deleteAloneHabitCardTest() {
        logger.info("Start test deleteAloneHabitCardTest");
        CreateHabitDropdown page = loadMyCabinetPage()
                .gotoCreateHabitDropdown();

        logger.info("Delete habit card");
        page.deleteAloneHabitCard();

        logger.info("Assert if warning is visible");
        Assert.assertTrue(page.isVisibleWarning(), "Warning is not visible:");
    }

}
