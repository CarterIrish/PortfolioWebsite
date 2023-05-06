package edu.vtc.cis2271;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Carter Irish
 *
 */
public class CSVReader 
{
	private File _CSVs;
	/**
	 * Construct a field containing the file
	 * @param f insert an object containing a File
	 */
	public CSVReader(File f)
	{
		this._CSVs = f;
		

	}

	/**
	 * 
	 * @return returns the number of rows contained within a CSV.txt file
	 * @throws FileNotFoundException
	 */
	public int numberOfRows() throws FileNotFoundException
	{
		Scanner s1 = new Scanner(this._CSVs);
		int lines = 0;
		for(int i = 0;s1.hasNextLine();i++)
		{s1.nextLine(); lines = i+1;}
		s1.close();
		return lines;
	}

	/**
	 * 
	 * @param row insert the number of which row to be scanned
	 * @return the number of Fields contained within selected row
	 * @throws IOException 
	 */
	public int numberOfFields(int row) throws IOException
	{
		char ch;
		int fields = 1;
		String line = "";
		Boolean hasQuote = false;
		BufferedReader br = new BufferedReader(new FileReader(this._CSVs));
		for(int i = 0;i<row;i++)
			line = br.readLine();
		for(int i=0;i<line.length();i++)
		{
			ch = line.charAt(i);
			if(ch =='"')
			{
				hasQuote = !hasQuote;
			}
			if(ch == ',' && hasQuote==false)
				fields++;
		}
		br.close();
		return fields;
	}



	/**
	 * 
	 * @param row insert the number of which row you'd like to search
	 * @param column insert the number of which column you'd like to search
	 * @return returns the field which can be found at given location
	 * @throws IOException 
	 */
	public String field(int row, int column) throws IOException
	{
		boolean hasQuote = false; // used to make sure i only add a field if its not in quotes
		char ch; // used to add each character to a field
		String field = ""; // contains the current field
		String line = ""; // contains the current line
		List<String> fields = new ArrayList<>(); // contains a list of fields from the current row

		BufferedReader br = new BufferedReader(new FileReader(this._CSVs));
		for(int i = 0;i<row;i++)
		{
			line = br.readLine();
		}
		for(int i=0;i<line.length();i++)
		{
			ch = line.charAt(i);
			field+=ch;
			if(ch =='"')
			{
				hasQuote = !hasQuote;
			}
			if(ch == ',' && hasQuote==false )
			{
				fields.add(field);
				field = "";
			}

		}
		fields.add(field);
		return (fields.get(column-1)).trim();
	}


	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException 
	{
		File CSVs = new File("C:\\Users\\cmani\\eclipse-workspace\\Java2271Labs\\src\\edu\\vtc\\cis2271\\CSVs.txt");
		CSVReader CSV1 = new CSVReader(CSVs);
		System.out.println("There are " + CSV1.numberOfRows() + " rows");
		System.out.println("There are " + CSV1.numberOfFields(2) + " fields in this row.");
		System.out.println(CSV1.field(2, 1));

	}

}
