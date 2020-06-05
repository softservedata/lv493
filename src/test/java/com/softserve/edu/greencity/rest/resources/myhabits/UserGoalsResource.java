package com.softserve.edu.greencity.rest.resources.myhabits;

import java.util.List;

import com.softserve.edu.greencity.rest.dto.RestHttpMethods;
import com.softserve.edu.greencity.rest.dto.RestUrlRepository;
import com.softserve.edu.greencity.rest.engine.RestQueries;
import com.softserve.edu.greencity.rest.entity.ResponseCodeEntity;
import com.softserve.edu.greencity.rest.entity.myhabits.UserGoalEntity;
import com.softserve.edu.greencity.rest.tools.GenericConverter;

public class UserGoalsResource extends
		RestQueries<UserGoalEntity, UserGoalEntity, ResponseCodeEntity, ResponseCodeEntity, UserGoalEntity> {

	public UserGoalsResource() {
		super(RestUrlRepository.getUserGoals());
		initParameters();
	}

	private void initParameters() {
		addEntityParameters(RestHttpMethods.GET, UserGoalEntity.class);
		addEntityParameters(RestHttpMethods.POST, UserGoalEntity.class);
		addEntityParameters(RestHttpMethods.PUT, ResponseCodeEntity.class);
		addEntityParameters(RestHttpMethods.DELETE, ResponseCodeEntity.class);
		addEntityParameters(RestHttpMethods.PATCH, UserGoalEntity.class);
		//
		addListEntityParameters(RestHttpMethods.GET,
				new GenericConverter<List<UserGoalEntity>>(){}.getGenericType());
		addListEntityParameters(RestHttpMethods.POST,
				new GenericConverter<List<UserGoalEntity>>(){}.getGenericType());
		addListEntityParameters(RestHttpMethods.PUT,
				new GenericConverter<List<ResponseCodeEntity>>(){}.getGenericType());
		addListEntityParameters(RestHttpMethods.DELETE,
				new GenericConverter<List<ResponseCodeEntity>>(){}.getGenericType());
		addListEntityParameters(RestHttpMethods.PATCH,
				new GenericConverter<List<UserGoalEntity>>(){}.getGenericType());
	}

}
