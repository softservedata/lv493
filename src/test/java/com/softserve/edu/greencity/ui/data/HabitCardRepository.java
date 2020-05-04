package com.softserve.edu.greencity.ui.data;

public class HabitCardRepository {
    private HabitCardRepository() {
    }

    public static HabitCard getSaveBagsCard() {
        return new HabitCard(Habit.SAVE_BAGS);
    }

}
