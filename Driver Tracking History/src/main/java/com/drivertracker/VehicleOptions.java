package com.techelevator;

public class VehicleOptions implements Vehicle {
	
	private String name;
	private int distance;
	
	public VehicleOptions(String name, int distance) {
		this.name = name;
		this.distance = distance;
	}
	
	public String getName() {
		return name;
	}
	public int getDistance() {
		return distance;
	}

	@Override
	public double calculateToll(int distance) {
		// TODO Auto-generated method stub
		return 0;
	}


}
