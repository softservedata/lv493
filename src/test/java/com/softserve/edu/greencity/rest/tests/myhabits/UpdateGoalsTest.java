package com.softserve.edu.greencity.rest.tests.myhabits;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.greencity.rest.data.User;
import com.softserve.edu.greencity.rest.data.UserRepository;
import com.softserve.edu.greencity.rest.data.myhabits.UserGoal;
import com.softserve.edu.greencity.rest.data.myhabits.UserGoalRepository;
import com.softserve.edu.greencity.rest.entity.myhabits.UserGoalEntity;
import com.softserve.edu.greencity.rest.services.myhabits.UserCustomGoalsService;
import com.softserve.edu.greencity.rest.tests.GreencityRestTestRunner;

public class UpdateGoalsTest extends GreencityRestTestRunner {
    User user = UserRepository.get().getDefault();
    UserCustomGoalsService userCustomGoalsService;
    List<UserGoal> goalForCreating = UserGoalRepository.get().customGoalsForUpdating();
    List<UserGoalEntity> createdGoals;

    @BeforeClass
    public void beforeClass() {
        userCustomGoalsService = loadApplication()
                .successfulUserLogin(user)
                .gotoMyhabitsService()
                .gotoUserCustomGoalsService();

        createdGoals = userCustomGoalsService.createCustomGoals(goalForCreating);
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        userCustomGoalsService.deleteCustomGoals(createdGoals);
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        userCustomGoalsService.updateCustomGoals(createdGoals);
    }

    @DataProvider
    public Object[][] userGoals() {
        return new Object[][] {
            {  UserGoalRepository.get().customGoalsForReUpdating(), UserGoalRepository.get().updatedCustomGoals()}
        };
    }

    @Test(dataProvider = "userGoals")
    public void updateUserGoal(List<UserGoal> newGoals, List<UserGoal> expectedGoals) {
        logger.info("Start updateUserGoal()");

        Assert.assertEquals(UserGoal.converToUserGoalList(userCustomGoalsService.updateCustomGoals(createdGoals, newGoals)),
                expectedGoals, "Goals is not updated: ");
    }

}
