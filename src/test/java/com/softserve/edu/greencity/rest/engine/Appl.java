package com.softserve.edu.greencity.rest.engine;

import com.softserve.edu.greencity.rest.dto.KeyParameters;
import com.softserve.edu.greencity.rest.dto.RestParameters;
import com.softserve.edu.greencity.rest.dto.RestUrlRepository;

public class Appl {
	public static void main(String[] args) {
		RestParameters parameters = new RestParameters()
			.addNewObjectParameter(KeyParameters.DISCOUNT_DTO)
				.addObjectParameter(KeyParameters.DISCOUNT_MAX, 0)
				.addObjectParameter(KeyParameters.DISCOUNT_MIN, 0)
				.addNewObjectParameter(KeyParameters.SPECIFICATION)
					.addObjectParameter(KeyParameters.NAME, "string")
				.buildCurrentObjectParameter()
			.buildCurrentObjectParameter()
			.addNewObjectParameter(KeyParameters.DISTANCE_FROM_USER_DTO)
				.addObjectParameter(KeyParameters.DISTANCE, 0)
				.addObjectParameter(KeyParameters.LAT, 0)
				.addObjectParameter(KeyParameters.LNG, 0)
			.buildCurrentObjectParameter()
			.addNewObjectParameter(KeyParameters.MAP_BOUNDS_DTO)
				.addObjectParameter(KeyParameters.NORTH_EAST_LAT, 0)
				.addObjectParameter(KeyParameters.NORTH_EAST_LNG, 0)
				.addObjectParameter(KeyParameters.SOUTH_WEST_LAT, 0)
				.addObjectParameter(KeyParameters.SOUTH_WEST_LNG, 0)
			.buildCurrentObjectParameter()
			.addObjectParameter(KeyParameters.SEARCH_REG, "string")
			.addObjectParameter(KeyParameters.STATUS, "PROPOSED")
			.addObjectParameter(KeyParameters.TIME, "string");
		RestCrud restCrud = new RestCrud(RestUrlRepository.getDefault()) {};
		String res = restCrud.prepareJson(parameters);
		System.out.println(res);
	}
}
