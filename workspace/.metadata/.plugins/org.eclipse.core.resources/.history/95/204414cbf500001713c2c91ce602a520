package fr.ece.bernoux.lab3MVC.Model;

import java.util.ArrayList;
import java.util.Observable;

public class UserList extends Observable implements Model {
	private ArrayList<String> userList;

	public UserList() {
		super();
		this.userList = new ArrayList<>();
	}

	public boolean addUser(String user) {
		if (!this.userList.contains(user)) {
			this.userList.add(user);
			//Make this as has been changed
			this.setChanged();
			//Notify all observer that something has been changed ant sent in parameter all the data
			this.notifyObservers(this.getData());
			//This has been not changed anymore
			this.clearChanged();
			//True if the user has been had
			return true;
		}
		return false;
	}

	@Override
	public String[] getData() {
		Object[] myArray = this.userList.toArray();
		String[] myString = new String[myArray.length];
		//For each String in my array,
		for (int i = 0; i < myArray.length; i++) {
			myString[i] = myArray[i].toString();

		}

		return (myString);
	}

}
