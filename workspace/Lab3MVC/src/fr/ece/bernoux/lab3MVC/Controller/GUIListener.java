package fr.ece.bernoux.lab3MVC.Controller;

import java.awt.event.ActionListener;

import javax.swing.text.JTextComponent;

public interface GUIListener {
	ActionListener getAddUserListener(JTextComponent textComponent);
}
