package fr.ece.bernoux.lab3MVC.Controller;

import java.util.HashSet;

import fr.ece.bernoux.lab3MVC.Model.UserList;
import fr.ece.bernoux.lab3MVC.View.GUI;
import fr.ece.bernoux.lab3MVC.View.View;

public class Main {

	public static void main(String[] args) {

		UserList model = new UserList();
		HashSet<View> views = new HashSet<>();
		GUI gui = new GUI(model, " Lab3 ", 320, 240);
		views.add(gui);
		Controller controller = new Controller(model,views);
		controller.start();
	}

}
