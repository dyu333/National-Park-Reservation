package com.techelevator.npgeek.Models;

import java.util.Map;

public interface SurveyDao {
	
	public void save(Survey survey);

	public Map<Park, Integer> getTopParks();

}
