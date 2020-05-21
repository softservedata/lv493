package com.softserve.edu.greencity.rest.entity;

public class LogginedUserEntity {
	private int userId;
	private String accessToken;
	private String refreshToken;
	private String name;
	private boolean ownRegistrations;

	public LogginedUserEntity() {
		userId = -1;
		accessToken = "";
		refreshToken = "";
		name = "";
		ownRegistrations = false;
	}
	
	public LogginedUserEntity(int userId, String accessToken,
			String refreshToken, String name,
			boolean ownRegistrations) {
		this.userId = userId;
		this.accessToken = accessToken;
		this.refreshToken = refreshToken;
		this.name = name;
		this.ownRegistrations = ownRegistrations;
	}

	public int getUserId() {
		return userId;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public String getName() {
		return name;
	}

	public boolean isOwnRegistrations() {
		return ownRegistrations;
	}

	@Override
	public String toString() {
		return "LogginedUserEntity [userId=" + userId
				+ ", accessToken=" + accessToken
				+ ", refreshToken="
				+ refreshToken + ", name="
				+ name + ", ownRegistrations="
				+ ownRegistrations + "]";
	}
	
}
