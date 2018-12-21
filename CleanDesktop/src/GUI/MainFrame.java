package GUI;

import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

import Functions.CreateFolders;

public class MainFrame extends JFrame {
	JButton startBtn;
	CreateFolders cf = new CreateFolders();
	
	
	
	public MainFrame() {
		setSize(600, 400);
		setLayout(null);
		startBtn = new JButton("Start");
		startBtn.setBounds(60, 50, 100, 25);
		add(startBtn);
		
		startBtn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cf.cleanDesktop();
			}
		});
	}

}

