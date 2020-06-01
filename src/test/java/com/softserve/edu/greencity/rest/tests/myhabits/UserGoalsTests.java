package com.softserve.edu.greencity.rest.tests.myhabits;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
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
import com.softserve.edu.greencity.rest.services.myhabits.MyHabitsService;
import com.softserve.edu.greencity.rest.tests.GreencityRestTestRunner;

public class UserGoalsTests extends GreencityRestTestRunner {
    User user = UserRepository.get().getDefault();
    MyHabitsService myHabitsService;
    List<UserGoalEntity> createdGoals;
    List<UserGoalEntity> selectedGoals;
    List<UserGoal> goalForCreating = UserGoalRepository.get().customGoals();
    List<UserGoalEntity> goalsForSelecting = UserGoalEntityRepository.get().goalsForSelecting();
    UserGoal customGoalForSelecting = UserGoalRepository.get().buyNaturalFood();

    @BeforeClass
    public void beforeClass() {
        logger.info("Start beforeClass() for " + getClass().getSimpleName());
        logger.info("Go to UserGoalsService");
        myHabitsService = loadApplication()
                .successfulUserLogin(user)
                .gotoMyhabitsService();

        logger.info("Create goals: " + goalForCreating);
        createdGoals = myHabitsService.gotoUserCustomGoalsService()
            .createCustomGoals(goalForCreating);
        List<UserGoalEntity> customSelected = new ArrayList<>();
        customSelected.add(createdGoals.stream().filter(goal -> goal.getText()
                .contains(customGoalForSelecting.getText())).findAny().orElse(null));

        logger.info("Select goals: " + customSelected + " " + goalsForSelecting);
        selectedGoals = myHabitsService.gotoUserGoalsService()
            .selectUserGoals(goalsForSelecting, customSelected);
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        logger.info("Start afterClass() for " + getClass().getSimpleName());
        logger.info("Deselect user goals: " + selectedGoals);
        myHabitsService.gotoUserGoalsService().deselectUserGoals(selectedGoals);

        logger.info("Delete created goals: " + createdGoals);
        myHabitsService.gotoUserCustomGoalsService().deleteCustomGoals(createdGoals);
    }


    @DataProvider
    public Object[][] selectedUserGoals() {
        return new Object[][] {
            { UserGoalRepository.get().typicalGoal()}
        };
    }

    @Test(dataProvider = "selectedUserGoals")
    public void checkUserGoals(List<UserGoal> expectedGoals) {
        logger.info("Start checkUserGoals()");
        logger.info("Check selected user goals");
        Assert.assertEquals(myHabitsService.gotoUserGoalsService().userGoals(),
                expectedGoals, "Goals are not selected: ");
        logger.info("Goals are selected");
    }

    @DataProvider
    public Object[][] availableUserGoals() {
        return new Object[][] {
            {UserGoalRepository.get().availableGoals()}
        };
    }

    @Test(dataProvider = "availableUserGoals")
    public void checkAvailableUserGoals(List<UserGoal> expectedGoals) {
        logger.info("Start checkAvailableUserGoals()");
        logger.info("Check available user goals");
        Assert.assertEquals(myHabitsService.gotoUserGoalsService().availableUserGoals(),
                expectedGoals, "Goals are not available: ");
        logger.info("Goals are available");
    }

    @DataProvider
    public Object[][] selectedUserGoalsWithLanguage() {
        return new Object[][] {
            {UserGoalRepository.get().typicalGoalUK(), LanguagesCode.UKRAINIAN}
        };
    }

    @Test(dataProvider = "selectedUserGoalsWithLanguage")
    public void checkUserGoals(List<UserGoal> expectedGoals, LanguagesCode language) {
        logger.info("Start checkUserGoals()");
        logger.info("Check selected user goals");
        Assert.assertEquals(myHabitsService.gotoUserGoalsService().userGoals(language),
                expectedGoals, "Goals are not selected: ");
        logger.info("Goals are selected");
    }


    @DataProvider
    public Object[][] availableUserGoalsWithLanguage() {
        return new Object[][] {
            {UserGoalRepository.get().availableGoalsUK(), LanguagesCode.UKRAINIAN}
        };
    }

    @Test(dataProvider = "availableUserGoalsWithLanguage")
    public void checkAvailableUserGoals(List<UserGoal> expectedGoals, LanguagesCode language) {
        logger.info("Start checkAvailableUserGoals()");
        logger.info("Check available user goals");
        Assert.assertEquals(myHabitsService.gotoUserGoalsService().availableUserGoals(language),
                expectedGoals, "Goals are not available: ");
        logger.info("Goals are available");
    }


    @DataProvider
    public Object[][] customGoals() {
        return new Object[][] {
            {UserGoalRepository.get().customGoals() }
        };
    }

    @Test(dataProvider = "customGoals")
    public void checkUserCustomGoals(List<UserGoal> expectedGoals) {
        logger.info("Start checkUserCustomGoals()");
        logger.info("Check all present user custom goals");
        Assert.assertEquals(myHabitsService.gotoUserCustomGoalsService().customGoals(),
                expectedGoals, "Goals are not present: ");
        logger.info("Goals are present");
    }

    @DataProvider
    public Object[][] availableCustomGoals() {
        return new Object[][] {
            { UserGoalRepository.get().availableCustomGoals() }
        };
    }

    @Test(dataProvider = "availableCustomGoals")
    public void checkAvailableUserCustomGoals(List<UserGoal> expectedGoals) {
        logger.info("Start checkAvailableUserCustomGoals()");
        logger.info("Check available user custom goals");
        Assert.assertEquals(myHabitsService.gotoUserCustomGoalsService().availableCustomGoals(),
                expectedGoals, "Goals are not available: ");
        logger.info("Goals are available");
    }


}
