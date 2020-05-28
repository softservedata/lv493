package com.softserve.edu.greencity.rest.entity;

public class HabitDictionaryIdEntity {
    private int habitDictionaryId;

    public HabitDictionaryIdEntity(int habitDictionaryId) {
        this.habitDictionaryId = habitDictionaryId;
    }

    public int getHabitDictionaryId() {
        return habitDictionaryId;
    }

    @Override
    public String toString() {
        return "HabitDirectoryIdEntity [habitDictionaryId=" + habitDictionaryId
                + "]";
    }

}
