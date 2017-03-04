package fr.ece.bernoux.PPE.convertisseurQuestion;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MainQuestion {
	
	public static ArrayList<Question> createQuestion(File question){
		FileReader fr;
		String str = "";
		try {
			fr = new FileReader(question);
			int i = 0;
			// Lecture des données
			while ((i = fr.read()) != -1)
				str += (char) i;
			// Affichage
			// System.out.println(str);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		ArrayList<Question> myquestions = new ArrayList<>();
		String[] lines = str.split("\n");
		for (String line : lines) {
			String[] words = line.split("/");
			myquestions.add(new Question(Integer.parseInt(words[0]), words[1].replaceAll("[\r\n]+", "")));
		}
		
		return myquestions;
		
	}
	
	public static String createSQL(ArrayList<Question> myquestions){
		// Ecriture du contenue de fichier

				String sql = "-- peuplements base de données --\n\n-- questions --\n";
				sql += "INSERT INTO `saveplus_beta`.`questions`(`id_question`,`intitule`)\n";
				sql += "VALUES";

				for (Question myquestion : myquestions) {
					sql += "(" + myquestion.id + "," + "\"" + myquestion.title + "\")";
					if (myquestions.indexOf(myquestion) != myquestions.size() - 1) {
						sql += ",\n";
					} else {
						sql += ";\n";
					}

				}
		return sql;	
	}
	

	public static void convertQ(File question, File questionSQL) {
		FileWriter fw;
		
		ArrayList<Question> myquestions = createQuestion(question);
		
		for (Question myquestion : myquestions) {
			//System.out.println(myquestion.toString());
		}
		String sql = createSQL(myquestions);

		
		System.out.println(sql);
		try {
			// Création de l'objet
			fw = new FileWriter(questionSQL);
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
		File question = new File("src/fichier/questions.txt");
		File questionSQL = new File("src/fichier/questions.sql");
		convertQ(question, questionSQL);

	}
}
