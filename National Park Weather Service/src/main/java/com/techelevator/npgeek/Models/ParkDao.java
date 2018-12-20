package com.techelevator.npgeek.Models;

import java.util.List;

public interface ParkDao {
	
	public List<Park> getAllParks();
	
	public Park getParkByParkCode(String parkcode);

}
