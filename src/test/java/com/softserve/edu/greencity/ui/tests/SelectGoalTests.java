package com.softserve.edu.greencity.ui.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.greencity.ui.data.Goal;
import com.softserve.edu.greencity.ui.data.GoalRepository;
import com.softserve.edu.greencity.ui.data.UserRepository;
import com.softserve.edu.greencity.ui.pages.cabinet.ManageGoalsDropdown;


public class SelectGoalTests extends GreencityTestRunner {

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

        logger.info("Deselect " + GoalRepository.get().defaultGoalForSelecting().toString());
        (new ManageGoalsDropdown(driver))
        .deselectGoal(GoalRepository.get().defaultGoalForSelecting())
        .closeManageGoalsDropdown();

        logger.info("Sign out");
        loadMyCabinetPage()
        .signout();
    }

	@DataProvider
    public Object[][] goalsDataProvider() {
        return new Object[][] {
            {GoalRepository.get().defaultGoalForSelecting()}
            };
    }

    @Test(dataProvider = "goalsDataProvider")
    public void selectGoalTest(Goal goal) {
        logger.info("Start test selectGoalTest");

        logger.info("Select " + goal.toString());
         ManageGoalsDropdown page = loadMyCabinetPage()
                .gotoManageGoalsDropdown()
                .selectGoal(goal);

         logger.info("Assert if goal is selected");
         Assert.assertTrue(page.isSelectedGoal(goal), "Goal is not selected:");
    }

}
