package edu.vtc.cis2271;

import java.util.Scanner;

public class Roman_numbers2 
{

	public static void main(String[] args) 
	{
		//Initializing the scanner
		Scanner in = new Scanner(System.in);
		//gathering input
		System.out.println("Give me a number, and I'll convert it to a roman numeral: ");
		int n = in.nextInt();
		System.out.print("In Roman numerals, " + n + " is: ");
		// Separating off the thousands

		switch (n/1000)
		{
		case 1:
			System.out.println(1);
			System.out.print("M");
			n = n - 1000;
			break;
		case 2:
			System.out.print("MM");
			n = n - 2000;
			break;
		case 3:
			System.out.print("MMM");
			n = n - 3000;
			break;
		}

		// Separating off the hundreds
		switch (n/100)
		{
		case 1:
			System.out.print("C");
			n = n-100;
			break;
		case 2:
			System.out.print("CC");
			n = n-200;
			break;
		case 3:
			System.out.print("CCC");
			n = n-300;
			break;
		case 4: 
			System.out.print("CD");
			n = n-400;
			break;
		case 5:
			System.out.print("D");
			n = n-500;
			break;
		case 6:
			System.out.print("DC");
			n = n-600;
			break;
		case 7:
			System.out.print("DCC");
			n = n-700;
			break;
		case 8:
			System.out.print("DCCC");
			n = n-800;
			break;
		case 9:
			System.out.print("CM");
			n = n-900;
			break;
		}
		
		//Separating off the tens
		switch (n/10)
		{
		case 1:
			System.out.print("X");
			n = n-10;
			break;
		case 2:
			System.out.print("XX");
			n = n-20;
			break;
		case 3:
			System.out.print("XXX");
			n = n-30;
			break;
		case 4: 
			System.out.print("XL");
			n = n-40;
			break;
		case 5:
			System.out.print("L");
			n = n-50;
			break;
		case 6:
			System.out.print("LX");
			n = n-60;
			break;
		case 7:
			System.out.print("LXX");
			n = n-70;
			break;
		case 8:
			System.out.print("LXXX");
			n = n-80;
			break;
		case 9:
			System.out.print("XC");
			n = n-90;
			break;
		}
		
		// taking care of the ones
		switch (n)
		{
		case 1:
			System.out.print("I");
			n = n-1;
			break;
		case 2:
			System.out.print("II");
			n = n-2;
			break;
		case 3:
			System.out.print("III");
			n = n-3;
			break;
		case 4: 
			System.out.print("IV");
			n = n-4;
			break;
		case 5:
			System.out.print("V");
			n = n-5;
			break;
		case 6:
			System.out.print("VI");
			n = n-6;
			break;
		case 7:
			System.out.print("VII");
			n = n-7;
			break;
		case 8:
			System.out.print("VIII");
			n = n-8;
			break;
		case 9:
			System.out.print("IX");
			n = n-9;
			break;
		}
		// Printing out the amount left over for testing purposes
		///System.out.println(n);
		in.close();
	}
}