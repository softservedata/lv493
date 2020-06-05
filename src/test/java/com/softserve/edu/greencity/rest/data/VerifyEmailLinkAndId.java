package com.softserve.edu.greencity.rest.data;

import com.softserve.edu.greencity.rest.tools.RegexUtils;

/**
 * VerifyEmailLinkAndId class for supporter VerifyEmailEntity and include verifyEmailURL and token.
 */
public class VerifyEmailLinkAndId {

    private String verifyEmailURL;
    private String token;
    private int id;
    
    /**
     * Default constructor.
     */
    public VerifyEmailLinkAndId() {
        this.verifyEmailURL = "";
        this.id = -1;
        this.token = "";
    }

    /**
     * Constructor.
     * @param verifyEmailURL String
     */
    public VerifyEmailLinkAndId(String verifyEmailURL) {
        this.verifyEmailURL = verifyEmailURL;
        getSplitEmailURL();
    }
    
    // getters
    /**
     * Parsing URL and set 'id' and 'token' fields.
     */
    private void getSplitEmailURL() {
        this.id = RegexUtils.getId(verifyEmailURL);
        this.token = RegexUtils.getToken(verifyEmailURL);
    }

    /**
     * Getter a 'verifyEmailURL' field.
     * @return String
     */
    public String getVerifyEmailURL() {
        return verifyEmailURL;
    }

    /**
     * Getter a 'token' field.
     * @return String
     */
    public String getToken() {
        return token;
    }

    /**
     * Getter a 'id' field.
     * @return int
     */
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "verifyEmailURL = " + verifyEmailURL + "\ntoken = " + token + ", id = " + id;
    }

}
