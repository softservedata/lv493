package com.softserve.edu.greencity.rest.services.myhabits;

import java.util.ArrayList;
import java.util.List;

import com.softserve.edu.greencity.rest.data.LanguagesCode;
import com.softserve.edu.greencity.rest.data.myhabits.UserHabit;
import com.softserve.edu.greencity.rest.dto.ContentTypes;
import com.softserve.edu.greencity.rest.dto.KeyParameters;
import com.softserve.edu.greencity.rest.dto.MethodParameters;
import com.softserve.edu.greencity.rest.dto.RestParameters;
import com.softserve.edu.greencity.rest.entity.LogginedUserEntity;
import com.softserve.edu.greencity.rest.entity.ResponseCodeEntity;
import com.softserve.edu.greencity.rest.entity.myhabits.HabitDictionaryIdEntity;
import com.softserve.edu.greencity.rest.entity.myhabits.UserHabitEntity;
import com.softserve.edu.greencity.rest.resources.myhabits.UserHabitsResource;
import com.softserve.edu.greencity.rest.tools.GenericConverter;
import com.softserve.edu.greencity.rest.tools.JsonUtils;

import io.qameta.allure.Step;

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

	/**
	 * Get all selected habits of current user according to language.
	 * @param language code
	 * @return list of habit entities
	 */
	@Step("Get user habits")
	public List<UserHabitEntity> userHabitEntities(LanguagesCode language){
        return getUserHabitsResource().httpGetAsListEntity(new MethodParameters()
                .addHeaderParameters(getHeaderParameters())
                .addUrlParameters(getLanguageParameter(language))
                .addPathVariables(getUserIdParameter()));
	}

	/**
     * Get all selected habits of current user.
     * @return list of habit entities
     */
	@Step("Get user habits")
	public List<UserHabitEntity> userHabitEntities(){
        return userHabitEntities(LanguagesCode.ENGLISH);
    }

	/**
     * Get all selected habits of current user according to language.
     * @param language code
     * @return list of habits
     */
	@Step("Get user habits")
    public List<UserHabit> userHabits(LanguagesCode language) {
        return UserHabit.converToUserHabitList(userHabitEntities(language));
    }

    /**
     * Get all selected habits of current user.
     * @return list of habits
     */
	@Step("Get user habits")
    public List<UserHabit> userHabits() {
        return UserHabit.converToUserHabitList(userHabitEntities());
    }

    /**
     * Get all available habits of current user for selecting according to language.
     * @param language code
     * @return list of habit entities
     */
	@Step("Get available user habits")
	public List<UserHabitEntity> userAvailableHabitEntities(LanguagesCode language){
        return getUserHabitsResource().httpGetAsListEntity(new MethodParameters()
                .setIndex(1)
                .addHeaderParameters(getHeaderParameters())
                .addUrlParameters(getLanguageParameter(language))
                .addPathVariables(getUserIdParameter()));
    }

	/**
     * Get all available habits of current user for selecting.
     * @return list of habit entities
     */
	@Step("Get available user habits")
	public List<UserHabitEntity> userAvailableHabitEntities(){
        return userAvailableHabitEntities(LanguagesCode.ENGLISH);
    }

	/**
     * Get all available habits of current user for selecting according to language.
     * @param language code
     * @return list of habits
     */
	@Step("Get available user habits")
	public List<UserHabit> userAvailableHabits(LanguagesCode language){
	    return UserHabit.converToUserHabitList(userAvailableHabitEntities(language));
    }

	/**
     * Get all available habits of current user for selecting.
     * @return list of habits
     */
	@Step("Get available user habits")
    public List<UserHabit> userAvailableHabits(){
        return UserHabit.converToUserHabitList(userAvailableHabitEntities());
    }

    /**
     * Select habits of current user from available according to language.
     * @param habits
     * @param language code
     * @return
     */

	// Error
	// code 400
	// But work correct, habit is saved
	@Step("Add user habits")
    public ResponseCodeEntity addUserHabit(List<UserHabitEntity> habits, LanguagesCode language){
        List<HabitDictionaryIdEntity> habitDirectoryIds = new ArrayList<>();
        habits.forEach(habit -> habitDirectoryIds.add(new HabitDictionaryIdEntity(habit.getId())));

        RestParameters mediaTypeParameters = new RestParameters()
                .addDirectJsonParameter(new JsonUtils()
                        .entityToJson(habitDirectoryIds, new GenericConverter<List<HabitDictionaryIdEntity>>() {}.getGenericType()));

        return getUserHabitsResource().httpPostAsEntity(new MethodParameters()
                .addHeaderParameters(getHeaderParameters())
                .addUrlParameters(getLanguageParameter(language))
                .addPathVariables(getUserIdParameter())
                .addContentType(ContentTypes.APPLICATION_JSON)
                .addMediaTypeParameters(mediaTypeParameters));
    }

    /**
     * Select habits of current user from available.
     * @param habits
     * @return
     */
	@Step("Add user habits")
    public ResponseCodeEntity addUserHabit(List<UserHabitEntity> habits){
        return addUserHabit(habits, LanguagesCode.ENGLISH );
    }

    /**
     * Remove habits of current user to available.
     * @param habit
     * @return
     */
    // No response, only code
    // Do not work at all
	@Step("Delete user habits")
    public ResponseCodeEntity deleteUserHabit(UserHabitEntity habit){
        RestParameters pathVariables  = new RestParameters()
                .addParameter(KeyParameters.USER_ID, String.valueOf(getLogginedUserEntity().getUserId()))
                .addParameter(KeyParameters.HABIT_ID, String.valueOf(habit.getId()));

        return getUserHabitsResource().httpDeleteAsEntity(new MethodParameters()
                .addHeaderParameters(getHeaderParameters())
                .addPathVariables(pathVariables));
    }

}