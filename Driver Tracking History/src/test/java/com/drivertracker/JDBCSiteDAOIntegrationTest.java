package com.techelevator;

import java.time.LocalDate;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import com.techelevator.model.Campground;
import com.techelevator.model.Site;
import com.techelevator.model.SiteDAO;
import com.techelevator.model.jdbc.JDBCSiteDAO;

public class JDBCSiteDAOIntegrationTest extends DAOIntegrationTest {
	
	private SiteDAO siteDAO;
	private DataSource dataSource = super.getDataSource();
	private JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	
	@Before
	public void setup() {
		siteDAO = new JDBCSiteDAO(dataSource);
	}

	@Test
	public void verify_reservation_conflicting_dates() {
	
		Campground campground2 = new Campground();
		campground2.setCampground_id(1);
		
		List<Object> sites = siteDAO.getAvailableSites(campground2, LocalDate.parse("2018-10-24"), LocalDate.parse("2018-10-27"));
		for (Object site : sites) {
			long id = ((Site) site).getSite_id();
			Assert.assertFalse(id == 1);
		}
	}
	
	@Test
	public void verify_reservation_no_conflicting_dates() {
	
		Campground campground2 = new Campground();
		campground2.setCampground_id(1);
		
		List<Object> sites = siteDAO.getAvailableSites(campground2, LocalDate.parse("2019-10-24"), LocalDate.parse("2019-10-27"));
		boolean included = false;
		for (Object site : sites) {
			long id = ((Site) site).getSite_id();
			if (id == 1) {
				included = true;
			}
		}

		Assert.assertTrue(included);
	}	

}
