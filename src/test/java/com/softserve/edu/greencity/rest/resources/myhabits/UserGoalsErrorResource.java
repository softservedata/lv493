package com.softserve.edu.greencity.rest.resources.myhabits;

import java.util.List;

import com.softserve.edu.greencity.rest.dto.RestHttpMethods;
import com.softserve.edu.greencity.rest.dto.RestUrlRepository;
import com.softserve.edu.greencity.rest.engine.RestQueries;
import com.softserve.edu.greencity.rest.entity.ErrorEntity;
import com.softserve.edu.greencity.rest.entity.ResponseCodeEntity;
import com.softserve.edu.greencity.rest.tools.GenericConverter;

public class UserGoalsErrorResource extends
		RestQueries<ErrorEntity, ResponseCodeEntity, ResponseCodeEntity, ResponseCodeEntity, ResponseCodeEntity> {

    public final static String  NOT_SELECTED_GOALS = "This user hasn't selected any goals yet";
    public final static String  OTHER_USER = "You can't perform actions with the data of other user";

	public UserGoalsErrorResource() {
		super(RestUrlRepository.getUserGoals());
		initParameters();
	}

	private void initParameters() {
		addEntityParameters(RestHttpMethods.GET, ErrorEntity.class);
		addEntityParameters(RestHttpMethods.POST, ResponseCodeEntity.class);
		addEntityParameters(RestHttpMethods.PUT, ResponseCodeEntity.class);
		addEntityParameters(RestHttpMethods.DELETE, ResponseCodeEntity.class);
		addEntityParameters(RestHttpMethods.PATCH, ResponseCodeEntity.class);
		//
		addListEntityParameters(RestHttpMethods.GET,
				new GenericConverter<List<ErrorEntity>>(){}.getGenericType());
		addListEntityParameters(RestHttpMethods.POST,
				new GenericConverter<List<ResponseCodeEntity>>(){}.getGenericType());
		addListEntityParameters(RestHttpMethods.PUT,
				new GenericConverter<List<ResponseCodeEntity>>(){}.getGenericType());
		addListEntityParameters(RestHttpMethods.DELETE,
				new GenericConverter<List<ResponseCodeEntity>>(){}.getGenericType());
		addListEntityParameters(RestHttpMethods.PATCH,
				new GenericConverter<List<ResponseCodeEntity>>(){}.getGenericType());
	}

}
