package com.softserve.edu.greencity.rest.data;

import java.util.ArrayList;
import java.util.List;

import com.softserve.edu.greencity.rest.entity.UserHabitEntity;

public class UserHabitEntityRepository {
	private static volatile UserHabitEntityRepository instance = null;

	private UserHabitEntityRepository() {
	}

	public static UserHabitEntityRepository get() {
		if (instance == null) {
			synchronized (UserHabitEntityRepository.class) {
				if (instance == null) {
					instance = new UserHabitEntityRepository();
				}
			}
		}
		return instance;
	}

	public UserHabitEntity getDefault() {
		return saveBags();
	}

	public UserHabitEntity saveBags() {
		return new UserHabitEntity(1, "Save bags");
	}

	public UserHabitEntity saveBagsDelete() {
        return new UserHabitEntity(41, "Save bags");
    }

	public List<UserHabitEntity> habitsForAddinging() {
        List<UserHabitEntity> result = new ArrayList<>();
        result.add(saveBags());
        return result;
    }

	public List<UserHabitEntity> habitsForDeleting() {
        List<UserHabitEntity> result = new ArrayList<>();
        result.add(saveBagsDelete());
        return result;
    }

}
