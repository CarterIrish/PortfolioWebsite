package edu.vtc.cis2271;

import java.util.Arrays;
import java.util.Scanner;

public class Fibonacci 
{

	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		System.out.println("How many digits of the sequence? ");
		int n = in.nextInt();

		if (n<=2)
		{
			for(int i=0;i<n;i++)
			{
				System.out.println("1 ");
				System.exit(0);
			}
		}
		int[] fibs = new int[n];

		fibs[0]=1;
		fibs[1]=1;
		for(int i=2;i<n;i++)
		{
			fibs[i] = fibs[i-2]+fibs[i-1]; 
		}
		//System.out.println("Fibs:");
		System.out.println(Arrays.toString(fibs));
		System.out.println();
		for(int i=0;i<n;i++) 
		{
			if (i==0)
				System.out.print(fibs[i]);
			else if(i>0)
			{
				System.out.print(", "+ fibs[i]);
			}
		}
		// find the sum of all the numbers in the sequence
		int sum = 0;
		for (int i=0;i<fibs.length;i++)
		{
			sum+=fibs[i];
		}
		System.out.println();
		System.out.println(sum);
		// find the squares of the indices
		int[] squares = new int[n];
		for(int i =0;i<n;i++)
		{
			squares[i] = i*i;
		}
		System.out.println("These are the squares of each index");
		System.out.println(Arrays.toString(squares));
		// compare the two arrays and print the larger of each index
		int[] largest = new int[n];
		for (int i=0;i<n;i++)
		{
			if (squares[i]>fibs[i])
			{
				largest[i] = squares[i];
			}
			else
			{
				largest[i] = fibs[i];
			}

		}
		System.out.println("Largest of the squares: ");
		System.out.println(Arrays.toString(largest));
		in.close();
	}


}




