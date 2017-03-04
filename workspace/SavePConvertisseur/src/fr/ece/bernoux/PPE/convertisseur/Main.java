package fr.ece.bernoux.PPE.convertisseur;

import java.io.File;

import fr.ece.bernoux.PPE.convertisseurQuestion.MainQuestion;
import fr.ece.bernoux.PPE.convertisseurReponses.MainReponse;

public class Main {

	public static void main(String[] args) {
		File question = new File("src/fichier/questions.txt");
		File reponse = new File("src/fichier/reponses.txt");
		File QRSQL = new File("src/fichier/qrsql.sql");		
	
		MainReponse.convertR(reponse, QRSQL);
		MainQuestion.convertQ(question, QRSQL);

	}

}
