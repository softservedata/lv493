package com.softserve.edu.greencity.ui.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.softserve.edu.greencity.ui.data.HabitItem;
import com.softserve.edu.greencity.ui.data.HabitItemRepository;
import com.softserve.edu.greencity.ui.data.User;
import com.softserve.edu.greencity.ui.data.UserRepository;
import com.softserve.edu.greencity.ui.pages.cabinet.MyCabinetPage;


public class CheckHabitTests extends GreencityTestRunner {
    private final User user = UserRepository.get().temporary();

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

        SoftAssert softAssert= new SoftAssert();

        logger.info("Assert if added defined habit items");
        softAssert.assertEquals(page.getHabitComponent(habit.getHabit()).getSelectedHabitItemsCount(),
                habit.getItemsCount(), "Chosen habit items do not match with defined:");

        logger.info("Assert if added defined habit estimation");
        softAssert.assertEquals(page.getHabitComponent(habit.getHabit()).getSelectedEstimation(),
                habit.getEstimation(), "Chosen habit estimation do not match with defined:");

        softAssert.assertAll();
    }
}
