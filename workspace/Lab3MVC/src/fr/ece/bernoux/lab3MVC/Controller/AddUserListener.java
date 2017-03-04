package fr.ece.bernoux.lab3MVC.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.text.JTextComponent;

import fr.ece.bernoux.lab3MVC.Model.UserList;

public class AddUserListener implements ActionListener {
	private final JTextComponent textComponent;
	private final UserList userList;

	public AddUserListener(JTextComponent textComponent, UserList userList) {
		super();
		this.textComponent = textComponent;
		this.userList = userList;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//System.out.println(e.getActionCommand().toString());
		userList.addUser(textComponent.getText());
		textComponent.setText("");
	}

	public JTextComponent getTextComponent() {
		return textComponent;
	}

}
