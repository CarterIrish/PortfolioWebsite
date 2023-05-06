package edu.vtc.cis2271;

import java.util.Scanner;

public class MadLibs {

	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Give me a color: ");
		String color = in.next();
		System.out.print("Give me a supterlative: ");
		String sup = in.next();
		System.out.print("Give me an adjective: ");
		String adj_1 = in.next();
		System.out.print("Give me a body part: ");
		String B_Part = in.next();
		System.out.print("Give me a noun: ");
		String noun = in.next();
		System.out.print("Give me an animal: ");
		String animal = in.next();
		System.out.print("Give me another adjective: ");
		String adj_2 = in.next();
		System.out.print("Give me another adjective: ");
		String adj_3 = in.next();
		System.out.print("Give me another adjective: ");
		String adj_4 = in.next();
		System.out.println("The Red Dragon is the " + color + " of all.");
		System.out.println("It has So-Called " + sup + "and a " + B_Part + "shaped like a " + noun + ".");
		System.out.println("It loves to eat " + animal + " , although it will feast on nearly anything.");
		System.out.println("It is " + adj_2 + "and " + adj_3 + ".");
		System.out.println("You must be " + adj_4 + " around it, or you may end up as it`s meal!");
		in.close();
	}

}
