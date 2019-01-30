package GUI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Functions.ChangeSettings;

public class SettingsFrame extends JFrame {
	JTextField img_destination;
	JButton select_img_destination;
	JLabel description1;
	String username = System.getProperty("user.name");
	public SettingsFrame() {
	setSize(600, 400);
	setLayout(null);
	
	ChangeSettings changeSettings = new ChangeSettings();
	changeSettings.changeSettings();
	
	//Elements
	img_destination = new JTextField("C:/Users/"+username+"/Pictures/CleanDesktop");
	img_destination.setBounds(20, 30, 300, 25);
	img_destination.setEditable(false);
	select_img_destination = new JButton("Select");
	select_img_destination.setBounds(320, 30, 30, 25);
	description1 = new JLabel ("Destination Paths");
	description1.setBounds(20, 5, 100, 25);
	//Adding Elements
	add(description1);
	add(img_destination);
	add(select_img_destination);
	}
}
