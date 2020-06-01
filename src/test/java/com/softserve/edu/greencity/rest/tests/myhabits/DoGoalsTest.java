package com.softserve.edu.greencity.rest.tests.myhabits;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.greencity.rest.data.LanguagesCode;
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
        userGoalsService = loadApplication()
                .successfulUserLogin(user)
                .gotoMyhabitsService()
                .gotoUserGoalsService();
        selectedGoals = userGoalsService
                .gotoUserGoalsService()
                .selectUserGoals(goalForDoing, new ArrayList<>());
        userGoal = selectedGoals.get(0);

    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        userGoalsService.deselectUserGoals(selectedGoals);
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        userGoalsService.doUserGoals(userGoal);
    }

    @DataProvider
    public Object[][] userGoalEntities() {
        return new Object[][] {
                { UserGoalRepository.get().sortingTrashDone() }};
    }

    @Test(dataProvider = "userGoalEntities")
    public void doUserGoal(UserGoal expectedGoal) {
        logger.info("Start doUserGoal()");

        Assert.assertEquals(UserGoal.converToUserGoal( userGoalsService.doUserGoals(userGoal)),
                expectedGoal, "Goals is not done: ");
    }

    @DataProvider
    public Object[][] userGoalEntitiesWithLanguage() {
        return new Object[][] { { UserGoalRepository.get().sortingTrashDoneUK(),
                LanguagesCode.UKRAINIAN } };
    }

    @Test(dataProvider = "userGoalEntitiesWithLanguage")
    public void doUserGoal(UserGoal expectedGoal, LanguagesCode language) {
        logger.info("Start doUserGoal()");

        Assert.assertEquals(UserGoal.converToUserGoal(userGoalsService.doUserGoals(userGoal)),
                expectedGoal, "Goals is not done: ");
    }

}
