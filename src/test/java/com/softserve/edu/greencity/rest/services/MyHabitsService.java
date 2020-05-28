package com.softserve.edu.greencity.rest.services;

import java.util.List;
import java.util.stream.Collectors;

import com.softserve.edu.greencity.rest.dto.KeyParameters;
import com.softserve.edu.greencity.rest.dto.RestParameters;
import com.softserve.edu.greencity.rest.entity.LogginedUserEntity;
import com.softserve.edu.greencity.rest.entity.UserGoalEntity;

public class MyHabitsService extends LogginedUserService {

    public MyHabitsService(LogginedUserEntity logginedUserEntity) {
        super(logginedUserEntity);

    }

    // getters

    // Functionals

    protected RestParameters getUserIdParameter() {
        return new RestParameters()
                .addParameter(KeyParameters.USER_ID, String.valueOf(getLogginedUserEntity().getUserId()));
    }

    protected RestParameters getGoalsIdsParameter(List<UserGoalEntity> goals) {
        return new RestParameters()
                .addParameter(KeyParameters.IDS, getStringOfIds(goals));
    }

    private String getStringOfIds(List<UserGoalEntity> goals) {
        return goals.stream().map(UserGoalEntity::getId)
                .collect(Collectors.toList()).stream()
                .map(String::valueOf)
                .collect(Collectors.joining(","));
    }

    // Business Logic

    public UserGoalsService gotoUserGoalsService() {
        return new UserGoalsService(logginedUserEntity);
    }

    public UserCustomGoalsService gotoUserCustomGoalsService() {
        return new UserCustomGoalsService(logginedUserEntity);
    }

    public UserHabitsService gotoUserHabitsService() {
        return new UserHabitsService(logginedUserEntity);
    }

    public UserHabitStatisticService gotoUserHabitStatisticService() {
        return new UserHabitStatisticService(logginedUserEntity);
    }

}
