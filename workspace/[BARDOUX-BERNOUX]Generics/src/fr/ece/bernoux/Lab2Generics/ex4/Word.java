package fr.ece.bernoux.Lab2Generics.ex4;

public class Word {
	private final String myword;

	public Word(String myword) {
		super();
		this.myword = myword;
	}

	public String getMyword() {
		return myword;
	}

	@Override
	public String toString() {
		return myword;
	}

}
