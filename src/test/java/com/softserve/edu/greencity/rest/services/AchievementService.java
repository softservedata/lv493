package com.softserve.edu.greencity.rest.services;

import java.util.List;

import com.softserve.edu.greencity.rest.dto.MethodParameters;
import com.softserve.edu.greencity.rest.entity.AchievementEntity;
import com.softserve.edu.greencity.rest.entity.LogginedUserEntity;
import com.softserve.edu.greencity.rest.resources.AchievementResource;

public class AchievementService extends LogginedUserService{
	protected AchievementResource achievementResource;

	public AchievementService(LogginedUserEntity logginedUserEntity) {
		super(logginedUserEntity);
		achievementResource = new AchievementResource();
	}

	// getters

	public AchievementResource getAchievementResource() {
        return achievementResource;
    }

	// Functionals

	/**
	 * Get all available achievement. Admin access.
	 * @return list of achievement entities
	 */
	public List<AchievementEntity> achievement(){
	    return getAchievementResource().httpGetAsListEntity(new MethodParameters()
	            .addHeaderParameters(getHeaderParameters()));
	}

}