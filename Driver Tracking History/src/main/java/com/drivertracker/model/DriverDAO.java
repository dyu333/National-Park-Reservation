package com.drivertracker.model;

import java.util.List;

public interface DriverDAO {

	public List<Object> getDriverResults();
	
	public long createDriverRecord();
	
	public long createDriverNameRecord();

	
	
}
