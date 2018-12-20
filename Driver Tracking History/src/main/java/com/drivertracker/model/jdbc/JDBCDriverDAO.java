package com.drivertracker.model.jdbc;

import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.drivertracker.model.Driver;
import com.drivertracker.model.DriverDAO;

public class JDBCDriverDAO implements DriverDAO {

	private JdbcTemplate template;
	
	public JDBCDriverDAO(DataSource datasource) {
		template = new JdbcTemplate(datasource);
	}

	@Override
	public List<Object> getDriverResults() {
		List<Object> drivers = new ArrayList<Object>();
		
		String sql = "SELECT * FROM driver_tracker_results GROUP BY driver " +
						"ORDER BY miles_driven ASC";
		SqlRowSet results = template.queryForRowSet(sql);
		
		while (results.next()) {
			Driver driver = mapRowToDriver(results);
			drivers.add(driver);
		}
		return drivers;
	}
	
	@Override
	public long createDriverRecord() {
		long nextDriverId = getNextDriverId();
		String sqlInsertNewDriverRecord = "INSERT INTO driving_history_tracker(driver_id, driver, " +
											"start_time, stop_time, miles_driven) VALUES(?, ?, ?, ?, ?)";

		template.update(sqlInsertNewDriverRecord);
	
		return nextDriverId;
	}
	
	@Override
	public long createDriverNameRecord() {
		long nextNameId = getNextNameId();
		String sqlInsertNewNameRecord = "INSERT INTO driver_name(name_id, name, VALUES(?, ?)";

		template.update(sqlInsertNewNameRecord);
	
		return nextNameId;
	}

	private Driver mapRowToDriver(SqlRowSet results) {
		Driver driver = new Driver();
		driver.setResults_id(results.getLong("results_id"));
		driver.setDriver(results.getString("driver"));
		driver.setTotalMiles(results.getInt("total_miles"));
		driver.setAverageSpeed(results.getInt("average_speed"));
		
		return driver;
	}
	
	private long getNextDriverId() {
		SqlRowSet nextIdResult = template.queryForRowSet("SELECT nextval('driver_id_seq')");
		if(nextIdResult.next()) {
			return nextIdResult.getLong(1);
		} else {
			throw new RuntimeException("Something went wrong while getting an id for the new department");
		}
	}
	
	private long getNextNameId() {
		SqlRowSet nextIdResult = template.queryForRowSet("SELECT nextval('name_id_seq')");
		if(nextIdResult.next()) {
			return nextIdResult.getLong(1);
		} else {
			throw new RuntimeException("Something went wrong while getting an id for the new department");
		}
	}
}
