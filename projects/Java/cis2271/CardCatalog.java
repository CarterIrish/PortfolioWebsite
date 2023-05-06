package edu.vtc.cis2271;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Carter Irish
 *
 */
public class CardCatalog 
{
	/**
	 * 
	 */
	
	public CardCatalog()
	{
		_titleIndex = new HashMap<>();
	}
	
	/**
	 * @param b
	 */
	public void addBook(Book b)
	{
		_titleIndex.put(b.getTitle(),b);
	}
	
	public Book findBookByTitle(String a)
	{
		return _titleIndex.get(a);
	}
	
	
	private static Map<String,Book> _titleIndex; 

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		CardCatalog cc = new CardCatalog();
	}

}
