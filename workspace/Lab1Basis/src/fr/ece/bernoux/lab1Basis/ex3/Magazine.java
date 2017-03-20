package fr.ece.bernoux.lab1Basis.ex3;

import java.util.Calendar;

import fr.ece.bernoux.lab1Basis.ex5.Person;

public class Magazine extends Periodic {
	private final Topic topic;
	private final int value;

	public Magazine(String namep, String editionp, Periodicity peridicityp, Calendar datep, int issueNumberp,
			Topic topicp, int valuep) {
		super(namep, editionp, peridicityp, datep, issueNumberp);
		this.topic = topicp;
		this.value = valuep;
	}

	public Magazine() {
		super();
		this.topic = Topic.DEFAULT;
		this.value = -1;
	}

	public Topic getTopic() {
		return topic;
	}

	public int getValue() {
		return value;
	}

	@Override
	public Person getAuthor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "Magazine";
	}

}
