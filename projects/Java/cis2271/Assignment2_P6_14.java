package edu.vtc.cis2271;

import java.util.Random;
import java.util.Scanner;
public class Assignment2_P6_14 
{

	public static void main(String[] args) 
	{
		double waterLevel = 10;
		int width = 10;
		int length = 10;
		double heights [][]= new double [width][length];
		/* This following code will create & fill the 10x10 array with random numbers between 1-14
		 * then it will print them out in a 10x10 string
		 */
		Random rand = new Random();
		for (int i = 0;i<heights.length;i++)
		{
			for (int j = 0;j<heights.length;j++)
			{
				int n = rand.nextInt(1,11);
				heights[i][j] = n;
				if (j>0)
					System.out.print(" " + heights[i][j]);
				if (j==9)
					System.out.println();
				if (j==0)
				{
					System.out.print(heights[i][j]);
				}


			}
		}
		System.out.println("Assuming the maximum terain height is 10");
		System.out.println("while also assuming the maximum water height is 10");
		System.out.println("The following map represents each stage in a flood");
		floodMap(heights, waterLevel); // This calls the method which creates a flood map
	}
	public static void floodMap(double[][] heights, double waterLevel) 
	{
		// This iterates through and will print * for each number below given num and a " " for each number above given num
		for (int f = 1;f<=waterLevel;f++) /* This code will run the following code until
		the water level is equal to the maximum terrain value possible*/
		{
			if(f==1)
				System.out.println("____________________");
			System.out.println("At water level: "+ f);
			for (int i = 0;i<heights.length;i++)
			{
				for (int j = 0;j<heights.length;j++)
				{
					if (heights[i][j]<=f)	
						System.out.print(" *");
					else if (heights[i][j]>f)
						System.out.print("  ");
					if (j>=9)
						System.out.println();
				}
			}
			System.out.println("____________________");
		}
	}

}
