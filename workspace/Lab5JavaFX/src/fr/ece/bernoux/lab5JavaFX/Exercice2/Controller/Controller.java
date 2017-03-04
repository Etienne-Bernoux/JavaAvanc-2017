package fr.ece.bernoux.lab5JavaFX.Exercice2.Controller;

import fr.ece.bernoux.lab5JavaFX.Exercice2.Model.UserList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {
	//We useUserList as Model because our program need to word for a specific data Structure
	private  UserList userList;
	@FXML
	private TextField textField;
	
	@FXML
	private TextArea textArea;
	
	@FXML
	private Button button;
	
	private String[] args;
	
	public Controller(){
		
	}
	
	public void setController(UserList userList, String[] args) {
		this.userList = userList;

		this.args = args;
	}

	@FXML
	private void validateText ( ActionEvent event ) {
		System.out.println(textField.getText().toString());
	
	}

	@FXML
	public void initialize() {
		
	}

	
}
