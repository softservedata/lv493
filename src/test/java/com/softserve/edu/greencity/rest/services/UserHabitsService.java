package com.softserve.edu.greencity.rest.services;

import java.util.ArrayList;
import java.util.List;

import com.softserve.edu.greencity.rest.data.LanguagesCode;
import com.softserve.edu.greencity.rest.data.UserHabit;
import com.softserve.edu.greencity.rest.dto.ContentTypes;
import com.softserve.edu.greencity.rest.dto.KeyParameters;
import com.softserve.edu.greencity.rest.dto.MethodParameters;
import com.softserve.edu.greencity.rest.dto.RestParameters;
import com.softserve.edu.greencity.rest.entity.HabitDictionaryIdEntity;
import com.softserve.edu.greencity.rest.entity.LogginedUserEntity;
import com.softserve.edu.greencity.rest.entity.ResponseCodeEntity;
import com.softserve.edu.greencity.rest.entity.UserHabitEntity;
import com.softserve.edu.greencity.rest.resources.UserHabitsResource;
import com.softserve.edu.greencity.rest.tools.GenericConverter;
import com.softserve.edu.greencity.rest.tools.JsonUtils;

public class UserHabitsService extends MyHabitsService {
	protected UserHabitsResource userHabitsResource;

	public UserHabitsService(LogginedUserEntity logginedUserEntity) {
		super(logginedUserEntity);
		userHabitsResource = new UserHabitsResource();
	}

	// getters

	public UserHabitsResource getUserHabitsResource() {
        return userHabitsResource;
    }

	// Functionals

	public List<UserHabitEntity> userHabitEntities(LanguagesCode language){
        return getUserHabitsResource().httpGetAsListEntity(new MethodParameters()
                .addHeaderParameters(getHeaderParameters())
                .addUrlParameters(getLanguageParameter(language))
                .addPathVariables(getUserIdParameter()));
	}

	public List<UserHabitEntity> userHabitEntities(){
        return userHabitEntities(LanguagesCode.ENGLISH);
    }

	public List<UserHabit> userHabits() {
        return UserHabit.converToUserHabitList(userHabitEntities());
    }

    public List<UserHabit> userHabits(LanguagesCode language) {
        return UserHabit.converToUserHabitList(userHabitEntities(language));
    }


	public List<UserHabitEntity> userAvailableHabitEntities(LanguagesCode language){
        return getUserHabitsResource().httpGetAsListEntity(new MethodParameters()
                .setIndex(1)
                .addHeaderParameters(getHeaderParameters())
                .addUrlParameters(getLanguageParameter(language))
                .addPathVariables(getUserIdParameter()));
    }

	public List<UserHabitEntity> userAvailableHabitEntities(){
        return userAvailableHabitEntities(LanguagesCode.ENGLISH);
    }

	public List<UserHabit> userAvailableHabits(LanguagesCode language){
	    return UserHabit.converToUserHabitList(userAvailableHabitEntities(language));
    }

    public List<UserHabit> userAvailableHabits(){
        return UserHabit.converToUserHabitList(userAvailableHabitEntities());
    }

	/**
     * Select from dropdown to cabinet page
     * @param goal
     * @return
     */

	// Error
	// code 400
	// But work correct, habit is saved

    public ResponseCodeEntity addUserHabit(List<UserHabitEntity> habits, LanguagesCode language){ // TODO
        RestParameters urlParameters = new RestParameters()
                .addParameter(KeyParameters.LANGUAGE, String.valueOf(language));

        List<HabitDictionaryIdEntity> habitDirectoryIds = new ArrayList<>();
        habits.forEach(habit -> habitDirectoryIds.add(new HabitDictionaryIdEntity(habit.getId())));

        String json = new JsonUtils().entityToJson(habitDirectoryIds, new GenericConverter<List<HabitDictionaryIdEntity>>() {}.getGenericType());

        RestParameters mediaTypeParameters = new RestParameters()
                .addParameter(KeyParameters.JSON, json);

        return getUserHabitsResource().httpPostAsEntity(new MethodParameters()
                .addHeaderParameters(getHeaderParameters())
                .addUrlParameters(urlParameters)
                .addPathVariables(getUserIdParameter())
                .addContentType(ContentTypes.APPLICATION_JSON)
                .addMediaTypeParameters(mediaTypeParameters));
    }

    public ResponseCodeEntity addUserHabit(List<UserHabitEntity> habits){
        return addUserHabit(habits, LanguagesCode.ENGLISH );
    }

    /**
     * Remove from cabinet to dropdown
     * @param goal
     * @return
     */
    // No response, only code
    // Do not work at all
    public ResponseCodeEntity deleteUserHabit(UserHabitEntity habit){
        RestParameters pathVariables  = new RestParameters()
                .addParameter(KeyParameters.USER_ID, String.valueOf(getLogginedUserEntity().getUserId()))
                .addParameter(KeyParameters.HABIT_ID, String.valueOf(habit.getId()));

        return getUserHabitsResource().httpDeleteAsEntity(new MethodParameters()
                .addHeaderParameters(getHeaderParameters())
                .addPathVariables(pathVariables));
    }

}