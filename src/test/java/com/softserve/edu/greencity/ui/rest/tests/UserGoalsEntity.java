package com.softserve.edu.greencity.ui.rest.tests;
class UserGoalsEntity {
	public int id;
	public String text;
	public String status;
	
	public UserGoalsEntity() {
		id = 0;
		text = "";
		status = "";
	}
	
	public UserGoalsEntity(int id, String text, String status) {
		this.id = id;
		this.text = text;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public String getText() {
		return text;
	}

	public String getStatus() {
		return status;
	}

	@Override
	public String toString() {
		return "userGoals [id=" + id
				+ ", text=" + text
				+ ", status=" + status + "]";
	}
	
}