package com.softserve.edu.greencity.ui.data;

public class HabitItemRepository {
    private HabitItemRepository() {
    }

    public static HabitItem getSaveBagsHabit() {
        return new HabitItem(Habit.SAVE_BAGS, 9, Estimation.SUPER);
    }

    public static HabitItem getDiscardCupsHabit() {
        return new HabitItem(Habit.DISCARD_DISPOSABLE_CUPS, 2, Estimation.NORMAL);
    }

}
