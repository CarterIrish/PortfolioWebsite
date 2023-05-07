package edu.vtc.cis2271;

import java.util.ArrayList;
import java.util.List;

public class Book
{
	/**
	 * create a book
	 * @param title the title, never null
	 * @param author the author, never null
	 * @param year the year written
	 */
  public Book(String title, Author author,int year)
  {
  	  _title = title;
  	  _authors = new ArrayList<>(1);
  	  _authors.add(author);
  	  _year = year;
  	  author.addBook(this);
  }
  
	/**
	 * create a book
	 * @param title the title, never null
	 * @param authors 
	 * @param year the year written
	 */
public Book(String title, List<Author> authors,int year)
{
	  _title = title;
	  _authors = new ArrayList<>(authors);
	  _year = year;
	  for(Author author: authors)
		  author.addBook(this);
}
  
  /**
   * Use the title as a human readable identifier for the book
   * @return the title
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
  {
  	   return _title;
  }
  
	/**
	 * @return the title
	 */
	public String getTitle()
	{
		return _title;
	}

	/**
	 * @return the year
	 */
	public int getYear()
	{
		return _year;
	}

	/**
	 * @return the author
	 */
	public Author getAuthor()
	{
		return _authors.get(0);
	}
	
	/**
	 * @return list of authors
	 */
	public Iterable<Author> getAuthors()
	{
		return new ArrayList<>(_authors);
		
	}

	/** test creating a single book
	 * @param args
	 */
	public static void main(String[] args)
	{
    Author a = new Author("Frank Herbert");
    Book b = new Book("Dune",a,1973);
    System.out.println(b + "\n");
    
    Author c = new Author("Jules Verne");
    Book d = new Book("20,000 Leagues Under the Sea", c, 1880);
    Book e = new Book("Around the World in 80 Days", c, 1890);
    System.out.println(c);
    for(Book i:c.getBooks())
    {
    	System.out.println(i);
    }
    System.out.println(Author.findAuthor("Jules Verne"));
    
	}

	
	private String _title;
	private int _year;
	private List<Author> _authors;
}
