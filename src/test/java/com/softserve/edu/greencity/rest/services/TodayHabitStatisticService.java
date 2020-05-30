package com.softserve.edu.greencity.rest.services;

import java.util.List;

import com.softserve.edu.greencity.rest.data.LanguagesCode;
import com.softserve.edu.greencity.rest.dto.KeyParameters;
import com.softserve.edu.greencity.rest.dto.MethodParameters;
import com.softserve.edu.greencity.rest.dto.RestParameters;
import com.softserve.edu.greencity.rest.entity.LogginedUserEntity;
import com.softserve.edu.greencity.rest.entity.TodayHabitStatisticEntity;
import com.softserve.edu.greencity.rest.resources.TodayHabitStatisticResource;

public class TodayHabitStatisticService extends LogginedUserService{
	protected TodayHabitStatisticResource todayHabitStatisticResource;

	public TodayHabitStatisticService(LogginedUserEntity logginedUserEntity) {
		super(logginedUserEntity);
		todayHabitStatisticResource = new TodayHabitStatisticResource();
	}

	// getters

	public TodayHabitStatisticResource getTodayHabitStatisticResource() {
        return todayHabitStatisticResource;
    }

	// Functionals


	// no response

//	{
//	    "habitItem": "caps",
//	    "notTakenItems": 2
//	}

	/**
	 * Get todays statistic for habits of current user according to language.
	 * @param language code
	 * @return list of habit statistic entities
	 */
	public List<TodayHabitStatisticEntity> todayStatisticsForAllHabitItems(LanguagesCode language){ //TODO try test
        RestParameters urlParameters = new RestParameters()
                .addParameter(KeyParameters.LANGUAGE, String.valueOf(language));

        return getTodayHabitStatisticResource().httpGetAsListEntity(new MethodParameters()

                .addHeaderParameters(getHeaderParameters())
                .addUrlParameters(urlParameters));
    }

	/**
     * Get todays statistic for habits of current user.
     * @return list of habit statistic entities
     */
	public List<TodayHabitStatisticEntity> todayStatisticsForAllHabitItems(){
        return todayStatisticsForAllHabitItems(LanguagesCode.ENGLISH);
    }

}