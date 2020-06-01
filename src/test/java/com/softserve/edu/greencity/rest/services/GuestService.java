package com.softserve.edu.greencity.rest.services;

import com.softserve.edu.greencity.rest.data.User;
import com.softserve.edu.greencity.rest.dto.ContentTypes;
import com.softserve.edu.greencity.rest.dto.KeyParameters;
import com.softserve.edu.greencity.rest.dto.MethodParameters;
import com.softserve.edu.greencity.rest.dto.RestParameters;
import com.softserve.edu.greencity.rest.entity.LogginedUserEntity;
import com.softserve.edu.greencity.rest.resources.SigninResource;
import com.softserve.edu.greencity.rest.tools.GreenCityCommonException;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GuestService {
	private SigninResource signinResource;
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    public GuestService() {
    	signinResource = new SigninResource();
    }
    
    // Business Logic
    
    public LogginedUserService successfulUserLogin(User user) {
    	MethodParameters methodParameters = new MethodParameters()
    			.addContentType(ContentTypes.APPLICATION_JSON);
    	RestParameters mediaTypeParameters = new RestParameters()
				.addParameter(KeyParameters.EMAIL, user.getEmail())
				.addParameter(KeyParameters.PASSWORD, user.getPassword());
    	RestParameters headerParameters = new RestParameters()
				.addParameter(KeyParameters.ACCEPT, ContentTypes.ALL_TYPES.toString());
    	LogginedUserEntity logginedUserEntity = signinResource
    			.httpPostAsEntity(methodParameters
    					.addMediaTypeParameters(mediaTypeParameters)
    					.addHeaderParameters(headerParameters));
		return new LogginedUserService(logginedUserEntity);
	}

}
