package com.techelevator;

public class FexEd extends DeliveryOptions implements DeliveryDriver {
	
	public FexEd(int customerWeight, int customerDistance) {
		super("                      FexEd", customerWeight, customerDistance);
	}
	
	public double calculateRate(int customerWeight, int customerDistance) {
		double rate = 20.00;
		if (customerDistance > 500) {
			double distanceRate = rate + 5.00;
			return distanceRate;
		}
		else if (customerWeight > 48) {
			double weightRate = rate + 3.00;
			return weightRate;
		}
		return rate;
	}
	
}