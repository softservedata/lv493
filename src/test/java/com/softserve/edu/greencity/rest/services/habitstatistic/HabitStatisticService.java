package com.softserve.edu.greencity.rest.services.habitstatistic;

import java.util.List;

import com.softserve.edu.greencity.rest.dto.ContentTypes;
import com.softserve.edu.greencity.rest.dto.KeyParameters;
import com.softserve.edu.greencity.rest.dto.MethodParameters;
import com.softserve.edu.greencity.rest.dto.RestParameters;
import com.softserve.edu.greencity.rest.entity.LogginedUserEntity;
import com.softserve.edu.greencity.rest.entity.ResponseCodeEntity;
import com.softserve.edu.greencity.rest.entity.habitstatistic.HabitStatisticEntity;
import com.softserve.edu.greencity.rest.entity.myhabits.UserHabitEntity;
import com.softserve.edu.greencity.rest.resources.habitstatistic.HabitStatisticResource;
import com.softserve.edu.greencity.rest.services.LogginedUserService;

public class HabitStatisticService extends LogginedUserService{
	protected HabitStatisticResource habitStatisticResource;

	public HabitStatisticService(LogginedUserEntity logginedUserEntity) {
		super(logginedUserEntity);
		habitStatisticResource = new HabitStatisticResource();
	}

	// getters

	public HabitStatisticResource getHabitStatisticResource() {
        return habitStatisticResource;
    }

	// Functionals

	// Functional of adding some days statistic of habits is not working

	/**
	 * Get full statistic of habit. Admin access.
	 * @param habit
	 * @return list of habit statistic
	 */
	public List<HabitStatisticEntity> habitStatistic(UserHabitEntity habit){
	    RestParameters pathVariables  = new RestParameters()
	            .addParameter(KeyParameters.HABIT_ID, String.valueOf(habit.getId()));

        return getHabitStatisticResource().httpGetAsListEntity(new MethodParameters()
                .addHeaderParameters(getHeaderParameters())
                .addPathVariables(pathVariables));
	}


	/**
	 * Add statistic for habit. Admin access.
	 * @param statistic
	 * @param habit
	 * @return
	 */

    public ResponseCodeEntity addHabitStatistic(HabitStatisticEntity statistic, UserHabitEntity habit) {
        RestParameters mediaTypeParameters = new RestParameters()
                .addParameter(KeyParameters.AMOUNT_OF_ITEMS, String.valueOf(statistic.getAmountOfItems()))
                .addParameter(KeyParameters.CREATED_ON, statistic.getCreatedOn())
                .addParameter(KeyParameters.HABIT_RATE, String.valueOf(statistic.getHabitRate()))
                //.addParameter(KeyParameters.ID,String.valueOf( statistic.getId()))
                .addParameter(KeyParameters.HABIT_ID, String.valueOf(habit.getId()));

        return getHabitStatisticResource().httpPostAsEntity(new MethodParameters()
                .addHeaderParameters(getHeaderParameters())
                .addContentType(ContentTypes.APPLICATION_JSON)
                .addMediaTypeParameters(mediaTypeParameters));
    }

    /**
     * Update statistic for habit. Admin access.
     * @param habit statistic
     * @return habit statistic
     */
    public HabitStatisticEntity updateHabitStatistic(HabitStatisticEntity habitStatistic){
        RestParameters pathVariables  = new RestParameters()
                .addParameter(KeyParameters.HABIT_STATISTIC_ID, String.valueOf(habitStatistic.getId()));

        RestParameters mediaTypeParameters = new RestParameters()
                .addParameter(KeyParameters.AMOUNT_OF_ITEMS, String.valueOf(habitStatistic.getAmountOfItems()))
                .addParameter(KeyParameters.HABIT_RATE, String.valueOf(habitStatistic.getHabitRate()))
                .addParameter(KeyParameters.ID, String.valueOf(habitStatistic.getId()));

        return getHabitStatisticResource().httpPatchAsEntity(new MethodParameters()
                .addHeaderParameters(getHeaderParameters())
                .addPathVariables(pathVariables)
                .addContentType(ContentTypes.APPLICATION_JSON)
                .addMediaTypeParameters(mediaTypeParameters));
    }

}