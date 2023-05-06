package edu.vtc.cis2271;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Formatter;
import java.util.Scanner;

/**
 * @author Carter.I
 *
 */
public class testProjects {

	public static void main(String[] args) 
	{
		int[] dice = new int[] {3,3,3,3,3,5};

		boolean isFour = false;
		int currentNum = 1;
		while(isFour==false)
		{
			int numOfKind = 0;
			for(int i=0;i<dice.length;i++)
			{
				if(currentNum==dice[i])
				{
					numOfKind++;
				}
			}
			if(numOfKind>=4)
				isFour = true;
			if(currentNum>6)
			{
				break;
			}

			currentNum++;
		}
		System.out.println(isFour);
	}

}
