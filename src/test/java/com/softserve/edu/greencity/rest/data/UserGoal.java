package com.softserve.edu.greencity.rest.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.softserve.edu.greencity.rest.entity.UserGoalsEntity;

public class UserGoal implements Comparable<UserGoal> {
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

	@Override
	public int compareTo(UserGoal userGoal) {
		return getText().compareTo(userGoal.getText());
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if ((obj == null) || (getClass() != obj.getClass())) {
			return false;
		}
		UserGoal other = (UserGoal) obj;
		if (((status == null) && (other.status != null) 
				|| (status != null) && (other.status == null))
				&& (!status.equals(other.status))) {
			return false;
		}
		if (((text == null) && (other.text != null) 
				|| (text != null) && (other.text == null))
				&& (!text.equals(other.text))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "UserGoal [text=" + text 
				+ ", status=" + status + "]";
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
		Collections.sort(result);
		return result;
	}
	
}
