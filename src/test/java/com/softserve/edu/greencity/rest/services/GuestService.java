package com.softserve.edu.greencity.rest.services;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.softserve.edu.greencity.rest.data.User;
import com.softserve.edu.greencity.rest.data.VerifyEmail;
import com.softserve.edu.greencity.rest.data.VerifyEmailLinkAndId;
import com.softserve.edu.greencity.rest.data.jira.testcases.GC528Data;
import com.softserve.edu.greencity.rest.data.jira.testcases.GC531Data;
import com.softserve.edu.greencity.rest.data.jira.testcases.GC532Data;
import com.softserve.edu.greencity.rest.data.jira.testcases.GC533Data;
import com.softserve.edu.greencity.rest.data.jira.testcases.GC534Data;
import com.softserve.edu.greencity.rest.data.jira.testcases.GC535Data;
import com.softserve.edu.greencity.rest.data.jira.testcases.GC536Data;
import com.softserve.edu.greencity.rest.data.jira.testcases.GC537Data;
import com.softserve.edu.greencity.rest.data.jira.testcases.GC540Data;
import com.softserve.edu.greencity.rest.data.jira.testcases.GC541Data;
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

public class GuestService {
    //
	private SigninResource signinResource;
    private SignUpResource signUpResource;
    private RegisterUserEntity registerUserEntity;
    private GetMail10MinTools getMail10MinTools;
    private VerifyEmailEntity verifyEmailEntity;
    private VerifyEmailResource verifyEmailResource;
	private GC528Data resultGC528Data;
    private GC531Data resultGC531Data;
    private GC533Data resultGC533Data;
    private GC532Data resultGC532Data;
    private GC534Data resultGC534Data;
    private GC535Data resultGC535Data;
    private GC536Data resultGC536Data;
    private GC537Data resultGC537Data;
    private GC540Data resultGC540Data;
    private GC541Data resultGC541Data;
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
    /**
     * Getting a temporary Email address for registration.
     * @return String
     */
    private String getTempEmail() {
        getMail10MinTools = new GetMail10MinTools(driver);
        String email = "";
        email = getMail10MinTools.getTempEmail();
        logger.info("temporary Email address for registration: " + email);
        return email;
    }

    /**
     * Verify a temporary Email.
     * @return
     */
    private String verifyTempEmail() {
        String urlLink = getMail10MinTools.verifyEmail();
        logger.info("verify Email successfully");
        registerUserEntity.setHttpsAfterVerify(getMail10MinTools.getHttpsAfterVerify());
        return urlLink;
    }

    /**
     * Getting a URL from a letter for Verify.
     * @return
     */
    private String getVerifyURL() {
        String urlLink = getMail10MinTools.getVerifyUrlInMail();
        logger.info("got 'verify mail' link");
        return urlLink;
    }

    // Business Logic

	// "https://***/ownSecurity/signIn" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"email\": \"***\", \"password\": \"***\"}"
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

