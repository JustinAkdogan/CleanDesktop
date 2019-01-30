package GUI;

import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.sun.glass.events.WindowEvent;

import Functions.CreateWorkspace;
import Functions.FileWhitelist;

public class MainFrame extends JFrame {
	JButton startBtn, whiteBtn, settingsBtn;
	CreateWorkspace cw = new CreateWorkspace();
	
	
	
	public MainFrame() {
		setSize(600, 400);
		setLayout(null);
		startBtn = new JButton("Clean Desktop");
		startBtn.setBounds(220, 300, 130, 25);
		whiteBtn = new JButton("Add File/s to Whitelist");
		whiteBtn.setBounds(200, 350, 170, 15);
		settingsBtn = new JButton("Settings");
		settingsBtn.setBounds(510,0,90,24);
		//Adding Elements
		add(startBtn);
		add(whiteBtn);
		add(settingsBtn);
		
		startBtn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cw.cleanDesktop();
			}
		});
		
		whiteBtn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				FileWhitelist fw = new FileWhitelist();
				fw.selectFiles();
			}
		});
		
		settingsBtn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				SettingsFrame settings= new SettingsFrame();
				settings.setTitle("Settings");
				settings.setResizable(false);
				settings.setVisible(true);
				setVisible(false);
			}
		});
	}

}

