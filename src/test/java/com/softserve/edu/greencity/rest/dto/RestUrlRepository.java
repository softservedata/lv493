package com.softserve.edu.greencity.rest.dto;

public final class RestUrlRepository {
    // TODO Send as Parameter
    private static String remoteServer = "https://greencity.azurewebsites.net";
    private static String localServer = "http://192.168.0.103:8080";

    private RestUrlRepository() {
    }

    public static RestUrl getDefault() {
    	return getSignin();
    }

	// POST "https://***/ownSecurity/signIn" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"email\": \"***\", \"password\": \"***\"}"
    /**
     * Prepare ULR for REST Sign-in response.
     * @return RestUrl
     */
    public static RestUrl getSignin() {

        return new RestUrl()
                .addBaseUrl(remoteServer)
//                .addBaseUrl(localServer)
                .addGetUrl("")
                .addPostUrl("/ownSecurity/signIn")
                .addPutUrl("")
                .addDeleteUrl("")
                .addPatchUrl("");
    }

    // POST "https://***/ownSecurity/signUp" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"email\": \"***\", \"lang\": \"***\", \"name\": \"***\", \"password\": \"***\"}"
    /**
     * Prepare ULR for REST Sign-Up response.
     * @return RestUrl
     */
    public static RestUrl getSignUp() {
        return new RestUrl()
//                .addBaseUrl(remoteServer)
                .addBaseUrl(localServer)
                .addGetUrl("")
                .addPostUrl("/ownSecurity/signUp")
                .addPutUrl("")
                .addDeleteUrl("")
                .addPatchUrl("");
    }

    // http://***/googleSecurity?idToken=**" -H "accept: */*" -H "Authorization: Bearer ***"
    /**
     * Prepare ULR for REST GoogleSecurity response.
     * @return RestUrl
     */
    public static RestUrl getGoogleSecurity() {
        return new RestUrl()
//                .addBaseUrl(remoteServer)
                .addBaseUrl(localServer)
                .addGetUrl("/googleSecurity")
                .addPostUrl("")
                .addPutUrl("")
                .addDeleteUrl("")
                .addPatchUrl("");
    }
    
    // http://***/ownSecurity/verifyEmail?token=***&user_id=***" -H "accept: */*
    /**
     * Prepare ULR for REST VerifyEmail response.
     * @return RestUrl
     */
    public static RestUrl getVerifyEmail() {
        return new RestUrl()
//                .addBaseUrl(remoteServer)
                .addBaseUrl(localServer)
                .addGetUrl("/ownSecurity/verifyEmail")
                .addPostUrl("")
                .addPutUrl("")
                .addDeleteUrl("")
                .addPatchUrl("");
    }

    //"http://***/user" -H "accept: */*" -H "Authorization: Bearer ***"
    /**
     * Prepare ULR for REST UserDto (Email notification) response.
     * @return RestUrl
     */
    public static RestUrl getUserDto() {
        return new RestUrl()
//                .addBaseUrl(remoteServer)
                .addBaseUrl(localServer)
                .addGetUrl("/user")
                .addPostUrl("")
                .addPutUrl("")
                .addDeleteUrl("")
                .addPatchUrl("");
    }

// EcoNews ---------------------------------------------------------------------

    public static RestUrl getAllTags() {
        return new RestUrl()
                .addBaseUrl(remoteServer)
                .addGetUrl("/tags")
                .addPostUrl("")
                .addPutUrl("")
                .addDeleteUrl("")
                .addPatchUrl("");
    }

    public static RestUrl getRecentlyCreatedNews() {
        return new RestUrl()
                .addBaseUrl(remoteServer)
                .addGetUrl("/econews/newest")
                .addPostUrl("")
                .addPutUrl("")
                .addDeleteUrl("")
                .addPatchUrl("");
    }

    public static RestUrl getNews() {
        return new RestUrl()
                .addBaseUrl(remoteServer)
                .addGetUrl("/econews")
                .addPostUrl("/econews")
                .addPutUrl("")
                .addDeleteUrl("/econews/{" + KeyParameters.ECONEWS_ID.toString() + "}")
                .addPatchUrl("");
    }

    public static RestUrl getNewsById() {
        return new RestUrl()
                .addBaseUrl(remoteServer)
                .addGetUrl("/econews/{" + KeyParameters.ID.toString() + "}")
                .addPostUrl("")
                .addPutUrl("")
                .addDeleteUrl("")
                .addPatchUrl("");
    }

    public static RestUrl getEconewsByTag() {
        return new RestUrl()
                .addBaseUrl(remoteServer)
                .addGetUrl("/econews/tags")
                .addPostUrl("")
                .addPutUrl("")
                .addDeleteUrl("")
                .addPatchUrl("");
    }

    //ChangePassword -------------------------------------------------------------

