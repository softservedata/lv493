package com.softserve.edu.greencity.rest.dto;

public final class RestUrlRepository {
	// TODO Send as Parameter
    private static String remoteServer = "https://greencity.azurewebsites.net";
//    private static String remoteServer = "http://localhost:8080";

    private RestUrlRepository() {
    }

    public static RestUrl getDefault() {
    	return getSignin();
    }

    public static RestUrl getSignin() {
        return new RestUrl()
                .addBaseUrl(remoteServer)
                .addGetUrl("")
                .addPostUrl("/ownSecurity/signIn")
                .addPutUrl("")
                .addDeleteUrl("")
                .addPatchUrl("");
    }

    public static RestUrl getUserGoals() {
        return new RestUrl()
                .addBaseUrl(remoteServer)
                .addGetUrl("/user/{" + KeyParameters.USER_ID.toString() + "}/goals")
                .addGetUrl("/user/{" + KeyParameters.USER_ID.toString() + "}/goals/available")
                .addPostUrl("/user/{" + KeyParameters.USER_ID.toString() + "}/goals")
                .addPutUrl("")
                .addDeleteUrl("/user/{" + KeyParameters.USER_ID.toString() + "}/userGoals")
                .addPatchUrl("/user/{" + KeyParameters.USER_ID.toString() + "}/goals/{" + KeyParameters.GOAL_ID.toString() + "}");
    }

    public static RestUrl getCustomUserGoals() {
        return new RestUrl()
                .addBaseUrl(remoteServer)
                .addGetUrl("/user/{" + KeyParameters.USER_ID.toString() + "}/customGoals")
                .addGetUrl("/user/{" + KeyParameters.USER_ID.toString() + "}/customGoals/available")
                .addPostUrl("/user/{" + KeyParameters.USER_ID.toString() + "}/customGoals")
                .addPutUrl("")
                .addDeleteUrl("/user/{" + KeyParameters.USER_ID.toString() + "}/customGoals")
                .addPatchUrl("/user/{" + KeyParameters.USER_ID.toString() + "}/customGoals");
    }

    public static RestUrl getAllGoals() { // Admin
        return new RestUrl()
                .addBaseUrl(remoteServer)
                .addGetUrl("/goals")
                .addPostUrl("")
                .addPutUrl("")
                .addDeleteUrl("")
                .addPatchUrl("");
    }

    public static RestUrl getAchievement() { // Admin
        return new RestUrl()
                .addBaseUrl(remoteServer)
                .addGetUrl("/achievements")
                .addPostUrl("")
                .addPutUrl("")
                .addDeleteUrl("")
                .addPatchUrl("");
    }

    public static RestUrl getHabitFact() { // Admin
        return new RestUrl()
                .addBaseUrl(remoteServer)
                .addGetUrl("/facts")
                .addGetUrl("/facts/random/{" + KeyParameters.HABIT_ID + "}")
                .addPostUrl("/facts")
                .addPutUrl("/facts/{" + KeyParameters.FACT_ID + "}")
                .addDeleteUrl("/facts/{" + KeyParameters.FACT_ID + "}")
                .addPatchUrl("");
    }

    public static RestUrl getHabitStatistic() { // Admin
        return new RestUrl()
                .addBaseUrl(remoteServer)
                .addGetUrl("/habit/statistic/{" + KeyParameters.HABIT_ID + "}")
                .addPostUrl("/habit/statistic/")
                .addPutUrl("")
                .addDeleteUrl("")
                .addPatchUrl("/habit/statistic/{" + KeyParameters.HABIT_STATISTIC_ID + "}");
    }

    public static RestUrl getTodayHabitStatistic() {
        return new RestUrl()
                .addBaseUrl(remoteServer)
                .addGetUrl("/habit/statistic/todayStatisticsForAllHabitItems")
                .addPostUrl("")
                .addPutUrl("")
                .addDeleteUrl("")
                .addPatchUrl("");
    }

    public static RestUrl getUserHabits() {
        return new RestUrl()
                .addBaseUrl(remoteServer)
                .addGetUrl("/user/{" + KeyParameters.USER_ID.toString() + "}/habits")
                .addGetUrl("/user/{" + KeyParameters.USER_ID.toString() + "}/habit-dictionary/available")
                .addPostUrl("/user/{" + KeyParameters.USER_ID.toString() + "}/habit")
                .addPutUrl("")
                .addDeleteUrl("/user/{" + KeyParameters.USER_ID.toString() + "}/habit/{" + KeyParameters.HABIT_ID + "}")
                .addPatchUrl("");
    }

    public static RestUrl getUserHabitsStatistic() {
        return new RestUrl()
                .addBaseUrl(remoteServer)
                .addGetUrl("/user/{" + KeyParameters.USER_ID.toString() + "}/habits/statistic")
                .addPostUrl("")
                .addPutUrl("")
                .addDeleteUrl("")
                .addPatchUrl("");
    }

}


