package com.softserve.edu.greencity.rest.data;

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

	public Habit getDefault() {
		return disposableCups();
	}

	public Habit disposableCups() {
		return new Habit(1);
	}



}
