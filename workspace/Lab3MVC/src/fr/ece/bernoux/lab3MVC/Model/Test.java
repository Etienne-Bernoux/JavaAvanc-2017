package fr.ece.bernoux.lab3MVC.Model;

public class Test {

	public static void main(String[] args) {
		UserList myList = new UserList();
		myList.addUser("Nicolas");
		myList.addUser("Etienne");
		myList.addUser("Toto");
		for (String myString : myList.getData())
			System.out.println(myString);
	}
}