    // "https://**/ownSecurity/signUp" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"email\": \"****\", \"lang\": \"En\", \"name\": \"****\", \"password\": \"***\"}"
    /**
     * Successful User Registration and verify Email in temp mail-box.
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
        //
        logger.trace("forming REST request for successfully user registration");
        MethodParameters methodParameters = new MethodParameters().addContentType(ContentTypes.APPLICATION_JSON);
        RestParameters mediaTypeParameters = new RestParameters()
                .addParameter(KeyParameters.EMAIL, user.getEmail())
                .addParameter(KeyParameters.LANG, language.toString())
                .addParameter(KeyParameters.NAME, user.getName())
                .addParameter(KeyParameters.PASSWORD, user.getPassword());
        RestParameters headerParameters = new RestParameters()
                .addParameter(KeyParameters.ACCEPT, ContentTypes.ALL_TYPES.toString());
        //
        logger.trace("send REST POST request for successfully user registration");
        registerUserEntity = signUpResource
                .httpPostAsEntity(methodParameters
                        .addMediaTypeParameters(mediaTypeParameters)
                        .addHeaderParameters(headerParameters));
        //
        logger.trace("got REST POST response: " + registerUserEntity);
        registerUserEntity.setVerifyEmailLinkAndId(new VerifyEmailLinkAndId(verifyTempEmail()));
        logger.info("succsessfully verify user's email and got additional link for verify: "
                + registerUserEntity.getVerifyEmailLinkAndId().getVerifyEmailURL());
        return registerUserEntity;
    }
    

    /**
     * Successful User Registration without verify Email in temp mail-box and getting verify URL.
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
        //
        logger.trace("forming REST request for successfully user registration");
        MethodParameters methodParameters = new MethodParameters()
                .addContentType(ContentTypes.APPLICATION_JSON);
        RestParameters mediaTypeParameters = new RestParameters()
                .addParameter(KeyParameters.EMAIL, user.getEmail())
                .addParameter(KeyParameters.LANG, language.toString())
                .addParameter(KeyParameters.NAME, user.getName())
                .addParameter(KeyParameters.PASSWORD, user.getPassword());
        RestParameters headerParameters = new RestParameters()
                .addParameter(KeyParameters.ACCEPT, ContentTypes.ALL_TYPES.toString());
        //
        logger.trace("send REST POST request for successfully user registration");
        registerUserEntity = signUpResource
                .httpPostAsEntity(methodParameters
                        .addMediaTypeParameters(mediaTypeParameters)
                        .addHeaderParameters(headerParameters));
        //
        logger.trace("got REST POST response: " + registerUserEntity);
        registerUserEntity.setVerifyEmailLinkAndId(new VerifyEmailLinkAndId(getVerifyURL()));
        logger.info("succsessfully verify user's email and got additional link for verify: "
                + registerUserEntity.getVerifyEmailLinkAndId().getVerifyEmailURL());
        return this;
    }

    /**
     * Unsuccessful User Registration with invalid user's credentials and getting a response message.
     * @param language Enum
     * @param user User
     * @return RegisterUserEntity
     */
    public RegisterUserEntity unsuccessfulUserRegistration(Languages language, User user) {
        List<RegisterUserEntity> registerUserEntities;
        logger.debug("start unsuccessfulUserRegistration with parameters: Languages " + language + "; user: " + user);
        logger.trace("preparing REST request for existing user registration");
        logger.trace("forming REST request for existing user registration");
        MethodParameters methodParameters = new MethodParameters()
                .addContentType(ContentTypes.APPLICATION_JSON);
        RestParameters mediaTypeParameters = new RestParameters()
                .addParameter(KeyParameters.EMAIL, user.getEmail())
                .addParameter(KeyParameters.LANG, language.toString())
                .addParameter(KeyParameters.NAME, user.getName())
                .addParameter(KeyParameters.PASSWORD, user.getPassword());
        RestParameters headerParameters = new RestParameters()
                .addParameter(KeyParameters.ACCEPT, ContentTypes.ALL_TYPES.toString());
        //
        logger.trace("send REST POST request for existing user registration");
        registerUserEntities = signUpResource
                .httpPostAsListEntity(methodParameters
                        .addMediaTypeParameters(mediaTypeParameters)
                        .addHeaderParameters(headerParameters));
        //
        logger.trace("got REST POST response: name = " + registerUserEntities.get(0).getName() 
                + "; message = " + registerUserEntities.get(0).getMessage());
        logger.info("got REST POST response: name = " + registerUserEntities.get(0).getName() 
                + "; message = " + registerUserEntities.get(0).getMessage());
        return registerUserEntities.get(0);
    }

