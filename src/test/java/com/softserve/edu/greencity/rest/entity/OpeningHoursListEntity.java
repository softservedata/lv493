package com.softserve.edu.greencity.rest.entity;

public class OpeningHoursListEntity {

    private String openTime;
    private String closeTime;
    private String weekDay;
    private String breakTime;
    
    public OpeningHoursListEntity() {
        this.openTime = "";
        this.closeTime = "";
        this.weekDay = "";
        this.breakTime = null;
    }
    
    public OpeningHoursListEntity(String openTime, String closeTime, String weekDay, String breakTime) {
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.weekDay = weekDay;
        this.breakTime = breakTime;
    }

    public String getOpenTime() {
        return openTime;
    }

    public String getCloseTime() {
        return closeTime;
    }

    public String getWeekDay() {
        return weekDay;
    }

    public String getBreakTime() {
        return breakTime;
    }

    @Override
    public String toString() {
        return "OpeningHoursListEntity [openTime=" + openTime + ", closeTime=" + closeTime + ", weekDay=" + weekDay + ", breakTime="
                + breakTime + "]";
    }
    
    
}
