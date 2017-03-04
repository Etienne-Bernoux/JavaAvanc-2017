package fr.ece.bernoux.PPE.convertisseurQuestion;

public class Question {
	public final int id;
	public final String title;
	
	public Question(int id, String title) {
		super();
		this.id = id;
		this.title = title;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", title=" + title + "]";
	}
	
	
	

}
