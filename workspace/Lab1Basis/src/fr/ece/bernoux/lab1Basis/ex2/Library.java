package fr.ece.bernoux.lab1Basis.ex2;

import fr.ece.bernoux.lab1Basis.ex4.Media;
import fr.ece.bernoux.lab1Basis.ex5.Element;
import fr.ece.bernoux.lab1Basis.ex5.User;

/**
 * 
 * @author Etienne
 *
 */
public class Library {
	private Media[] library;
	private User[] users;

	/**
	 * My library constructor
	 * 
	 * @param maxReferences
	 * @param maxUsers
	 */
	public Library(int maxReferences, int maxUsers) {
		this.library = new Media[maxReferences];
		this.users = new User[maxUsers];
	}

	/**
	 * Library without user(for user pocket)
	 * 
	 * @param maxReferences
	 */
	public Library(int maxReferences) {
		this.library = new Media[maxReferences];
		this.users = new User[0];
	}

	/**
	 * 
	 * @param newMedia
	 * @return
	 */
	public boolean addMedia(Media newMedia) {
		// Check if this object not already existS
		for (int i = 0; i < this.library.length; i++) {
			if (newMedia.equals(this.library[i]))
				return false;
		}
		// Find a free space
		for (int i = 0; i < this.library.length; i++) {
			if (this.library[i] == null) {
				this.library[i] = newMedia;
				return true;
			}
		}
		System.out.println("The library is full");
		return false;
	}

	/**
	 * The general remove method
	 * 
	 * @param rempub
	 * @param index
	 * @return the remove media
	 */
	public Media removeMedia(Media remMedia, int index) {
		Media refMedia = this.library[index];
		if (!remMedia.equals(refMedia))// remMedia need to be equals the user of
										// the index
			return null;
		this.library[index] = null;
		return refMedia;
	}

	/**
	 * 
	 * @param refMedia
	 * @return the remove media
	 */
	public Media removeMedia(Media refMedia) {
		for (int i = 0; i < this.library.length; i++) {
			if (refMedia.equals(this.library[i])) {
				return removeMedia(this.library[i], i);
			}
		}
		return null;
	}

	/**
	 * 
	 * @param ISBNp
	 * @return the remove media
	 */
	public Media removeMedia(String ISBNp) {
		for (int i = 0; i < this.library.length; i++) {
			if (this.library[i] != null && this.library[i] instanceof Book && ((Book) this.library[i]).getISBN() != null
					&& ISBNp.compareTo(((Book) this.library[i]).getISBN().toString()) == 0) {
				return removeMedia(this.library[i], i);
			}
		}
		return null;
	}

	/**
	 * Add user with first name and last name
	 * 
	 * @param firstName
	 * @param lastName
	 * @return
	 */
	public boolean addUser(String firstName, String lastName) {
		return addUser(new User(firstName, lastName));
	}

	/**
	 * Add user with a new user
	 * 
	 * @param newUser
	 * @return
	 */
	public boolean addUser(User newUser) {
		// Find a free space
		for (int i = 0; i < this.users.length; i++) {
			if (this.users[i] == null) {
				this.users[i] = newUser;
				return true;
			}
		}
		System.out.println("The library is full");
		return false;

	}

	/**
	 * 
	 * @param remUser
	 * @return
	 */
	public User removeUser(User remUser) {
		for (int i = 0; i < this.users.length; i++) {
			if (remUser.equals(this.users[i])) {
				return removeUser(this.users[i], i);
			}
		}
		return null;
	}

	/**
	 * 
	 * @param remUser
	 * @param index
	 * @return
	 */
	public User removeUser(User remUser, int index) {
		User refUser = this.users[index];
		if (remUser.equals(refUser) == false)// remUser need to be equals the
												// user of the index
			return null;
		this.users[index] = null;
		return refUser;
	}

	/**
	 * Remove user by is Id
	 * 
	 * @param iDUser
	 * @return
	 */
	public User removeUser(int iDUser) {
		for (int i = 0; i < this.users.length; i++) {
			if (this.users[i] != null && this.users[i].getIdNumber() == iDUser) {
				return removeUser(this.users[i], i);
			}
		}
		return null;
	}

	/**
	 * Print the content of the library
	 */
	@Override
	public String toString() {
		String text = "\n***Library Content***\n";
		for (int i = 0; i < this.library.length; i++) {
			if (this.library[i] != null)
				text += this.library[i] + "\n";
		}
		if (this.users != null) {
			text += "***Library Users***\n";
			for (int i = 0; i < users.length; i++) {
				if (this.users[i] != null)
					text += this.users[i].toString() + "\n";
			}
		}
		return text;
	}

	/**
	 * 
	 * @param title
	 * @return
	 */
	public Library searchByTitle(String title) {
		Library research = new Library(this.library.length, this.users.length);
		for (int i = 0; i < this.library.length; i++) {
			if (this.library[i].getTitle() == title) {
				research.addMedia(this.library[i]);
			}
		}

		return research;
	}