    // http://***/ownSecurity/verifyEmail?token=***&user_id=***" -H "accept: */*
    /**
     * Verifying user email, if a user didn't do that 'verify' in incoming letter.
     * @return VerifyEmail
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
        RestParameters headerParameters = new RestParameters()
                .addParameter(KeyParameters.ACCEPT, ContentTypes.ALL_TYPES.toString());
        //
        logger.trace("send REST POST request for verify Email address");
        this.verifyEmailEntity = verifyEmailResource
                .httpGetAsEntity(methodParameters
                        .addUrlParameters(urlParameters)
                        .addHeaderParameters(headerParameters));
        //
        logger.info("successful verify Email address");
        return VerifyEmail.converToVerifyEmail(verifyEmailEntity);
    }
    
    // 
    /**
     * Unsuccessful User Registration (Jira Story: GC-184/GC-468; Test GC-528)
     * @param language Enum
     * @param user User
     * @return GC528Data
     */
    public GC528Data userStory184Test528(Languages language, User user) {
        List<RegisterUserEntity> registerUserEntities;
        resultGC528Data = new GC528Data(user);
        //
        logger.debug("start userStory184Test528 with parameters: Languages " + language + "; user: " + user);
        logger.trace("preparing REST request for user registration");
        logger.trace("forming REST request for user registration");
        MethodParameters methodParameters = new MethodParameters()
                .addContentType(ContentTypes.APPLICATION_JSON);
        RestParameters mediaTypeParameters = new RestParameters()
                .addParameter(KeyParameters.EMAIL, user.getEmail())
                .addParameter(KeyParameters.LANG, language.toString())
                .addParameter(KeyParameters.NAME, user.getName())
                .addParameter(KeyParameters.PASSWORD, user.getPassword());
        RestParameters headerParameters = new RestParameters()
                .addParameter(KeyParameters.ACCEPT, ContentTypes.ALL_TYPES.toString());
        //
        logger.trace("send REST POST request for user registration");
        registerUserEntities = signUpResource
                .httpPostAsListEntity(methodParameters
                        .addMediaTypeParameters(mediaTypeParameters)
                        .addHeaderParameters(headerParameters));
        //
        resultGC528Data.setName(registerUserEntities.get(0).getName())
                       .setMessage(registerUserEntities.get(0).getMessage());
//                       .getResponseCode(registerUserEntities.);
        logger.trace("got REST POST response: name = " + resultGC528Data.getName() 
                    + "; message = " + resultGC528Data.getMessage());
        logger.info("got REST POST response: name = " + resultGC528Data.getName() 
                    + "; message = " + resultGC528Data.getMessage());
        return resultGC528Data;
    }
    
    /**
     * Unsuccessful User Registration (Jira Story: GC-184/GC-468; Test GC-532)
     * @param language Enum
     * @param user User
     * @return GC532Data
     */
    public GC532Data userStory184Test532(Languages language, User user) {
        List<RegisterUserEntity> registerUserEntities;
        resultGC532Data = new GC532Data();
        //
        logger.debug("start userStory184Test532 with parameters: Languages " + language + "; user: " + user);
        logger.trace("preparing REST request for user registration");
        logger.trace("forming REST request for user registration");
        MethodParameters methodParameters = new MethodParameters()
                .addContentType(ContentTypes.APPLICATION_JSON);
        RestParameters mediaTypeParameters = new RestParameters()
                .addParameter(KeyParameters.EMAIL, user.getEmail())
                .addParameter(KeyParameters.LANG, language.toString())
                .addParameter(KeyParameters.NAME, user.getName())
                .addParameter(KeyParameters.PASSWORD, user.getPassword());
        RestParameters headerParameters = new RestParameters()
                .addParameter(KeyParameters.ACCEPT, ContentTypes.ALL_TYPES.toString());
        //
        logger.trace("send REST POST request for user registration");
        registerUserEntities = signUpResource
                .httpPostAsListEntity(methodParameters
                        .addMediaTypeParameters(mediaTypeParameters)
                        .addHeaderParameters(headerParameters));
        //
        resultGC532Data.setName(registerUserEntities.get(0).getName())
                       .setMessage(registerUserEntities.get(0).getMessage());
        logger.trace("got REST POST response: name = " + registerUserEntities.get(0).getName() 
                    + "; message = " + registerUserEntities.get(0).getMessage());
        logger.info("got REST POST response: name = " + registerUserEntities.get(0).getName() 
                    + "; message = " + registerUserEntities.get(0).getMessage());
        return resultGC532Data;
    }

