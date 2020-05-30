package com.softserve.edu.greencity.rest.services;

import com.softserve.edu.greencity.rest.dto.MethodParameters;
import com.softserve.edu.greencity.rest.entity.LogginedUserEntity;
import com.softserve.edu.greencity.rest.entity.UserHabitStatisticEntity;
import com.softserve.edu.greencity.rest.resources.UserHabitStatisticResource;

public class UserHabitStatisticService extends MyHabitsService{
	protected UserHabitStatisticResource userHabitStatisticResource;

	public UserHabitStatisticService(LogginedUserEntity logginedUserEntity) {
		super(logginedUserEntity);
		userHabitStatisticResource = new UserHabitStatisticResource();
	}

	// getters

	public UserHabitStatisticResource getUserHabitStatisticResource() {
        return userHabitStatisticResource;
    }

	// Functionals

	/**
	 * Get statistic for habits of current user.
	 * @return habit statistic entity
	 */
	public UserHabitStatisticEntity userHabitStatistic(){
        return getUserHabitStatisticResource().httpGetAsEntity(new MethodParameters()
                .addHeaderParameters(getHeaderParameters())
                .addPathVariables(getUserIdParameter()));
	}

}