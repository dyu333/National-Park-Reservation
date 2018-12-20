package com.techelevator.npgeek.Models;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcSurveyDao implements SurveyDao {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private ParkDao parkDao;
	
	@Autowired
	public JdbcSurveyDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	@Override
	public Map<Park, Integer> getTopParks() {
		Map<Park, Integer> topParks = new LinkedHashMap<>();
		String statement = "SELECT parkcode, COUNT(*) FROM survey_result GROUP BY parkcode ORDER BY COUNT(*) DESC LIMIT 5"; 
		SqlRowSet results = jdbcTemplate.queryForRowSet(statement);
		while(results.next()) {
			String parkCode = results.getString("parkcode");
			Integer surveyAmount = results.getInt("count");
			Park newPark = parkDao.getParkByParkCode(parkCode);
			topParks.put(newPark, surveyAmount);
		}
		return topParks;
	}
	
	
	
	@Override
	public void save(Survey newSurvey) {
		String sqlSurvey = "INSERT into survey_result (parkcode, emailaddress, state, activitylevel) " +
							"values(?, ?, ? ,?)";
		jdbcTemplate.update(sqlSurvey, newSurvey.getParkCode(), newSurvey.getEmailAddress(), newSurvey.getState(), newSurvey.getActivityLevel());
		
	}
	

}
