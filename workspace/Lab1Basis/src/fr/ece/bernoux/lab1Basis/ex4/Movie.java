package fr.ece.bernoux.lab1Basis.ex4;

import fr.ece.bernoux.lab1Basis.ex5.Person;

public class Movie extends Multimedia {
	private final GenreMovie genre;
	private final Person producer;
	private final Person realisator;
	private final Person director;
	private final Person[] actors;

	/**
	 * 
	 * @param title
	 * @param year
	 * @param genre
	 * @param producer
	 * @param realisator
	 * @param director
	 * @param actors
	 */
	public Movie(String title, int year, GenreMovie genre, Person producer, Person realisator, Person director,
			Person[] actors) {
		super(title, year);
		this.genre = genre;
		this.producer = producer;
		this.realisator = realisator;
		this.director = director;
		this.actors = actors;
	}

	public Movie() {
		super();
		this.genre = GenreMovie.DEFAULT;
		this.producer = new Person("defaultProducer");
		this.realisator = new Person("defaultRealisator");
		this.director = new Person("defaultDirector");
		this.actors = new Person[1];
		this.actors[0] = new Person("defaultActor");
	}

	public GenreMovie getGenre() {
		return genre;
	}

	public Person getProducer() {
		return producer;
	}

	public Person getDirector() {
		return director;
	}

	public Person[] getActors() {
		return actors;
	}

	@Override
	public Person getAuthor() {
		// TODO Auto-generated method stub
		return this.realisator;
	}

	public Person getRealisator() {
		return realisator;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "Movie";
	}

}
