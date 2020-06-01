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
        logger.info("Start beforeClass() for " + getClass().getSimpleName());
        logger.info("Go to UserCustomGoalsService");
        userCustomGoalsService = loadApplication()
                .successfulUserLogin(user)
                .gotoMyhabitsService()
                .gotoUserCustomGoalsService();

        logger.info("Create goals: " + goalForCreating);
        createdGoals = userCustomGoalsService.createCustomGoals(goalForCreating);
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        logger.info("Start afterClass() for " + getClass().getSimpleName());
        logger.info("Delete created goals: " + createdGoals);
        userCustomGoalsService.deleteCustomGoals(createdGoals);
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        logger.info("Start afterMethod() for " + getClass().getSimpleName());
        logger.info("ReUpdate user goals: " + createdGoals);
        userCustomGoalsService.updateCustomGoals(createdGoals);
    }

    @DataProvider
    public Object[][] userGoals() {
        return new Object[][] {
            {  UserGoalRepository.get().customGoalsForReUpdating(), UserGoalRepository.get().updatedCustomGoals()}
        };
    }

    @Test(dataProvider = "userGoals")
    public void updateUserGoals(List<UserGoal> newGoals, List<UserGoal> expectedGoals) {
        logger.info("Start updateUserGoals()");
        logger.info("Update goals: " + createdGoals + "to: " + newGoals);
        List<UserGoalEntity> updatedGoals = userCustomGoalsService.updateCustomGoals(createdGoals, newGoals);
        Assert.assertEquals(UserGoal.converToUserGoalList(updatedGoals), expectedGoals, "Goals are not updated: ");
        logger.info("Goals are updated: " + updatedGoals);
    }

}
