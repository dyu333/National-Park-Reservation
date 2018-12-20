package com.techelevator;

import java.util.Scanner;

public class MainDelivery {

	public static void main(String[] args) {

		System.out.println("Please enter weight in ounces:");
		
		Scanner weightOunces = new Scanner(System.in);
		String weightInput = weightOunces.nextLine();
		
		System.out.println("How many miles is the distance to destination?");
		
		Scanner distanceMiles = new Scanner(System.in);
		String distanceInput = distanceMiles.nextLine();
		
		int customerWeight = Integer.parseInt(weightInput);
		int customerDistance = Integer.parseInt(distanceInput);

		System.out.println("Delivery Method				$cost");
		System.out.println("----------------------------------------------");
		
		DeliveryDriver[] deliveryMethod = new DeliveryDriver[] {new PostalServiceFirstClass(customerWeight, customerDistance), new PostalServiceSecondClass(customerWeight, customerDistance), new PostalServiceThirdClass(customerWeight, customerDistance), new FexEd(customerWeight, customerDistance), new SPUFourDayGround(customerWeight, customerDistance), new SPUTwoDayBusiness(customerWeight, customerDistance), new SPUNextDay(customerWeight, customerDistance)};
		
		for(DeliveryDriver shippingOptions : deliveryMethod) {
			String name = shippingOptions.getName();
			double ratesForShipping = shippingOptions.calculateRate(customerWeight, customerDistance);
			System.out.println(name + "		" + ratesForShipping);
		}
			//System.out.println("Total Miles Traveled: " + totalMiles);
	
	}

}
