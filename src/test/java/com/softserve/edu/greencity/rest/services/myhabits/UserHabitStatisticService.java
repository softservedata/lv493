package com.softserve.edu.greencity.rest.services.myhabits;

import com.softserve.edu.greencity.rest.dto.MethodParameters;
import com.softserve.edu.greencity.rest.entity.LogginedUserEntity;
import com.softserve.edu.greencity.rest.entity.myhabits.UserHabitStatisticEntity;
import com.softserve.edu.greencity.rest.resources.myhabits.UserHabitStatisticResource;

import io.qameta.allure.Step;

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
	@Step("Get user habits statistic")
	public UserHabitStatisticEntity userHabitStatistic(){
        return getUserHabitStatisticResource().httpGetAsEntity(new MethodParameters()
                .addHeaderParameters(getHeaderParameters())
                .addPathVariables(getUserIdParameter()));
	}

}