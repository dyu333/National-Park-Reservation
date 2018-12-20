package com.techelevator.model.jdbc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.model.Campground;
import com.techelevator.model.Site;
import com.techelevator.model.SiteDAO;

public class JDBCSiteDAO implements SiteDAO {
	
	private JdbcTemplate template;
	
	public JDBCSiteDAO(DataSource datasource) {
		template = new JdbcTemplate(datasource);
	}
	
	@Override
	public List<Object> getAvailableSites(Campground camp, LocalDate arrive, LocalDate depart) {
		
		List<Object> availableSites = new ArrayList<Object>();
		
		String sql = "SELECT DISTINCT * FROM site JOIN campground ON "
				+ "site.campground_id = campground.campground_id WHERE site.campground_id = ? " 
				+ "AND site_id NOT IN (SELECT site.site_id FROM site JOIN reservation ON "
				+ "reservation.site_id = site.site_id WHERE (? >= reservation.from_date AND "
				+ "? <= reservation.to_date) OR (? >= reservation.from_date AND ? <= reservation.to_date) OR"
				+ "(? < reservation.from_date AND ? > reservation.to_date) ) ORDER BY daily_fee LIMIT 5";
		
		SqlRowSet results = template.queryForRowSet(sql, camp.getCampground_id(), arrive, 
				arrive, depart, depart, arrive, depart);
		
		while (results.next()) {
			Site site = mapRowToSite (results);
			availableSites.add(site);
		}
		return availableSites;
	}

	private Site mapRowToSite(SqlRowSet results) {
		Site site = new Site();
		site.setSite_id(results.getLong("site_id"));
		site.setCampground_id(results.getLong("campground_id"));
		site.setSite_number(results.getInt("site_number"));
		site.setMax_occupancy(results.getInt("max_occupancy"));
		site.setAccessible(results.getBoolean("accessible"));
		site.setMax_rv_length(results.getInt("max_rv_length"));
		site.setUtilities(results.getBoolean("utilities"));
		
		return site;
	}
}