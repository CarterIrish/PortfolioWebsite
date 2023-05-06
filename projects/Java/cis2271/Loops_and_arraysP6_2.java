package edu.vtc.cis2271;

import java.util.Arrays;
import java.util.Random;
public class Loops_and_arraysP6_2 
{

	public static void main(String[] args) 
	{
		/* My first step is to create my array and then fill-
		* -it with a random number between 1-6(since thats the range on a typical dice)
		*/
		int[] DieToss = new int[20];
		Random rand = new Random();
		for (int i = 0; i<20;i++)
		{
			int n = rand.nextInt(6);
			DieToss[i]=n+=1;
		}
		// here I'm just printing out the array to display it for testing
		System.out.println(Arrays.toString(DieToss));
		/* These are my variables which I will use to keep track of the longest run,
		 * start of the longest run, current longest run, current longest running value, 
		 * and the actual longest running value
		 */
		int currentLength = 1;
		int longestLength = 1;
		int currentVal = -1;
		int longestVal = 0;
		int startRun = 0;
		// Here is where I begin iterating through and looking for the start of runs
		for (int i = 1; i<DieToss.length;i++)
		{
			if (DieToss[i] == DieToss[i-1]) // This here will run if the number I'm on is equal to previous
			{
				currentLength++;
				currentVal = DieToss[i];

				if (longestLength<currentLength) // This part here is used to keep track of where the longest run starts
					startRun = i-(currentLength-1); // Stores longest run
			}

			else
				currentLength = 1; // resets the current runs length if it doesnt exceed longest length
			if (DieToss[i]!=DieToss[i-1]) // Runs at the end of each run
			{
				longestVal=DieToss[startRun]; // Stores the value which holds longest run
			}
			if (currentLength>longestLength) // Stores the length of longest run 
				longestLength=currentLength;
		}
		System.out.println();
		System.out.println("The start of my longest run was: " + startRun); 
		// Following code is meant print my array without [] & ,
		/* At some point my code went a miss and will have the wrong value for length is start run == zero
		 * To fix this, if the start of a run is at 0, then the length will automatically have +1
		 */
		if(startRun==0) 
		{
			System.out.print("The most frequent # was: " + longestVal + " & it appeared ");
			System.out.print(longestLength + " times");
		}
		else if(startRun>0)
			System.out.print("The most frequent # was: " + longestVal + " & it appeared " + (longestLength+1) + " times!");
		System.out.println();
		for(int i=0;i<20;i++) //makes it so the first number wont print with a , before it
		{
			if (i==0) //Makes sure that a parenthesis will exist before the our first num
			{
				if (i==startRun)
				{
					System.out.print("(");
				}
			System.out.print(DieToss[i]);
			}

	
			else if(i>0)
			{
				if(i==startRun)
				{
					System.out.print(", (");
					System.out.print(DieToss[i]);
				}
				else if(i==startRun+longestLength)
					System.out.print(")");
				System.out.print(", "+ DieToss[i]);
			// ONE ISSUE REMAINS: PROGRAM WONT PRINT A ) IF RUN ENDS AT END OF ARRAY
			}
		}
	}

}
