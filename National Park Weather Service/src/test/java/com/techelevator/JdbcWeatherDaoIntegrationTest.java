package com.techelevator;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import com.techelevator.npgeek.Models.JdbcWeatherDao;
import com.techelevator.npgeek.Models.Weather;
import com.techelevator.npgeek.Models.WeatherDao;

public class JdbcWeatherDaoIntegrationTest extends DAOIntegrationTest {
	
	private WeatherDao weatherDao;
	private DataSource dataSource = super.getDataSource();
	private JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	
	@Before
	public void setup() {
		weatherDao = new JdbcWeatherDao(dataSource);
	}
	
	@Test
	public void verify_weather_by_parkcode() {
		String insertSql = "INSERT INTO park (parkcode, parkname, state, acreage, elevationinfeet, milesoftrail, " +
	            "numberofcampsites, climate, yearfounded, annualvisitorcount, inspirationalquote, " +
				"inspirationalquotesource, parkdescription, entryfee, numberofanimalspecies) " +
				"VALUES ('TP', 'Test Park', 'Ohio', 30000, 700, 150.0, 1, 'Tropical', 2018, 2000000, " +
				"'Test quote', 'Test quote source', 'Test description', 50, 500)";
		jdbcTemplate.update(insertSql);
		String insertSql2 = "INSERT INTO weather (parkcode, fivedayforecastvalue, low, high, forecast) " +				       
				"VALUES ('TP', 1, 27, 40, 'snow')";
		jdbcTemplate.update(insertSql2);

		List<Weather> weather = weatherDao.getWeatherByParkCode("TP");

		Assert.assertTrue(weather.size() > 0);
	}
	

}