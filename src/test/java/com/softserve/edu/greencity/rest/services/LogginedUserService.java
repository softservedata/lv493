package com.softserve.edu.greencity.rest.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.softserve.edu.greencity.rest.dto.ContentTypes;
import com.softserve.edu.greencity.rest.dto.KeyParameters;
import com.softserve.edu.greencity.rest.dto.MethodParameters;
import com.softserve.edu.greencity.rest.dto.RestParameters;
import com.softserve.edu.greencity.rest.entity.GoogleSecurityEntity;
import com.softserve.edu.greencity.rest.entity.LogginedUserEntity;
import com.softserve.edu.greencity.rest.entity.UserDtoEntity;
import com.softserve.edu.greencity.rest.resources.GoogleSecurityResource;
import com.softserve.edu.greencity.rest.resources.UserDtoResource;

public class LogginedUserService {
    //
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    //
    protected LogginedUserEntity logginedUserEntity;
    private GoogleSecurityEntity googleSecurityEntity;
    private GoogleSecurityResource googleSecurityResource;
    private UserDtoEntity userDtoEntity;
    private UserDtoResource userDtoResource;

    public LogginedUserService(LogginedUserEntity logginedUserEntity) {
        this.logginedUserEntity = logginedUserEntity;
    }

    // getters

    public LogginedUserEntity getLogginedUserEntity() {
        return logginedUserEntity;
    }

    private GoogleSecurityEntity getGoogleSecurityEntity() {
        return googleSecurityEntity;
    }

    private GoogleSecurityResource getGoogleSecurityResource() {
        googleSecurityResource = new GoogleSecurityResource();
        return googleSecurityResource;
    }

    private UserDtoResource getUserDtoResource() {
        userDtoResource = new UserDtoResource();
        return userDtoResource;
    }

    private UserDtoEntity getUserDtoEntity() {
//        userDtoEntity = new UserDtoEntity();
        return userDtoEntity;
    }

    // Functionals

    // http://***/googleSecurity?idToken=**" -H "accept: */*" -H "Authorization: Bearer ***"
    /**
     * Google security authentication
     * @return GoogleSecurityEntity
     */
    public GoogleSecurityEntity googleSecurity() {
        logger.debug("start check google security authentication");
        logger.trace("preparing REST request for successfully user registration");
        MethodParameters methodParameters = new MethodParameters();
        getGoogleSecurityResource();
        //
        RestParameters headerParameters = new RestParameters()
                .addParameter(KeyParameters.ACCEPT, ContentTypes.ALL_TYPES.toString())
                .addParameter(KeyParameters.AUTHORIZATION, KeyParameters.BEARER.toString() + getLogginedUserEntity().getAccessToken());
        //
        RestParameters urlParameters = new RestParameters()
                .addParameter(KeyParameters.ID_TOKEN, String.valueOf(getLogginedUserEntity().getUserId()));
        //
        GoogleSecurityEntity googleSecurityEntity = googleSecurityResource
                .httpGetAsEntity(methodParameters.addUrlParameters(urlParameters).addHeaderParameters(headerParameters));
        // System.out.println("***googleSecurityEntity = " +
        // googleSecurityEntity);
        return googleSecurityEntity;
    }

    //"http://***/user" -H "accept: */*" -H "Authorization: Bearer ***"
    /**
     * User Dto Email Notification.
     * @return UserDtoEntity
     */
    public UserDtoEntity userDtoEmailNotification() {
        logger.debug("start userDtoEmailNotification()");
        logger.trace("preparing REST request for get Email Notification");
        logger.info("forming REST request for get Email Notification");
        MethodParameters methodParameters = new MethodParameters();
        getUserDtoResource();
        //
        RestParameters headerParameters = new RestParameters()
                .addParameter(KeyParameters.ACCEPT, ContentTypes.ALL_TYPES.toString())
                .addParameter(KeyParameters.AUTHORIZATION, KeyParameters.BEARER.toString() + getLogginedUserEntity().getAccessToken());
        //
        UserDtoEntity userDtoEntity = userDtoResource
                .httpGetAsEntity(methodParameters.addHeaderParameters(headerParameters));
        //
        return userDtoEntity;
    }

    // Business Logic
    public MyhabitsService gotoMyhabitsService() {
        return new MyhabitsService(logginedUserEntity);
    }

    public EconewsUserService gotoEconewsUserService() {
        return new EconewsUserService(logginedUserEntity);
    }
    
    public PlacesService gotoPlacesService() {
        return new PlacesService(logginedUserEntity);
    }
}
