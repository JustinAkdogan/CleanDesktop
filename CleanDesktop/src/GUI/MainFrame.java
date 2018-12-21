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
import Functions.FileWhitelist;

public class MainFrame extends JFrame {
	JButton startBtn, whiteBtn;
	CreateFolders cf = new CreateFolders();
	
	
	
	public MainFrame() {
		setSize(600, 400);
		setLayout(null);
		startBtn = new JButton("Clean Desktop");
		startBtn.setBounds(220, 300, 130, 25);
		whiteBtn = new JButton("Add File/s to Whitelist");
		whiteBtn.setBounds(200, 350, 170, 15);
		add(startBtn);
		add(whiteBtn);
		
		startBtn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cf.cleanDesktop();
			}
		});
		
		whiteBtn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				FileWhitelist fw = new FileWhitelist();
			}
		});
	}

}

