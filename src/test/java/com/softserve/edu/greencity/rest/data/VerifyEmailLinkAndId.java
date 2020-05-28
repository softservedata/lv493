package com.softserve.edu.greencity.rest.data;

import com.softserve.edu.greencity.rest.tools.RegexUtils;

public class VerifyEmailLinkAndId {

    private String verifyEmailURL;
    private String token;
    private int id;
    
    public VerifyEmailLinkAndId() {
        this.verifyEmailURL = "";
        this.id = -1;
        this.token = "";
    }

    public VerifyEmailLinkAndId(String verifyEmailURL) {
        this.verifyEmailURL = verifyEmailURL;
        getSplitEmailURL();
    }
    
    private void getSplitEmailURL() {
        this.id = RegexUtils.getId(verifyEmailURL);
        this.token = RegexUtils.getToken(verifyEmailURL);
    }

    public String getVerifyEmailURL() {
        return verifyEmailURL;
    }

    public String getToken() {
        return token;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "verifyEmailURL = " + verifyEmailURL + "\ntoken = " + token + ", id = " + id;
    }


}
