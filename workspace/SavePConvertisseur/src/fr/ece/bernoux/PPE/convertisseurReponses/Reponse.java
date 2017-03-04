package fr.ece.bernoux.PPE.convertisseurReponses;

public class Reponse {
	
	public final int id_reponse;
	public final String intitule;
	public final int valeur;
	public final int question_id;
	
	public Reponse(int id_reponse, String intitule, int valeur, int question_id) {
		super();
		this.id_reponse = id_reponse;
		this.intitule = intitule;
		this.valeur = valeur;
		this.question_id = question_id;
	}

	
	@Override
	public String toString() {
		return "Reponse [id_reponse=" + id_reponse + ", intitule=" + intitule + ", valeur=" + valeur + ", question_id="
				+ question_id + "]";
	}
	
	
	
	//INSERT INTO `reponses` (`id_reponse`, `intitule`, `valeur`, `question_id`) VALUES

}
