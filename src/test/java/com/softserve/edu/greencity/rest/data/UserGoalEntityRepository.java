package com.softserve.edu.greencity.rest.data;

import java.util.ArrayList;
import java.util.List;

import com.softserve.edu.greencity.rest.entity.UserGoalEntity;

public class UserGoalEntityRepository {
	private static volatile UserGoalEntityRepository instance = null;

	private UserGoalEntityRepository() {
	}

	public static UserGoalEntityRepository get() {
		if (instance == null) {
			synchronized (UserGoalEntityRepository.class) {
				if (instance == null) {
					instance = new UserGoalEntityRepository();
				}
			}
		}
		return instance;
	}

	public UserGoalEntity getDefault() {
		return buyComposter();
	}

	public UserGoalEntity buyComposter() {
		return new UserGoalEntity(43, "Buy composter", "ACTIVE");
	}

	public UserGoalEntity buyBambooBrush() {
        return new UserGoalEntity(47, "Buy a bamboo brush", "ACTIVE");
    }

	public UserGoalEntity sortingTrash() {
        return new UserGoalEntity(48, "Start sorting trash", "ACTIVE");
    }

	public List<UserGoalEntity> goalsForDeleting() {
        List<UserGoalEntity> result = new ArrayList<>();
        result.add(sortingTrash());
        result.add(buyBambooBrush());
        return result;
    }


	public UserGoalEntity buyComposterAdd() {
        return new UserGoalEntity(1, "Buy composter", "");
    }

    public UserGoalEntity buyBambooBrushAdd() {
        return new UserGoalEntity(2, "Buy a bamboo brush", "");
    }

	public List<UserGoalEntity> goalsForAdding() {
        List<UserGoalEntity> result = new ArrayList<>();
        result.add(buyComposterAdd());
        result.add(buyBambooBrushAdd());
        return result;
    }

}