    /**
     * Successful User Registration (Jira Story: GC-184/GC-468; Test GC-531)
     * @param language
     * @param user
     * @param driver
     * @return
     */
    public GC531Data userStory184Test531(Languages language, User user, WebDriver driver) {
        logger.debug("start userStory468Test531 with parameters: Languages " + language + "; user: " + user + "; WebDriver");
        logger.trace("preparing REST request for successfully user registration");
        this.driver = driver;
        user.setEmail(getTempEmail());
        //
        logger.trace("forming REST request for successfully user registration");
        MethodParameters methodParameters = new MethodParameters()
                .addContentType(ContentTypes.APPLICATION_JSON);
        RestParameters mediaTypeParameters = new RestParameters()
                .addParameter(KeyParameters.EMAIL, user.getEmail())
                .addParameter(KeyParameters.LANG, language.toString())
                .addParameter(KeyParameters.NAME, user.getName())
                .addParameter(KeyParameters.PASSWORD, user.getPassword());
        RestParameters headerParameters = new RestParameters()
                .addParameter(KeyParameters.ACCEPT, ContentTypes.ALL_TYPES.toString());
        //
        logger.trace("send REST POST request for successfully user registration");
        registerUserEntity = signUpResource
                .httpPostAsEntity(methodParameters
                        .addMediaTypeParameters(mediaTypeParameters)
                        .addHeaderParameters(headerParameters));
        logger.trace("got REST POST response: " + registerUserEntity);
        //
        registerUserEntity.setVerifyEmailLinkAndId(new VerifyEmailLinkAndId(verifyTempEmail()));
        resultGC531Data = new GC531Data(registerUserEntity);
        logger.info("succsessfully verify user's email and got additional link for verify: "
                + registerUserEntity.getVerifyEmailLinkAndId().getVerifyEmailURL());
        return resultGC531Data;
    }
    
    /**
     * User Registration without verify email and try logging (Jira Story: GC-184/GC-468; Test GC-533).
     * @param language Enum
     * @param user User
     * @param driver WebDriver
     * @return GC533Data
     */
    public GC533Data userStory184Test533(Languages language, User user, WebDriver driver) {
        logger.debug("start userStory184Test533 with parameters: Languages " + language + "; user: " + user + "; WebDriver");
        logger.trace("preparing REST request for user registration");
        this.driver = driver;
        user.setEmail(getTempEmail());
        resultGC533Data = new GC533Data(user);
        //
        logger.trace("forming REST request for user registration");
        MethodParameters methodParameters = new MethodParameters()
                .addContentType(ContentTypes.APPLICATION_JSON);
        RestParameters mediaTypeParameters = new RestParameters()
                .addParameter(KeyParameters.EMAIL, user.getEmail())
                .addParameter(KeyParameters.LANG, language.toString())
                .addParameter(KeyParameters.NAME, user.getName())
                .addParameter(KeyParameters.PASSWORD, user.getPassword());
        RestParameters headerParameters = new RestParameters()
                .addParameter(KeyParameters.ACCEPT, ContentTypes.ALL_TYPES.toString());
        //
        logger.trace("send REST POST request for user registration");
        registerUserEntity = signUpResource
                .httpPostAsEntity(methodParameters
                        .addMediaTypeParameters(mediaTypeParameters)
                        .addHeaderParameters(headerParameters));
        //
        logger.trace("got REST POST response: " + registerUserEntity);
        registerUserEntity.setVerifyEmailLinkAndId(new VerifyEmailLinkAndId(getVerifyURL()));
        logger.info("succsessfully verify user's email and got additional link for verify: "
                + registerUserEntity.getVerifyEmailLinkAndId().getVerifyEmailURL());
        resultGC533Data.setOwnRegistrations(registerUserEntity.isOwnRegistrations());
        //
        logger.trace("preparing REST request for unsuccessfully user logging");
        methodParameters = new MethodParameters()
                .addContentType(ContentTypes.APPLICATION_JSON);
        logger.trace("forming REST request for unsuccessfully user logging");
        mediaTypeParameters = new RestParameters()
                .addParameter(KeyParameters.EMAIL, user.getEmail())
                .addParameter(KeyParameters.PASSWORD, user.getPassword());
        headerParameters = new RestParameters()
                .addParameter(KeyParameters.ACCEPT, ContentTypes.ALL_TYPES.toString());
        //
        logger.trace("send REST POST request for unsuccessfully user logging");
        LogginedUserEntity logginedUserEntity  = signinResource
                .httpPostAsEntity(methodParameters
                        .addMediaTypeParameters(mediaTypeParameters)
                        .addHeaderParameters(headerParameters));
        //
        logger.trace("got REST POST response: " + logginedUserEntity.getMessage());
        logger.info("unsuccessful logging");
        resultGC533Data.setMessage(logginedUserEntity.getMessage());
        //
        return resultGC533Data;
    }
    
