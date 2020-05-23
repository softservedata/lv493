package com.softserve.edu.greencity.rest.services;

import com.softserve.edu.greencity.rest.entity.LogginedUserEntity;

public class LogginedUserService {
	protected LogginedUserEntity logginedUserEntity;

	public LogginedUserService(LogginedUserEntity logginedUserEntity) {
		this.logginedUserEntity = logginedUserEntity;
	}

	// getters
	
	public LogginedUserEntity getLogginedUserEntity() {
		return logginedUserEntity;
	}
	
	// Business Logic
	
	public MyCabinetService gotoMyCabinetService() {
		return new MyCabinetService(logginedUserEntity);
	}
	
}
