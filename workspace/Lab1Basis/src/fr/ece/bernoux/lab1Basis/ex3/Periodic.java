package fr.ece.bernoux.lab1Basis.ex3;

import java.util.Calendar;

public abstract class Periodic extends Publication {
	private final Periodicity peridicity;
	private final Calendar date;
	private final int issueNumber;

	public Periodic(String name, String edition, Periodicity peridicity, Calendar datep, int issueNumber) {
		super(name, edition);
		this.peridicity = peridicity;
		this.date = datep;
		this.issueNumber = issueNumber;
	}

	public Periodic() {
		super();
		this.peridicity = Periodicity.DEFAULT;
		this.date = Calendar.getInstance();
		this.issueNumber = -1;
	}

	@Override
	public boolean equals(Object other) {
		// If there is no object, return null
		if (other == null)
			return false;
		// Check the type
		if (other.getClass() != this.getClass())
			return false;

		Periodic periodic = (Periodic) other;
		if (periodic.issueNumber == this.issueNumber)
			return true;
		return false;
	}

	public Periodicity getPeridicity() {
		return peridicity;
	}

	public Calendar getDate() {
		return date;
	}

	public int getIssueNumber() {
		return issueNumber;
	}

	public int getYear() {
		if (date != null)
			return Calendar.YEAR;
		return 0;
	}

}