    /**
     * Unsuccessful User Registration (Jira Story: GC-184/GC-468; Test GC-534).
     * @param language Enum
     * @param user User
     * @return GC534Data
     */
    public GC534Data userStory184Test534(Languages language, User user) {
        List<RegisterUserEntity> registerUserEntities;
        resultGC534Data = new GC534Data(user);
        //
        logger.debug("start userStory184Test534 with parameters: Languages " + language + "; user: " + user);
        logger.trace("preparing REST request for user registration");
        logger.trace("forming REST request for user registration");
        MethodParameters methodParameters = new MethodParameters()
                .addContentType(ContentTypes.APPLICATION_JSON);
        RestParameters mediaTypeParameters = new RestParameters()
                .addParameter(KeyParameters.EMAIL, user.getEmail())
                .addParameter(KeyParameters.LANG, language.toString())
                .addParameter(KeyParameters.NAME, user.getName())
                .addParameter(KeyParameters.PASSWORD, user.getPassword());
        RestParameters headerParameters = new RestParameters()
                .addParameter(KeyParameters.ACCEPT, ContentTypes.ALL_TYPES.toString());
        //
        logger.trace("send REST POST request for user registration");
        registerUserEntities = signUpResource
                .httpPostAsListEntity(methodParameters
                        .addMediaTypeParameters(mediaTypeParameters)
                        .addHeaderParameters(headerParameters));
        //
        resultGC534Data.setName(registerUserEntities.get(0).getName())
                       .setMessage(registerUserEntities.get(0).getMessage());
//                       .getResponseCode(registerUserEntities.);
        logger.trace("got REST POST response: name = " + resultGC534Data.getName() 
                    + "; message = " + resultGC534Data.getMessage());
        logger.info("got REST POST response: name = " + resultGC534Data.getName() 
                    + "; message = " + resultGC534Data.getMessage());
        return resultGC534Data;
    }
    
    /**
     * Unsuccessful User Registration (Jira Story: GC-184/GC-468; Test GC-535).
     * @param language Enum
     * @param user User
     * @return GC535Data
     */
    public GC535Data userStory184Test535(Languages language, User user) {
        List<RegisterUserEntity> registerUserEntities;
        resultGC535Data = new GC535Data(user);
        //
        logger.debug("start userStory184Test535 with parameters: Languages " + language + "; user: " + user);
        logger.trace("preparing REST request for user registration");
        logger.trace("forming REST request for user registration");
        MethodParameters methodParameters = new MethodParameters()
                .addContentType(ContentTypes.APPLICATION_JSON);
        RestParameters mediaTypeParameters = new RestParameters()
                .addParameter(KeyParameters.EMAIL, user.getEmail())
                .addParameter(KeyParameters.LANG, language.toString())
                .addParameter(KeyParameters.NAME, user.getName())
                .addParameter(KeyParameters.PASSWORD, user.getPassword());
        RestParameters headerParameters = new RestParameters()
                .addParameter(KeyParameters.ACCEPT, ContentTypes.ALL_TYPES.toString());
        //
        logger.trace("send REST POST request for user registration");
        registerUserEntities = signUpResource
                .httpPostAsListEntity(methodParameters
                        .addMediaTypeParameters(mediaTypeParameters)
                        .addHeaderParameters(headerParameters));
        //
        resultGC535Data.setName(registerUserEntities.get(0).getName())
                       .setMessage(registerUserEntities.get(0).getMessage());
//                       .getResponseCode(registerUserEntities.);
        logger.trace("got REST POST response: name = " + resultGC535Data.getName() 
                    + "; message = " + resultGC535Data.getMessage());
        logger.info("got REST POST response: name = " + resultGC535Data.getName() 
                    + "; message = " + resultGC535Data.getMessage());
        return resultGC535Data;
    }
    
