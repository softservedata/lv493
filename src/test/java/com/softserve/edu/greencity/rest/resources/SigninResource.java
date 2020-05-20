package com.softserve.edu.greencity.rest.resources;

import com.softserve.edu.greencity.rest.dto.RestUrlRepository;
import com.softserve.edu.greencity.rest.engine.RestQueries;
import com.softserve.edu.greencity.rest.entity.LogginedUserEntity;
import com.softserve.edu.greencity.rest.entity.ResponseCodeEntity;

public class SigninResource extends RestQueries<ResponseCodeEntity,
					LogginedUserEntity, ResponseCodeEntity,
					ResponseCodeEntity, ResponseCodeEntity> {

	public SigninResource() {
        super(RestUrlRepository.getSignin(),
        		ResponseCodeEntity.class, LogginedUserEntity.class,
        		ResponseCodeEntity.class, ResponseCodeEntity.class,
        		ResponseCodeEntity.class);
    }

}
