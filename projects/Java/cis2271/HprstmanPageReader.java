/**
 * HprstmanPageReader.java
 * Copyright 2022, Craig A. Damon
 * all rights reserved
 */
package edu.vtc.cis2271;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

/**
 * HprstmanPageReader - description
 * @author Craig A. Damon & Carter Irish
 *
 */
public class HprstmanPageReader
{

	public static void main(String[] args) throws IOException
	{
		String hRef = "";
		int firstI;
		int lastI;

		String address = "http://horstmann.com/index.html";
		URL pageLocation = new URL(address);
		Scanner in = new Scanner(pageLocation.openStream());
		if (!in.hasNext())
			System.out.println("url is empty");
		while (in.hasNext())
		{
			String line = in.nextLine();
			firstI = line.indexOf("<a");
			lastI = line.indexOf("a>");
			if(firstI>-1 && lastI>-1)
			{
				hRef = line.substring(firstI, lastI+2);
				System.out.println(hRef);
			}
			//			System.out.println(line);
		}
	}

}
