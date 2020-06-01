package com.softserve.edu.greencity.rest.tests.myhabits;

import java.util.ArrayList;
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
import com.softserve.edu.greencity.rest.services.myhabits.UserGoalsService;
import com.softserve.edu.greencity.rest.tests.GreencityRestTestRunner;

public class DoCustomGoalsTest extends GreencityRestTestRunner {
    User user = UserRepository.get().getDefault();
    UserGoalsService userGoalsService;
    List<UserGoal> goalForCreating = UserGoalRepository.get().customGoalsForAdding();
    List<UserGoalEntity> selectedGoals;
    List<UserGoalEntity> createdGoals;
    UserGoalEntity userCustomGoal;

    @BeforeClass
    public void beforeClass() {
        logger.info("Start beforeClass() for " + getClass().getSimpleName());
        logger.info("Go to UserGoalsService");
        userGoalsService = loadApplication()
                .successfulUserLogin(user)
                .gotoMyhabitsService()
                .gotoUserGoalsService();

        logger.info("Create goals: " + goalForCreating);
        createdGoals = userGoalsService.gotoUserCustomGoalsService()
                .createCustomGoals(goalForCreating);

        logger.info("Select created goals: " + createdGoals);
        selectedGoals = userGoalsService
                .gotoUserGoalsService()
                .selectUserGoals(new ArrayList<>(), createdGoals);

        logger.info("Select goal for doing");
        userCustomGoal = selectedGoals.get(0);

    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        logger.info("Start afterClass() for " + getClass().getSimpleName());
        logger.info("Deselect user goals: " + selectedGoals);
        userGoalsService.deselectUserGoals(selectedGoals);

        logger.info("Delete created goals: " + createdGoals);
        userGoalsService.gotoUserCustomGoalsService().deleteCustomGoals(createdGoals);
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        logger.info("Start afterMethod() for " + getClass().getSimpleName());
        logger.info("Undo user goal: " + userCustomGoal);
        userGoalsService.doUserGoal(userCustomGoal);
    }


    @DataProvider
    public Object[][] customUserGoalEntities() {
        return new Object[][] {
                { UserGoalRepository.get().buyNaturalFoodDONE() } };
    }

    @Test(dataProvider = "customUserGoalEntities")
    public void doUserCustomGoal(UserGoal expectedGoal) {
        logger.info("Start doUserCustomGoal()");
        logger.info("Do custom goal: " + userCustomGoal);
        UserGoalEntity doneGoal = userGoalsService.doUserGoal(userCustomGoal);
        Assert.assertEquals(UserGoal.converToUserGoal(doneGoal), expectedGoal, "Custom goal is not done: ");
        logger.info("Custom goal is done" + doneGoal);
    }

}
