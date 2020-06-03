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
import com.softserve.edu.greencity.rest.data.myhabits.UserGoalEntityRepository;
import com.softserve.edu.greencity.rest.data.myhabits.UserGoalRepository;
import com.softserve.edu.greencity.rest.entity.myhabits.UserGoalEntity;
import com.softserve.edu.greencity.rest.services.myhabits.UserGoalsService;
import com.softserve.edu.greencity.rest.tests.GreencityRestTestRunner;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;

@Feature("Do user goals")
public class DoGoalsTest extends GreencityRestTestRunner {
    UserGoalsService userGoalsService;
    List<UserGoalEntity> selectedGoals;
    UserGoalEntity userGoal;

    @BeforeClass(description = "Select goals")
    public void beforeClass() {
        logger.info("Start beforeClass() for " + getClass().getSimpleName());

        logger.info("Go to UserGoalsService");
        userGoalsService = loadApplication()
                .successfulUserLogin(UserRepository.get().getDefault())
                .gotoMyhabitsService().gotoUserGoalsService();

        logger.info("Select goals: " + UserGoalEntityRepository.get().goalsForDoing());
        selectedGoals = userGoalsService.gotoUserGoalsService()
                .selectUserGoals(UserGoalEntityRepository.get().goalsForDoing(), new ArrayList<>());
    }

    @AfterClass(alwaysRun = true, description = "Deselect goals")
    public void afterClass() {
        logger.info("Start afterClass() for " + getClass().getSimpleName());

        logger.info("Deselect user goals: " + selectedGoals);
        userGoalsService.deselectUserGoals(selectedGoals);
    }

    @AfterMethod(alwaysRun = true, description = "Undo goal")
    public void afterMethod() {
        logger.info("Start afterMethod() for " + getClass().getSimpleName());

        logger.info("Undo user goal: " + userGoal);
        userGoalsService.doUserGoal(userGoal);
    }

    @DataProvider
    public Object[][] userGoalEntities() {
        return new Object[][] { { selectedGoals.get(0),
                UserGoalRepository.get().sortingTrashDone() } };
    }

    @Description("Check if user can do goal")
    @Parameters({ "Goal for doing", "Done goal" })
    @Test(dataProvider = "userGoalEntities", description = "Do goal")
    public void doUserGoal(UserGoalEntity goal, UserGoal expectedGoal) {
        logger.info("Start doUserGoal()");

        logger.info("Do goal: " + goal);
        UserGoalEntity doneGoal = userGoalsService.doUserGoal(goal);
        userGoal = doneGoal;

        Assert.assertEquals(UserGoal.converToUserGoal(doneGoal), expectedGoal,
                "Goals is not done: ");

        logger.info("Goal is done" + doneGoal);
    }

}
