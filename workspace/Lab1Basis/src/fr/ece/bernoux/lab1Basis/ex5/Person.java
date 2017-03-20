package fr.ece.bernoux.lab1Basis.ex5;

public class Person {
	private final String firstName;
	private final String lastName;

	public Person(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Person(String lastName) {
		super();
		this.firstName = "";
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + "]";
	}

	public Person() {
		this.firstName = "defaultFirstName";
		this.lastName = "defaultLastName";
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

}
