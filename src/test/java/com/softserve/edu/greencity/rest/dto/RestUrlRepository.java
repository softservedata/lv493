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
                .addPostUrl("/user/{" + KeyParameters.USER_ID.toString() + "}/goals")
                .addPutUrl("")
                .addDeleteUrl("")
                .addPatchUrl("");
    }
    
    public static RestUrl getNews() {
        return new RestUrl()
                .addBaseUrl(remoteServer)
                //.addGetUrl("/econews/{" + KeyParameters.ID.toString() + "}")
                .addPostUrl("/econews")
                .addPutUrl("")
                //.addDeleteUrl("/econews/{" + KeyParameters.ECONEWS_ID.toString() + "}")
                .addPatchUrl("");
    }

}
