package fr.ece.bernoux.PPE.convertisseurReponses;

public class QuestionReponse {
	
	public final int reponse_id;
	public final int question_id;
	public QuestionReponse(int reponse_id, int question_id) {
		super();
		this.reponse_id = reponse_id;
		this.question_id = question_id;
	}
	@Override
	public String toString() {
		return "QuestionReponse [reponse_id=" + reponse_id + ", question_id=" + question_id + "]";
	}
	
	
	
	//INSERT INTO `questions_reponses` (`reponse_id`, `question_id`) VALUES

}
