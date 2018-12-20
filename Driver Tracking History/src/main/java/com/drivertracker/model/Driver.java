package com.drivertracker.model;

import java.math.BigDecimal;
import java.sql.Time;

public class Driver {
	
	private long driver_id;
	private String driver;
	private Time startTime;
	private Time stopTime;
	private float milesDriven;
	private long results_id;
	private int totalMiles;
	private int averageSpeed;
	
	
	public long getDriver_id() {
		return driver_id;
	}
	public void setDriver_id(long driver_id) {
		this.driver_id = driver_id;
	}
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public Time getStartTime() {
		return startTime;
	}
	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}
	public Time getStopTime() {
		return stopTime;
	}
	public void setStopTime(Time stopTime) {
		this.stopTime = stopTime;
	}
	public float getMilesDriven() {
		return milesDriven;
	}
	public void setMilesDriven(float milesDriven) {
		this.milesDriven = milesDriven;
	}
	public long getResults_id() {
		return results_id;
	}
	public void setResults_id(long results_id) {
		this.results_id = results_id;
	}
	public int getTotalMiles() {
		return totalMiles;
	}
	public void setTotalMiles(int totalMiles) {
		this.totalMiles = totalMiles;
	}

	public int getAverageSpeed() {
		long difference = getStopTime()-getStartTime();
		
		this.averageSpeed = 
	}
		double yearCoeff = 365.26/getYear();
		this.alienAge= BigDecimal.valueOf(this.earthAge*yearCoeff);
		this.alienAge = alienAge.setScale(2, BigDecimal.ROUND_HALF_UP);
		return this.alienAge;
	}

	public int getAverageSpeeed(Time stopTime, Time startTime) {
		int mph = ((Math.floor(getStopTime()) - (Math.floor(getStartTime()));
		return mph;
}

	
	