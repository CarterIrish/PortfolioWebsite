package edu.vtc.cis2271;
import java.util.Scanner;
public class StringReaders 
{

	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Please give me a single number string: ");
		String Apple = in.next();
		//System.out.println(Apple);//Test point
		in.close();
		int AppleInt = 0;
		int AppleBin = 0;
		int AppleHex = 0;
		
		try 
		{
		AppleInt = Integer.parseInt(Apple);
		System.out.println(AppleInt);
		}
		catch (NumberFormatException e) 
		{
			System.out.println("Expected a number string. Got "+ "'"+ Apple+"'");
		}
		
		try 
		{
		AppleBin = Integer.parseInt(Apple,2);
		System.out.println(AppleBin);
		}
		catch (NumberFormatException e) 
		{
			System.out.println("Expected a Binary number string(10101010). Got "+ "'"+ Apple+"'");
		}
		
		try 
		{
		AppleHex = Integer.parseInt(Apple,16);
		System.out.println(AppleHex);
		}
		catch (NumberFormatException e) 
		{
			System.out.println("Expected a Hexidecimal number string. Got "+ "'"+ Apple+"'");
		}
	}
}

