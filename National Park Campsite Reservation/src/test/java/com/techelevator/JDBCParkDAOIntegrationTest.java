package com.techelevator;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.model.ParkDAO;
import com.techelevator.model.jdbc.JDBCParkDAO;

public class JDBCParkDAOIntegrationTest extends DAOIntegrationTest {
	
	private ParkDAO parkDAO;
	private DataSource dataSource = super.getDataSource();
	private JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	
	@Before
	public void setup() {
		parkDAO = new JDBCParkDAO(dataSource);
	}
	
	@Test
	public void verify_all_parks() {
		String insertSql = "INSERT INTO park (name, location, establish_date, area, visitors, description) VALUES ('test', 'testLocation', '1940-05-20', 100000, 1000000, 'testdescription')";
		jdbcTemplate.update(insertSql);
		
		List<Object> park = parkDAO.getAllParks();
		
		Assert.assertTrue(park.size() > 0);
		
		
	}
}
