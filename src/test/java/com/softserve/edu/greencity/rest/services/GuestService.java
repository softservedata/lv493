package com.softserve.edu.greencity.rest.services;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.softserve.edu.greencity.rest.data.UnsuccessfulRegistration;
import com.softserve.edu.greencity.rest.data.User;
import com.softserve.edu.greencity.rest.dto.ContentTypes;
import com.softserve.edu.greencity.rest.dto.KeyParameters;
import com.softserve.edu.greencity.rest.dto.MethodParameters;
import com.softserve.edu.greencity.rest.dto.RestParameters;
import com.softserve.edu.greencity.rest.entity.LogginedUserEntity;
import com.softserve.edu.greencity.rest.entity.RegisterUserEntity;
import com.softserve.edu.greencity.rest.resources.SignUpResource;
import com.softserve.edu.greencity.rest.resources.SigninResource;
import com.softserve.edu.greencity.ui.data.Languages;
import com.softserve.edu.greencity.ui.tools.GetMail10MinTools;

public class GuestService {
    //
	private SigninResource signinResource;
	private SignUpResource signUpResource;
	protected RegisterUserEntity registerUserEntity;
	private GetMail10MinTools getMail10MinTools;
	private WebDriver driver;
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    public GuestService() {
    	signinResource = new SigninResource();
    	signUpResource = new SignUpResource();
    }
    
    // getters
    public RegisterUserEntity getRegisterUserEntity() {
        return registerUserEntity;
    }
    
    // Functional
    private String getTempEmail() {
        getMail10MinTools = new GetMail10MinTools(driver);
        String email = "";
        email = getMail10MinTools.getTempEmail();
        logger.info("temporary Email address for registration: " + email);
        return email;
    }
    
    public void verifyTempEmail() {
//      tmp = new GetMail10MinTools(driver);
        getMail10MinTools.verifyEmail();
        logger.info("verify Email successfully");
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
    
    public RegisterUserEntity successfulUserRegistration(Languages language, User user, WebDriver driver) {
        this.driver = driver;
        user.setEmail(getTempEmail());
        MethodParameters methodParameters = new MethodParameters()
                .addContentType(ContentTypes.APPLICATION_JSON);
        RestParameters mediaTypeParameters = new RestParameters()
                .addParameter(KeyParameters.EMAIL, user.getEmail())
                .addParameter(KeyParameters.LANG, language.toString())
                .addParameter(KeyParameters.NAME, user.getName())
                .addParameter(KeyParameters.PASSWORD, user.getPassword());
        RestParameters headerParameters = new RestParameters()
                .addParameter(KeyParameters.ACCEPT, ContentTypes.ALL_TYPES.toString());
        RegisterUserEntity registerUserEntity = signUpResource
                .httpPostAsEntity(methodParameters
                        .addMediaTypeParameters(mediaTypeParameters)
                        .addHeaderParameters(headerParameters));
        verifyTempEmail();
        return registerUserEntity;
    }
    
    public List<UnsuccessfulRegistration> unsuccessfulUserRegistration(Languages language, User user) {
        MethodParameters methodParameters = new MethodParameters()
                .addContentType(ContentTypes.APPLICATION_JSON);
        RestParameters mediaTypeParameters = new RestParameters()
                .addParameter(KeyParameters.EMAIL, user.getEmail())
                .addParameter(KeyParameters.LANG, language.toString())
                .addParameter(KeyParameters.NAME, user.getName())
                .addParameter(KeyParameters.PASSWORD, user.getPassword());
        RestParameters headerParameters = new RestParameters()
                .addParameter(KeyParameters.ACCEPT, ContentTypes.ALL_TYPES.toString());
        List<RegisterUserEntity> registerUserEntities = signUpResource
                .httpPostAsListEntity(methodParameters
                        .addMediaTypeParameters(mediaTypeParameters)
                        .addHeaderParameters(headerParameters));
        System.out.println("registerUserEntities: " + registerUserEntities);
        return UnsuccessfulRegistration.converToUnsuccessfulRegistrationList(registerUserEntities);
    }
    
}
