package com.softserve.edu.greencity.rest.data;

import java.util.ArrayList;
import java.util.List;

import com.softserve.edu.greencity.rest.entity.UserGoalsEntity;

public class UserGoal {
	private String text;
	private String status;

	public UserGoal(String text, String status) {
		this.text = text;
		this.status = status;
	}

	// setters

	public void setText(String text) {
		this.text = text;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	// getters

	public String getText() {
		return text;
	}

	public String getStatus() {
		return status;
	}

	// static factory
	
	public static UserGoal converToUserGoal(UserGoalsEntity userGoalsEntity) {
		return new UserGoal(userGoalsEntity.getText(), userGoalsEntity.getStatus());
	}
	
	public static List<UserGoal> converToUserGoalList(List<UserGoalsEntity> userGoalsEntities) {
		List<UserGoal> result = new ArrayList<>();
		for (UserGoalsEntity userGoalsEntity : userGoalsEntities) {
			result.add(converToUserGoal(userGoalsEntity));
		}
		return result;
	}
	
}
