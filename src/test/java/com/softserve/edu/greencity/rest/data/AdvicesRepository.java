package com.softserve.edu.greencity.rest.data;

public class AdvicesRepository {
    
    private static AdvicesRepository instance = null;

    public AdvicesRepository() {
    }
    
    public static AdvicesRepository get() {
        if (instance == null) {
            synchronized (AdvicesRepository.class) {
                if (instance == null) {
                    instance = new AdvicesRepository();
                }
            }
        }
        return instance;
    }
    
    public Advices gefault() {
        return getHabitID();
    }
    
    public Advices getHabitID() {
        return new Advices(1);
    }
    
}