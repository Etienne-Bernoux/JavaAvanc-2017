package fr.ece.bernoux.lab1Basis.exBonus;

public class ISBN {
	private final String A;
	private final String B;
	private final String C;
	private final String D;
	private final String KEY;

	private ISBN(String a, String b, String c, String d, String kEY) {
		super();
		A = a;
		B = b;
		C = c;
		D = d;
		KEY = kEY;
	}

	public static ISBN createISBN(String isbn) {
		if (isbn.length() != 17) {
			System.out.println("error isbn number of character");
			return null;
		}
		String reg = ("-");
		String[] res = isbn.split(reg);
		if (res.length != 5) {
			System.out.println("error isbn size");
			return null;
		}
		if (res[0].length() != 3) {
			System.out.println("error isbn first part");
			return null;
		}
		// I do not calculate the key here with the modulo method
		String A = res[0];
		String B = res[1];
		String C = res[2];
		String D = res[3];
		String KEY = res[4];

		return new ISBN(A, B, C, D, KEY);
	}

	@Override
	public String toString() {
		// System.out.println(this.A+"-"+this.B+"-"+this.C+"-"+this.D+"-"+this.KEY);
		return (this.A + "-" + this.B + "-" + this.C + "-" + this.D + "-" + this.KEY);
	}

}