    /**
     * Unsuccessful User Registration (Jira Story: GC-184/GC-468; Test GC-536)
     * @param language Enum
     * @param user User
     * @return GC536Data
     */
    public GC536Data userStory184Test536(Languages language, User user) {
        List<RegisterUserEntity> registerUserEntities;
        resultGC536Data = new GC536Data(user);
        //
        logger.debug("start userStory184Test536 with parameters: Languages " + language + "; user: " + user);
        logger.trace("preparing REST request for user registration");
        logger.trace("forming REST request for user registration");
        MethodParameters methodParameters = new MethodParameters()
                .addContentType(ContentTypes.APPLICATION_JSON);
        RestParameters mediaTypeParameters = new RestParameters()
                .addParameter(KeyParameters.EMAIL, user.getEmail())
                .addParameter(KeyParameters.LANG, language.toString())
                .addParameter(KeyParameters.NAME, user.getName())
                .addParameter(KeyParameters.PASSWORD, user.getPassword());
        RestParameters headerParameters = new RestParameters()
                .addParameter(KeyParameters.ACCEPT, ContentTypes.ALL_TYPES.toString());
        //
        logger.trace("send REST POST request for user registration");
        registerUserEntities = signUpResource
                .httpPostAsListEntity(methodParameters
                        .addMediaTypeParameters(mediaTypeParameters)
                        .addHeaderParameters(headerParameters));
        //
        resultGC536Data.setName(registerUserEntities.get(0).getName())
                       .setMessage(registerUserEntities.get(0).getMessage());
//                       .getResponseCode(registerUserEntities.);
        logger.trace("got REST POST response: name = " + resultGC536Data.getName() 
                    + "; message = " + resultGC536Data.getMessage());
        logger.info("got REST POST response: name = " + resultGC536Data.getName() 
                    + "; message = " + resultGC536Data.getMessage());
        return resultGC536Data;
    }
    
    /**
     * Unsuccessful User Registration (Jira Story: GC-184/GC-468; Test GC-537)
     * @param language Enum
     * @param user User
     * @return GC537Data
     */
    public GC537Data userStory184Test537(Languages language, User user) {
        List<RegisterUserEntity> registerUserEntities;
        resultGC537Data = new GC537Data(user);
        //
        logger.debug("start userStory184Test537 with parameters: Languages " + language + "; user: " + user);
        logger.trace("preparing REST request for user registration");
        logger.trace("forming REST request for user registration");
        MethodParameters methodParameters = new MethodParameters()
                .addContentType(ContentTypes.APPLICATION_JSON);
        RestParameters mediaTypeParameters = new RestParameters()
                .addParameter(KeyParameters.EMAIL, user.getEmail())
                .addParameter(KeyParameters.LANG, language.toString())
                .addParameter(KeyParameters.NAME, user.getName())
                .addParameter(KeyParameters.PASSWORD, user.getPassword());
        RestParameters headerParameters = new RestParameters()
                .addParameter(KeyParameters.ACCEPT, ContentTypes.ALL_TYPES.toString());
        //
        logger.trace("send REST POST request for user registration");
        registerUserEntities = signUpResource
                .httpPostAsListEntity(methodParameters
                        .addMediaTypeParameters(mediaTypeParameters)
                        .addHeaderParameters(headerParameters));
        //
        resultGC537Data.setName(registerUserEntities.get(0).getName())
                       .setMessage(registerUserEntities.get(0).getMessage());
//                       .getResponseCode(registerUserEntities.);
        logger.trace("got REST POST response: name = " + resultGC537Data.getName() 
                    + "; message = " + resultGC537Data.getMessage());
        logger.info("got REST POST response: name = " + resultGC537Data.getName() 
                    + "; message = " + resultGC537Data.getMessage());
        return resultGC537Data;
    }
    
