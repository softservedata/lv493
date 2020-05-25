package com.softserve.edu.greencity.rest.services;

import java.util.Iterator;
import java.util.List;

import com.softserve.edu.greencity.rest.data.UserGoal;
import com.softserve.edu.greencity.rest.data.UserGoalStatus;
import com.softserve.edu.greencity.rest.dto.ContentTypes;
import com.softserve.edu.greencity.rest.dto.KeyParameters;
import com.softserve.edu.greencity.rest.dto.MethodParameters;
import com.softserve.edu.greencity.rest.dto.RestParameters;
import com.softserve.edu.greencity.rest.entity.LogginedUserEntity;
import com.softserve.edu.greencity.rest.entity.UserGoalsEntity;
import com.softserve.edu.greencity.rest.resources.UserGoalsResource;

public class MyhabitsService extends LogginedUserService {
	private UserGoalsResource userGoalsResource;

	public MyhabitsService(LogginedUserEntity logginedUserEntity) {
		super(logginedUserEntity);
		userGoalsResource = new UserGoalsResource();
	}

	// getters

	public UserGoalsResource getUserGoalsResource() {
		return userGoalsResource;
	}

	// Functionals
	
	public List<UserGoalsEntity> userGoalsEntities() {
    	MethodParameters methodParameters = new MethodParameters();
    	RestParameters headerParameters = new RestParameters()
				.addParameter(KeyParameters.ACCEPT, ContentTypes.ALL_TYPES.toString())
				.addParameter(KeyParameters.AUTHORIZATION,
						KeyParameters.BEARER.toString() + getLogginedUserEntity().getAccessToken());
    	RestParameters pathVariables = new RestParameters()
    			.addParameter(KeyParameters.USER_ID,
    					String.valueOf(getLogginedUserEntity().getUserId()));
    	List<UserGoalsEntity> userGoalsEntities = userGoalsResource
    			.httpGetAsListEntity(methodParameters
    					.addPathVariables(pathVariables)
    					.addHeaderParameters(headerParameters));
    	System.out.println("***userGoalsEntities = " + userGoalsEntities);
		return userGoalsEntities;
	}
	
	public List<UserGoal> userGoals() {
		return UserGoal.converToUserGoalList(userGoalsEntities());
	}
	
	public List<UserGoal> userGoalsByStatus(UserGoalStatus userGoalStatus) {
		List<UserGoal> result = userGoals();
		for (Iterator<UserGoal> iterator = result.iterator(); iterator.hasNext(); ) {
			UserGoal current = iterator.next();
			if (!current.getStatus().toUpperCase().equals(userGoalStatus.toString())) {
				iterator.remove();
			}
		}
		return result;
	}
	
	// Business Logic
}
