package com.softserve.edu.greencity.rest.data;

import java.util.ArrayList;
import java.util.List;

import com.softserve.edu.greencity.rest.entity.RegisterUserEntity;

public class UnsuccessfulRegistration {

    private String name;
    private String message;

    public UnsuccessfulRegistration(String name, String message) {
        this.name = name;
        this.message = message;
    }

    // setters
    public void setName(String name) {
        this.name = name;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    // getters
    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }

// static factory

    public static UnsuccessfulRegistration converToUnsuccessfulRegistration(
            RegisterUserEntity registerUserEntity) {
        return new UnsuccessfulRegistration(registerUserEntity.getName(),
                registerUserEntity.getMessage());
    }

    public static List<UnsuccessfulRegistration> converToUnsuccessfulRegistrationList(
            List<RegisterUserEntity> registerUserEntities) {
        List<UnsuccessfulRegistration> result = new ArrayList<>();
        for (RegisterUserEntity registerUserEntity : registerUserEntities) {
            result.add(converToUnsuccessfulRegistration(registerUserEntity));
        }
        return result;
    }

}
