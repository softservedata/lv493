package com.softserve.edu.greencity.rest.data;

public class AdvicesRepository {

    public AdvicesRepository() {
    }
    
    public Advices gefault() {
        return getHabitID();
    }
    
    public static Advices getHabitID() {
        return new Advices(1);
    }
    
}