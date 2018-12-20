package com.techelevator;

public interface DeliveryDriver {

double calculateRate(int customerWeight, int customerDistance);
	
	String getName();
	int getCustomerWeight();
	int getCustomerDistance();

}