package fr.ece.bernoux.lab1Basis.ex5;

import fr.ece.bernoux.lab1Basis.ex2.Library;
import fr.ece.bernoux.lab1Basis.ex4.Media;

public class User extends Person implements Element {
	private final int idNumber;
	private static int index = 0;
	private Library pocket;
	// private static final int MaxMediaBorrowed = 3;

	public User(String firstName, String lastName) {
		super(firstName, lastName);
		index++;
		this.idNumber = index;
		this.setPocket(new Library(3, 0));

	}

	/**
	 * Use to get a media when a user borrow a media
	 * 
	 * @param media
	 */
	public void getMedia(Media media) {
		pocket.addMedia(media);
	}

	/**
	 * Use to give back a media when a user return a media
	 * 
	 * @param media
	 * @return
	 */
	public Media giveBackMedia(Media media) {
		return pocket.removeMedia(media);
	}

	public int getIdNumber() {
		return idNumber;
	}

	public static int getIndex() {
		return index;
	}

	public Library getPocket() {
		return pocket;
	}

	public void setPocket(Library pocket) {
		this.pocket = pocket;
	}

	@Override
	public String toString() {
		return "User [firstName=" + super.getFirstName() + ", lastName=" + super.getLastName() + "+idNumber=" + idNumber
				+ ", pocket=" + this.pocket.toString() + "]";
	}

	@Override
	public boolean equals(Object other) {
		// If there is no object, return null
		if (other == null)
			return false;
		// Check the type
		if (other.getClass() != this.getClass())
			return false;
		User user = (User) other;
		if (user.idNumber == this.idNumber)
			return true;
		return false;
	}

	public Person getPerson() {
		return this;
	}

}
