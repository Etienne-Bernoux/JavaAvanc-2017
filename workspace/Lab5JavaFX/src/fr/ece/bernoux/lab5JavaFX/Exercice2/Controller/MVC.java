package fr.ece.bernoux.lab5JavaFX.Exercice2.Controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class MVC extends Application {

	public static void main(String[] args) {
		launch(args);	
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root =FXMLLoader.load(getClass().getResource("/fr/ece/bernoux/lab5JavaFX/Exercice2/View/layout.fxml"));
		Scene scene = new Scene (root);

		primaryStage.setTitle (" Welcome  to  JavaFX !");
		primaryStage.setScene ( scene );
		primaryStage.sizeToScene ();
		primaryStage.show ();
		
		
		
		
	}

}
