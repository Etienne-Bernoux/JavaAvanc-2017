package fr.ece.bernoux.lab1Basis.ex3;

import fr.ece.bernoux.lab1Basis.ex4.Media;
import fr.ece.bernoux.lab1Basis.ex5.Item;
import fr.ece.bernoux.lab1Basis.ex5.Person;

public abstract class Publication extends Item implements Media {
	private final String name;
	private final String edition;

	/**
	 * 
	 * @param name
	 * @param edition
	 */
	public Publication(String name, String edition) {
		super();
		this.name = name;
		this.edition = edition;
	}

	/**
	 * 
	 */
	public Publication() {
		super();
		this.name = "default_name";
		this.edition = "default_edition";
	}

	@Override
	public boolean equals(Object other) {
		// If there is no object, return null
		if (other == null)
			return false;
		// Check the type
		if (other.getClass() != this.getClass())
			return false;
		Publication publication = (Publication) other;
		if (publication.name == this.name && publication.edition == this.edition)
			return true;
		return false;
	}

	public String getEdition() {
		return edition;
	}

	public String getName() {
		return name;
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return name;
	}

	public Person getPerson() {
		return this.getAuthor();
	}

}
