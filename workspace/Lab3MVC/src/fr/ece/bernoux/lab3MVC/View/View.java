package fr.ece.bernoux.lab3MVC.View;

import java.util.Observer;
import fr.ece.bernoux.lab3MVC.Controller.GUIListener;

public interface View extends Observer{
	void setController(GUIListener Controller);
	void start();
}
