package edu.vtc.cis2271;

import java.io.IOException;
import java.math.RoundingMode;
import java.util.Formattable;
import java.util.Formatter;
import java.text.DecimalFormat;
import java.math.BigDecimal;

/** Class to make bank account objects which contain an account number and balance. Class also contains methods to manage
 * each account as well including withdrawals and deposits. 
 * @author Carter Irish
 *
 */
public class BankAccount implements Formattable
{
	// Declaring instance variables
	private double _Ballance;
	private int _accountNum;

	/** Will construct a bank account object containing both the acc num and balance of an account.
	 * @param accountNum insert account num
	 * @param Ballance insert the amount of money in acc as a double
	 */
	public BankAccount(int accountNum, double Ballance)
	{
		this._accountNum = accountNum;
		this._Ballance = Ballance;

	}

	/** Will deposit money into the selected bank acc.
	 * @param amount insert amount of money to add into balance
	 */
	public void depositMonies(double amount) 
	{
		this._Ballance+=amount;
	}

	/** Will subtract the given amount of money from balance of selected acc.
	 * @param amount insert the amount of money to subtract from balance
	 */
	public void withdrawMonies(double amount)
	{
		this._Ballance-=amount;
	}

	/** Returns the account number for bank acc object.
	 * @return the account number
	 */
	public int getAccountNum()
	{
		return this._accountNum;
	}

	/**Will return the acc num for given account object.
	 * @return the balance
	 */
	public double getBallance()

	{
		return this._Ballance;
	}

	/**Will format the bank acc balance to selected precision and width while also adding $ symbol.
	 * @param formatter
	 * @param flags
	 * @param width the value of minimum width 
	 * @param percsion the value of maximum characters
	 */
	@Override
	public void formatTo(Formatter formatter, int flags, int width, int percision) 
	{
		Appendable a = formatter.out();
		this._Ballance = imposePercision(percision, this._Ballance);
		String balance = "$" + String.valueOf(this._Ballance);
		addPadding(width, a, balance);
		System.out.println(a);
	}

	/** Will add in padding to the beginning of balance string up to given width. If number equals or exceeds width,
	 * no padding will be added to the string. 
	 * @param width the minimum width of string
	 * @param a appendable object
	 * @param balance the balance in form of string
	 */
	public static void addPadding(int width, Appendable a, String balance) {
		String padding = "";
		if(width>balance.length()-1)
		{
			int padAmt = width-(balance.length()-1);
			while(padding.length()<padAmt)
			{
				padding+=" ";
			}
			balance = padding + balance;
		}
		try 
		{
			a.append(balance);
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * @param percision the requested number of decimal digits
	 * @param balance the number of type double to be rounded to given precision
	 * @return
	 */
	public static double imposePercision(int percision, double balance)
	{
		BigDecimal bd = new BigDecimal(balance).setScale(percision, RoundingMode.CEILING);
		balance = bd.doubleValue();
		return balance;
	}

	/**Main program
	 * @param args
	 */
	public static void main(String[] args) 
	{
		BankAccount b1 = new BankAccount(1234567, 123456.456);
		System.out.println("This is your account number: " + b1.getAccountNum());
		System.out.println("This is your ballance: $" + b1.getBallance());
		//b1.depositMonies(.88);
		System.out.println("This is your ballance: $" + b1.getBallance());
		Formatter formatter = new Formatter();
		b1.formatTo(formatter, 0, 10, 2);
	}

	/** TODO
	 * 1) Add option to manage the precision of the balance when doing the formatTo method
	 * - do this using setMaximumFractionDigits()
	 * - also string Format. not the locale version.
	 * 2) streamline the actual code via minimizing code per method
	 */
}
