package edu.vtc.cis2271;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
public class File_Lab 
{

	public static void main(String[] args) throws IOException
	{
		File f = new File("C:/Users/cmani/Downloads/babynames.txt");
		System.out.println("The file "+f+" is contained in: ");
		System.out.println(f.getAbsoluteFile());
		isSize(f);
		if(f.exists()==false)
			System.out.println(f+" does not exist!");
		else
		{
			if(f.isAbsolute())
				System.out.println(f+" is a directory");
			else
				if(f.isAbsolute()==false)
				{System.out.print(f);
				isType(f);
				isSize(f);
				}

		}


	}
	public static void isType(File f)
	{
		if(f.getName().endsWith(".java"))
		{System.out.println(" is a java source file!");
		return;}
		if(f.getName().endsWith(".class"))
		{System.out.println(" is a java class file!");
		return;}
		if(f.getName().endsWith(".txt"))
		{System.out.println(" is a text file!");
		return;}
		System.out.println(" is an unknown file type!");
	}
	public static void isSize(File f) throws FileNotFoundException
	{
		if(f.getName().endsWith(".java")||f.getName().endsWith(".txt"))
		{
			int lines = 0;
			Scanner in = new Scanner(f);
			for(int i = 0;in.hasNextLine();i++)
			{
				in.nextLine();
				lines++;
			}
			in.close();
			System.out.println("The number of lines is: " + lines);
		}
		else 
		{
			int byteLength;
			byteLength = (int) f.length();
			System.out.println("The number of bytes is: " + byteLength);
		}

	}
}
