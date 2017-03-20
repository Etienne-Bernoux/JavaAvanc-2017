package fr.ece.bernoux.lab1Basis.ex4;

import fr.ece.bernoux.lab1Basis.ex5.Person;
import fr.ece.bernoux.lab1Basis.ex5.Item;

public abstract class Multimedia extends Item {
	private final String title;
	private final int year;

	public Multimedia(String title, int year) {
		super();
		this.title = title;
		this.year = year;
	}

	public Multimedia() {
		super();
		this.title = "defaultTitle";
		this.year = -1;
	}

	@Override
	public boolean equals(Object other) {
		// If there is no object, return null
		if (other == null)
			return false;
		// Check the type
		if (other.getClass() != this.getClass())
			return false;
		Multimedia multimedia = (Multimedia) other;
		if (multimedia.title == this.title && multimedia.getType() == this.getType())
			return true;
		return false;
	}

	public String getTitle() {
		return title;
	}

	public int getYear() {
		return year;
	}

	public String getEdition() {
		return null;
	}

	public Person getPerson() {
		return this.getAuthor();
	}

	public Person getAuthor() {
		// TODO Auto-generated method stub
		return null;
	}

}
