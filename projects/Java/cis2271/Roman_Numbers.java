package edu.vtc.cis2271;

import java.util.Scanner;

public class Roman_Numbers 
{

	public static void main(String[] args) 
	{
		//Initializing the scanner
		Scanner in = new Scanner(System.in);
		// creating the variables which hold my Roman numeral 
		int thousands;
		int five_hundreds;
		int hundreds;
		int fiftys;
		int tens;
		int ones;
		//gathering input
		int n = in.nextInt();
		System.out.println(n);
		// Separating the number into groups
		if (n>=1000)
		{
			thousands = n / 1000;
			System.out.println(thousands);
			for (int i = 0; i < thousands; i++ )
			{
				System.out.print("M");
			}
			n = n - (thousands * 1000);
			System.out.println();
			System.out.println(n);
			//Now that I've tackled the 1000's, I need to cover the 500's
			if (n >=500)
			{
				five_hundreds = n / 500;
			}
			
		}
	}

}
