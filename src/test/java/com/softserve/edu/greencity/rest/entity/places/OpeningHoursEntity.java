package com.softserve.edu.greencity.rest.entity.places;

public class OpeningHoursEntity {
	
	private int id;
	private String openTime;
	private String closeTime;
	private String weekDay;
	private String breakTime;
	
	public OpeningHoursEntity() {
		
		this.id = -1;
		this.openTime = "";
		this.closeTime = "";
		this.weekDay = "";
		this.breakTime = "";
	}

	public OpeningHoursEntity(int id, String openTime, String closeTime, String weekDay, String breakTime) {
		
		this.id = id;
		this.openTime = openTime;
		this.closeTime = closeTime;
		this.weekDay = weekDay;
		this.breakTime = breakTime;
	}
	
	public int getId() {
		return id;
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
		return "OpeningHoursEntity [id=" + id + ", openTime=" + openTime + ", closeTime=" + closeTime + ", weekDay="
				+ weekDay + ", breakTime=" + breakTime + "]";
	}

}
