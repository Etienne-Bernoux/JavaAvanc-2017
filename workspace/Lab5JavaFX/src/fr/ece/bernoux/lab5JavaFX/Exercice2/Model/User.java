package fr.ece.bernoux.lab5JavaFX.Exercice2.Model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class User {
	private final StringProperty firstName;

	public User(String name) {
		super();
		this.firstName = new SimpleStringProperty(name);
	}

    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

}
