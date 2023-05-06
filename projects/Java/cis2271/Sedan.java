package edu.vtc.cis2271;

public class Sedan extends Vehicle
{

	public Sedan(CarCompany make, String model) 
	{
		super(make, model);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int getPassengerCapacity()
	{
		return 5;
	}
	
	@Override
	public int getCargoCapacity()
	{
		return 250;
	}
	
	@Override
	public int getMileage()
	{
		return 50;
	}
	
	@Override 
	public int getAverageSpeed()
	{
		return 60;
	}

}
