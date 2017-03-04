package fr.ece.bernoux.lab5JavaFX.Exercice2.Controller;

import java.util.HashSet;
import java.util.Set;

import fr.ece.bernoux.lab5JavaFX.Exercice2.Model.UserList;
import fr.ece.bernoux.lab5JavaFX.Exercice2.View.View;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {
	//We useUserList as Model because our program need to word for a specific data Structure
	private  UserList userList;
	//We use a general view because we can imagine that different view can be executed for this program.
	private  Set<View> views;
	
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

	void start(){
		//For each view
			//The controller need to be set
			view.setController(this);
			view.start(args);
			userList.addObserver(view);	
	}

	public Set<View> getViews() {
		return views;
	}

	public UserList getModel() {
		return userList;
	}
	
	@FXML
	private void validateText ( ActionEvent event ) {
		System.out.println(textField.getText().toString());
	
	}

	@FXML
	public void initialize() {
		
	}

	
}