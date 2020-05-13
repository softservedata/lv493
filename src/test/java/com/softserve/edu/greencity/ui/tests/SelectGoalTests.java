package com.softserve.edu.greencity.ui.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.greencity.ui.data.Goal;
import com.softserve.edu.greencity.ui.data.GoalRepository;
import com.softserve.edu.greencity.ui.data.User;
import com.softserve.edu.greencity.ui.data.UserRepository;
import com.softserve.edu.greencity.ui.pages.cabinet.ManageGoalsDropdown;


public class SelectGoalTests extends GreencityTestRunner {
    private final User user = UserRepository.get().temporary();
    private Goal goalComponent;

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

        logger.info("Deselect " + goalComponent.toString());
        (new ManageGoalsDropdown(driver))
        .deselectGoal(goalComponent)
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
        goalComponent = goal;
        logger.info("Start test selectGoalTest");

        logger.info("Select " + goal.toString());
         ManageGoalsDropdown page = loadMyCabinetPage()
                .gotoManageGoalsDropdown()
                .selectGoal(goal);

         logger.info("Assert if goal is selected");
         Assert.assertTrue(page.isSelectedGoal(goal), "Goal is not selected:");
    }


}
