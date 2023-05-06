package edu.vtc.cis2271;

import java.util.Scanner;

public class Integer_stuff_again {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("give me positive integer: ");
		int num;
		while((num = in.nextInt())>=0)
		{
			boolean prime = true;
			if (num == 2)
			{

			}
			else if (num%2==0)
			{
				prime = false;
			}
			else
			{
				double sq = Math.sqrt(num);

				for (int i = 3; i<= sq; i+=2)
				{
					if (num%i==0)
					{
						prime = false;
						break;
					}
				}
			}
			if (prime)
			{
				System.out.println("This is indeed a prime number");
			}
			else
			{
				System.out.print("This is most deffininently not a prime number");
			}

		}
		System.out.println("Thats a negative number");
		in.close();
	}
}