package fr.ece.bernoux.PPE.convertisseurReponses;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MainReponse {
	
	public static void createReponse(File reponse,ArrayList<Reponse> myreponses,ArrayList<QuestionReponse> myquestionReponses) {
		FileReader fr;
		String str = "";
		try {
			fr = new FileReader(reponse);
			int i = 0;
			// Lecture des données
			while ((i = fr.read()) != -1)
				str += (char) i;
			// Affichage
			//System.out.println(str);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		int i=0;
		
		String[] lines = str.split("\n");
		for (String line : lines) {
			i++;
			String[] words = line.split("/");
			for (String word : words) {
				//System.out.println(word);
			}
			//System.out.println(i);
			myreponses.add(new Reponse(Integer.parseInt(words[0]), words[1],Integer.parseInt(words[2]),Integer.parseInt(words[3])));
			myquestionReponses.add(new QuestionReponse(Integer.parseInt(words[0]), Integer.parseInt(words[4].replaceAll("[\r\n]+", ""))));
		}
		
	}

	public static void convertR(File reponse, File reponseSQL) {
		FileWriter fw;
		ArrayList<Reponse> myreponses = new ArrayList<>();
		ArrayList<QuestionReponse> myquestionReponses = new ArrayList<>();
		createReponse(reponse,myreponses,myquestionReponses);
		for (Reponse myreponse : myreponses) {
			//System.out.println(myreponse.toString());
		}
		for (QuestionReponse myquestionReponse : myquestionReponses) {
			//System.out.println(myquestionReponse.toString());
		}
	
		// Ecriture du contenue de fichier

		String sql = "-- peuplements base de données --\n\n-- reponses --\n";
		sql += "INSERT INTO `reponses` (`id_reponse`, `intitule`, `valeur`, `question_id`)\n";
		sql += "VALUES";

		for (Reponse myreponse : myreponses) {
			sql += "(" + myreponse.id_reponse + "," + "\"" + myreponse.intitule + "\","+ myreponse.valeur +","+ myreponse.question_id + ")";
			if (myreponses.indexOf(myreponse) != myreponses.size() - 1) {
				sql += ",\n";
			} else {
				sql += ";\n";
			}

		}
		sql += "\n-- questions_reponses --\n\n";
		sql += "INSERT INTO `questions_reponses` (`reponse_id`, `question_id`)\n";
		sql += "VALUES";
		
		for (QuestionReponse myquestionReponse : myquestionReponses) {
			sql += "(" + myquestionReponse.reponse_id + ","+ myquestionReponse.question_id + ")";
			if (myquestionReponses.indexOf(myquestionReponse) != myreponses.size() - 1) {
				sql += ",\n";
			} else {
				sql += ";\n";
			}
		}
		System.out.println(sql);
		try {
			// Création de l'objet
			fw = new FileWriter(reponseSQL);
			// On écrit la chaîne
			fw.write(sql);
			// On ferme le flux
			fw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		File reponse = new File("src/fichier/reponses.txt");
		File reponseSQL = new File("src/fichier/reponses.sql");
		convertR(reponse, reponseSQL);

	}
}
