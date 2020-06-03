package com.softserve.edu.greencity.rest.services.myhabits;

import java.util.ArrayList;
import java.util.List;

import com.softserve.edu.greencity.rest.data.myhabits.UserGoal;
import com.softserve.edu.greencity.rest.dto.ContentTypes;
import com.softserve.edu.greencity.rest.dto.MethodParameters;
import com.softserve.edu.greencity.rest.dto.RestParameters;
import com.softserve.edu.greencity.rest.entity.LogginedUserEntity;
import com.softserve.edu.greencity.rest.entity.ResponseCodeEntity;
import com.softserve.edu.greencity.rest.entity.myhabits.CustomGoalSaveEntity;
import com.softserve.edu.greencity.rest.entity.myhabits.CustomGoalUpdateEntity;
import com.softserve.edu.greencity.rest.entity.myhabits.UserGoalEntity;
import com.softserve.edu.greencity.rest.resources.myhabits.UserCustomGoalsResource;
import com.softserve.edu.greencity.rest.tools.JsonUtils;

import io.qameta.allure.Step;

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

	/**
     * Get all custom goals of current user.
     * @return list of goal entities
     */
	@Step("Get selected user custom goals")
    public List<UserGoalEntity> customGoalsEntities(){
        return getUserCustomGoalsResource().httpGetAsListEntity(new MethodParameters()
                .addHeaderParameters(getHeaderParameters())
                .addPathVariables(getUserIdParameter()));
    }

    /**
     * Get all custom goals of current user.
     * @return list of goals
     */
    @Step("Get selected user custom goals")
    public List<UserGoal> customGoals(){
        return UserGoal.converToUserGoalList(customGoalsEntities());
    }

    /**
     * Get all available custom goals of current user for selecting.
     * @return list of goal entities
     */
    @Step("Get available user custom goals")
    public List<UserGoalEntity> availableCustomGoalsEntities(){
        return getUserCustomGoalsResource().httpGetAsListEntity(new MethodParameters()
                .setIndex(1)
                .addHeaderParameters(getHeaderParameters())
                .addPathVariables(getUserIdParameter()));
    }

    /**
     * Get all available custom goals of current user for selecting.
     * @return list of goals
     */
    @Step("Get available user custom goals")
    public List<UserGoal> availableCustomGoals(){
        return UserGoal.converToUserGoalList(availableCustomGoalsEntities());
    }

    /**
     * Create new goals for current user.
     * @param goals
     * @return list of created goal entities
     */
    @Step("Create user custom goals")
    public List<UserGoalEntity> createCustomGoals(List<UserGoal> goals){
        List<CustomGoalSaveEntity.CustomGoal> customGoalSaveRequestDtoList = new ArrayList<>();
        goals.forEach(goal -> customGoalSaveRequestDtoList.add(new CustomGoalSaveEntity.CustomGoal(goal.getText())));

        RestParameters mediaTypeParameters = new RestParameters()
                .addDirectJsonParameter(new JsonUtils()
                        .entityToJson(new CustomGoalSaveEntity(customGoalSaveRequestDtoList), CustomGoalSaveEntity.class));

        return getUserCustomGoalsResource().httpPostAsListEntity(new MethodParameters()
                .addHeaderParameters(getHeaderParameters())
                .addPathVariables(getUserIdParameter())
                .addContentType(ContentTypes.APPLICATION_JSON)
                .addMediaTypeParameters(mediaTypeParameters));
    }

    /**
     * Update custom goals of current user.
     * @param goals
     * @param new goals
     * @return list of created goal entities
     */
    @Step("Update user custom goals")
    public List<UserGoalEntity> updateCustomGoals(List<UserGoalEntity> goals, List<UserGoal> newGoals ){
        List<CustomGoalUpdateEntity.CustomGoal> customGoals  = new ArrayList<>();
        for(int i = 0; i< goals.size(); i++) {
            customGoals.add(new CustomGoalUpdateEntity.CustomGoal(goals.get(i).getId(), newGoals.get(i).getText()));
        }

        RestParameters mediaTypeParameters = new RestParameters()
                .addDirectJsonParameter(new JsonUtils()
                        .entityToJson(new CustomGoalUpdateEntity(customGoals), CustomGoalUpdateEntity.class));

        return getUserCustomGoalsResource().httpPatchAsListEntity(new MethodParameters()
                .addHeaderParameters(getHeaderParameters())
                .addPathVariables(getUserIdParameter())
                .addContentType(ContentTypes.APPLICATION_JSON)
                .addMediaTypeParameters(mediaTypeParameters));
    }

    /**
     * Update custom goals of current user.
     * @param new goals
     * @return list of created goal entities
     */
    @Step("Update user custom goals")
    public List<UserGoalEntity> updateCustomGoals(List<UserGoalEntity> goals){
        return updateCustomGoals(goals, UserGoal.converToUserGoalList(goals));
    }


    /**
     * Delete custom goals of current user.
     * @param goals
     * @return
     */
    @Step("Delete user custom goals")
    public ResponseCodeEntity deleteCustomGoals(List<UserGoalEntity> goals){
        return getUserCustomGoalsResource().httpDeleteAsEntity(new MethodParameters()
                .addHeaderParameters(getHeaderParameters())
                .addUrlParameters(getGoalsIdsParameter(goals))
                .addPathVariables(getUserIdParameter()));
    }

}
