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
    
    public static RestUrl getSignUp() {
        return new RestUrl()
                .addBaseUrl(remoteServer)
//                .addBaseUrl(localServer)
                .addGetUrl("")
                .addPostUrl("/ownSecurity/signUp")
                .addPutUrl("")
                .addDeleteUrl("")
                .addPatchUrl("");
    }

    public static RestUrl getUserGoals() {
        return new RestUrl()
                .addBaseUrl(remoteServer)
                .addGetUrl("/user/{" + KeyParameters.USER_ID.toString() + "}/goals")
                .addPostUrl("/user/{" + KeyParameters.USER_ID.toString() + "}/goals")
                .addPutUrl("")
                .addDeleteUrl("")
                .addPatchUrl("");
    }
    
    // http://***/googleSecurity?idToken=**" -H "accept: */*" -H "Authorization: Bearer ***"
    public static RestUrl getGoogleSecurity() {
        return new RestUrl()
                .addBaseUrl(remoteServer)
//                .addBaseUrl(localServer)
                .addGetUrl("/googleSecurity")
                .addPostUrl("")
                .addPutUrl("")
                .addDeleteUrl("")
                .addPatchUrl("");
    }
    
    // http://***/ownSecurity/verifyEmail?token=***&user_id=***" -H "accept: */*
    public static RestUrl getVerifyEmail() {
        return new RestUrl()
                .addBaseUrl(remoteServer)
//                .addBaseUrl(localServer)
                .addGetUrl("/ownSecurity/verifyEmail")
                .addPostUrl("")
                .addPutUrl("")
                .addDeleteUrl("")
                .addPatchUrl("");
    }
    
    //"http://***/user" -H "accept: */*" -H "Authorization: Bearer ***"
    public static RestUrl getUserDto() {
        return new RestUrl()
                .addBaseUrl(remoteServer)
//                .addBaseUrl(localServer)
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

    //Places ---------------------------------------------------------------------
    
    public static RestUrl getPlacesByStatus() {
        return new RestUrl()
                .addBaseUrl(remoteServer)
                .addGetUrl("/place/{" + KeyParameters.PLACE_STATUS.toString() + "}")
                .addPostUrl("place/filter/predicate")
 //               .addPostUrl("")
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

}
