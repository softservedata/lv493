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
import com.softserve.edu.greencity.rest.data.myhabits.UserGoalEntityRepository;
import com.softserve.edu.greencity.rest.data.myhabits.UserGoalRepository;
import com.softserve.edu.greencity.rest.entity.myhabits.UserGoalEntity;
import com.softserve.edu.greencity.rest.services.myhabits.UserGoalsService;
import com.softserve.edu.greencity.rest.tests.GreencityRestTestRunner;

public class DoGoalsTest extends GreencityRestTestRunner {
    User user = UserRepository.get().getDefault();
    UserGoalsService userGoalsService;
    List<UserGoalEntity> goalForDoing = UserGoalEntityRepository.get().goalsForSortingTrash();
    List<UserGoalEntity> selectedGoals;
    UserGoalEntity userGoal;

    @BeforeClass
    public void beforeClass() {
        logger.info("Start beforeClass() for " + getClass().getSimpleName());
        logger.info("Go to UserGoalsService");
        userGoalsService = loadApplication()
                .successfulUserLogin(user)
                .gotoMyhabitsService()
                .gotoUserGoalsService();

        logger.info("Select goals: " + goalForDoing);
        selectedGoals = userGoalsService
                .gotoUserGoalsService()
                .selectUserGoals(goalForDoing, new ArrayList<>());

        logger.info("Select goal for doing");
        userGoal = selectedGoals.get(0);

    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        logger.info("Start afterClass() for " + getClass().getSimpleName());
        logger.info("Deselect user goals: " + selectedGoals);
        userGoalsService.deselectUserGoals(selectedGoals);
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        logger.info("Start afterMethod() for " + getClass().getSimpleName());
        logger.info("Undo user goal: " + userGoal);
        userGoalsService.doUserGoal(userGoal);
    }

    @DataProvider
    public Object[][] userGoalEntities() {
        return new Object[][] {
                { UserGoalRepository.get().sortingTrashDone() }};
    }

    @Test(dataProvider = "userGoalEntities")
    public void doUserGoal(UserGoal expectedGoal) {
        logger.info("Start doUserGoal()");
        logger.info("Do goal: " + userGoal);
        UserGoalEntity doneGoal =  userGoalsService.doUserGoal(userGoal);
        Assert.assertEquals(UserGoal.converToUserGoal(doneGoal),
                expectedGoal, "Goals is not done: ");
        logger.info("Пoal is done" + doneGoal);
    }

}
