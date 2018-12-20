package GUI;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MainFrame extends JFrame {
	JButton startBtn;
	
	
	public MainFrame() {
		setSize(600, 400);
		setLayout(null);
		startBtn = new JButton("Start");
		startBtn.setBounds(60, 50, 100, 25);
		add(startBtn);
	}
}

