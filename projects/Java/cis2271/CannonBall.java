package edu.vtc.cis2271;

import java.util.Scanner;

public class CannonBall 
{
	private double _xcoord;
	private double _ycoord;
	private double _xvelo;
	private double _yvelo;
	
		
	public CannonBall(int x)
	{
		this._xcoord = x;
		this._ycoord = 0;
		this._xvelo = 0;
		this._yvelo = 0;
	}
	
	public void move(double sec)
	{
		this._xcoord += (sec * this._xvelo);
		this._ycoord += (sec * this._yvelo);
		//System.out.println("("+this._xcoord+", "+this._ycoord+")");
		this._yvelo += (-9.81*sec);
	}
	
	public double getX()
	{
		return this._xcoord;
	}
	
	public double getY()
	{
		return this._ycoord;
	}
	
	public void shoot(int angle, int velocity)
	{
		this._xvelo = velocity*(Math.cos(Math.toRadians(angle)));
		System.out.printf("Your X velocity is: %.4f \n", this._xvelo);
		
		this._yvelo = velocity*(Math.sin(Math.toRadians(angle))); 
		System.out.printf("Your Y velocity is: %.4f \n\n", this._yvelo);
		System.out.println("Time(s)    X      Y");
		move(.1);
		for(double i=.2; this._ycoord>0; i+=.1)
		{
			System.out.printf("%.1f      %.2f  %.2f \n",i,getX(),getY());
			move(i);


		}

	}
	

	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Please give me a firing angle(<=90) & initial velocity: ");
		int sAngle = in.nextInt();
		int iVelocity = in.nextInt();
		System.out.println("The firing angle is: " + sAngle + 
				"\nThe inital velocity is: " + iVelocity + "\n");
		CannonBall Ball_ = new CannonBall(0);
		Ball_.shoot(sAngle, iVelocity);
		in.close();
	}

}
