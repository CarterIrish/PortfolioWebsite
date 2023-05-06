package edu.vtc.cis2271;
import java.util.Scanner;
public class Integeger_stuff 
{

	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		System.out.println("give me positive integers: ");
		int num = in.nextInt();
		if (num<0) 
		{
			System.out.print("Thats negative.");
		}
		else
		{
			num = in.nextInt();
			while (num>0)
			{
				num = in.nextInt();
			}
			System.out.println("Thats negative");
		}
		in.close();
	}
}