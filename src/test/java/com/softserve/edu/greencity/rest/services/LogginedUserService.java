package com.softserve.edu.greencity.rest.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.softserve.edu.greencity.rest.data.LanguagesCode;
import com.softserve.edu.greencity.rest.dto.ContentTypes;
import com.softserve.edu.greencity.rest.dto.KeyParameters;
import com.softserve.edu.greencity.rest.dto.MethodParameters;
import com.softserve.edu.greencity.rest.dto.RestParameters;
import com.softserve.edu.greencity.rest.entity.ErrorEntity;
import com.softserve.edu.greencity.rest.entity.GoogleSecurityEntity;
import com.softserve.edu.greencity.rest.entity.LogginedUserEntity;
import com.softserve.edu.greencity.rest.entity.UserDtoEntity;
import com.softserve.edu.greencity.rest.resources.GoogleSecurityResource;
import com.softserve.edu.greencity.rest.resources.UserDtoResource;
import com.softserve.edu.greencity.rest.resources.places.PlacesResource;
import com.softserve.edu.greencity.rest.services.habitstatistic.HabitStatisticService;
import com.softserve.edu.greencity.rest.services.habitstatistic.TodayHabitStatisticService;
import com.softserve.edu.greencity.rest.services.myhabits.MyHabitsService;

public class LogginedUserService {

    //
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    //
    protected LogginedUserEntity logginedUserEntity;
    private GoogleSecurityEntity googleSecurityEntity;
    private GoogleSecurityResource googleSecurityResource;
    private UserDtoEntity userDtoEntity;
    private UserDtoResource userDtoResource;
    private PlacesResource placesResource;
    private ErrorEntity error;


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

    protected RestParameters getHeaderParameters() {
        return new RestParameters()
                .addParameter(KeyParameters.ACCEPT, ContentTypes.ALL_TYPES.toString())
                .addParameter(KeyParameters.AUTHORIZATION, KeyParameters.BEARER.toString() + getLogginedUserEntity().getAccessToken());
    }

    protected RestParameters getLanguageParameter(LanguagesCode language) {
        return new RestParameters()
                .addParameter(KeyParameters.LANGUAGE, String.valueOf(language));
    }

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
                .addParameter(KeyParameters.AUTHORIZATION, KeyParameters.BEARER.toString() 
                             + getLogginedUserEntity().getAccessToken());
        //
        RestParameters urlParameters = new RestParameters()
                .addParameter(KeyParameters.ID_TOKEN, String.valueOf(getLogginedUserEntity().getUserId()));
        //
        logger.trace("send REST POST request for Google security authentication");
        GoogleSecurityEntity googleSecurityEntity = googleSecurityResource
                .httpGetAsEntity(methodParameters
                        .addUrlParameters(urlParameters)
                        .addHeaderParameters(headerParameters));
        //
        logger.trace("got REST POST response: " + googleSecurityEntity);
        logger.info("got REST POST response: " + googleSecurityEntity);
        return googleSecurityEntity;
    }

    //"http://***/user" -H "accept: */*" -H "Authorization: Bearer ***"
    /**
     * Getting User Dto Email Notification.
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
                .addParameter(KeyParameters.AUTHORIZATION, KeyParameters.BEARER.toString() 
                             + getLogginedUserEntity().getAccessToken());
        //
        logger.trace("send REST POST request for getting User Dto Email Notification");
        UserDtoEntity userDtoEntity = userDtoResource
                .httpGetAsEntity(methodParameters
                        .addHeaderParameters(headerParameters));
        //
        logger.trace("got REST POST response: " + userDtoEntity);
        logger.info("got REST POST response: " + userDtoEntity);
        return userDtoEntity;
    }

    // Business Logic

    public EconewsUserService gotoEconewsUserService() {
        return new EconewsUserService(logginedUserEntity);
    }

	public PlacesService gotoPlacesService() {
        return new PlacesService(logginedUserEntity);
    }

    public TipsTricksService gotoTipsTricksService() {
        return new TipsTricksService(logginedUserEntity);
    }

    public FavoritePlacesService gotoFavoritePlacesService() {
        return new FavoritePlacesService(logginedUserEntity);
    }

    public MyHabitsService gotoMyhabitsService() {
        return new MyHabitsService(logginedUserEntity);
    }

    public HabitStatisticService gotoHabitStatisticService() {
        return new HabitStatisticService(logginedUserEntity);
    }

    public TodayHabitStatisticService gotoTodayHabitStatisticService() {
        return new TodayHabitStatisticService(logginedUserEntity);
    }

    public AchievementService gotoAchievementService() {
        return new AchievementService(logginedUserEntity);
    }

    public GoalsService gotoGoalsService() {
        return new GoalsService(logginedUserEntity);
    }
}

