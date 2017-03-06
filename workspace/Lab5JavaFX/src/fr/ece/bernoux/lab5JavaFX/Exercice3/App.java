package fr.ece.bernoux.lab5JavaFX.Exercice3;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;

public class App extends Application {

	public static void main(String[] args) {
		launch(args);	
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		Parent root =FXMLLoader.load(getClass().getResource("View.fxml"));
		Scene scene = new Scene (root);
	        stage.setScene(scene);
	        stage.show();
	        System.out.println("complete");

	}
	

}
