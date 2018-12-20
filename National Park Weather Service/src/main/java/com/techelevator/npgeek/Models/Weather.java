package com.techelevator.npgeek.Models;

public class Weather {

	private String parkCode;
	private Integer fiveDayForecastValue;
	private Integer low;
	private Integer high;
	private String forecast;
	
	
	public String getParkCode() {
		return parkCode.toLowerCase();
	}
	public void setParkCode(String parkcode) {
		this.parkCode = parkcode;
	}
	public Integer getFiveDayForecastValue() {
		return fiveDayForecastValue;
	}
	public void setFiveDayForecastValue(Integer fiveDayForecastValue) {
		this.fiveDayForecastValue = fiveDayForecastValue;
	}
	public Integer getLow() {
		return low;
	}
	public void setLow(Integer low) {
		this.low = low;
	}
	public Integer getHigh() {
		return high;
	}
	public void setHigh(Integer high) {
		this.high = high;
	}
	public String getForecast() {
		return forecast;
	}
	public void setForecast(String forecast) {
		this.forecast = forecast;
	}
	
}