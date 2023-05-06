package edu.vtc.cis2271;
import java.util.Scanner;
public class PrimeNumberFactors 
{

	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Give me a postive integer: ");
		int n = in.nextInt();
		System.out.println("The prime factors of this number are: ");
		// Here I'm looking to see if n is divisible by 2, since if it is, the factor would be 2
		while (n % 2 == 0) 
		{
	        System.out.print(2 + " ");
	        n /= 2;
	    }
		// The moment n is odd, I know the factor cannot be two anymore 
		// thus i now need to sort through the other prime factors starting with 3
	    for (int i = 3; i <= Math.sqrt(n); i += 2) 
	    { 
	    	while (n % i == 0) 
	    	{ 
	    		System.out.print(i + " "); n /= i; 
	    	} 
	    } if (n > 2)
	    	System.out.print(n);
	    in.close();
	  }
	
}

