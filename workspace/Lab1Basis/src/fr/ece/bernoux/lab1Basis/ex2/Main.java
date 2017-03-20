package fr.ece.bernoux.lab1Basis.ex2;

import fr.ece.bernoux.lab1Basis.ex3.*;
import fr.ece.bernoux.lab1Basis.ex4.*;

public class Main {

	public static void main(String[] args) {

		Library myLibrary = new Library(10, 10);
		System.out.println(myLibrary.toString());
		System.out.println("*****Adding");
		myLibrary.addMedia(
				new Book("force", "etienne", "bernoux", 2004, "durand", 200, "classique", "978-2-86689-006-1"));
		myLibrary.addMedia(new Book("force", null, 0, null, 0, null, "978-2-86549-006-1"));
		myLibrary.addMedia(new Magazine());
		myLibrary.addMedia(new Newspaper("toto", null, null, null, 0, null));
		myLibrary.addMedia(new Newspaper());
		System.out.println(myLibrary.toString());
		myLibrary.addMedia(new Book("force", "etienne", 2004, "durand", 200, "classique", "978-2-86549-006-1"));
		myLibrary.addMedia(new CD());
		myLibrary.addMedia(new CD());
		myLibrary.addMedia(new Movie());

		myLibrary.addUser("Etienne", "Bernoux");
		myLibrary.addUser("Nicolas", "Bardoux");

		System.out.println(myLibrary.toString());

		System.out.println("*****Research");
		System.out.println(myLibrary.searchByAuthorLastName("etienne"));

		System.out.println(myLibrary.searchByAuthor("etienne bernoux"));
		System.out.println(myLibrary.searchByUsers("nicolas bardoux"));

		System.out.println(myLibrary.searchByYear(2004));

		System.out.println("*****Borrow");
		myLibrary.borrowMedia(myLibrary.searchByAuthor("etienne bernoux").getLibrary()[0],
				myLibrary.searchByUsers("nicolas bardoux").getUsers()[0], 7);
		System.out.println(myLibrary.toString());

		System.out.println("*****Return");
		System.out.println(myLibrary.searchByUsers("nicolas bardoux").getUsers()[0].getPocket()
				.searchByAuthor("etienne bernoux").toString());
		myLibrary
				.returnMedia(
						myLibrary.searchByUsers("nicolas bardoux").getUsers()[0].getPocket()
								.searchByAuthor("etienne bernoux").getLibrary()[0],
						myLibrary.searchByUsers("nicolas bardoux").getUsers()[0]);
		System.out.println(myLibrary.toString());

		System.out.println("*****Remove");
		System.out.println(myLibrary
				.removeMedia(
						new Book("force", "etienne", "bernoux", 2004, "durand", 200, "classique", "978-2-86689-006-1"))
				.toString());
		System.out.println(myLibrary.removeMedia("978-2-86549-006-1").toString());
		System.out.println(myLibrary.toString());
		System.out.println(myLibrary.removeMedia(new Magazine()));
		System.out.println(myLibrary.removeMedia(new Newspaper("toto", null, null, null, 0, null)));
		System.out.println(myLibrary.removeUser(2));
		System.out.println(myLibrary.toString());

	}

}
