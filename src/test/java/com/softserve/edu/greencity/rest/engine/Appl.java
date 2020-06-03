package com.softserve.edu.greencity.rest.engine;

import java.util.List;

import com.softserve.edu.greencity.rest.dto.RestUrlRepository;
import com.softserve.edu.greencity.rest.entity.BaseEntity;

public class Appl {
	public static void main(String[] args) throws Exception {
		/*-
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
		//
//		RestParameters parameters = new RestParameters().addDirectJsonParameter(
//				"[\"distanceFromUserDto\":{\"distance\":0,\"lng\":0,\"lat\":0},\"distance\":{\"distance\":1,\"lng\":1,\"lat\":1}]");
//		RestCrud restCrud = new RestCrud(RestUrlRepository.getDefault()) {};
//		String res = restCrud.prepareJson(parameters);
//		System.out.println(res);
		//
		RestCrud restCrudStub = PowerMockito.mock(RestCrud.class);
		PowerMockito.when(restCrudStub.httpPostAsText(null)).thenReturn("[{\"name\":\"password\",\"message\":\"mustnotbeblank\"},{\"name\":\"name\",\"message\":\"mustnotbeblank\"},{\"name\":\"password\",\"message\":\"PasswordhascontainatleastonecharacterofUppercaseletter(A-Z),Lowercaseletter(a-z),Digit(0-9),Specialcharacter(~`!@#$%^&*()+=_-{}[]|:;”’?/<>,.).\"},{\"name\":\"lang\",\"message\":\"mustnotbeblank\"},{\"name\":\"email\",\"message\":\"mustnotbeblank\"}]");
		PowerMockito.whenNew(RestCrud.class).withAnyArguments().thenReturn(restCrudStub);
		RestQueries<RegisterUserEntity, RegisterUserEntity, RegisterUserEntity, RegisterUserEntity, RegisterUserEntity> restQueries
			= Mockito.spy(new RestQueries<RegisterUserEntity, RegisterUserEntity, RegisterUserEntity, RegisterUserEntity, RegisterUserEntity>(RestUrlRepository.getDefault()) {});
		//restQueries
		//Mockito.when(restQueries.validateParameter(null,null));
	    */
//		RestQueries<RegisterUserEntity, RegisterUserEntity, RegisterUserEntity, RegisterUserEntity, RegisterUserEntity> restQueries	
//		    = new RestQueries<RegisterUserEntity, RegisterUserEntity, RegisterUserEntity, RegisterUserEntity, RegisterUserEntity>(RestUrlRepository.getDefault()) {};
//		RestQueries<List<String>, List<String>, List<String>, List<String>, List<String>> restQueries	
//	    	= new RestQueries<List<String>, List<String>, List<String>, List<String>, List<String>>(RestUrlRepository.getDefault()) {};
		RestQueries<BaseEntity, BaseEntity, BaseEntity, BaseEntity, BaseEntity> restQueries	
    		= new RestQueries<BaseEntity, BaseEntity, BaseEntity, BaseEntity, BaseEntity>(RestUrlRepository.getDefault()) {};
    	BaseEntity registerUserEntity = restQueries.httpPostAsEntity(null);
		System.out.println(registerUserEntity);
	}
}
