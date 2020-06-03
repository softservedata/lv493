package com.softserve.edu.greencity.rest.dto;

public final class RestUrlRepository {
    // TODO Send as Parameter
    private static String remoteServer = "https://greencity.azurewebsites.net";
    private static String localServer = "http://localhost:8080";

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
    
    public static RestUrl getSignUp() {
        return new RestUrl()
                .addBaseUrl(remoteServer)
                .addGetUrl("")
                .addPostUrl("/ownSecurity/signUp")
                .addPutUrl("")
                .addDeleteUrl("")
                .addPatchUrl("");
    }

    public static RestUrl getGoogleSecurity() {
        return new RestUrl()
                .addBaseUrl(remoteServer)
                .addGetUrl("/googleSecurity")
                .addPostUrl("")
                .addPutUrl("")
                .addDeleteUrl("")
                .addPatchUrl("");
    }

    public static RestUrl getVerifyEmail() {
        return new RestUrl()
                .addBaseUrl(remoteServer)
                .addGetUrl("/ownSecurity/verifyEmail")
                .addPostUrl("")
                .addPutUrl("")
                .addDeleteUrl("")
                .addPatchUrl("");
    }

    public static RestUrl getUserDto() {
        return new RestUrl()
                .addBaseUrl(remoteServer)
                .addGetUrl("/user")
                .addPostUrl("")
                .addPutUrl("")
                .addDeleteUrl("")
                .addPatchUrl("");
    }
    
// EcoNews ---------------------------------------------------------------------

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

    public static RestUrl getEcoNewsByTag() {
        return new RestUrl()
                .addBaseUrl(remoteServer)
                .addGetUrl("/econews/tags")
                .addPostUrl("")
                .addPutUrl("")
                .addDeleteUrl("")
                .addPatchUrl("");
    }

    //Favorite Places ---------------------------------------------------------------------
    public static RestUrl favoritePlaces() {
        return new RestUrl()
                .addBaseUrl(remoteServer)
                .addGetUrl("/favorite_place/")
                .addPostUrl("")
                .addPutUrl("/favorite_place/")
                .addDeleteUrl("/favorite_place/{" + KeyParameters.PLACE_ID.toString() + "}")
                .addPatchUrl("");
    }

    public static RestUrl saveFavoritePlace() {
        return new RestUrl()
                .addBaseUrl(remoteServer)
                .addGetUrl("")
                .addPostUrl("/place/save/favorite/")
                .addPutUrl("")
                .addDeleteUrl("")
                .addPatchUrl("");
    }

    public static RestUrl favoritePlacesById() {
        return new RestUrl()
                .addBaseUrl(remoteServer)
                .addGetUrl("/favorite_place/favorite/{" + KeyParameters.PLACE_ID.toString() + "}")
                .addPostUrl("")
                .addPutUrl("")
                .addDeleteUrl("")
                .addPatchUrl("");
    }
}
