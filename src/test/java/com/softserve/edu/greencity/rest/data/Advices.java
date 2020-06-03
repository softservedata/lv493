package com.softserve.edu.greencity.rest.data;

public class Advices {
    private int habitId;
   

    public Advices(int habitId) {
        this.habitId = habitId;
        
    }
    
    //setters
    
    public int setHabitId(int habitId) {
        return habitId;
    }
    
    public String setLanguage(String language) {
        return language;
    }
    
    //getters
    
    public int getHabitId() {
        return habitId;
    }
    
//    public String getHabitId() {
//        String strHabitId = String.valueOf(habitId);
//        return strHabitId;
//    }
    
    
    @Override
    public String toString() {
        return "Advices [habitId= " + habitId + "]";
    }
    
}
