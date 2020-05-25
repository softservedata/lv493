package com.softserve.edu.greencity.rest.data;

public enum UserGoalStatus {
	ACTIVE("ACTIVE"),
	DONE("DONE");
	
	private String status;

    private UserGoalStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
    	return status;
    }
}
