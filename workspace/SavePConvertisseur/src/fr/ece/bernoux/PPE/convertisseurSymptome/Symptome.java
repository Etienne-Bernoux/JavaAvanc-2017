package fr.ece.bernoux.PPE.convertisseurSymptome;

public class Symptome {
/*
	INSERT INTO `saveplus_beta`.`symptomes`
	(`id_symptome`,
	`titre`,
	`cluster`)
	VALUES
	(<{id_symptome: }>,
	<{titre: }>,
	<{cluster: }>);
*/
	
	public final int id_symptome;
	public final String titre;
	public final int cluster;
	public Symptome(int id_symptome, String titre, int cluster) {
		super();
		this.id_symptome = id_symptome;
		this.titre = titre;
		this.cluster = cluster;
	}
	@Override
	public String toString() {
		return "Symptome [id_symptome=" + id_symptome + ", titre=" + titre + ", cluster=" + cluster + "]";
	}
	
	
}
