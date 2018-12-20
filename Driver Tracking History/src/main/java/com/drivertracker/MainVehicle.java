package com.techelevator;

import java.util.Scanner;

public class MainVehicle {

	public static void main(String[] args) {

		System.out.println("Vehicle			Distance Traveled 		Toll$");
		System.out.println("---------------------------------------------------------------");
		
		Vehicle[] vehicleTolls = new Vehicle[] {new Car(), new CarWithTrailer(), new Tank(), new TruckFourAxles(), new TruckSixAxles(), new TruckEightPlusAxles()};
		
		for(Vehicle tollRates : vehicleTolls) {
			String name = tollRates.getName();
			int distance = tollRates.getDistance();
			double ratesForToll = tollRates.calculateToll(distance);
			System.out.println(name + "		" + distance + "			" + ratesForToll);
		}
			//System.out.println("Total Toll Revenue: " + totalTolls);
	
	}

}
