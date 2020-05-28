package com.softserve.edu.greencity.rest.entity;

public class UserGoalEntity {
	private int id;
	private String text;
	private String status;

	public UserGoalEntity() {
		id = -1;
		text = "";
		status = "";
	}

	public UserGoalEntity(int id, String text) {
        this.id = id;
        this.text = text;
        this.status = "";
    }

	public UserGoalEntity(int id, String text, String status) {
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
		return "UserGoalsEntity [id=" + id
				+ ", text=" + text
				+ ", status=" + status + "]";
	}


}
