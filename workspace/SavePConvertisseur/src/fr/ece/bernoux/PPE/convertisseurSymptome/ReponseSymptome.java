package fr.ece.bernoux.PPE.convertisseurSymptome;

public class ReponseSymptome {
	/*
	INSERT INTO `saveplus_beta`.`reponses_symptomes`
	(`symptome_id`,
	`reponse_id`)
	VALUES
	(<{symptome_id: }>,
	<{reponse_id: }>);
*/
	public final int symptome_id;
	public final int reponse_id;
	public ReponseSymptome(int symptome_id, int reponse_id) {
		super();
		this.symptome_id = symptome_id;
		this.reponse_id = reponse_id;
	}
	@Override
	public String toString() {
		return "ReponseSymptome [symptome_id=" + symptome_id + ", reponse_id=" + reponse_id + "]";
	}
	

}
