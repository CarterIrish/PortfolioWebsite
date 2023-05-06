package edu.vtc.cis2271;

public abstract class Vehicle 
{
	private CarCompany _make;
	private String _model;
	private int _passengers;
	private int _cargo;

	public Vehicle(CarCompany make, String model)
	{
		this._model = model;
		this._make = make;
		this._passengers = 0;
		this._cargo = 0;

	}

	public String toString()
	{
		return this._make+ " "+ this._model;

	}

	public abstract int getPassengerCapacity();


	public abstract int getCargoCapacity();


	public void loadPassengers(int numPassengers)throws TooManyPassengersException
	{
		if(this._passengers+numPassengers>getPassengerCapacity())
		{
			throw new TooManyPassengersException();
		}
		else
			this._passengers += numPassengers;
	}
	
	public int unloadPassengers()
	{
		int tempPassengers=this._passengers;
		this._passengers =0;
		return tempPassengers;
	}
	
	public void loadCargo(int cargoWeight)throws TooMuchCargoException
	{
		if(this._cargo+cargoWeight>getCargoCapacity())
		{
			throw new TooMuchCargoException();
		}
	}
	
	public abstract int getAverageSpeed();
	public abstract int getMileage();
	
	public void transportPeople(int numPeople, int distance)
	{
		int trips = numPeople/getPassengerCapacity();
		if(numPeople%getPassengerCapacity()!=0)
			trips++;
		System.out.println("This trip will take "+trips+" trips");
		
		double time = ((double)distance/getAverageSpeed())*trips;
		System.out.println("The total time will take "+ time + " hours.");
		
		double gallonsGas = (double)distance/getMileage();
		System.out.println("The gallons of gas used is: "+gallonsGas);
	}
	


	public static void main(String[] args) 
	{
		CarCompany c1 = new CarCompany("Toyota");
		CarCompany c2 = new CarCompany("Ford");
		CarCompany c3 = new CarCompany("Mazda");
		Vehicle v1 = new Sedan(c1, "Camery");
		//System.out.println(v1);
		PickupTruck p1 = new PickupTruck(c2, "F-150");
		SportsCar sc1 = new SportsCar(c3, "Miata");
		Sedan se1 = new Sedan(c1, "camery");
		try 
		{
			sc1.loadPassengers(1);
		} catch (TooManyPassengersException e) {
			System.out.println("Too many passengers!!!!");
		}
		System.out.println(sc1.unloadPassengers());
		try {
			sc1.loadCargo(50);
		}
		catch (TooMuchCargoException e){
			System.out.println("Too much cargo!!!!");
		}
		p1.transportPeople(1, 100);

	}

}