	/**
	 * 
	 * @param firstName
	 * @param lastName
	 * @return
	 */
	public Library searchByAuthor(String firstName, String lastName) {
		return this.searchByAuthorFirstName(firstName).searchByAuthorLastName(lastName);
	}

	/**
	 * 
	 * @param author
	 * @return
	 */
	public Library searchByAuthor(String author) {

		return searchByPerson(author, library);

		/*
		 * Library library = new Library(this.library.length); for (int i = 0; i
		 * < this.library.length; i++) { if (this.library[i] != null) { if
		 * (this.library[i].getAuthor() != null) { String firstName =
		 * this.library[i].getAuthor().getFirstName(); String lastName =
		 * this.library[i].getAuthor().getLastName(); String concat = firstName
		 * + " " + lastName; String concatInverse = lastName + " " + firstName;
		 * 
		 * if (firstName == author || lastName == author ||
		 * concat.compareToIgnoreCase(author) == 0 ||
		 * concatInverse.compareToIgnoreCase(author) == 0) {
		 * library.addMedia(this.library[i]); } } } }
		 * 
		 * if (library.library.length == 0) return null; else return library;
		 */
	}

	/**
	 * 
	 * @param author
	 * @return
	 */
	public Library searchByAuthorLastName(String author) {
		Library research = new Library(this.library.length, this.users.length);
		for (int i = 0; i < this.library.length; i++) {
			if (this.library[i] != null && this.library[i].getAuthor() != null
					&& this.library[i].getAuthor().getLastName() == author) {
				research.addMedia(this.library[i]);
			}
		}
		return research;
	}

	/**
	 * 
	 * @param author
	 * @return
	 */
	public Library searchByAuthorFirstName(String author) {
		Library research = new Library(library.length, this.users.length);
		for (int i = 0; i < this.library.length; i++) {
			if (this.library[i] != null && this.library[i].getAuthor() != null
					&& this.library[i].getAuthor().getFirstName() == author) {
				research.addMedia(library[i]);
			}
		}
		return research;
	}

	/**
	 * 
	 * @param year
	 * @return
	 */
	public Library searchByYear(int year) {
		Library research = new Library(this.library.length, this.users.length);
		for (int i = 0; i < this.library.length; i++) {
			if (this.library[i] != null && this.library[i].getYear() == year) {
				research.addMedia(this.library[i]);
			}
		}
		return research;
	}

	/**
	 * 
	 * @param type
	 * @return
	 */
	public Library searchByType(String type) {
		Library research = new Library(this.library.length, this.users.length);
		for (int i = 0; i < this.library.length; i++) {
			if (this.library[i] != null && this.library[i].getType() == type) {
				research.addMedia(this.library[i]);
			}
		}
		return research;
	}

	/**
	 * 
	 * @param edition
	 * @return
	 */
	public Library searchByEdition(String edition) {
		Library research = new Library(this.library.length, this.users.length);
		for (int i = 0; i < this.library.length; i++) {
			if (this.library[i] != null && this.library[i].getEdition() == edition) {
				research.addMedia(this.library[i]);
			}
		}
		return research;
	}

	/**
	 * 
	 * @param name
	 * @return
	 */
	public Library searchByUsers(String name) {
		return searchByPerson(name, users);
	}

	public Library searchByPerson(String name, Element[] myarray) {
		Library newLibrary = new Library(this.library.length, this.users.length);
		for (int i = 0; i < myarray.length; i++) {
			if (myarray[i] != null) {
				if (myarray[i].getPerson() != null) {

					String firstName = myarray[i].getPerson().getFirstName();
					String lastName = myarray[i].getPerson().getLastName();
					String concat = firstName + " " + lastName;
					String concatInverse = lastName + " " + firstName;

					if (firstName == name || lastName == name || concat.compareToIgnoreCase(name) == 0
							|| concatInverse.compareToIgnoreCase(name) == 0) {
						if (myarray[i] instanceof User) {
							newLibrary.addUser((User) myarray[i]);
						}

						if (myarray[i] instanceof Media) {
							newLibrary.addMedia((Media) myarray[i]);
						}
					}
				}

			}
		}
		return newLibrary;
	}

	public boolean borrowMedia(Media media, User user, int durationDay) {
		this.removeMedia(media);
		media.setLoan(user.getIdNumber(), durationDay);
		user.getMedia(media);
		return true;
	}

	public boolean returnMedia(Media media, User user) {
		this.addMedia(media);
		media.setAvailable();
		user.giveBackMedia(media);
		return true;
	}

	public Media[] getLibrary() {
		return library;
	}

	public void setLibrary(Media[] library) {
		this.library = library;
	}

	public User[] getUsers() {
		return users;
	}

	public void setUsers(User[] users) {
		this.users = users;
	}

}
