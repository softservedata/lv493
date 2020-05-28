package com.softserve.edu.greencity.rest.services;

import java.util.Iterator;
import java.util.List;

import com.softserve.edu.greencity.rest.data.LanguagesCode;
import com.softserve.edu.greencity.rest.data.UserGoal;
import com.softserve.edu.greencity.rest.data.UserGoalStatus;
import com.softserve.edu.greencity.rest.dto.ContentTypes;
import com.softserve.edu.greencity.rest.dto.KeyParameters;
import com.softserve.edu.greencity.rest.dto.MethodParameters;
import com.softserve.edu.greencity.rest.dto.RestParameters;
import com.softserve.edu.greencity.rest.entity.GoalsEntity;
import com.softserve.edu.greencity.rest.entity.LogginedUserEntity;
import com.softserve.edu.greencity.rest.entity.UserGoalEntity;
import com.softserve.edu.greencity.rest.resources.UserGoalsResource;
import com.softserve.edu.greencity.rest.tools.JsonUtils;

public class UserGoalsService extends MyHabitsService {
	protected UserGoalsResource userGoalsResource;

	public UserGoalsService(LogginedUserEntity logginedUserEntity) {
		super(logginedUserEntity);
		userGoalsResource = new UserGoalsResource();
	}

	// getters

	public UserGoalsResource getUserGoalsResource() {
        return userGoalsResource;
    }

	// Functionals

	public List<UserGoalEntity>  userGoalsEntities(LanguagesCode language){
	    return getUserGoalsResource().httpGetAsListEntity(new MethodParameters()
                .addHeaderParameters(getHeaderParameters())
                .addUrlParameters(getLanguageParameter(language))
                .addPathVariables(getUserIdParameter()));
	}

	public List<UserGoalEntity>  userGoalsEntities () {
        return userGoalsEntities(LanguagesCode.ENGLISH);
    }

	public List<UserGoal> userGoals() {
        return UserGoal.converToUserGoalList(userGoalsEntities());
    }

	public List<UserGoal> userGoals(LanguagesCode language) {
        return UserGoal.converToUserGoalList(userGoalsEntities(language));
    }

    public List<UserGoal> userGoalsByStatus(UserGoalStatus userGoalStatus) {
        List<UserGoal> result = userGoals();
        for (Iterator<UserGoal> iterator = result.iterator(); iterator.hasNext(); ) {
            UserGoal current = iterator.next();
            if (!current.getStatus().toUpperCase().equals(userGoalStatus.toString())) {
                iterator.remove();
            }
        }
        return result;
    }


	public List<UserGoalEntity> availableUserGoalsEntities(LanguagesCode language){
        return getUserGoalsResource().httpGetAsListEntity(new MethodParameters()
                .setIndex(1)
                .addHeaderParameters(getHeaderParameters())
                .addUrlParameters(getLanguageParameter(language))
                .addPathVariables(getUserIdParameter()));
    }

    public List<UserGoalEntity> availableUserGoalsEntities(){
        return availableUserGoalsEntities(LanguagesCode.ENGLISH);
    }

    public List<UserGoal> availableUserGoals(LanguagesCode language) {
        return UserGoal.converToUserGoalList(availableUserGoalsEntities(language));
    }

    public List<UserGoal> availableUserGoals() {
        return UserGoal.converToUserGoalList(availableUserGoalsEntities());
    }


	/**
	 * Select from droppdown to cabinet page
	 * @param goal
	 * @return
	 */
	public List<UserGoalEntity> selectUserGoals(List<UserGoalEntity> goals, List<UserGoalEntity> customGoals, LanguagesCode language){ // TODO
        RestParameters urlParameters = new RestParameters()
                .addParameter(KeyParameters.LANGUAGE, String.valueOf(language));



        String json = new JsonUtils().entityToJson(GoalsEntity.convertToGoalsEntity(goals, customGoals), GoalsEntity.class);

        RestParameters mediaTypeParameters = new RestParameters()
                .addParameter(KeyParameters.JSON, json);


        return getUserGoalsResource().httpPostAsListEntity(new MethodParameters()
                .addHeaderParameters(getHeaderParameters())
                .addUrlParameters(urlParameters)
                .addPathVariables(getUserIdParameter())
                .addContentType(ContentTypes.APPLICATION_JSON)
                .addMediaTypeParameters(mediaTypeParameters));
    }

	public List<UserGoalEntity> selectUserGoals(List<UserGoalEntity> goals, List<UserGoalEntity> customGoals){
        return selectUserGoals(goals, customGoals, LanguagesCode.ENGLISH);
    }



	/**
	 * Change status of one of the goals for current user to DONE. and back
	 * @param goal
	 * @return
	 */

    public UserGoalEntity doUserGoals(UserGoalEntity goal, LanguagesCode language){
        RestParameters pathVariables  = new RestParameters()
                .addParameter(KeyParameters.USER_ID, String.valueOf(getLogginedUserEntity().getUserId()))
                .addParameter(KeyParameters.GOAL_ID, String.valueOf(goal.getId()));

        return getUserGoalsResource().httpPatchAsEntity(new MethodParameters()
                .addHeaderParameters(getHeaderParameters())
                .addUrlParameters(getLanguageParameter(language))
                .addPathVariables(pathVariables));
    }

    public UserGoalEntity doUserGoals(UserGoalEntity goal){
        return doUserGoals(goal, LanguagesCode.ENGLISH);
    }

	/**
	 * Remove from selected to dropdown
	 * @param goal
	 * @return
	 */
    // no response
    // swagger - only id
    // work correct

	public List<Integer> deleteUserGoals(List<UserGoalEntity> goals){
        return getUserGoalsResource().httpDeleteAsListEntity(new MethodParameters()
                .addHeaderParameters(getHeaderParameters())
                .addUrlParameters(getGoalsIdsParameter(goals))
                .addPathVariables(getUserIdParameter()));
    }

}
