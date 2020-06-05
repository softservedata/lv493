package com.softserve.edu.greencity.rest.data.myhabits;

public class UserHabitStatisticRepository {
	private static volatile UserHabitStatisticRepository instance = null;

	private UserHabitStatisticRepository() {
	}

	public static UserHabitStatisticRepository get() {
		if (instance == null) {
			synchronized (UserHabitStatisticRepository.class) {
				if (instance == null) {
					instance = new UserHabitStatisticRepository();
				}
			}
		}
		return instance;
	}

	public UserHabitStatistic getDefault() {
		return availableStatistic();
	}

	public UserHabitStatistic availableStatistic() {
		return new UserHabitStatistic("2020-04-27T16:50:18.241+03:00")
		        .addItemPerMonth(0, "cap")
		        .addUnTakenItem(0, "cap");
	}

}
