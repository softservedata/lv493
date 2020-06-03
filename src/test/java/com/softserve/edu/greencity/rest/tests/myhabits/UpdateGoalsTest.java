package com.softserve.edu.greencity.rest.tests.myhabits;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.softserve.edu.greencity.rest.data.UserRepository;
import com.softserve.edu.greencity.rest.data.myhabits.UserGoal;
import com.softserve.edu.greencity.rest.data.myhabits.UserGoalRepository;
import com.softserve.edu.greencity.rest.entity.myhabits.UserGoalEntity;
import com.softserve.edu.greencity.rest.services.myhabits.UserCustomGoalsService;
import com.softserve.edu.greencity.rest.tests.GreencityRestTestRunner;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;

@Feature("Update user goals")
public class UpdateGoalsTest extends GreencityRestTestRunner {
    UserCustomGoalsService userCustomGoalsService;
    List<UserGoalEntity> createdGoals;

    @BeforeClass(description = "Create goals")
    public void beforeClass() {
        logger.info("Start beforeClass() for " + getClass().getSimpleName());

        logger.info("Go to UserCustomGoalsService");
        userCustomGoalsService = loadApplication()
                .successfulUserLogin(UserRepository.get().getDefault())
                .gotoMyhabitsService()
                .gotoUserCustomGoalsService();

        logger.info("Create goals: " + UserGoalRepository.get().customGoalsForUpdating());
        createdGoals = userCustomGoalsService.createCustomGoals(UserGoalRepository.get().customGoalsForUpdating());
    }

    @AfterMethod(alwaysRun = true, description = "ReUpdate user goals")
    public void afterMethod() {
        logger.info("Start afterMethod() for " + getClass().getSimpleName());

        logger.info("ReUpdate user goals: " + createdGoals);
        userCustomGoalsService.updateCustomGoals(createdGoals);
    }

    @AfterClass(alwaysRun = true, description = "Delete created goals")
    public void afterClass() {
        logger.info("Start afterClass() for " + getClass().getSimpleName());

        logger.info("Delete created goals: " + createdGoals);
        userCustomGoalsService.deleteCustomGoals(createdGoals);
    }

    @DataProvider
    public Object[][] userGoals() {
        return new Object[][] {
                { UserGoalRepository.get().customGoalsForReUpdating(),
                        UserGoalRepository.get().updatedCustomGoals() } };
    }

    @Description("Check if user can update goals")
    @Parameters({ "Goals for updating", "Updated goals" })
    @Test(dataProvider = "userGoals", description = "Update goals")
    public void updateUserGoals(List<UserGoal> newGoals, List<UserGoal> expectedGoals) {
        logger.info("Start updateUserGoals()");

        logger.info("Update goals: " + createdGoals + "to: " + newGoals);
        List<UserGoalEntity> updatedGoals = userCustomGoalsService
                .updateCustomGoals(createdGoals, newGoals);

        Assert.assertEquals(UserGoal.converToUserGoalList(updatedGoals),
                expectedGoals, "Goals are not updated: ");

        logger.info("Goals are updated: " + updatedGoals);
    }

}
