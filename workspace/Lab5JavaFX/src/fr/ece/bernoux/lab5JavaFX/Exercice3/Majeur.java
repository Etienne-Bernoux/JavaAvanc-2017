package fr.ece.bernoux.lab5JavaFX.Exercice3;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Majeur {
	private final SimpleStringProperty name;
	private final SimpleIntegerProperty number;
	public Majeur(String name, int number) {
		super();
		this.name = new SimpleStringProperty(name);
		this.number = new SimpleIntegerProperty(number);
	}
	public String getName() {
		return name.get();
	}
	public int getNumber() {
		return number.get();
	}

}
