
package fr.ece.bernoux.lab3MVC.View;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Observable;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import fr.ece.bernoux.lab3MVC.Model.Model;
import fr.ece.bernoux.lab3MVC.Model.UserList;

/**
 * @author Etienne Bernoux
 */
public class GUI extends AbstractView {

	private final JFrame frame;
	private final JList<String> list = new JList<>();


	public GUI( Model model,String title, int width, int height) {
		super(model);
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	private void configJMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic(KeyEvent.VK_F);
		menuBar.add(fileMenu);
		JMenuItem quitItem = new JMenuItem("Quit");
		quitItem.setMnemonic(KeyEvent.VK_Q);
		quitItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		fileMenu.add(quitItem);
		frame.setJMenuBar(menuBar);
	}

	private void configJPanel() {
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(new BorderLayout());
		final JTextField textField = new JTextField();
		textField.addActionListener(this.getController().getAddUserListener(textField));
		panel.add(textField, BorderLayout.PAGE_START);
		panel.add(list, BorderLayout.CENTER);
	}

	@Override
	public void start() {
		configJMenuBar();
		configJPanel();
		frame.setVisible(true);
	}

	//This main is not working because he as no controller
	public static void main(String[] args) {
		
		GUI gui = new GUI(new UserList(),"myInterface", 320, 240);
		gui.start();
	}

	@Override
	public void update(Observable o, Object arg) {
		//We add the list of data
			this.list.setListData((String[]) arg);
			//System.out.println("MAJ");
		
	}
	public JFrame getFrame() {
		return frame;
	}

	public JList<String> getList() {
		return list;
	}



}