    /**
     * Unsuccessful User Registration (Jira Story: GC-184/GC-468; Test GC-540)
     * @param language Enum
     * @param user User
     * @return GC540Data
     */
    public GC540Data userStory184Test540(Languages language, User user) {
//        List<RegisterUserEntity> registerUserEntities;
        resultGC540Data = new GC540Data(user);
        //
        logger.debug("start userStory184Test540 with parameters: Languages " + language + "; user: " + user);
        logger.trace("preparing REST request for user registration");
        logger.trace("forming REST request for user registration");
        MethodParameters methodParameters = new MethodParameters()
                .addContentType(ContentTypes.APPLICATION_JSON);
        RestParameters mediaTypeParameters = new RestParameters()
                .addParameter(KeyParameters.EMAIL, user.getEmail())
                .addParameter(KeyParameters.LANG, language.toString())
                .addParameter(KeyParameters.NAME, user.getName())
                .addParameter(KeyParameters.PASSWORD, user.getPassword());
        RestParameters headerParameters = new RestParameters()
                .addParameter(KeyParameters.ACCEPT, ContentTypes.ALL_TYPES.toString());
        //
        logger.trace("send REST POST request for user registration");
        registerUserEntity = signUpResource
                .httpPostAsEntity(methodParameters
                        .addMediaTypeParameters(mediaTypeParameters)
                        .addHeaderParameters(headerParameters));
        //
        resultGC540Data.setName(registerUserEntity.getName())
                       .setMessage(registerUserEntity.getMessage());
//                       .getResponseCode(registerUserEntities.);
        logger.trace("got REST POST response: name = " + resultGC540Data.getName() 
                    + "; message = " + resultGC540Data.getMessage());
        logger.info("got REST POST response: name = " + resultGC540Data.getName() 
                    + "; message = " + resultGC540Data.getMessage());
        return resultGC540Data;
    }
    
    /**
     * Unsuccessful User Registration (Jira Story: GC-184/GC-468; Test GC-541)
     * @param language Enum
     * @param user User
     * @return GC541Data
     */
    public GC541Data userStory184Test541(Languages language, User user) {
        List<RegisterUserEntity> registerUserEntities;
        resultGC541Data = new GC541Data(user);
        //
        logger.debug("start userStory184Test541 with parameters: Languages " + language + "; user: " + user);
        logger.trace("preparing REST request for user registration");
        logger.trace("forming REST request for user registration");
        MethodParameters methodParameters = new MethodParameters()
                .addContentType(ContentTypes.APPLICATION_JSON);
        RestParameters mediaTypeParameters = new RestParameters()
                .addParameter(KeyParameters.EMAIL, user.getEmail())
                .addParameter(KeyParameters.LANG, language.toString())
                .addParameter(KeyParameters.NAME, user.getName())
                .addParameter(KeyParameters.PASSWORD, user.getPassword());
        RestParameters headerParameters = new RestParameters()
                .addParameter(KeyParameters.ACCEPT, ContentTypes.ALL_TYPES.toString());
        //
        logger.trace("send REST POST request for user registration");
        registerUserEntities = signUpResource
                .httpPostAsListEntity(methodParameters
                        .addMediaTypeParameters(mediaTypeParameters)
                        .addHeaderParameters(headerParameters));
        //
        resultGC541Data.setName(registerUserEntities.get(0).getName())
                       .setMessage(registerUserEntities.get(0).getMessage());
//                       .getResponseCode(registerUserEntities.);
        logger.trace("got REST POST response: name = " + resultGC541Data.getName() 
                    + "; message = " + resultGC541Data.getMessage());
        logger.info("got REST POST response: name = " + resultGC541Data.getName() 
                    + "; message = " + resultGC541Data.getMessage());
        return resultGC541Data;
    }

    public EconewsGuestService gotoEconewsGuestService() {
        return new EconewsGuestService();
    }
    
    public PlacesGuestService gotoPlacesGuestService() {
        return new PlacesGuestService();
    }
    
    public TipsGuestService gotoTipsTricksGuestService() {
        return new TipsGuestService();
    }
}
