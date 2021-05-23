package com.atms.model;

public class OpeningHours {

	private String dayOfWeek;
	
	private Hours[] hours;

	public String getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public Hours[] getHours() {
		return hours;
	}

	public void setHours(Hours[] hours) {
		this.hours = hours;
	}
	
	
}
