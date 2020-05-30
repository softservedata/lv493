package com.softserve.edu.greencity.rest.data;

import java.util.ArrayList;
import java.util.List;

import com.softserve.edu.greencity.rest.entity.UserGoalEntity;

public class UserCustomGoalEntityRepository {
	private static volatile UserCustomGoalEntityRepository instance = null;

	private UserCustomGoalEntityRepository() {
	}

	public static UserCustomGoalEntityRepository get() {
		if (instance == null) {
			synchronized (UserCustomGoalEntityRepository.class) {
				if (instance == null) {
					instance = new UserCustomGoalEntityRepository();
				}
			}
		}
		return instance;
	}

	public UserGoalEntity getDefault() {
		return myGoal();
	}

	public UserGoalEntity myGoal() {
		return new UserGoalEntity(12, "My goal");
	}

	public List<UserGoalEntity> goalsForUpdating() {
        List<UserGoalEntity> result = new ArrayList<>();
        result.add(myGoal());
        return result;
    }

	public List<UserGoalEntity> goalsForDeleting() {
        List<UserGoalEntity> result = new ArrayList<>();
        result.add(myGoal());
        return result;
    }





}
