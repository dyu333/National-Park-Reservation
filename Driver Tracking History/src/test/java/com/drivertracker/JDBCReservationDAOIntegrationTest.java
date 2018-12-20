package com.techelevator;

import java.time.LocalDate;
import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.model.ReservationDAO;
import com.techelevator.model.Site;
import com.techelevator.model.jdbc.JDBCReservationDAO;


public class JDBCReservationDAOIntegrationTest extends DAOIntegrationTest {
	
	private ReservationDAO reservationDAO;
	private DataSource dataSource = super.getDataSource();
	private JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	
	@Before
	public void setup() {
		reservationDAO = new JDBCReservationDAO(dataSource);
	}

	
	@Test
	public void verify_reservation_created() {
		
		Site site = new Site();
		site.setSite_id(1);
			
		reservationDAO.createReservation(site, "test", LocalDate.parse("2019-10-23"), LocalDate.parse("2019-10-27"));
		
		String sql = "SELECT * FROM reservation WHERE name = 'test'";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		
		Assert.assertTrue(results.next());
	}

}
