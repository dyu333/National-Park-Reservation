package com.techelevator;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.model.CampgroundDAO;
import com.techelevator.model.Park;
import com.techelevator.model.jdbc.JDBCCampgroundDAO;

public class JDBCCampgroundDAOIntegrationTest extends DAOIntegrationTest {
	
	private CampgroundDAO campgroundDAO;
	private DataSource dataSource = super.getDataSource();
	private JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	
	@Before
	public void setup() {
		campgroundDAO = new JDBCCampgroundDAO(dataSource);
	}
	
	@Test
	public void verify_all_campgrounds() {
		String insertSql2 = "INSERT INTO park (name, location, establish_date, area, visitors, description) VALUES ('testpark', 'Arizona', '1919-02-26', 473999, 2000000, 'park description')";
		jdbcTemplate.update(insertSql2);
		String insertSql3 = "SELECT park_id FROM park WHERE name = 'testpark'";
		SqlRowSet park = jdbcTemplate.queryForRowSet(insertSql3);
		park.next();
		Long parkid = park.getLong("park_id");
		String insertSql = "INSERT INTO campground (park_id, name, open_from_mm, open_to_mm, daily_fee) VALUES (?, 'test', '01', '02', 50.00)";
		jdbcTemplate.update(insertSql, parkid);
		
			Park park1 = new Park();
			park1.setPark_id(parkid);
		
		List<Object> campground = campgroundDAO.getAllCampgrounds(park1);
		
		Assert.assertTrue(campground.size() > 0);
	}

}
