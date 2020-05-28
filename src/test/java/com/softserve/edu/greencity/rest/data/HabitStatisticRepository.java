package com.softserve.edu.greencity.rest.data;

import com.softserve.edu.greencity.rest.entity.HabitStatisticEntity;

public class HabitStatisticRepository {
	private static volatile HabitStatisticRepository instance = null;

	private HabitStatisticRepository() {
	}

	public static HabitStatisticRepository get() {
		if (instance == null) {
			synchronized (HabitStatisticRepository.class) {
				if (instance == null) {
					instance = new HabitStatisticRepository();
				}
			}
		}
		return instance;
	}

	public HabitStatisticEntity getDefault() {
		return availableStatistic();
	}

	public HabitStatisticEntity availableStatistic() {
		return new HabitStatisticEntity(1,"2019-11-13T00:00:00+03:00",HabitRate.GOOD, 5);
	}



}
