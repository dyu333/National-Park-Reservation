package com.techelevator.npgeek.Models;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcWeatherDao implements WeatherDao {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcWeatherDao (DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Weather> getWeatherByParkCode(String parkcode) {
		List<Weather> weather = new ArrayList<>();
		String statement = "SELECT * FROM weather WHERE parkcode = ?";
		SqlRowSet result = jdbcTemplate.queryForRowSet(statement, parkcode.toUpperCase());

		while(result.next()) {
			weather.add(mapRowToWeather(result));
		}
		return weather;
	}

	private Weather mapRowToWeather(SqlRowSet result) {
		Weather currentWeather = new Weather();
		currentWeather.setParkCode(result.getString("parkcode"));
		currentWeather.setFiveDayForecastValue(result.getInt("fivedayforecastvalue"));
		currentWeather.setLow(result.getInt("low"));
		currentWeather.setHigh(result.getInt("high"));
		currentWeather.setForecast(result.getString("forecast"));
		
		return currentWeather;
	}

}