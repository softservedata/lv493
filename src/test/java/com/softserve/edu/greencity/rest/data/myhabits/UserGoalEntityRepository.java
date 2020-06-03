package com.softserve.edu.greencity.rest.data.myhabits;

import java.util.ArrayList;
import java.util.List;

import com.softserve.edu.greencity.rest.entity.myhabits.UserGoalEntity;

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
        return new UserGoalEntity(1, "Buy composter", "ACTIVE");
    }

    public UserGoalEntity buyBambooBrush() {
        return new UserGoalEntity(2, "Buy a bamboo brush", "ACTIVE");
    }

    public UserGoalEntity sortingTrash() {
        return new UserGoalEntity(3, "Start sorting trash", "ACTIVE");
    }

    private List<UserGoalEntity> goalsForDeleting = new ArrayList<>();

    public void setGoalsForDeleting(List<UserGoalEntity> entities) {
        entities.forEach(goal -> goalsForDeleting.add(new UserGoalEntity(goal.getId(), goal.getText())));
    }

    public List<UserGoalEntity> goalsForDeleting() {
        return goalsForDeleting;
    }

    public List<UserGoalEntity> goalsForDoing() {
        List<UserGoalEntity> result = new ArrayList<>();
        result.add(sortingTrash());
        return result;
    }

    public List<UserGoalEntity> goalsForSelecting() {
        List<UserGoalEntity> result = new ArrayList<>();
        result.add(buyComposter());
        result.add(buyBambooBrush());
        return result;
    }

	public List<UserGoalEntity> goalsForAdding() {
        List<UserGoalEntity> result = new ArrayList<>();
        result.add(buyComposter());
        result.add(buyBambooBrush());
        return result;
    }

}
