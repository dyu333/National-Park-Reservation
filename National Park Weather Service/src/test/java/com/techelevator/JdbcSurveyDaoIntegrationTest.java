package com.techelevator;

import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.npgeek.Models.JdbcSurveyDao;
import com.techelevator.npgeek.Models.SurveyDao;

public class JdbcSurveyDaoIntegrationTest extends DAOIntegrationTest {
	
private SurveyDao surveyDao;
private DataSource dataSource = super.getDataSource();
private JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	
	@Before
	public void setup() {
		surveyDao = new JdbcSurveyDao(dataSource);
	}
	
	
	@Test
	public void verify_can_insert_survey() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(super.getDataSource());
		String insertSql = "INSERT INTO survey_result (parkcode, emailaddress, state, activitylevel) " +				       
				"VALUES ('TP', 'test@gmail.com', 'Ohio', 'active')";
		jdbcTemplate.update(insertSql);
		String sqlSurveySearch = "SELECT * FROM survey_result WHERE emailaddress = 'test@gmail.com'";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSurveySearch);
		Assert.assertTrue(results.next());
	}
	

}