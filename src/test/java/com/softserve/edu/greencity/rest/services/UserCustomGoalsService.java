package com.softserve.edu.greencity.rest.services;

import java.util.ArrayList;
import java.util.List;

import com.softserve.edu.greencity.rest.data.UserGoal;
import com.softserve.edu.greencity.rest.dto.ContentTypes;
import com.softserve.edu.greencity.rest.dto.KeyParameters;
import com.softserve.edu.greencity.rest.dto.MethodParameters;
import com.softserve.edu.greencity.rest.dto.RestParameters;
import com.softserve.edu.greencity.rest.entity.CustomGoalSaveEntity;
import com.softserve.edu.greencity.rest.entity.CustomGoalUpdateEntity;
import com.softserve.edu.greencity.rest.entity.LogginedUserEntity;
import com.softserve.edu.greencity.rest.entity.ResponseCodeEntity;
import com.softserve.edu.greencity.rest.entity.UserGoalEntity;
import com.softserve.edu.greencity.rest.resources.UserCustomGoalsResource;
import com.softserve.edu.greencity.rest.tools.JsonUtils;

public class UserCustomGoalsService extends MyHabitsService {
	protected UserCustomGoalsResource userCustomGoalsResource;

	public UserCustomGoalsService(LogginedUserEntity logginedUserEntity) {
		super(logginedUserEntity);
		userCustomGoalsResource = new UserCustomGoalsResource();
	}

	// getters

	public UserCustomGoalsResource getUserCustomGoalsResource() {
        return userCustomGoalsResource;
    }


	// Functionals

    public List<UserGoalEntity> userCustomGoalsEntities(){
        return getUserCustomGoalsResource().httpGetAsListEntity(new MethodParameters()
                .addHeaderParameters(getHeaderParameters())
                .addPathVariables(getUserIdParameter()));
    }

    public List<UserGoal> userCustomGoals(){
        return UserGoal.converToUserGoalList(userCustomGoalsEntities());
    }

    public List<UserGoalEntity> availableUserCustomGoalsEntities(){
        return getUserCustomGoalsResource().httpGetAsListEntity(new MethodParameters()
                .setIndex(1)
                .addHeaderParameters(getHeaderParameters())
                .addPathVariables(getUserIdParameter()));
    }

    public List<UserGoal> availableUserCustomGoals(){
        return UserGoal.converToUserGoalList(availableUserCustomGoalsEntities());
    }


    public List<UserGoalEntity> createUserCustomGoals(List<UserGoal> goals){ // TODO

        List<CustomGoalSaveEntity.CustomGoal> customGoalSaveRequestDtoList = new ArrayList<>();
        goals.forEach(goal -> customGoalSaveRequestDtoList.add(new CustomGoalSaveEntity.CustomGoal(goal.getText())));

        String json = new JsonUtils().entityToJson(new CustomGoalSaveEntity(customGoalSaveRequestDtoList), CustomGoalSaveEntity.class);

        RestParameters mediaTypeParameters = new RestParameters()
                .addParameter(KeyParameters.JSON, json);

        return getUserCustomGoalsResource().httpPostAsListEntity(new MethodParameters()
                .addHeaderParameters(getHeaderParameters())
                .addPathVariables(getUserIdParameter())
                .addContentType(ContentTypes.APPLICATION_JSON)
                .addMediaTypeParameters(mediaTypeParameters));

    }


    public List<UserGoalEntity> updateUserCustomGoals(List<UserGoalEntity> goals){ // TODO

        List<CustomGoalUpdateEntity.CustomGoal> customGoals  = new ArrayList<>();
        goals.forEach(goal -> customGoals.add(new CustomGoalUpdateEntity.CustomGoal(goal.getId(), goal.getText())));

        String json = new JsonUtils().entityToJson(new CustomGoalUpdateEntity(customGoals), CustomGoalUpdateEntity.class);

        RestParameters mediaTypeParameters = new RestParameters()
                .addParameter(KeyParameters.JSON, json);

        return getUserCustomGoalsResource().httpPatchAsListEntity(new MethodParameters()
                .addHeaderParameters(getHeaderParameters())
                .addPathVariables(getUserIdParameter())
                .addContentType(ContentTypes.APPLICATION_JSON)
                .addMediaTypeParameters(mediaTypeParameters));
    }


    public ResponseCodeEntity deleteUserCustomGoals(List<UserGoalEntity> goals){
        return getUserCustomGoalsResource().httpDeleteAsEntity(new MethodParameters()
                .addHeaderParameters(getHeaderParameters())
                .addUrlParameters(getGoalsIdsParameter(goals))
                .addPathVariables(getUserIdParameter()));
    }

}
