package fr.ece.bernoux.Lab6Lambda.Exercice2;

public class Teacher {
	private final String name;
	private final Gender gender ;
	
	
	
	public Teacher(String name, Gender gender) {
		super();
		this.name = name;
		this.gender = gender;
	}
	

	public Gender getGender() {
		return gender;
	}
	

}

