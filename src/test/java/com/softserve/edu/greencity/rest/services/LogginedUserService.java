package com.softserve.edu.greencity.rest.services;

import com.softserve.edu.greencity.rest.data.VerifyEmail;
import com.softserve.edu.greencity.rest.dto.ContentTypes;
import com.softserve.edu.greencity.rest.dto.KeyParameters;
import com.softserve.edu.greencity.rest.dto.MethodParameters;
import com.softserve.edu.greencity.rest.dto.RestParameters;
import com.softserve.edu.greencity.rest.entity.GoogleSecurityEntity;
import com.softserve.edu.greencity.rest.entity.LogginedUserEntity;
import com.softserve.edu.greencity.rest.entity.VerifyEmailEntity;
import com.softserve.edu.greencity.rest.resources.GoogleSecurityResource;
import com.softserve.edu.greencity.rest.resources.VerifyEmailResource;

public class LogginedUserService {
    //
    protected LogginedUserEntity logginedUserEntity;
    private GoogleSecurityEntity googleSecurityEntity;
    private VerifyEmailEntity verifyEmailEntity;
    private GoogleSecurityResource googleSecurityResource;
    private VerifyEmailResource verifyEmailResource;

    public LogginedUserService(LogginedUserEntity logginedUserEntity) {
        this.logginedUserEntity = logginedUserEntity;
    }

    // getters

    public LogginedUserEntity getLogginedUserEntity() {
        return logginedUserEntity;
    }

    protected GoogleSecurityEntity getGoogleSecurityEntity() {
        return googleSecurityEntity;
    }

    protected GoogleSecurityResource getGoogleSecurityResource() {
        googleSecurityResource = new GoogleSecurityResource();
        return googleSecurityResource;
    }

    protected VerifyEmailResource getVerifyEmailResource() {
        verifyEmailResource = new VerifyEmailResource();
        return verifyEmailResource;
    }

    protected VerifyEmailEntity getVerifyEmailEntity() {
        return verifyEmailEntity;
    }

    // Functionals

    // http://***/googleSecurity?idToken=**" -H "accept: */*" -H "Authorization: Bearer ***"
    public GoogleSecurityEntity googleSecurity() {
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

    // http://***/ownSecurity/verifyEmail?token=***&user_id=***" -H "accept: */*
    public VerifyEmail verifyEmail() {
        MethodParameters methodParameters = new MethodParameters();
        getVerifyEmailResource();
        //
        RestParameters urlParameters = new RestParameters()
                .addParameter(KeyParameters.TOKEN, String.valueOf(getLogginedUserEntity().getAccessToken()))
                .addParameter(KeyParameters.USER_ID2, String.valueOf(getLogginedUserEntity().getUserId()));
        //
        RestParameters headerParameters = new RestParameters()
                .addParameter(KeyParameters.ACCEPT, ContentTypes.ALL_TYPES.toString());
        //
        VerifyEmailEntity verifyEmailEntity = verifyEmailResource
                .httpGetAsEntity(methodParameters
                        .addUrlParameters(urlParameters)
                        .addHeaderParameters(headerParameters));
        //
        System.out.println("***verifyEmailEntity = " + verifyEmailEntity);
        return VerifyEmail.converToVerifyEmail(verifyEmailEntity);
    }

    // Business Logic
    public MyhabitsService gotoMyhabitsService() {
        return new MyhabitsService(logginedUserEntity);
    }

    public EconewsUserService gotoEconewsUserService() {
        return new EconewsUserService(logginedUserEntity);
    }
}
