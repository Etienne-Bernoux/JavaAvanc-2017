/**
 * 
 */
package fr.ece.bernoux.lab1Basis.ex2;

import fr.ece.bernoux.lab1Basis.ex3.Publication;
import fr.ece.bernoux.lab1Basis.ex5.Person;
import fr.ece.bernoux.lab1Basis.exBonus.ISBN;

/**
 * @author Etienne Bernoux
 *
 */
public class Book extends Publication {
	private final Person author;
	private final int yearPublication;
	private final int numberPages;
	private final String genre;
	private final ISBN myISBN; // Identification number

	public Book(String titlep, String authorp, int yearPublicationp, String editionp, int numberPagesp, String genrep,
			String iSBNp) {
		super(titlep, editionp);
		this.author = new Person(authorp);
		this.yearPublication = yearPublicationp;
		this.numberPages = numberPagesp;
		this.genre = genrep;
		this.myISBN = ISBN.createISBN(iSBNp);
	}

	public Book(String titlep, String authorfirstName, String authorLastName, int yearPublicationp, String editionp,
			int numberPagesp, String genrep, String iSBNp) {
		super(titlep, editionp);
		this.author = new Person(authorfirstName, authorLastName);
		this.yearPublication = yearPublicationp;
		this.numberPages = numberPagesp;
		this.genre = genrep;
		this.myISBN = ISBN.createISBN(iSBNp);
	}

	public Book() {
		super();
		this.author = new Person();
		this.yearPublication = -1;
		this.numberPages = -1;
		this.genre = "defaultGenre";
		this.myISBN = ISBN.createISBN("978-2-86889-006-1");
		;
	}

	@Override
	public boolean equals(Object other) {
		// If there is no object, return null
		if (other == null)
			return false;
		// Check the type
		if (other.getClass() != this.getClass())
			return false;
		Book book = (Book) other;
		if (book.getISBN().toString().compareTo(this.getISBN().toString()) == 0)
			return true;
		return false;
	}

	public String getTitle() {
		return getName();
	}

	public Person getAuthor() {
		return author;
	}

	public int getYearPublication() {
		return yearPublication;
	}

	public int getNumberPages() {
		return numberPages;
	}

	public String getGenre() {
		return genre;
	}

	public ISBN getISBN() {
		return myISBN;
	}

	@Override
	public int getYear() {
		// TODO Auto-generated method stub
		return yearPublication;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "Book";
	}

	public ISBN getMyISBN() {
		return myISBN;
	}

}
