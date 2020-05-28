package com.softserve.edu.greencity.rest.resources;

import java.util.List;

import com.softserve.edu.greencity.rest.dto.RestHttpMethods;
import com.softserve.edu.greencity.rest.dto.RestUrlRepository;
import com.softserve.edu.greencity.rest.engine.RestQueries;
import com.softserve.edu.greencity.rest.entity.HabitFactFullEntity;
import com.softserve.edu.greencity.rest.entity.HabitFactEntity;
import com.softserve.edu.greencity.rest.entity.ResponseCodeEntity;
import com.softserve.edu.greencity.rest.tools.GenericConverter;

public class HabitFactResource extends
		RestQueries<HabitFactFullEntity, HabitFactFullEntity, HabitFactEntity, ResponseCodeEntity, ResponseCodeEntity> {

	public HabitFactResource() {
		super(RestUrlRepository.getHabitFact());
		initParameters();
	}

	private void initParameters() {
		addEntityParameters(RestHttpMethods.GET, HabitFactFullEntity.class);
		addEntityParameters(RestHttpMethods.POST, HabitFactFullEntity.class);
		addEntityParameters(RestHttpMethods.PUT, HabitFactEntity.class);
		addEntityParameters(RestHttpMethods.DELETE, ResponseCodeEntity.class);
		addEntityParameters(RestHttpMethods.PATCH, ResponseCodeEntity.class);
		//
		addListEntityParameters(RestHttpMethods.GET,
				new GenericConverter<List<HabitFactFullEntity>>(){}.getGenericType());
		addListEntityParameters(RestHttpMethods.POST,
				new GenericConverter<List<HabitFactFullEntity>>(){}.getGenericType());
		addListEntityParameters(RestHttpMethods.PUT,
				new GenericConverter<List<HabitFactEntity>>(){}.getGenericType());
		addListEntityParameters(RestHttpMethods.DELETE,
				new GenericConverter<List<ResponseCodeEntity>>(){}.getGenericType());
		addListEntityParameters(RestHttpMethods.PATCH,
				new GenericConverter<List<ResponseCodeEntity>>(){}.getGenericType());
	}

}
