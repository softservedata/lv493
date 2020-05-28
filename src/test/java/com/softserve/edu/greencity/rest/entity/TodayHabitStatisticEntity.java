package com.softserve.edu.greencity.rest.entity;

public class TodayHabitStatisticEntity {
    private String habitItem;
    private int notTakenItems;

    public TodayHabitStatisticEntity() {
        habitItem = "";
        notTakenItems = -1;
    }

    public TodayHabitStatisticEntity(String habitItem, int notTakenItems) {
        this.habitItem = habitItem;
        this.notTakenItems = notTakenItems;
    }

    public String getHabitItem() {
        return habitItem;
    }

    public int getNotTakenItems() {
        return notTakenItems;
    }

    @Override
    public String toString() {
        return "TodayHabitStatisticEntity [habitItem=" + habitItem
                + ", notTakenItems=" + notTakenItems + "]";
    }

}
