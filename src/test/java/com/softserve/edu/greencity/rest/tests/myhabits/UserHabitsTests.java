package com.softserve.edu.greencity.rest.tests.myhabits;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.greencity.rest.data.LanguagesCode;
import com.softserve.edu.greencity.rest.data.User;
import com.softserve.edu.greencity.rest.data.UserRepository;
import com.softserve.edu.greencity.rest.data.myhabits.UserHabit;
import com.softserve.edu.greencity.rest.data.myhabits.UserHabitRepository;
import com.softserve.edu.greencity.rest.data.myhabits.UserHabitStatistic;
import com.softserve.edu.greencity.rest.data.myhabits.UserHabitStatisticRepository;
import com.softserve.edu.greencity.rest.services.myhabits.UserHabitsService;
import com.softserve.edu.greencity.rest.tests.GreencityRestTestRunner;

public class UserHabitsTests extends GreencityRestTestRunner {
    User user = UserRepository.get().getDefault();
    UserHabitsService userHabitsService;

    @BeforeClass
    public void beforeClass() {
        logger.info("Start beforeClass() for " + getClass().getSimpleName());
        logger.info("Go to UserHabitsService");
        userHabitsService = loadApplication()
                .successfulUserLogin(user)
                .gotoMyhabitsService()
                .gotoUserHabitsService();
    }

    @DataProvider
    public Object[][] userHabits() {
        return new Object[][] {
            { UserHabitRepository.get().typicalHabits()}
            };
    }

    @Test(dataProvider = "userHabits")
    public void checkUserHabits(List<UserHabit> expectedHabits) {
        logger.info("Start checkUserHabits()");
        logger.info("Check selected user habits");
        Assert.assertEquals(userHabitsService.userHabits(),
                expectedHabits, "Habits are not selected: ");
        logger.info("Habits are selected");
    }


    @DataProvider
    public Object[][] userHabitsWithLanguage() {
        return new Object[][] {
            {UserHabitRepository.get().typicalHabitsUK(), LanguagesCode.UKRAINIAN}
        };
    }

    @Test(dataProvider = "userHabitsWithLanguage")
    public void checkUserHabits(List<UserHabit> expectedHabits, LanguagesCode language) {
        logger.info("Start checkUserHabits()");
        logger.info("Check selected user habits");
        Assert.assertEquals(userHabitsService.userHabits(language),
                expectedHabits, "Habits are not selected: ");
        logger.info("Habits are selected");
    }


    @DataProvider
    public Object[][] availableHabits() {
        return new Object[][] {
            { UserHabitRepository.get().typicalHabits()}
            };
    }

    @Test(dataProvider = "availableHabits")
    public void checkAvailableUserHabits(List<UserHabit> expectedHabits) {
        logger.info("Start checkAvailableUserHabits()");
        logger.info("Check available user habits");
        Assert.assertEquals(userHabitsService.userAvailableHabits(),
                expectedHabits, "Habits are not available: ");
        logger.info("Habits are available");
    }

    @DataProvider
    public Object[][] availableHabitsWithLanguage() {
        return new Object[][] {
            {UserHabitRepository.get().typicalHabitsUK(), LanguagesCode.UKRAINIAN}
        };
    }

    @Test(dataProvider = "availableHabitsWithLanguage")
    public void checkAvailableUserHabits(List<UserHabit> expectedHabits,LanguagesCode language) {
        logger.info("Start checkAvailableUserHabits()");
        logger.info("Check available user habits");
        Assert.assertEquals(userHabitsService.userAvailableHabits(language),
                expectedHabits, "Habits are not available: ");
        logger.info("Habits are available");
    }

    @DataProvider
    public Object[][] userHabitsStatistic() {
        return new Object[][] {
            {UserHabitStatisticRepository.get().getDefault()}
        };
    }

    @Test(dataProvider = "userHabitsStatistic")
    public void checkUserHabitStatistic(UserHabitStatistic expectedStatistic) {
        logger.info("Start checkUserHabitStatistic()");
        logger.info("Check user habits statistic");
        Assert.assertEquals(UserHabitStatistic.converToUserHabitStatistic(
                    userHabitsService.gotoUserHabitStatisticService().userHabitStatistic()),
                expectedStatistic, "Statistic is not correct: ");
        logger.info("Statistic is correct");
    }

}
