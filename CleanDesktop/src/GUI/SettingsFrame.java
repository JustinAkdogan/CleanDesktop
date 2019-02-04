package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;



import Functions.ChangeSettings;
import Functions.ChooseDestinationFolder;

public class SettingsFrame extends JFrame {
	JTextField img_destination, msc_destination, vid_destination, doc_destination, delete_size_range;
	JButton select_img_destination, select_msc_destination, select_vid_destination, select_doc_destination;
	JLabel description1,description2;
	JRadioButton deleteEmptyFiles,customDeleteFiles,kb,mb,gb;
	String username = System.getProperty("user.name");
	BufferedReader br;
	int lineCounter = 0;
	public SettingsFrame() {
	setSize(600, 400);
	setLayout(null);
	ChangeSettings changeSettings = new ChangeSettings();
	
	//Elements
	description1 = new JLabel ("Destination Paths");
	description1.setBounds(20, 5, 100, 25);
	
	img_destination = new JTextField("C:/Users/"+username+"/Pictures/CleanDesktop");
	img_destination.setBounds(20, 30, 500, 25);
	img_destination.setEditable(false);
	select_img_destination = new JButton("Select");
	select_img_destination.setBounds(520, 30, 30, 25);
	
	msc_destination = new JTextField("C:/Users/"+username+"/Pictures/CleanDesktop");
	msc_destination.setBounds(20, 70, 500, 25);
	msc_destination.setEditable(false);
	select_msc_destination = new JButton("Select");
	select_msc_destination.setBounds(520, 70, 30, 25);
	
	vid_destination = new JTextField("C:/Users/"+username+"/Pictures/CleanDesktop");
	vid_destination.setBounds(20, 110, 500, 25);
	vid_destination.setEditable(false);
	select_vid_destination = new JButton("Select");
	select_vid_destination.setBounds(520, 110, 30, 25);
	
	doc_destination = new JTextField("C:/Users/"+username+"/Pictures/CleanDesktop");
	doc_destination.setBounds(20, 150, 500, 25);
	doc_destination.setEditable(false);
	select_doc_destination = new JButton("Select");
	select_doc_destination.setBounds(520, 150, 30, 25);
	
	description2 = new JLabel ("Delete Files");
	description2.setBounds(20, 180, 100, 25);
	
	deleteEmptyFiles = new JRadioButton("Delete all Files < 1 KB");
	deleteEmptyFiles.setBounds(20, 200, 150, 25);
	
	customDeleteFiles = new JRadioButton("Delete all Files < ");
	customDeleteFiles.setBounds(200, 200, 120, 25);
	
	delete_size_range = new JTextField("22");
	delete_size_range.setBounds(320, 200, 50, 25);
	
	kb = new JRadioButton("KB");
	kb.setBounds(370, 200, 50, 25);
	
	mb = new JRadioButton("MB");
	mb.setBounds(420, 200, 50, 25);
	
	gb = new JRadioButton("GB");
	gb.setBounds(480, 200, 50, 25);
		
	//Adding Elements
	add(description1);
	add(img_destination);
	add(select_img_destination);
	add(msc_destination);
	add(select_msc_destination);
	add(vid_destination);
	add(select_vid_destination);
	add(doc_destination);
	add(select_doc_destination);
	add(description2);
	add(deleteEmptyFiles);
	add(customDeleteFiles);
	add(delete_size_range);
	add(kb);
	add(mb);
	add(gb);
	
	select_img_destination.addActionListener(new ActionListener()
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			ChooseDestinationFolder desfolder = new ChooseDestinationFolder();
			String destination = desfolder.chooseFolder();
			changeSettings.changeSettings(destination, 1);
			getSettings();
		}
	});
	
	select_msc_destination.addActionListener(new ActionListener()
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			ChooseDestinationFolder desfolder = new ChooseDestinationFolder();
			String destination = desfolder.chooseFolder();
			changeSettings.changeSettings(destination, 2);
			getSettings();
		}
	});
	
	select_vid_destination.addActionListener(new ActionListener()
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			ChooseDestinationFolder desfolder = new ChooseDestinationFolder();
			String destination = desfolder.chooseFolder();
			changeSettings.changeSettings(destination, 3);
			getSettings();
		}
	});
	
	select_doc_destination.addActionListener(new ActionListener()
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			ChooseDestinationFolder desfolder = new ChooseDestinationFolder();
			String destination = desfolder.chooseFolder();
			changeSettings.changeSettings(destination, 4);
			getSettings();
		}
	});
	
	customDeleteFiles.addActionListener(new ActionListener()
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			deleteEmptyFiles.setSelected(false);
			changeSettings.changeSettings("false", 6);
			changeSettings.changeSettings("true", 7);
		}
	});
	
	deleteEmptyFiles.addActionListener(new ActionListener()
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			customDeleteFiles.setSelected(false);
			changeSettings.changeSettings("true", 6);
			changeSettings.changeSettings("false", 7);
		}
	});
	
	kb.addActionListener(new ActionListener()
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			gb.setSelected(false);
			mb.setSelected(false);
			changeSettings.changeSettings("kb", 9);
		}
	});
	
	mb.addActionListener(new ActionListener()
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			gb.setSelected(false);
			kb.setSelected(false);
			changeSettings.changeSettings("mb", 9);
		}
	});
	
	gb.addActionListener(new ActionListener()
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			mb.setSelected(false);
			kb.setSelected(false);
			changeSettings.changeSettings("gb", 9);
		}
	});
	
	delete_size_range.addKeyListener(new KeyAdapter() {
		public void keyTyped(KeyEvent e) {
			char input = e.getKeyChar();
			if((input < '0' || input > '9' && input != '\b')) {
				e.consume();
				changeSettings.changeSettings(delete_size_range.getText(), 8);
				// #TODO Write in Settings don't work correctly
			}
		}
		
	});
		
	getSettings();

	}
	
	
	public void getSettings () {
		lineCounter = 0;
		try {
			br = new BufferedReader(new FileReader("C:\\CleanDesktop\\Settings.ini"));
			String line;
			
	        while ((line = br.readLine()) != null) {
	        	if (lineCounter == 1) {
	        		img_destination.setText(line.substring(line.indexOf("=")+1, line.length()));
	        	}else if (lineCounter == 2) {
	        		msc_destination.setText(line.substring(line.indexOf("=")+1, line.length()));
	        	}else if (lineCounter == 3) {
	        		vid_destination.setText(line.substring(line.indexOf("=")+1, line.length()));
	        	}else if (lineCounter == 4) {
	        		doc_destination.setText(line.substring(line.indexOf("=")+1, line.length()));
	        	}else if (lineCounter == 6) {
	        		deleteEmptyFiles.setSelected(Boolean.parseBoolean(line.substring(line.indexOf("=")+1, line.length())));
	        	}else if (lineCounter == 7) {
	        		customDeleteFiles.setSelected(Boolean.parseBoolean(line.substring(line.indexOf("=")+1, line.length())));
	        	}else if (lineCounter == 8) {
	        		delete_size_range.setText(line.substring(line.indexOf("=")+1, line.length()));
	        	}else if (lineCounter == 9) {
	        		if (line.substring(line.indexOf("=")+1, line.length()).contains("kb")){ kb.setSelected(true); }
	        		else if (line.substring(line.indexOf("=")+1, line.length()).contains("mb")){ mb.setSelected(true); }
	        		else if (line.substring(line.indexOf("=")+1, line.length()).contains("gb")){ gb.setSelected(true); }
	        	}
	        	lineCounter++;
	           }
	        br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
