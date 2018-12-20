package com.techelevator;

public class DeliveryOptions implements DeliveryDriver {
	
	private String name;
	public int customerWeight;
	public int customerDistance;
	
	public DeliveryOptions(String name, int customerWeight, int customerDistance ) {
		this.name = name;
		this.customerWeight = customerWeight;
		this.customerDistance = customerDistance;
	}
	
	public String getName() {
		return name;
	}
	public int getCustomerWeight() {
		return customerWeight;
	}
	public int getCustomerDistance() {
		return customerDistance;
	}

	@Override
	public double calculateRate(int customerWeight, int customerDistance) {
		// TODO Auto-generated method stub
		return 0;
	}

}
