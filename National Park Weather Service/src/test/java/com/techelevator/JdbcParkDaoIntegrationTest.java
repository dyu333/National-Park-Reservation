package com.techelevator;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.npgeek.Models.JdbcParkDao;
import com.techelevator.npgeek.Models.Park;
import com.techelevator.npgeek.Models.ParkDao;

public class JdbcParkDaoIntegrationTest extends DAOIntegrationTest {
	
	private ParkDao parkDao;
	private DataSource dataSource = super.getDataSource();
	private JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	
	@Before
	public void setup() {
		parkDao = new JdbcParkDao(dataSource);
	}
	
	@Test
	public void verify_all_parks() {
		String insertSql = "DELETE FROM weather";
		jdbcTemplate.update(insertSql);
		String insertSql2 = "DELETE FROM park";
		jdbcTemplate.update(insertSql2);
		String insertSql3 = "INSERT INTO park (parkcode, parkname, state, acreage, elevationinfeet, milesoftrail, " +
				            "numberofcampsites, climate, yearfounded, annualvisitorcount, inspirationalquote, " +
							"inspirationalquotesource, parkdescription, entryfee, numberofanimalspecies) " +
							"VALUES ('TP', 'Test Park', 'Ohio', 30000, 700, 150.0, 1, 'Tropical', 2018, 2000000, " +
							"'Test quote', 'Test quote source', 'Test description', 50, 500)";
		jdbcTemplate.update(insertSql3);

		List<Park> parks = parkDao.getAllParks();

		Assert.assertTrue(parks.size() > 0);
	}
	

	@Test
	public void get_parks_by_parkCode_returns_parks() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(super.getDataSource());
		String insertSQL = "INSERT INTO park (parkcode, parkname, state, acreage, elevationinfeet, milesoftrail, " +
	            "numberofcampsites, climate, yearfounded, annualvisitorcount, inspirationalquote, " +
				"inspirationalquotesource, parkdescription, entryfee, numberofanimalspecies) " +
				"VALUES ('TP', 'Test Park', 'Ohio', 30000, 700, 150.0, 1, 'Tropical', 2018, 2000000, " +
				"'Test quote', 'Test quote source', 'Test description', 50, 500)";
		jdbcTemplate.update(insertSQL);
		String sqlParkcodeSearch = "SELECT * FROM park WHERE parkcode = 'TP'";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlParkcodeSearch);
		Assert.assertTrue(results.next());
	}

}
