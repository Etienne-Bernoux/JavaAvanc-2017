package fr.ece.bernoux.lab5JavaFX.Exercice2.Controller;

import fr.ece.bernoux.lab5JavaFX.Exercice2.Model.UserList;
import fr.ece.bernoux.lab5JavaFX.Exercice2.View.GUI;



public class Main {

	public static void main(String[] args) {
		//Creation of the model
		UserList model = new UserList();
		
		//Creation of the views
		GUI gui = new GUI();
		gui.init();

		//controller.getModel().addUser("etienne");
		//controller.getModel().addUser("nicolas");
		//controller.getModel().addUser("toto");

	}

}