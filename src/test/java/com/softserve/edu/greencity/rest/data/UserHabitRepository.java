package com.softserve.edu.greencity.rest.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserHabitRepository {
	private static volatile UserHabitRepository instance = null;

	private UserHabitRepository() {
	}

	public static UserHabitRepository get() {
		if (instance == null) {
			synchronized (UserHabitRepository.class) {
				if (instance == null) {
					instance = new UserHabitRepository();
				}
			}
		}
		return instance;
	}

	public UserHabit getDefault() {
		return saveBags();
	}

	public UserHabit saveBags() {
		return new UserHabit("Save bags");
	}

	public UserHabit discardDisposableCups() {
        return new UserHabit("Discard disposable cups");
    }

	public UserHabit saveBagsUK() {
        return new UserHabit("Економити пакети");
    }

    public UserHabit discardDisposableCupsUK() {
        return new UserHabit("Відмовитись від одноразових стаканчиків");
    }


	public List<UserHabit> typicalHabits() {
        List<UserHabit> result = new ArrayList<>();
        result.add(discardDisposableCups());
        Collections.sort(result);
        return result;
    }

    public List<UserHabit> typicalHabitsUK() {
        List<UserHabit> result = new ArrayList<>();
        result.add(discardDisposableCupsUK());
        Collections.sort(result);
        return result;
    }

    public List<UserHabit> availableHabits() {
        List<UserHabit> result = new ArrayList<>();
        result.add(saveBags());
        Collections.sort(result);
        return result;
    }

    public List<UserHabit> availableHabitsUK() {
        List<UserHabit> result = new ArrayList<>();
        result.add(saveBagsUK());
        Collections.sort(result);
        return result;
    }


}
