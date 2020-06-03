package com.softserve.edu.greencity.rest.services;

import com.softserve.edu.greencity.rest.data.LanguagesCode;
import com.softserve.edu.greencity.rest.dto.ContentTypes;
import com.softserve.edu.greencity.rest.dto.KeyParameters;
import com.softserve.edu.greencity.rest.dto.RestParameters;
import com.softserve.edu.greencity.rest.entity.LogginedUserEntity;
import com.softserve.edu.greencity.rest.services.habitstatistic.HabitStatisticService;
import com.softserve.edu.greencity.rest.services.habitstatistic.TodayHabitStatisticService;
import com.softserve.edu.greencity.rest.services.myhabits.MyHabitsService;

public class LogginedUserService {
	protected LogginedUserEntity logginedUserEntity;

	public LogginedUserService(LogginedUserEntity logginedUserEntity) {
		this.logginedUserEntity = logginedUserEntity;
	}

	// getters

	public LogginedUserEntity getLogginedUserEntity() {
		return logginedUserEntity;
	}

	// Functionals

    protected RestParameters getHeaderParameters() {
        return new RestParameters()
                .addParameter(KeyParameters.ACCEPT, ContentTypes.ALL_TYPES.toString())
                .addParameter(KeyParameters.AUTHORIZATION, KeyParameters.BEARER.toString() + getLogginedUserEntity().getAccessToken());
    }

    protected RestParameters getLanguageParameter(LanguagesCode language) {
        return new RestParameters()
                .addParameter(KeyParameters.LANGUAGE, String.valueOf(language));
    }


	public MyHabitsService gotoMyhabitsService() {
        return new MyHabitsService(logginedUserEntity);
    }

    public HabitStatisticService gotoHabitStatisticService() {
        return new HabitStatisticService(logginedUserEntity);
    }

    public TodayHabitStatisticService gotoTodayHabitStatisticService() {
        return new TodayHabitStatisticService(logginedUserEntity);
    }

    public AchievementService gotoAchievementService() {
        return new AchievementService(logginedUserEntity);
    }

    public GoalsService gotoGoalsService() {
        return new GoalsService(logginedUserEntity);
    }
}
