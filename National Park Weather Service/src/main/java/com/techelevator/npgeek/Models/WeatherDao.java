package com.techelevator.npgeek.Models;

import java.util.List;

public interface WeatherDao {

	public List<Weather> getWeatherByParkCode(String parkcode);

}
