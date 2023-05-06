package edu.vtc.cis2271;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.lang.Character;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Carter Irish
 *
 */
public class Babynames 
{
	
	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException 
	{
		File babynames = new File("C:/Users/cmani/Downloads/babynames.txt");
		Scanner in = new Scanner(babynames);
		Set<String> boyNames = new HashSet<>(); 
		Set<String> girlNames = new HashSet<>();
		while(in.hasNextLine())
		{
			in.nextInt();;
			boyNames.add(in.next());
			in.nextInt();
			in.nextDouble();
			girlNames.add(in.next());
			in.nextLine();
			
		}
		for(String i: boyNames)
			if(girlNames.contains(i))
				System.out.print(i + ", ");
	}

}
