package edu.vtc.cis2271;

import java.util.Scanner;

public class Fun_with_conversions_2 
{

	public static void main(String[] args) 
	{
	Scanner in = new Scanner(System.in);
	System.out.print("What temperature is the temperature? ");
	double temp = in.nextDouble();
	String unit = in.next();
	System.out.print("What do you want to convert it to? ");
	String out_unit = in.next(); 
	double res_temp;
	switch (unit) 
	{
	case "C":
		if (out_unit.equalsIgnoreCase("k"))
		{
			res_temp = (temp + 273.15);
		}
		else if (out_unit.equalsIgnoreCase("F"))
		{
			res_temp = (temp * 1.8) + 32;
		}
		else
			res_temp = 0.0;
		break;
	case "c":
		if (out_unit.equalsIgnoreCase("k"))
		{
			res_temp = (temp + 273.15);
		}
		else if (out_unit.equalsIgnoreCase("F"))
		{
			res_temp = (temp * 1.8) + 32;
		}
		else
			res_temp = 0.0;
		break;
	case "f":
	case "F":
		if (out_unit.equalsIgnoreCase("c"))
		{
			res_temp = (5.0/9)*(temp - 32);
		}
		else if (out_unit.equalsIgnoreCase("k"))
		{
			res_temp = (((5.0/9)*(temp-32))+273.15);
		}
		else 
		{
			res_temp = 0.0;
		}
		break;
	case "k":
	case "K":
		if (out_unit.equalsIgnoreCase("f"))
		{
			res_temp = ((temp - 273.15)*1.8+32);
		}
		else if (out_unit.equalsIgnoreCase("c"))
		{
			res_temp = temp - 273.15;
		}
		else 
		{
			res_temp = 0.0;
		}
		break;
	default:
		res_temp = 0.0;
	}

	System.out.printf("The temperatutre in " + out_unit.toUpperCase() + " is: %.2f", res_temp);
	System.out.print(out_unit);
	
	
	
	in.close();
	}

}
