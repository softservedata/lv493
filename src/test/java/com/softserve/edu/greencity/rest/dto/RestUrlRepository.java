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
//                .addBaseUrl(remoteServer)
                .addBaseUrl(localServer)
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


