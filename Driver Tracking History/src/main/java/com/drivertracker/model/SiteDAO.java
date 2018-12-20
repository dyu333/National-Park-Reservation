package com.techelevator.model;

import java.time.LocalDate;
import java.util.List;

public interface SiteDAO {
	
	public List<Object> getAvailableSites(Campground camp, LocalDate arrive, LocalDate depart);
	
}
