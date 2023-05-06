package edu.vtc.cis2271;

import java.util.Scanner;

public class Values2 
{

	public static void main(String[] args) 
	{
	Scanner in = new Scanner(System.in);
	System.out.println("What temperature is it in Celsius?");
	int temp = in.nextInt();
	System.out.println("The degrees in farenheight is: " + ((temp * 1.8) + 32));
	in.close();
	}

}
