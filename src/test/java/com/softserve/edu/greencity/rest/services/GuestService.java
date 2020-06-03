package com.softserve.edu.greencity.rest.services;

import com.softserve.edu.greencity.rest.data.User;
import com.softserve.edu.greencity.rest.data.VerifyEmail;
import com.softserve.edu.greencity.rest.data.VerifyEmailLinkAndId;
import com.softserve.edu.greencity.rest.dto.ContentTypes;
import com.softserve.edu.greencity.rest.dto.KeyParameters;
import com.softserve.edu.greencity.rest.dto.MethodParameters;
import com.softserve.edu.greencity.rest.dto.RestParameters;
import com.softserve.edu.greencity.rest.entity.LogginedUserEntity;
import com.softserve.edu.greencity.rest.entity.RegisterUserEntity;
import com.softserve.edu.greencity.rest.entity.VerifyEmailEntity;
import com.softserve.edu.greencity.rest.entity.places.PlaceEntity;
import com.softserve.edu.greencity.rest.resources.SignUpResource;
import com.softserve.edu.greencity.rest.resources.SigninResource;
import com.softserve.edu.greencity.rest.resources.VerifyEmailResource;
import com.softserve.edu.greencity.rest.resources.places.FavoritePlaceResources;
import com.softserve.edu.greencity.rest.tools.GetMail10MinTools;
import com.softserve.edu.greencity.ui.data.Languages;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class GuestService {
    //
	private SigninResource signinResource;
    private SignUpResource signUpResource;
    private RegisterUserEntity registerUserEntity;
    private GetMail10MinTools getMail10MinTools;
    private VerifyEmailEntity verifyEmailEntity;
    private VerifyEmailResource verifyEmailResource;
    private WebDriver driver;
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());


    private PlaceEntity placeEntity;
    private FavoritePlaceResources favoritePlaceResources;

    public GuestService() {
        signinResource = new SigninResource();
        signUpResource = new SignUpResource();
        placeEntity = new PlaceEntity();
        favoritePlaceResources = new FavoritePlaceResources();
    }