    public static RestUrl getChangePassword() {
        return new RestUrl()
                .addBaseUrl(remoteServer)
                .addPostUrl("/ownSecurity/changePassword")
                .addPutUrl("")
                .addPatchUrl("");
    }

    public static RestUrl getRestorePassword() {
        return new RestUrl()
                .addBaseUrl(remoteServer)
                .addPostUrl("")
                .addGetUrl("/ownSecurity/restorePassword")
                .addPutUrl("")
                .addPatchUrl("");
    }

    //Places ---------------------------------------------------------------------

    public static RestUrl getPlacesByStatus() {
        return new RestUrl()
                .addBaseUrl(remoteServer)
                .addGetUrl("/place/{" + KeyParameters.PLACE_STATUS.toString() + "}")
                .addPostUrl("")
                .addPutUrl("")
                .addDeleteUrl("")
                .addPatchUrl("");
    }

	// https://***/place/about/1 -H "accept: */*" -H "Authorization: Bearer **"
    public static RestUrl getPlaceAbouId() {
        return new RestUrl()
                .addBaseUrl(remoteServer)
//                .addBaseUrl(localServer)
                .addGetUrl("/place/about/{" + KeyParameters.PLACE_ID.toString() + "}")
                .addPostUrl("")
                .addPutUrl("")
                .addDeleteUrl("")
                .addPatchUrl("");
    }

    public static RestUrl getPlacesByPredicate() {
        return new RestUrl()
                .addBaseUrl(remoteServer)
                .addGetUrl("")
                .addPostUrl("/place/filter/predicate")
                .addPutUrl("")
                .addDeleteUrl("")
                .addPatchUrl("");
    }

    public static RestUrl getPlaceInfoId() {
        return new RestUrl()
                .addBaseUrl(remoteServer)
                .addGetUrl("/place/info/favorite/{" + KeyParameters.PLACE_ID.toString() + "}")
                .addPostUrl("")
                .addPutUrl("")
                .addDeleteUrl("")
                .addPatchUrl("");
    }


    //Favorite Places ---------------------------------------------------------------------
    public static RestUrl favoritePlaces() {
        return new RestUrl()
                .addBaseUrl(remoteServer)
                .addGetUrl("/favorite_place")
                .addPostUrl("")
                .addPutUrl("/favorite_place")
                .addDeleteUrl("")
                .addPatchUrl("");
    }

//News Subscriber---------------------------------------------------------------------------------

    public static RestUrl getNewsSubscriber() {
        return new RestUrl()
                .addBaseUrl(remoteServer)
                .addGetUrl("/newsSubscriber") //admin can get all newsSubcriber
                .addPostUrl("/newsSubscriber")
                .addPutUrl("")
                .addDeleteUrl("")
                .addPatchUrl("");

    }

   public static RestUrl getNewsSubscriberUnsubscribe() {
       return new RestUrl()
               .addBaseUrl(remoteServer)
               .addGetUrl("/newsSubscriber/unsubscribe")//admin
               .addPostUrl("")
               .addPutUrl("")
               .addDeleteUrl("")
               .addPatchUrl("");
   }


//Advice -----------------------------------------------------------------------------------------

   public static RestUrl getAdvices() {
       return new RestUrl()
               .addBaseUrl(remoteServer)
               .addGetUrl("/advices")
               .addPostUrl("/advices")
               .addPutUrl("/advices/{" + KeyParameters.ADVICE_ID.toString() + "}")
               .addDeleteUrl("/advices/{" + KeyParameters.ADVICE_ID.toString() + "}")
               .addPatchUrl("");

   }

   public static RestUrl getAdvicesRandom() {
       return new RestUrl()
               .addBaseUrl(remoteServer)
               .addGetUrl("/advices/random/{" + KeyParameters.HABIT_ID.toString()+ "}")
               .addPostUrl("")
               .addPutUrl("")
               .addDeleteUrl("")
               .addPatchUrl("");

   }

   // User Goals ---------------------------------------------------------------------

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

   // All goals ---------------------------------------------------------------------

   public static RestUrl getAllGoals() { // Admin
       return new RestUrl()
               .addBaseUrl(remoteServer)
               .addGetUrl("/goals")
               .addPostUrl("")
               .addPutUrl("")
               .addDeleteUrl("")
               .addPatchUrl("");
   }

   // Achievement ---------------------------------------------------------------------

   public static RestUrl getAchievement() { // Admin
       return new RestUrl()
               .addBaseUrl(remoteServer)
               .addGetUrl("/achievements")
               .addPostUrl("")
               .addPutUrl("")
               .addDeleteUrl("")
               .addPatchUrl("");
   }

   // Habits Statistic ---------------------------------------------------------------------

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

   // User habits ---------------------------------------------------------------------

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
