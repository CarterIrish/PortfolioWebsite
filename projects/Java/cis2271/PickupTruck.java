package edu.vtc.cis2271;

public class PickupTruck extends Vehicle {

	public PickupTruck(CarCompany make, String model) 
	{
		super(make, model);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int getPassengerCapacity()
	{
		return 1;
	}
	
	@Override
	public int getCargoCapacity()
	{
		return 2000;
	}
	
	@Override
	public int getMileage()
	{
		return 25;
	}
	
	@Override 
	public int getAverageSpeed()
	{
		return 60;
	}
}
