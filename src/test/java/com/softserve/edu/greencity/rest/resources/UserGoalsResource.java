package com.softserve.edu.greencity.rest.resources;

import com.softserve.edu.greencity.rest.dto.RestUrlRepository;
import com.softserve.edu.greencity.rest.engine.RestQueries;
import com.softserve.edu.greencity.rest.entity.ResponseCodeEntity;
import com.softserve.edu.greencity.rest.entity.UserGoalsEntity;

public class UserGoalsResource extends
		RestQueries<UserGoalsEntity, ResponseCodeEntity,
		ResponseCodeEntity, ResponseCodeEntity, ResponseCodeEntity> {

	public UserGoalsResource() {
		super(RestUrlRepository.getUserGoals());
	}

}
