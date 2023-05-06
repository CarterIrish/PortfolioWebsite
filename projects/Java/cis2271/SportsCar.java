package edu.vtc.cis2271;

public class SportsCar extends Vehicle {

	public SportsCar(CarCompany make, String model) {
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
		return 100;
	}
	
	@Override
	public int getMileage()
	{
		return 40;
	}
	
	@Override 
	public int getAverageSpeed()
	{
		return 60;
	}

}
