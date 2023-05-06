/**
 * Author.java
 * Copyright 2015, Craig A. Damon
 * all rights reserved
 */
package edu.vtc.cis2271;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Author - an author who has (or will) written one or more books
 * @author Craig A. Damon
 *
 */
public class Author
{

	/**
	 * @param name the name of the author, never null
	 */
	public Author(String name)
	{
	  _name = name;
	  _books = new HashSet<>();
	  _authorIndex.put(name,this);
	}

	/**
	 * use the name of the author as a human readable identifier
	 * @return the author's name
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return _name;
	}
	
	/**
	 * add a book to the books written by the author
	 * @param b the book written by the author, never null
	 */
	public void addBook(Book b)
	{
		_books.add(b);
	}
	
	/**
	 * @return the name, never null
	 */
	public String getName()
	{
		return _name;
	}
	
	/**
	 * @return list of books
	 */
	public Iterable<Book> getBooks()
	{
		return new ArrayList<>(_books);
	}
	
	/**
	 * @param a the name of the author
	 * @return 
	 */
	public static Author findAuthor(String a)
	{
		return _authorIndex.get(a);
	}

	private String _name;
	private Set<Book> _books;
	private static Map<String,Author> _authorIndex = new HashMap<>();
}
