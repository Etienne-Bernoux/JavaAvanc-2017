package fr.ece.bernoux.Lab2Generics.ex4;

public class ColoredWord extends Word {
	private final Color color;

	public ColoredWord(String myword, Color color) {
		super(myword);
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

	@Override
	public String toString() {
		return this.getMyword() + " ,Color=" + color.toString();
	}

	/**
	 * The Color enumeration who is an inner class of Colored Word
	 * 
	 * @author nicolas & etienne
	 *
	 */
	public enum Color {
		RED, GREEN, BLUE, YELLOW, PURPLE, TURQUOISE

	}

}
