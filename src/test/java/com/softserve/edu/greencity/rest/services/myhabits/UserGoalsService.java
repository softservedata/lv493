package com.softserve.edu.greencity.rest.services.myhabits;

import java.util.Iterator;
import java.util.List;

import com.softserve.edu.greencity.rest.data.LanguagesCode;
import com.softserve.edu.greencity.rest.data.myhabits.UserGoal;
import com.softserve.edu.greencity.rest.data.myhabits.UserGoalStatus;
import com.softserve.edu.greencity.rest.dto.ContentTypes;
import com.softserve.edu.greencity.rest.dto.KeyParameters;
import com.softserve.edu.greencity.rest.dto.MethodParameters;
import com.softserve.edu.greencity.rest.dto.RestParameters;
import com.softserve.edu.greencity.rest.entity.LogginedUserEntity;
import com.softserve.edu.greencity.rest.entity.ResponseCodeEntity;
import com.softserve.edu.greencity.rest.entity.myhabits.GoalsEntity;
import com.softserve.edu.greencity.rest.entity.myhabits.UserGoalEntity;
import com.softserve.edu.greencity.rest.resources.myhabits.UserGoalsResource;
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

    /**
     * Get all selected goals of current user according to language.
     * @param language code
     * @return list of goal entities
     */
    public List<UserGoalEntity> userGoalsEntities(LanguagesCode language) {
        return getUserGoalsResource().httpGetAsListEntity(new MethodParameters()
                .addHeaderParameters(getHeaderParameters())
                .addUrlParameters(getLanguageParameter(language))
                .addPathVariables(getUserIdParameter()));
    }

    /**
     * Get all selected goals of current user.
     * @return list of goal entities
     */
    public List<UserGoalEntity> userGoalsEntities() {
        return userGoalsEntities(LanguagesCode.ENGLISH);
    }

    /**
     * Get all selected goals of current user according to language.
     * @param language code
     * @return list of goals
     */
    public List<UserGoal> userGoals(LanguagesCode language) {
        return UserGoal.converToUserGoalList(userGoalsEntities(language));
    }

    /**
     * Get all selected goals of current user.
     * @return list of goals
     */
    public List<UserGoal> userGoals() {
        return UserGoal.converToUserGoalList(userGoalsEntities());
    }

    /**
     * Get all selected goals of current user by status.
     * @param user goal status
     * @return list of goals
     */
    public List<UserGoal> userGoalsByStatus(UserGoalStatus userGoalStatus) {
        List<UserGoal> result = userGoals();
        for (Iterator<UserGoal> iterator = result.iterator(); iterator
                .hasNext();) {
            UserGoal current = iterator.next();
            if (!current.getStatus().toUpperCase()
                    .equals(userGoalStatus.toString())) {
                iterator.remove();
            }
        }
        return result;
    }

    /**
     * Get all available goals of current user for selecting according to language.
     * @param language
     * @return list of goal entities
     */
    public List<UserGoalEntity> availableUserGoalsEntities(LanguagesCode language) {
        return getUserGoalsResource().httpGetAsListEntity(new MethodParameters()
                .setIndex(1).addHeaderParameters(getHeaderParameters())
                .addUrlParameters(getLanguageParameter(language))
                .addPathVariables(getUserIdParameter()));
    }

    /**
     * Get all available goals of current user for selecting.
     * @return list of goal entities
     */
    public List<UserGoalEntity> availableUserGoalsEntities() {
        return availableUserGoalsEntities(LanguagesCode.ENGLISH);
    }

    /**
     * Get all available goals of current user for selecting according to language.
     * @param language
     * @return list of goals
     */
    public List<UserGoal> availableUserGoals(LanguagesCode language) {
        return UserGoal.converToUserGoalList(availableUserGoalsEntities(language));
    }

    /**
     * Get all available goals for selecting.
     * @return list of goals
     */
    public List<UserGoal> availableUserGoals() {
        return UserGoal.converToUserGoalList(availableUserGoalsEntities());
    }

    /**
     * Select goals for current user from available ones (including custom goals) according to language.
     * @param goals
     * @param custom goals
     * @param language code
     * @return list of selected goal entities
     */
    public List<UserGoalEntity> selectUserGoals(List<UserGoalEntity> goals, List<UserGoalEntity> customGoals, LanguagesCode language) { // TODO
        RestParameters urlParameters = new RestParameters()
                .addParameter(KeyParameters.LANGUAGE, String.valueOf(language));

        String json = new JsonUtils().entityToJson(GoalsEntity.convertToGoalsEntity(goals, customGoals), GoalsEntity.class);

        RestParameters mediaTypeParameters = new RestParameters()
                .addParameter(KeyParameters.JSON, json);

        return getUserGoalsResource()
                .httpPostAsListEntity(new MethodParameters()
                        .addHeaderParameters(getHeaderParameters())
                        .addUrlParameters(urlParameters)
                        .addPathVariables(getUserIdParameter())
                        .addContentType(ContentTypes.APPLICATION_JSON)
                        .addMediaTypeParameters(mediaTypeParameters));
    }

    /**
     * Select goals for current user from available ones (including custom goals).
     * @param goals
     * @param custom goals
     * @return list of selected goal entities
     */
    public List<UserGoalEntity> selectUserGoals(List<UserGoalEntity> goals, List<UserGoalEntity> customGoals) {
        return selectUserGoals(goals, customGoals, LanguagesCode.ENGLISH);
    }

   /**
    * Change status of one of the goals for current user to DONE or back according to language.
    * @param goal
    * @param language code
    * @return
    */
    public UserGoalEntity doUserGoal(UserGoalEntity goal, LanguagesCode language) {
        RestParameters pathVariables = new RestParameters()
                .addParameter(KeyParameters.USER_ID, String.valueOf(getLogginedUserEntity().getUserId()))
                .addParameter(KeyParameters.GOAL_ID, String.valueOf(goal.getId()));

        return getUserGoalsResource().httpPatchAsEntity(new MethodParameters()
                .addHeaderParameters(getHeaderParameters())
                .addUrlParameters(getLanguageParameter(language))
                .addPathVariables(pathVariables));
    }

    /**
     * Change status of one of the goals for current user to DONE or back.
     * @param goal
     * @return
     */
    public UserGoalEntity doUserGoal(UserGoalEntity goal) {
        return doUserGoal(goal, LanguagesCode.ENGLISH);
    }

    /**
     * Deselect goals for current user to available ones.
     * @param goals
     * @return
     */

    // no response
    // swagger - only id
    // work correct

    public ResponseCodeEntity deselectUserGoals(List<UserGoalEntity> goals) {
        return getUserGoalsResource().httpDeleteAsEntity(new MethodParameters()
                .addHeaderParameters(getHeaderParameters())
                .addUrlParameters(getGoalsIdsParameter(goals))
                .addPathVariables(getUserIdParameter()));
    }

}
