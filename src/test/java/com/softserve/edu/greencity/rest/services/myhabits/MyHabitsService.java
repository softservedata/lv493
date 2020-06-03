package com.softserve.edu.greencity.rest.services.myhabits;

import java.util.List;
import java.util.stream.Collectors;

import com.softserve.edu.greencity.rest.dto.KeyParameters;
import com.softserve.edu.greencity.rest.dto.RestParameters;
import com.softserve.edu.greencity.rest.entity.LogginedUserEntity;
import com.softserve.edu.greencity.rest.entity.myhabits.UserGoalEntity;
import com.softserve.edu.greencity.rest.services.LogginedUserService;

public class MyHabitsService extends LogginedUserService {

    public MyHabitsService(LogginedUserEntity logginedUserEntity) {
        super(logginedUserEntity);

    }

    // getters

    // Functionals

    /**
     * Get user id parameter of current user.
     * @return rest parameter
     */
    protected RestParameters getUserIdParameter() {
        return new RestParameters()
                .addParameter(KeyParameters.USER_ID, String.valueOf(getLogginedUserEntity().getUserId()));
    }

    /**
     * Get goals id parameter of current user for deleting.
     * @return rest parameter
     */
    protected RestParameters getGoalsIdsParameter(List<UserGoalEntity> goals) {
        return new RestParameters()
                .addParameter(KeyParameters.IDS, getStringOfIds(goals));
    }

    /**
     * Form string for ids of goals separated by comma.
     * @param goals
     * @return ids string
     */
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
