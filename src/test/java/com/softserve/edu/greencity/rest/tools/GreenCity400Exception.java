package com.softserve.edu.greencity.rest.tools;

public class GreenCity400Exception extends GreenCityCommonException {
    private static final long serialVersionUID = 1L;
    //
    private static final String SIGN_UP_400_EXCEPTION_MESSAGE = "User with this email is already registered";
    private static final String VERIFY_EMAIL_400_EXCEPTION_MESSAGE = "No any email to verify by this token";
    private static final String GOOGLE_SECURITY_400_EXCEPTION_MESSAGE = "No message available";
    //

    public GreenCity400Exception() {
        super();
    }

    public GreenCity400Exception(Exception e) {
        super(e);
    }

    public GreenCity400Exception(String message) {
        super(message);
        if (message.equals(SIGN_UP_400_EXCEPTION_MESSAGE)) {
            signUp400Exeption();
        }
        if (message.equals(VERIFY_EMAIL_400_EXCEPTION_MESSAGE)) {
            verifyEmail400Exeption();
        }
        if (message.equals(GOOGLE_SECURITY_400_EXCEPTION_MESSAGE)) {
            googleSecurity400Exeption();
        }
    }

    public GreenCity400Exception(String message, Exception e) {
        super(message, e);
    }

    private void signUp400Exeption() {
        logger.error("Error registering: You entered registered user's email. Try to enter new email or go to logging.");
    }
    
    private void verifyEmail400Exeption() {
        logger.error("Error Verify email: No any email to verify by this token.");
    }
    
    private void googleSecurity400Exeption() {
        logger.error("Error Google Security: No message available.");
    }
}
