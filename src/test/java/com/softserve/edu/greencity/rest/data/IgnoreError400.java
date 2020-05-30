package com.softserve.edu.greencity.rest.data;

public enum IgnoreError400 {
    EXIST_EMAIL("Subscriber with this email address exists in the database."), 
    FAULTY_EMAIL("непрвильно сформована email адреса"), 
    BAD_PASSWORD("Bad password"), 
    BAD_EMAIL("The user does not exist by this email"), 
    BLANK_FIELD("must not be blank"), 
    ALREADY_REGISTERED("User with this email is already registered"),
    VERIFY_EMAIL("No any email to verify by this token"),
    GOOGLE_SECURITY("No message available");

    private String message;

    private IgnoreError400(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }


}
