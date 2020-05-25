package com.softserve.edu.greencity.rest.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserGoalRepository {
	private static volatile UserGoalRepository instance = null;

	private UserGoalRepository() {
	}

	public static UserGoalRepository get() {
		if (instance == null) {
			synchronized (UserGoalRepository.class) {
				if (instance == null) {
					instance = new UserGoalRepository();
				}
			}
		}
		return instance;
	}

	public UserGoal getDefault() {
		return buyComposter();
	}
	
	public UserGoal buyComposter() {
		return new UserGoal("Buy composter", "ACTIVE");
	}
	
	public UserGoal sortingTrash() {
		return new UserGoal("Start sorting trash", "ACTIVE");
	}
	
	public UserGoal recyclingBatteries() {
		return new UserGoal("Start recycling batteries", "ACTIVE");
	}
	
	public UserGoal bookVegans() {
		return new UserGoal("Finish book about vegans", "ACTIVE");
	}
	
	public List<UserGoal> typicalGoal() {
		List<UserGoal> result = new ArrayList<>();
		result.add(buyComposter());
		result.add(sortingTrash());
		result.add(recyclingBatteries());
		result.add(bookVegans());
		Collections.sort(result);
		return result;
	}
	
}
