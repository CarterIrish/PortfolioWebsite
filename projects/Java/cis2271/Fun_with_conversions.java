package edu.vtc.cis2271;

import java.util.Scanner;

public class Fun_with_conversions 
{

	public static void main(String[] args) 
	{
	Scanner in = new Scanner(System.in);
	System.out.println("What temperature is the temperature?");
	int temp = in.nextInt();
	String unit = in.next();
	double res_temp;
	switch (unit) 
	{
	case "C":
		res_temp = (temp * 1.8) + 32;
	case "c":
		res_temp = (temp*1.8) + 32;
		break;
	case "f":
	case "F":
		res_temp = (5.0/9)*(temp - 32);
		break;
	default:
		res_temp = 0.0;
	}
	
	System.out.println(res_temp);
	//System.out.printf("The degrees in farenheight is: %.2f%s", ((temp * 1.8) + 32), unit);
	
	in.close();
	}

}
