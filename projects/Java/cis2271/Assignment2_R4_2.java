package edu.vtc.cis2271;
import java.util.Scanner;
public class Assignment2_R4_2 

{

	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Give me height & width: ");
		int height = in.nextInt();
		int width = in.nextInt();
		for (int i = 1,j = 0; i<=width;i++)
		{	
			System.out.print("*");
			if (i==width)
			{
				i=0;
				j++;
				System.out.println();
				if (j==height)
				{
					break;
				}

			}

		}
		in.close();
	}
}
