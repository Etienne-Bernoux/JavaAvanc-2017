package fr.ece.bernoux.lab5JavaFX.Exercice1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class FirstAppController {
	@FXML
	private TextField textField;
	
	@FXML
	private Button button;
	
	@FXML
	private void validateText ( ActionEvent event ) {
		System.out.println(textField.getText().toString());
	
	}

}
