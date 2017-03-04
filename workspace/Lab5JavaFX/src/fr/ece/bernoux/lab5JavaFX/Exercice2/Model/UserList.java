package fr.ece.bernoux.lab5JavaFX.Exercice2.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class UserList {
	private ObservableList<User> userList;

	public UserList() {
		super();
		this.userList = FXCollections.observableArrayList();
	}
	public UserList(User user) {
		super();
		this.userList = FXCollections.observableArrayList(user);
	}

	public boolean addUser(User user) {
		if (!this.userList.contains(user)) {
			this.userList.add(user);
		}
		return false;
	}

	public ObservableList<User> getUserList() {
		return userList;
	}

	public void setUserList(ObservableList<User> userList) {
		this.userList = userList;
	}

	public String[] getData() {
		Object[] myArray = this.userList.toArray();
		String[] myString = new String[myArray.length];
		//For each String in my array,
		for (int i = 0; i < myArray.length; i++) {
			myString[i] = myArray[i].toString();

		}

		return (myString);
	}

	@Override
	public String toString() {
		String result = "";
		for (User string : userList) {
			result+= string.getName() +"/n";
		}
		
		return result;
	}



}
