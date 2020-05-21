package com.softserve.edu.greencity.rest.entity;

public class UserGoalsEntity {
	private int id;
	private String text;
	private String status;

	public UserGoalsEntity() {
		id = -1;
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
		return "UserGoalsEntity [id=" + id
				+ ", text=" + text
				+ ", status=" + status + "]";
	}

}
