package com.softserve.edu.greencity.rest.tests.myhabits;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.softserve.edu.greencity.rest.data.ResponseCode;
import com.softserve.edu.greencity.rest.data.UserRepository;
import com.softserve.edu.greencity.rest.data.myhabits.UserGoal;
import com.softserve.edu.greencity.rest.data.myhabits.UserGoalEntityRepository;
import com.softserve.edu.greencity.rest.data.myhabits.UserGoalRepository;
import com.softserve.edu.greencity.rest.entity.ResponseCodeEntity;
import com.softserve.edu.greencity.rest.entity.myhabits.UserGoalEntity;
import com.softserve.edu.greencity.rest.services.myhabits.UserCustomGoalsService;
import com.softserve.edu.greencity.rest.tests.GreencityRestTestRunner;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;

@Feature("Create user goals")
public class CreateGoalsTest extends GreencityRestTestRunner {
    UserCustomGoalsService userCustomGoalsService;

    @BeforeMethod(description = "Go to User Custom Goals Service")
    public void beforeMethod() {
        logger.info("Start beforeMethod() for " + getClass().getSimpleName());
        logger.info("Go to UserCustomGoalsService");
        userCustomGoalsService = loadApplication()
                .successfulUserLogin(UserRepository.get().getDefault())
                .gotoMyhabitsService()
                .gotoUserCustomGoalsService();
    }

    @DataProvider
    public Object[][] userGoals() {
        return new Object[][] {
                { UserGoalRepository.get().customGoalsForCreating(),
                        UserGoalRepository.get().createdCustomGoals() } };
    }

    @Description("Check if user can create goals")
    @Parameters({ "Goals for creating", "Creted goals" })
    @Test(dataProvider = "userGoals", description = "Create goals")
    public void createUserGoals(List<UserGoal> goals, List<UserGoal> expectedGoals) {
        logger.info("Start createUserGoals()");

        logger.info("Create custom goals: " + goals);
        List<UserGoalEntity> createdGoals = userCustomGoalsService.createCustomGoals(goals);

        UserGoalEntityRepository.get().setGoalsForDeleting(createdGoals);

        Assert.assertEquals(UserGoal.converToUserGoalList(createdGoals),
                expectedGoals, "Goals are not created: ");

        logger.info("Goals are created");
    }

    @DataProvider
    public Object[][] userGoalsDeleting() {
        return new Object[][] {
                { UserGoalEntityRepository.get().goalsForDeleting(), ResponseCode.RESPONSE200} // TODO
        };
    }

    @Description("Check if user can delete goals")
    @Parameters({ "Goals for deleting", "Response code" })
    @Test(dataProvider = "userGoalsDeleting", description = "Delete goals")
    public void deleteUserGoals(List<UserGoalEntity> goals, ResponseCode code) {
        logger.info("Start deleteUserGoals()");

        logger.info("Delete custom goals: " + goals);
        ResponseCodeEntity createdGoals = userCustomGoalsService
                .deleteCustomGoals(goals);

        Assert.assertEquals(createdGoals.getResponsecode(), code.getValue(),
                "Goals are not deleted: ");

        logger.info("Goals are deleted");
    }

}
