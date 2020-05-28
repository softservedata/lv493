package com.softserve.edu.greencity.rest.dto;

public final class RestUrlRepository {
    // TODO Send as Parameter
    private static String remoteServer = "https://greencity.azurewebsites.net";

    private RestUrlRepository() {
    }

    public static RestUrl getDefault() {
        return getSignin();
    }

    public static RestUrl getSignin() {
        return new RestUrl().addBaseUrl(remoteServer)
                .addGetUrl("")
                .addPostUrl("/ownSecurity/signIn")
                .addPutUrl("")
                .addDeleteUrl("")
                .addPatchUrl("");
    }

    public static RestUrl getUserGoals() {
        return new RestUrl().addBaseUrl(remoteServer)
                .addGetUrl("/user/{" + KeyParameters.USER_ID.toString() + "}/goals")
                .addPostUrl("/user/{" + KeyParameters.USER_ID.toString() + "}/goals")
                .addPutUrl("")
                .addDeleteUrl("")
                .addPatchUrl("");
    }

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
                .addGetUrl("/newsSubscriber/unsubscribe")
                .addPostUrl("")
                .addPutUrl("")
                .addDeleteUrl("")
                .addPatchUrl("");
    }
    
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
