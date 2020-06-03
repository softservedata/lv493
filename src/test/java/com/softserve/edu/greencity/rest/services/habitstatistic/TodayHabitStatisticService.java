package com.softserve.edu.greencity.rest.services.habitstatistic;

import java.util.List;

import com.softserve.edu.greencity.rest.data.LanguagesCode;
import com.softserve.edu.greencity.rest.dto.MethodParameters;
import com.softserve.edu.greencity.rest.entity.LogginedUserEntity;
import com.softserve.edu.greencity.rest.entity.habitstatistic.TodayHabitStatisticEntity;
import com.softserve.edu.greencity.rest.resources.habitstatistic.TodayHabitStatisticResource;
import com.softserve.edu.greencity.rest.services.LogginedUserService;

public class TodayHabitStatisticService extends LogginedUserService {
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

	/**
	 * Get todays statistic for habits of current user according to language.
	 * @param language code
	 * @return list of habit statistic entities
	 */

	// no response
	public List<TodayHabitStatisticEntity> todayStatisticsForAllHabitItems(LanguagesCode language){
        return getTodayHabitStatisticResource().httpGetAsListEntity(new MethodParameters()
                .addHeaderParameters(getHeaderParameters())
                .addUrlParameters(getLanguageParameter(language)));
    }

	/**
     * Get todays statistic for habits of current user.
     * @return list of habit statistic entities
     */
	public List<TodayHabitStatisticEntity> todayStatisticsForAllHabitItems(){
        return todayStatisticsForAllHabitItems(LanguagesCode.ENGLISH);
    }

}