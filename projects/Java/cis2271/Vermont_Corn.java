package edu.vtc.cis2271;

import java.util.Scanner;

public class Vermont_Corn 
{

	public static void main(String[] args) 
	{
	Scanner in = new Scanner(System.in);
	
	System.out.println("How many ears of corn do you want? ");
	int ears = in.nextInt();
	double cost;
	double price;
	if (ears < 12)
	{
		cost = ears * .50;
		price = .50;
	}
	else if (ears >= 12 && ears <= 23)
	{
		cost = ears * .45;
		price = .45;
	}
	else if (ears >= 24 && ears <= 35)
	{
		cost = ears * .40;
		price = .40;
	}
	else 
	{
		cost = ears * .35;
		price = .35;
	}
	System.out.printf("The price per ear of corn is, $%.2f", + price);
	System.out.printf(", and your total cost is, $%.2f", + cost);
	}
}
