package com.techelevator.model.jdbc;

import java.time.LocalDate;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.model.ReservationDAO;
import com.techelevator.model.Site;

public class JDBCReservationDAO implements ReservationDAO {
	
	private JdbcTemplate template;
	
	public JDBCReservationDAO(DataSource datasource) {
		template = new JdbcTemplate(datasource);
	}
	
	@Override
	public long createReservation(Site site, String reservationName, LocalDate arrive, 
			LocalDate depart) {
		long nextId = getNextReservationId();
		String sqlInsertNewReservation = "INSERT INTO reservation(reservation_id, site_id, name, from_date, to_date, create_date) VALUES(?, ?, ?, ?, ?, ?)";

		template.update(sqlInsertNewReservation, nextId, site.getSite_id(), reservationName, arrive,
				depart, LocalDate.now());
	
		return nextId;
	}

	
	private long getNextReservationId() {
		SqlRowSet nextIdResult = template.queryForRowSet("SELECT nextval('reservation_reservation_id_seq')");
		if(nextIdResult.next()) {
			return nextIdResult.getLong(1);
		} else {
			throw new RuntimeException("Something went wrong while getting an id for the new department");
		}
	}
}
