package edu.vtc.cis2271;
import java.util.Scanner;
public class AciiArt2 
{

	public static void main(String[] args) 
	{
		drawRow(4);
		Scanner in = new Scanner(System.in);
		System.out.println("Give me the dimensions for your line(L W Adj True/False): ");
		int length = in.nextInt();
		int width = in.nextInt();
		//int adj = in.nextInt();
		int height = in.nextInt();
		boolean filled = in.nextBoolean();
		//drawRow(length,width,adj);
		//drawRow(length,width,adj,filled);
		//drawBox(length,height,width);
		drawTriangle(4,1,3, filled);
		in.close();
	}
	public static void drawRow(int x)
	{
		for(int i= 0;i<x;i++)
		{
			System.out.print("*");
		}
		System.out.println();

	}
	public static void drawRow(int length, int width, int adj)
	{
		// here I'm finding the middle of my stars
		int middle = width/2;
		//System.out.println(middle);
		//Here I'm trying to firstly figure out the justification
		if (adj==0)
		{
			for (int i =0;i<middle;i++)
				System.out.print(" ");
			printStars(length);
		}
		else if (adj==1)
		{
			for (int i =0;i<width;i++)
				System.out.print(" ");
			printStars(length);
		}
		else if (adj==-1)
		{
			printStars(length);
			return;
		}

	}
	public static void drawRow(int length, int width, int adj, boolean filled)
	{
		// here I'm finding the middle of my stars
		int middle = width/2;
		//Here I'm trying to firstly figure out the justification
		if (adj==0)
		{
			if(filled)
			{
				for (int i =0;i<middle;i++)
					System.out.print(" ");
				printStars(length);
			}
			else 
			{
				for (int i =0;i<middle;i++)
					System.out.print(" ");
				printEmptyStars(length);
			}

		}
		else if (adj==1)
		{
			if(filled) 
			{
				for (int i =0;i<width;i++)
					System.out.print(" ");
				printStars(length);
			}
			else 
			{
				for (int i =0;i<width;i++)
					System.out.print(" ");
				printEmptyStars(length);

			}
		}
		else if (adj==-1)
		{
			if(filled)
			{
			printStars(length);
			return;
			}
			else
			{
				printEmptyStars(length);
			}
		}

	}
	private static void printEmptyStars(int length) {
		System.out.print("*");
		for (int i= 2;i<length;i++)
		{
			System.out.print(" ");
		}
		System.out.print("*");
		System.out.println();
	}
	private static void printStars(int length) 
	{
		for (int i =0;i<length;i++)
			System.out.print("*");
	}
	public static void drawBox(int width,int height,int displayWidth)
	{
		printStars(width);
		System.out.println();
		for (int i = 2; i<height;i++)
		{
			printEmptyStars(width);
		}
		printStars(width);
	}
	public static void drawTriangle(int Base, int Height, int displayWidth, boolean filled)
	{
		drawRow(1,displayWidth,0, filled);
	}
}
