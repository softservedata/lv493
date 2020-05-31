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
    List<UserGoalEntity> customGoals;
    List<UserGoalEntity> selectedGoals;


    @BeforeClass
    public void beforeClass() {
        myHabitsService = loadApplication()
                .successfulUserLogin(user)
                .gotoMyhabitsService();

        customGoals = myHabitsService.gotoUserCustomGoalsService()
            .createCustomGoals(UserGoalRepository.get().customGoals());
        List<UserGoalEntity> customSelected = new ArrayList<>();
        customSelected.add(customGoals.stream().filter(goal -> goal.getText()
                .contains(UserGoalRepository.get().buyNaturalFood().getText())).findAny().orElse(null));
        selectedGoals = myHabitsService.gotoUserGoalsService()
            .selectUserGoals(UserGoalEntityRepository.get().goalsForSelecting(),
                    customSelected);
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        myHabitsService.gotoUserGoalsService().deselectUserGoals(selectedGoals);
        myHabitsService.gotoUserCustomGoalsService().deleteCustomGoals(customGoals);


    }


    @DataProvider
    public Object[][] selectedUserGoals() {
        return new Object[][] {
            { UserGoalRepository.get().typicalGoal()}
        };
    }

    @Test(dataProvider = "selectedUserGoals")
    public void checkUserGoals(List<UserGoal> expectedGoals) {
        logger.info("Start checkUserGoals(" + user + ")");
        Assert.assertEquals(myHabitsService.gotoUserGoalsService().userGoals(),
                expectedGoals, "Goal is not selected: ");
    }

    @DataProvider
    public Object[][] availableUserGoals() {
        return new Object[][] {
            {UserGoalRepository.get().availableGoals()}
        };
    }

    @Test(dataProvider = "availableUserGoals")
    public void checkAvailableUserGoals(List<UserGoal> expectedGoals) {
        logger.info("Start checkAvailableUserGoals(" + user + ")");

        Assert.assertEquals(myHabitsService.gotoUserGoalsService().availableUserGoals(),
                expectedGoals, "Goal is not available: ");
    }

    @DataProvider
    public Object[][] selectedUserGoalsWithLanguage() {
        return new Object[][] {
            {UserGoalRepository.get().typicalGoalUK(), LanguagesCode.UKRAINIAN}
        };
    }

    @Test(dataProvider = "selectedUserGoalsWithLanguage")
    public void checkUserGoals(List<UserGoal> expectedGoals, LanguagesCode language) {
        logger.info("Start checkUserGoals(" + user + ")");

        Assert.assertEquals(myHabitsService.gotoUserGoalsService().userGoals(language),
                expectedGoals, "Goal is not selected: ");
    }


    @DataProvider
    public Object[][] availableUserGoalsWithLanguage() {
        return new Object[][] {
            {UserGoalRepository.get().availableGoalsUK(), LanguagesCode.UKRAINIAN}
        };
    }

    @Test(dataProvider = "availableUserGoalsWithLanguage")
    public void checkAvailableUserGoals(List<UserGoal> expectedGoals, LanguagesCode language) {
        logger.info("Start checkAvailableUserGoals(" + user + ")");

        Assert.assertEquals(myHabitsService.gotoUserGoalsService().availableUserGoals(language),
                expectedGoals, "Goal is not available: ");
    }


    @DataProvider
    public Object[][] customGoals() {
        return new Object[][] {
            {UserGoalRepository.get().customGoals() }
        };
    }

    @Test(dataProvider = "customGoals")
    public void checkUserCustomGoals(List<UserGoal> expectedGoals) {
        logger.info("Start checkUserCustomGoals(" + user + ")");

        Assert.assertEquals(myHabitsService.gotoUserCustomGoalsService().customGoals(),
                expectedGoals, "Goal is not present: ");
    }

    @DataProvider
    public Object[][] availableCustomGoals() {
        return new Object[][] {
            { UserGoalRepository.get().availableCustomGoals() }
        };
    }

    @Test(dataProvider = "availableCustomGoals")
    public void checkAvailableUserCustomGoals(List<UserGoal> expectedGoals) {
        logger.info("Start checkAvailableUserCustomGoals(" + user + ")");

        Assert.assertEquals(myHabitsService.gotoUserCustomGoalsService().availableCustomGoals(),
                expectedGoals, "Goal is not available: ");
    }


}
