package com.softserve.edu.greencity.rest.data;

public enum PlaceStatus {
	
	APPROVED("APPROVED"),
	DECLINED("DECLINED"),
	DELETED("DELETED"),
	PROPOSED("PROPOSED");
	
	PlaceStatus(String status) {
		this.status = status;
	}

	private String status;
	
	 @Override
	 public String toString() {
	       return status;
	    }
	
}
