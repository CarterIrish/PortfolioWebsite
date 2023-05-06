package edu.vtc.cis2271;

import java.util.Arrays;
import java.util.Scanner;

public class Fibonacci2 {

	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
	    System.out.println("How many fibs should I tell you?");
	    int n = in.nextInt();
	    
	    if (n <= 2)
	     {
	     for (int i = 0; i < n; i++)
	     System.out.print("1 ");
	     System.exit(0);
	     }
	    int[] fibs = new int[n];
	  
	    fibs[0] = 1;
	    fibs[1] = 1;
	      
	    for (int i = 2; i < n; i++)
	     {
	     fibs[i] = fibs[i-2] + fibs[i-1];
	     }
	    
	    System.out.println(Arrays.toString(fibs));
	in.close();
	}

}
