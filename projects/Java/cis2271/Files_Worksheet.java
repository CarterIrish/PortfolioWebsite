package edu.vtc.cis2271;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class Files_Worksheet 
{

	public static void main(String[] args)
	{
		File f = new File("MyFile.txt");
		System.out.println(f.length());
	}

}
