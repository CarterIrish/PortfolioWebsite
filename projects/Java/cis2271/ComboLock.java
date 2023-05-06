package edu.vtc.cis2271;

public class ComboLock 
{
	private int _secret1;
	private int _secret2;
	private int _secret3;
	private int _current;
	private boolean _correct;
	public ComboLock(int secret1, int secret2, int secret3)
	{
		this._secret1 = secret1;
		this._secret2 = secret2;
		this._secret3 = secret3;
		this._current = 0;
		this._correct = false;
	}

	public void reset()
	{
		this._current = 0;
	}
	
	public void turnRight(int ticks)
	{
		reset();
		this._current += ticks;
		if(this._current == this._secret1 && this._correct == false)
			this._correct = true;
		else if(this._current==this._secret3 && this._correct == true)
			this._correct = true;
		else
			this._correct = false;
		
	}
	
	public void turnLeft(int ticks)
	{
		reset();
		this._current +=ticks;
		if(this._current == this._secret2 && this._correct == true)
			this._correct = true;
		else 
			this._correct = false;
		
	}
	
	public boolean open()
	{
		
		return this._correct;
	}
	
	public static void main(String[] args) 
	{
		// Some tests to confirm proper code(only one can be true at a time or all false)
		boolean Test1 = true;
		boolean Test2 = false;
		boolean Test3 = false;


		ComboLock lockerLock = new ComboLock(9,14,5);
		if(Test1 == false && Test2 == false && Test3 == false)
		{lockerLock.turnRight(9);
		lockerLock.turnLeft(14);
		lockerLock.turnRight(5);}
		
		if (Test1)
		{lockerLock.turnLeft(9);
		lockerLock.turnLeft(20);
		lockerLock.turnLeft(3);
		lockerLock.turnRight(5);}
		
		if (Test2)
		{lockerLock.turnRight(9);
		lockerLock.turnRight(14);
		lockerLock.turnRight(5);}
		
		if(Test3)
		{lockerLock.turnLeft(9);
		lockerLock.turnRight(15);
		lockerLock.turnLeft(5);}
			

		
		System.out.println(lockerLock.open());
	}

}
