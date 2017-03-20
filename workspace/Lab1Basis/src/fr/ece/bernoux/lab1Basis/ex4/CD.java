package fr.ece.bernoux.lab1Basis.ex4;

import fr.ece.bernoux.lab1Basis.ex5.Person;

public class CD extends Multimedia {
	private final GenreMusic genre;
	private final Person artist;
	private final int numbreOfSong;

	/**
	 * 
	 * @param title
	 * @param year
	 * @param genre
	 * @param artist
	 * @param numbreOfSong
	 */
	public CD(String title, int year, GenreMusic genre, Person artist, int numbreOfSong) {
		super(title, year);
		this.genre = genre;
		this.artist = artist;
		this.numbreOfSong = numbreOfSong;
	}

	public CD() {
		super();
		this.genre = GenreMusic.DEFAULT;
		this.artist = new Person();
		this.numbreOfSong = -1;
	}

	public GenreMusic getGenre() {
		return genre;
	}

	public Person getArtist() {
		return artist;
	}

	public int getNumbreOfSong() {
		return numbreOfSong;
	}

	@Override
	public Person getAuthor() {
		// TODO Auto-generated method stub
		return artist;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "CD";
	}

}
