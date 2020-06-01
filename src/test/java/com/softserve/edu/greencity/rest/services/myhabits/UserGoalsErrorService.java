package com.softserve.edu.greencity.rest.services.myhabits;

import com.softserve.edu.greencity.rest.data.LanguagesCode;
import com.softserve.edu.greencity.rest.dto.KeyParameters;
import com.softserve.edu.greencity.rest.dto.MethodParameters;
import com.softserve.edu.greencity.rest.dto.RestParameters;
import com.softserve.edu.greencity.rest.entity.ErrorEntity;
import com.softserve.edu.greencity.rest.entity.LogginedUserEntity;
import com.softserve.edu.greencity.rest.resources.myhabits.UserGoalsErrorResource;

public class UserGoalsErrorService extends MyHabitsService {
    protected UserGoalsErrorResource userGoalsErrorResource;

    public UserGoalsErrorService(LogginedUserEntity logginedUserEntity) {
        super(logginedUserEntity);
        userGoalsErrorResource = new UserGoalsErrorResource();
    }

    // getters

    public UserGoalsErrorResource getUserGoalsErrorResource() {
        return userGoalsErrorResource;
    }

    // Functionals


    public ErrorEntity userGoalsEntities(LanguagesCode language) {
        return getUserGoalsErrorResource().httpGetAsEntity(new MethodParameters()
                .addHeaderParameters(getHeaderParameters())
                .addUrlParameters(getLanguageParameter(language))
                .addPathVariables(getUserIdParameter()));
    }

    public ErrorEntity userGoalsEntities() {
        return getUserGoalsErrorResource().httpGetAsEntity(new MethodParameters()
                .addHeaderParameters(getHeaderParameters())
                .addPathVariables(getUserIdParameter()));
    }

    public ErrorEntity userGoalsEntitiesWithOtherUser(int id) {
        RestParameters pathVariables = new RestParameters()
                .addParameter(KeyParameters.USER_ID, String.valueOf(id));

        return getUserGoalsErrorResource().httpGetAsEntity(new MethodParameters()
                .addHeaderParameters(getHeaderParameters())
                .addPathVariables(pathVariables));
    }


}