//     getters
    private RegisterUserEntity getRegisterUserEntity() {
        return registerUserEntity;
    }

    private VerifyEmailResource getVerifyEmailResource() {
        verifyEmailResource = new VerifyEmailResource();
        return verifyEmailResource;
    }

    private VerifyEmailEntity getVerifyEmailEntity() {
        return verifyEmailEntity;
    }

    // Functional
    private String getTempEmail() {
        getMail10MinTools = new GetMail10MinTools(driver);
        String email = "";
        email = getMail10MinTools.getTempEmail();
        logger.info("temporary Email address for registration: " + email);
        return email;
    }

    private String verifyTempEmail() {
        String urlLink = getMail10MinTools.verifyEmail();
        logger.info("verify Email successfully");
        return urlLink;
    }

    private String getVerifyURL() {
        String urlLink = getMail10MinTools.getVerifyUrlInMail();
        logger.info("got 'verify mail' link");
        return urlLink;
    }

    // Business Logic

    /**
     * Successful User Login
     * @param user
     * @return LogginedUserService
     */
    public LogginedUserService successfulUserLogin(User user) {
        logger.debug("start successfulUserLogin with parameters: user = " + user);
        logger.trace("preparing REST request for successfully user registration");
        MethodParameters methodParameters = new MethodParameters().addContentType(ContentTypes.APPLICATION_JSON);
        logger.trace("forming REST request for successfully user logging");
        RestParameters mediaTypeParameters = new RestParameters().addParameter(KeyParameters.EMAIL, user.getEmail())
                .addParameter(KeyParameters.PASSWORD, user.getPassword());
        RestParameters headerParameters = new RestParameters().addParameter(KeyParameters.ACCEPT, ContentTypes.ALL_TYPES.toString());
        logger.trace("send REST POST request for successfully user logging");
        LogginedUserEntity logginedUserEntity = signinResource
                .httpPostAsEntity(methodParameters.addMediaTypeParameters(mediaTypeParameters).addHeaderParameters(headerParameters));
        logger.trace("got REST POST response: " + logginedUserEntity);
        logger.info("successful logging");
        return new LogginedUserService(logginedUserEntity);
    }

    /**
     * Successful User Registration and verify Email in temp mail-box and get
     * VerifyURL.
     * @param language Enum
     * @param user User
     * @param driver WebDriver
     * @return RegisterUserEntity
     */
    public RegisterUserEntity successfulUserRegistration(Languages language, User user, WebDriver driver) {
        logger.debug("start successfulUserRegistration with parameters: Languages " + language + "; user: " + user + "; WebDriver");
        logger.trace("preparing REST request for successfully user registration");
        this.driver = driver;
        user.setEmail(getTempEmail());
        logger.trace("forming REST request for successfully user registration");
        MethodParameters methodParameters = new MethodParameters().addContentType(ContentTypes.APPLICATION_JSON);
        RestParameters mediaTypeParameters = new RestParameters().addParameter(KeyParameters.EMAIL, user.getEmail())
                .addParameter(KeyParameters.LANG, language.toString()).addParameter(KeyParameters.NAME, user.getName())
                .addParameter(KeyParameters.PASSWORD, user.getPassword());
        RestParameters headerParameters = new RestParameters().addParameter(KeyParameters.ACCEPT, ContentTypes.ALL_TYPES.toString());
        logger.trace("send REST POST request for successfully user registration");
        registerUserEntity = signUpResource
                .httpPostAsEntity(methodParameters.addMediaTypeParameters(mediaTypeParameters).addHeaderParameters(headerParameters));
        logger.trace("got REST POST response: " + registerUserEntity);
        registerUserEntity.setVerifyEmailLinkAndId(new VerifyEmailLinkAndId(verifyTempEmail()));
        logger.info("succsessfully verify user's email and got additional link for verify: "
                + registerUserEntity.getVerifyEmailLinkAndId().getVerifyEmailURL());
        return registerUserEntity;
    }

    /**
     * Successful User Registration without verify Email in temp mail-box and get
     * VerifyURL.
     * @param language Enum
     * @param user User
     * @param driver WebDriver
     * @return GuestService
     */
    public GuestService successfulUserRegistration2(Languages language, User user, WebDriver driver) {
        logger.debug("start successfulUserRegistration2 with parameters: Languages " + language + "; user: " + user + "; WebDriver");
        logger.trace("preparing REST request for successfully user registration");
        this.driver = driver;
        user.setEmail(getTempEmail());
        logger.trace("forming REST request for successfully user registration");
        MethodParameters methodParameters = new MethodParameters().addContentType(ContentTypes.APPLICATION_JSON);
        RestParameters mediaTypeParameters = new RestParameters().addParameter(KeyParameters.EMAIL, user.getEmail())
                .addParameter(KeyParameters.LANG, language.toString()).addParameter(KeyParameters.NAME, user.getName())
                .addParameter(KeyParameters.PASSWORD, user.getPassword());
        RestParameters headerParameters = new RestParameters().addParameter(KeyParameters.ACCEPT, ContentTypes.ALL_TYPES.toString());
        logger.trace("send REST POST request for successfully user registration");
        registerUserEntity = signUpResource
                .httpPostAsEntity(methodParameters.addMediaTypeParameters(mediaTypeParameters).addHeaderParameters(headerParameters));
        logger.trace("got REST POST response: " + registerUserEntity);
        registerUserEntity.setVerifyEmailLinkAndId(new VerifyEmailLinkAndId(getVerifyURL()));
        logger.info("succsessfully verify user's email and got additional link for verify: "
                + registerUserEntity.getVerifyEmailLinkAndId().getVerifyEmailURL());
        return this;
    }

    /**
     * Unsuccessful User Registration
     * @param language Enum
     * @param user User
     * @return String
     */
    public RegisterUserEntity unsuccessfulUserRegistration(Languages language, User user) {
        List<RegisterUserEntity> registerUserEntities;
        logger.debug("start unsuccessfulUserRegistration with parameters: Languages " + language + "; user: " + user);
        logger.trace("preparing REST request for existing user registration");
        logger.trace("forming REST request for existing user registration");
        MethodParameters methodParameters = new MethodParameters().addContentType(ContentTypes.APPLICATION_JSON);
        RestParameters mediaTypeParameters = new RestParameters().addParameter(KeyParameters.EMAIL, user.getEmail())
                .addParameter(KeyParameters.LANG, language.toString()).addParameter(KeyParameters.NAME, user.getName())
                .addParameter(KeyParameters.PASSWORD, user.getPassword());
        RestParameters headerParameters = new RestParameters().addParameter(KeyParameters.ACCEPT, ContentTypes.ALL_TYPES.toString());
        logger.trace("send REST POST request for existing user registration");
        registerUserEntities = signUpResource
                .httpPostAsListEntity(methodParameters.addMediaTypeParameters(mediaTypeParameters).addHeaderParameters(headerParameters));
        logger.trace("got REST POST response: " + registerUserEntities.get(0).getMessage());
        logger.info("got REST POST response: " + registerUserEntities.get(0).getMessage());
        return registerUserEntities.get(0);
    }

    // http://***/ownSecurity/verifyEmail?token=***&user_id=***" -H "accept: */*
    /**
     * Verifying user email, if a user didn't do that 'verify' in incoming letter.
     * @return
     */
    public VerifyEmail verifyEmail() {
        logger.debug("start verify Email address");
        logger.trace("preparing REST request for verify Email address");
        logger.trace("forming REST request for verify Email address");
        MethodParameters methodParameters = new MethodParameters();
        getVerifyEmailResource();
        //
        RestParameters urlParameters = new RestParameters()
                .addParameter(KeyParameters.TOKEN, String.valueOf(registerUserEntity.getVerifyEmailLinkAndId().getToken()))
                .addParameter(KeyParameters.USER_ID2, String.valueOf(registerUserEntity.getVerifyEmailLinkAndId().getId()));
        //
        RestParameters headerParameters = new RestParameters().addParameter(KeyParameters.ACCEPT, ContentTypes.ALL_TYPES.toString());
        //
        logger.trace("send REST POST request for verify Email address");
        this.verifyEmailEntity = verifyEmailResource
                .httpGetAsEntity(methodParameters.addUrlParameters(urlParameters).addHeaderParameters(headerParameters));
        //
        logger.info("successful verify Email address");
        return VerifyEmail.converToVerifyEmail(verifyEmailEntity);
    }

    public EcoNewsGuestService gotoEconewsGuestService() {
        return new EcoNewsGuestService();
    }

}
