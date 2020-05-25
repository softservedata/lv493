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
	
	public EconewsUserService gotoEconewsUserService() {
		return new EconewsUserService(logginedUserEntity);
	}
	
	public MyhabitsService gotoMyhabitsService() {
		return new MyhabitsService(logginedUserEntity);
	}
}
