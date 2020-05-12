package com.softserve.edu.greencity.ui.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.greencity.ui.data.HabitItem;
import com.softserve.edu.greencity.ui.data.HabitItemRepository;
import com.softserve.edu.greencity.ui.data.UserRepository;
import com.softserve.edu.greencity.ui.pages.cabinet.MyCabinetPage;


public class CheckHabitTests extends GreencityTestRunner {
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
        loadMyCabinetPage()
        .signout();
    }

	@DataProvider
    public Object[][] habitDataProvider() {
        return new Object[][] {
            {HabitItemRepository.get().discardCupsHabit()}
            };
    }

    @Test(dataProvider = "habitDataProvider")
    public void addHabitInfoTest(HabitItem habit) {
        logger.info("Start test addHabitInfoTest");
        logger.info("Add todays habit info");
        MyCabinetPage page = loadMyCabinetPage()
        .addTodaysHabitInfo(habit);

        logger.info("Assert if added defined habit items");
        Assert.assertEquals(page.getHabitComponent(habit.getHabit()).getSelectedHabitItemsCount(),
                habit.getItemsCount(), "Chosen habit items do not match with defined:");

        logger.info("Assert if added defined habit estimation");
        Assert.assertEquals(page.getHabitComponent(habit.getHabit()).getSelectedEstimation(),
                habit.getEstimation(), "Chosen habit estimation do not match with defined:");
    }
}
