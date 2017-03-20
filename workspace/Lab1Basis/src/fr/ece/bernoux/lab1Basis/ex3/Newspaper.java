package fr.ece.bernoux.lab1Basis.ex3;

import java.util.Calendar;

import fr.ece.bernoux.lab1Basis.ex5.Person;

public class Newspaper extends Periodic {

	private final NewspaperType newspaperType;

	public Newspaper(String namep, String editionp, Periodicity peridicityp, Calendar datep, int issueNumberp,
			NewspaperType newspaperTypep) {
		super(namep, editionp, peridicityp, datep, issueNumberp);
		this.newspaperType = newspaperTypep;
	}

	public Newspaper() {
		super();
		this.newspaperType = NewspaperType.DEFAULT;
	}

	public NewspaperType getNewspaperType() {
		return newspaperType;
	}

	@Override
	public Person getAuthor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "Newspaper";
	}

}
