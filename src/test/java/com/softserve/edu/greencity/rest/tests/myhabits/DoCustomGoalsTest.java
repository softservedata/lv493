package com.softserve.edu.greencity.rest.tests.myhabits;

import java.util.ArrayList;
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
import com.softserve.edu.greencity.rest.services.myhabits.UserGoalsService;
import com.softserve.edu.greencity.rest.tests.GreencityRestTestRunner;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;

@Feature("Do user goals")
public class DoCustomGoalsTest extends GreencityRestTestRunner {
    UserGoalsService userGoalsService;
    List<UserGoalEntity> selectedGoals;
    List<UserGoalEntity> createdGoals;
    UserGoalEntity userCustomGoal;

    @BeforeClass(description = "Create custom goals and select ones")
    public void beforeClass() {
        logger.info("Start beforeClass() for " + getClass().getSimpleName());
        logger.info("Go to UserGoalsService");
        userGoalsService = loadApplication()
                .successfulUserLogin(UserRepository.get().getDefault())
                .gotoMyhabitsService()
                .gotoUserGoalsService();

        logger.info("Create goals: " + UserGoalRepository.get().customGoalsForAdding());
        createdGoals = userGoalsService.gotoUserCustomGoalsService()
                .createCustomGoals(UserGoalRepository.get().customGoalsForAdding());

        logger.info("Select created goals: " + createdGoals);
        selectedGoals = userGoalsService.gotoUserGoalsService()
                .selectUserGoals(new ArrayList<>(), createdGoals);
    }

    @AfterClass(alwaysRun = true, description = "Deselect goals and delete created ones")
    public void afterClass() {
        logger.info("Start afterClass() for " + getClass().getSimpleName());

        logger.info("Deselect user goals: " + selectedGoals);
        userGoalsService.deselectUserGoals(selectedGoals);

        logger.info("Delete created goals: " + createdGoals);
        userGoalsService.gotoUserCustomGoalsService().deleteCustomGoals(createdGoals);
    }

    @AfterMethod(alwaysRun = true, description = "Undo user goal")
    public void afterMethod() {
        logger.info("Start afterMethod() for " + getClass().getSimpleName());

        logger.info("Undo user goal: " + userCustomGoal);
        userGoalsService.doUserGoal(userCustomGoal);
    }

    @DataProvider
    public Object[][] customUserGoalEntities() {
        return new Object[][] { { selectedGoals.get(0),
                UserGoalRepository.get().buyNaturalFoodDone() } };
    }

    @Description("Check if user can do custom goal")
    @Parameters({ "Custom goal for doing", "Done custom goal" })
    @Test(dataProvider = "customUserGoalEntities", description = "Do custom goal")
    public void doUserCustomGoal(UserGoalEntity goal, UserGoal expectedGoal) {
        logger.info("Start doUserCustomGoal()");

        logger.info("Do custom goal: " + userCustomGoal);
        UserGoalEntity doneGoal = userGoalsService.doUserGoal(goal);
        userCustomGoal = doneGoal;

        Assert.assertEquals(UserGoal.converToUserGoal(doneGoal), expectedGoal,
                "Custom goal is not done: ");

        logger.info("Custom goal is done" + doneGoal);
    }

}
