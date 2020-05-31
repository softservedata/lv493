package com.softserve.edu.greencity.rest.data.myhabits;

public class HabitRepository {
	private static volatile HabitRepository instance = null;

	private HabitRepository() {
	}

	public static HabitRepository get() {
		if (instance == null) {
			synchronized (HabitRepository.class) {
				if (instance == null) {
					instance = new HabitRepository();
				}
			}
		}
		return instance;
	}

	public UserHabit getDefault() {
		return disposableCups();
	}

	public UserHabit disposableCups() {
		return new UserHabit("Discard disposable cups");
	}

	public UserHabit saveBugs() {
        return new UserHabit("Save bags");
    }


}
