package com.techelevator;

public class Car extends VehicleOptions implements Vehicle {
	
	public Car() {
		super("                Car", 100);
	}

	public double calculateToll(int distance) {
		double toll = distance * 0.020;
			return toll;
	}

}
