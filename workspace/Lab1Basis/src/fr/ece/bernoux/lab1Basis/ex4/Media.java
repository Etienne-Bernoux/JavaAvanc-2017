package fr.ece.bernoux.lab1Basis.ex4;

import fr.ece.bernoux.lab1Basis.ex5.Element;
import fr.ece.bernoux.lab1Basis.ex5.Person;

public interface Media extends Element {
	String getTitle();

	Person getAuthor();

	int getYear();

	String getType();

	String getEdition();

	boolean equals(Object object);

	void setLoan(int lawnerIdNumber, int durationDay);

	void setLoan(int lawnerIdNumber);

	void setAvailable();
}
