package GUI;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JRootPane;
import javax.swing.JTextField;



import Functions.ChangeSettings;
import Functions.ChooseDestinationFolder;
import Functions.FileWhitelist;
import Functions.InitialiseSettings;

public class SettingsFrame extends JFrame {
	JTextField img_destination, msc_destination, vid_destination, doc_destination, delete_size_range;
	JButton select_img_destination, select_msc_destination, select_vid_destination, select_doc_destination,
	getStandardSettings,addFileToWL,removeFileFromWL,showWL,closeBtn,minimizeBtn;
	JLabel description1,description2,description3;
	JRadioButton deleteEmptyFiles,customDeleteFiles,kb,mb,gb;
	String username = System.getProperty("user.name");
	BufferedReader br;
	JPanel jp = new JPanel();
	private java.awt.Point initialClick;
	
	int lineCounter = 0;
	public SettingsFrame() {
	setSize(600, 400);
	setLayout(null);
	setUndecorated(true);
	setLocationRelativeTo(null);
	getContentPane().setBackground(new java.awt.Color(224, 74, 74));	
	ChangeSettings changeSettings = new ChangeSettings();
		
	//Elements
	description1 = new JLabel ("Destination Paths");
	description1.setBounds(20, 5, 100, 25);
	
	img_destination = new JTextField("C:/Users/"+username+"/Pictures/CleanDesktop");
	img_destination.setBounds(20, 30, 500, 25);
	img_destination.setEditable(false);
	
	select_img_destination = new JButton();
	select_img_destination.setBounds(520, 30, 30, 25);
	select_img_destination.setBackground(new java.awt.Color(224, 74, 74,0));
	select_img_destination.setBorderPainted(false);
	select_img_destination.setBorder(null);
	select_img_destination.setContentAreaFilled(false);
	select_img_destination.setIcon(new ImageIcon("res/select_file.png"));
	
	msc_destination = new JTextField("C:/Users/"+username+"/Pictures/CleanDesktop");
	msc_destination.setBounds(20, 70, 500, 25);
	msc_destination.setEditable(false);
	
	select_msc_destination = new JButton();
	select_msc_destination.setBounds(520, 70, 30, 25);
	select_msc_destination.setBackground(new java.awt.Color(224, 74, 74,0));
	select_msc_destination.setBorderPainted(false);
	select_msc_destination.setBorder(null);
	select_msc_destination.setContentAreaFilled(false);
	select_msc_destination.setIcon(new ImageIcon("res/select_file.png"));
	
	vid_destination = new JTextField("C:/Users/"+username+"/Pictures/CleanDesktop");
	vid_destination.setBounds(20, 110, 500, 25);
	vid_destination.setEditable(false);
	
	select_vid_destination = new JButton();
	select_vid_destination.setBounds(520, 110, 30, 25);
	select_vid_destination.setBackground(new java.awt.Color(224, 74, 74,0));
	select_vid_destination.setBorderPainted(false);
	select_vid_destination.setBorder(null);
	select_vid_destination.setContentAreaFilled(false);
	select_vid_destination.setIcon(new ImageIcon("res/select_file.png"));
	
	doc_destination = new JTextField("C:/Users/"+username+"/Pictures/CleanDesktop");
	doc_destination.setBounds(20, 150, 500, 25);
	doc_destination.setEditable(false);
	
	select_doc_destination = new JButton();
	select_doc_destination.setBounds(520, 150, 30, 25);
	select_doc_destination.setBackground(new java.awt.Color(224, 74, 74,0));
	select_doc_destination.setBorderPainted(false);
	select_doc_destination.setBorder(null);
	select_doc_destination.setContentAreaFilled(false);
	select_doc_destination.setIcon(new ImageIcon("res/select_file.png"));
	
	description2 = new JLabel ("Delete Files");
	description2.setBounds(20, 180, 100, 25);
	
	deleteEmptyFiles = new JRadioButton("Delete all Files < 1 KB");
	deleteEmptyFiles.setBounds(20, 200, 150, 25);
	deleteEmptyFiles.setBackground(new java.awt.Color(224, 74, 74));
	deleteEmptyFiles.setFocusPainted(false);
	
	customDeleteFiles = new JRadioButton("Delete all Files < ");
	customDeleteFiles.setBounds(200, 200, 120, 25);
	customDeleteFiles.setBackground(new java.awt.Color(224, 74, 74));
	customDeleteFiles.setFocusPainted(false);
	
	
	
	delete_size_range = new JTextField("22");
	delete_size_range.setBounds(320, 200, 50, 25);
	
	kb = new JRadioButton("KB");
	kb.setBounds(370, 200, 50, 25);
	kb.setBackground(new java.awt.Color(224, 74, 74));
	kb.setFocusPainted(false);
	
	mb = new JRadioButton("MB");
	mb.setBounds(420, 200, 50, 25);
	mb.setBackground(new java.awt.Color(224, 74, 74));
	mb.setFocusPainted(false);
	
	gb = new JRadioButton("GB");
	gb.setBounds(480, 200, 50, 25);
	gb.setBackground(new java.awt.Color(224, 74, 74));
	gb.setFocusPainted(false);
	
	getStandardSettings = new JButton();
	getStandardSettings.setBounds(220, 300, 64, 64);
	getStandardSettings.setBackground(new java.awt.Color(224, 74, 74,0));
	getStandardSettings.setBorderPainted(false);
	getStandardSettings.setBorder(null);
	getStandardSettings.setContentAreaFilled(false);
	getStandardSettings.setIcon(new ImageIcon("res/reset.png"));
	
	description3 = new JLabel ("File Whitelist");
	description3.setBounds(20, 230, 300, 25);
	
	addFileToWL = new JButton();
	addFileToWL.setBounds(20, 260, 50, 50);
	addFileToWL.setBackground(new java.awt.Color(224, 74, 74,0));
	addFileToWL.setBorderPainted(false);
	addFileToWL.setBorder(null);
	addFileToWL.setContentAreaFilled(false);
	addFileToWL.setIcon(new ImageIcon("res/addFile.png"));
	
	removeFileFromWL = new JButton();
	removeFileFromWL.setBounds(75, 260, 50, 50);
	removeFileFromWL.setBackground(new java.awt.Color(224, 74, 74,0));
	removeFileFromWL.setBorderPainted(false);
	removeFileFromWL.setBorder(null);
	removeFileFromWL.setContentAreaFilled(false);
	removeFileFromWL.setIcon(new ImageIcon("res/removeFile.png"));
	
	showWL = new JButton();
	showWL.setBounds(130, 260, 50, 50);
	showWL.setBackground(new java.awt.Color(224, 74, 74,0));
	showWL.setBorderPainted(false);
	showWL.setBorder(null);
	showWL.setContentAreaFilled(false);
	showWL.setIcon(new ImageIcon("res/showWL.png"));
	
	closeBtn = new JButton();
	closeBtn.setBounds(568, 0, 32, 32);
	closeBtn.setBackground(new java.awt.Color(224, 74, 74,0));
	closeBtn.setBorderPainted(false);
	closeBtn.setBorder(null);
	closeBtn.setContentAreaFilled(false);
	closeBtn.setIcon(new ImageIcon("res/close_operation.png"));
	
	minimizeBtn = new JButton();
	minimizeBtn.setBounds(532, 0, 32, 32);
	minimizeBtn.setBackground(new java.awt.Color(224, 74, 74,0));
	minimizeBtn.setBorderPainted(false);
	minimizeBtn.setBorder(null);
	minimizeBtn.setContentAreaFilled(false);
	minimizeBtn.setIcon(new ImageIcon("res/minimize_operation.png"));
		
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
	add(getStandardSettings);
	add(description3);
	add(addFileToWL);
	add(removeFileFromWL);
	add(showWL);
	add(closeBtn);
	add(minimizeBtn);
	add(jp);
	
	
	select_img_destination.addActionListener(new ActionListener()
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			ChooseDestinationFolder desfolder = new ChooseDestinationFolder();
			String destination = desfolder.chooseFolder();
			if (changeSettings != null) {  changeSettings.changeSettings(destination, 1);}
			getSettings();
		}
	});
	
	select_msc_destination.addActionListener(new ActionListener()
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			ChooseDestinationFolder desfolder = new ChooseDestinationFolder();
			String destination = desfolder.chooseFolder();
			if (changeSettings != null) {  changeSettings.changeSettings(destination, 2);}
			getSettings();
		}
	});
	
	select_vid_destination.addActionListener(new ActionListener()
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			ChooseDestinationFolder desfolder = new ChooseDestinationFolder();
			String destination = desfolder.chooseFolder();
			if (changeSettings != null) {  changeSettings.changeSettings(destination, 3);}
			getSettings();
		}
	});
	
	select_doc_destination.addActionListener(new ActionListener()
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			ChooseDestinationFolder desfolder = new ChooseDestinationFolder();
			String destination = desfolder.chooseFolder();
			if (changeSettings != null) {  changeSettings.changeSettings(destination, 4);}
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
	
	getStandardSettings.addActionListener(new ActionListener()
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			new InitialiseSettings();
			getSettings();
		}
	});
	
	addFileToWL.addActionListener(new ActionListener()
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			FileWhitelist fw = new FileWhitelist();
			fw.selectFiles();
		}
	});
	
	closeBtn.addActionListener(new ActionListener()
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			dispose();
		}
	});
	
	minimizeBtn.addActionListener(new ActionListener()
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			setState(Frame.ICONIFIED);
		}
	});
	
		
	getSettings();

	
	/* Moving the GUI */
	  addMouseListener(new MouseAdapter() {
	        public void mousePressed(MouseEvent e) {
	            initialClick = e.getPoint();
	            getComponentAt(initialClick);
	        }
	    });
	
	   addMouseMotionListener(new MouseMotionAdapter() {
	        @Override
	        public void mouseDragged(MouseEvent e) {

	            // get location of Window
	            int thisX = getLocation().x;
	            int thisY = getLocation().y;

	            // Determine how much the mouse moved since the initial click
	            int xMoved = e.getX() - initialClick.x;
	            int yMoved = e.getY() - initialClick.y;

	            // Move window to this position
	            int X = thisX + xMoved;
	            int Y = thisY + yMoved;
	            setLocation(X, Y);
	        }
	    });
	
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
