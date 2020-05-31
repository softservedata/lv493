package com.softserve.edu.greencity.rest.data.jira.testcases;

import java.util.ArrayList;
import java.util.List;

import com.softserve.edu.greencity.rest.entity.RegisterUserEntity;

public class GC532Data {

    // user credentials
    private String name;
    private String message;
    //
    // expected results
    public static final int EXPECTED_RESPONSE_CODE = 400;
    public static final String EXPECTED_NAME = "email";
    public static final String EXPECTED_MESSAGE = "User with this email is already registered";

    public GC532Data() {
        this.name = "";
        this.message = "";
    }

    public GC532Data(String name, String message) {
        this.name = name;
        this.message = message;
    }
    
    // getters
    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }

    // setters
    public GC532Data setName(String name) {
        this.name = name;
        return this;
    }

    public GC532Data setMessage(String message) {
        this.message = message;
        return this;
    }

    @Override
    public String toString() {
        return "GC532Data [name=" + name + ", message=" + message + "]";
    }
    
// static factory
    
    public static GC532Data converToGC532Data(RegisterUserEntity registerUserEntity) {
        return new GC532Data(registerUserEntity.getName(), registerUserEntity.getMessage());
    }
    
    public static List<GC532Data> converToGC532DataList(List<RegisterUserEntity> registerUserEntities) {
        List<GC532Data> result = new ArrayList<>();
        for (RegisterUserEntity registerUserEntity : registerUserEntities) {
            result.add(converToGC532Data(registerUserEntity));
        }
        return result;
    }
}
