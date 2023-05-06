package edu.vtc.cis2271;
import java.util.Scanner;
public class Polynomial 
{
	public Polynomial(int degree)
	{
		this._Coefficient = new float[degree+1];
		for (int i = 0; i<this._Coefficient.length;i++)
		{
			this._Coefficient[i] = 1.0f;
		}
	}	
	public int getDegree()
	{
		return (this._Coefficient.length)-1;
	}
	
	public float getCoefficient(int parameter)
	{
		if (parameter > 0 && parameter <= getDegree())
			return this._Coefficient[parameter];
		else
			return 0;
	}
	
	public void setCoefficient(int pizza, float taco )
	{
		this._Coefficient[pizza] = taco;
	}
	
	public String toString()
	{
		boolean first = true;
		String equation = "";
		for(int i = this._Coefficient.length-1;i>=0;i--)
		{
			if (this._Coefficient[i] == 0)
				continue;
			if (first)
				first = false;
			else 
				if (this._Coefficient[i]>0)
					equation += "+";
				
			equation += this._Coefficient[i];
			if (i==0)
				equation += " ";
			else if(i==1)
				equation += "x";
			else if (i!=0)
			{
				equation += "x^" +i;
			}
					
		}
		return equation;
	}
	public float evaluate(float cheese)
	{
		float total = 0;
		float xv = 1;
		for (int i = 0;i<this._Coefficient.length;i++)
		{
			total += this._Coefficient[i] * xv;
			xv*=cheese;
		}
		return total;
	}
	
	public static void read()
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Give me the degree of your polynomial: ");
		int degree = in.nextInt();
		Polynomial userPoly = new Polynomial(degree);
		System.out.println("Give me the your Coefficitents starting from the lowest degree: ");
		for (int i=0;i<=degree;i++)
		{
			float coeff = in.nextFloat();
			userPoly.setCoefficient(i, coeff);
		}
		System.out.println(userPoly);
		System.out.println("Give me a value for x: ");
		int x = in.nextInt();
		System.out.print("This polynomial evaluate's to: ");
		System.out.println(userPoly.evaluate(x));
		in.close();
	}
	
	private float[] _Coefficient;
	
	public static void main(String[] args) 
	{
		Polynomial example = new Polynomial(2);
		example.setCoefficient(0, 7);
		example.setCoefficient(1, 3);
		example.setCoefficient(2,1);
		System.out.println(example);
		System.out.println(example.evaluate(2));
		read();
	}

}