package GUI;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import Functions.ChangeSettings;
import Functions.ChooseDestinationFolder;
import Functions.Messages;
import Functions.Whitelist;
import Functions.InitialiseSettings;

public class SettingsFrame extends JFrame {
	JTextField img_destination, msc_destination, vid_destination, doc_destination, delete_size_range, program_path;
	JButton select_img_destination, select_msc_destination, select_vid_destination, select_doc_destination,show_program_path,
	getStandardSettings,addFileToWL,removeFileFromWL,showWL,closeBtn,minimizeBtn;
	JLabel description1,description2,description3,title,border,description4;
	JRadioButton deleteEmptyFiles,customDeleteFiles,kb,mb,gb;
	String username = System.getProperty("user.name");
	BufferedReader br;
	JPanel jp = new JPanel();
	int width = 600;
	int height = 400;
	private java.awt.Point initialClick;
	
	//Classes
	Whitelist whitelist = new Whitelist();
	Messages messages = new Messages();

	int lineCounter = 0;
	public SettingsFrame() {
	setSize(width, height);
	setLayout(null);
	setUndecorated(true);
	setLocationRelativeTo(null);
	getContentPane().setBackground(new java.awt.Color(224, 74, 74));	
	ChangeSettings changeSettings = new ChangeSettings();
		
	//Elements
	title = new JLabel ("Settings");
	title.setBounds((width-75)/2, 0, 75, 32);
	title.setFont(new Font("Calibri",Font.PLAIN,22));
	title.setForeground(Color.WHITE);
	
	border = new JLabel("_____________________________________________________________________________________________________________________________");
	border.setBounds(0,12,width+100,32);
	border.setHorizontalAlignment(JLabel.CENTER);
	border.setFont(new Font("Calibri",Font.PLAIN,22));
	border.setForeground(Color.WHITE);
	
	description1 = new JLabel ("Destination Paths (1. Images, 2. Music, 3. Videos, 4. Documents)");
	description1.setBounds(35, 95, 400, 25);
	
	img_destination = new JTextField("C:/Users/"+username+"/Pictures/CleanDesktop");
	img_destination.setBounds((width-530)/2, 120, 500, 25);
	img_destination.setEditable(false);
	
	select_img_destination = new JButton();
	select_img_destination.setBounds(535, 120, 30, 25);
	select_img_destination.setBackground(new java.awt.Color(224, 74, 74,0));
	select_img_destination.setBorderPainted(false);
	select_img_destination.setBorder(null);
	select_img_destination.setContentAreaFilled(false);
	select_img_destination.setIcon(new ImageIcon("res/selectFolder.png"));
	
	msc_destination = new JTextField("C:/Users/"+username+"/Pictures/CleanDesktop");
	msc_destination.setBounds((width-530)/2, 160, 500, 25);
	msc_destination.setEditable(false);
	
	select_msc_destination = new JButton();
	select_msc_destination.setBounds(535, 160, 30, 25);
	select_msc_destination.setBackground(new java.awt.Color(224, 74, 74,0));
	select_msc_destination.setBorderPainted(false);
	select_msc_destination.setBorder(null);
	select_msc_destination.setContentAreaFilled(false);
	select_msc_destination.setIcon(new ImageIcon("res/selectFolder.png"));
	
	vid_destination = new JTextField("C:/Users/"+username+"/Pictures/CleanDesktop");
	vid_destination.setBounds((width-530)/2, 200, 500, 25);
	vid_destination.setEditable(false);
	
	select_vid_destination = new JButton();
	select_vid_destination.setBounds(535, 200, 30, 25);
	select_vid_destination.setBackground(new java.awt.Color(224, 74, 74,0));
	select_vid_destination.setBorderPainted(false);
	select_vid_destination.setBorder(null);
	select_vid_destination.setContentAreaFilled(false);
	select_vid_destination.setIcon(new ImageIcon("res/selectFolder.png"));
	
	doc_destination = new JTextField("C:/Users/"+username+"/Pictures/CleanDesktop");
	doc_destination.setBounds((width-530)/2, 240, 500, 25);
	doc_destination.setEditable(false);
	
	select_doc_destination = new JButton();
	select_doc_destination.setBounds(535, 240, 30, 25);
	select_doc_destination.setBackground(new java.awt.Color(224, 74, 74,0));
	select_doc_destination.setBorderPainted(false);
	select_doc_destination.setBorder(null);
	select_doc_destination.setContentAreaFilled(false);
	select_doc_destination.setIcon(new ImageIcon("res/selectFolder.png"));
	
	description2 = new JLabel ("Delete Files");
	description2.setBounds(35, 270, 100, 25);
	
	deleteEmptyFiles = new JRadioButton("Delete all Files < 1 KB");
	deleteEmptyFiles.setBounds(35, 290, 150, 25);
	deleteEmptyFiles.setBackground(new java.awt.Color(224, 74, 74));
	deleteEmptyFiles.setIcon(new ImageIcon("res/checked.png"));
	deleteEmptyFiles.setFocusPainted(false);
	
	customDeleteFiles = new JRadioButton("Delete all Files < ");
	customDeleteFiles.setBounds(215, 290, 120, 25);
	customDeleteFiles.setBackground(new java.awt.Color(224, 74, 74));
	customDeleteFiles.setIcon(new ImageIcon("res/unchecked.png"));
	customDeleteFiles.setFocusPainted(false);
	
	
	delete_size_range = new JTextField("22");
	delete_size_range.setBounds(335, 290, 50, 25);
	
	kb = new JRadioButton("KB");
	kb.setBounds(385, 290, 50, 25);
	kb.setBackground(new java.awt.Color(224, 74, 74));
	kb.setIcon(new ImageIcon("res/checked.png"));
	kb.setFocusPainted(false);
	
	mb = new JRadioButton("MB");
	mb.setBounds(435, 290, 50, 25);
	mb.setBackground(new java.awt.Color(224, 74, 74));
	mb.setIcon(new ImageIcon("res/unchecked.png"));
	mb.setFocusPainted(false);
	
	gb = new JRadioButton("GB");
	gb.setBounds(495, 290, 50, 25);
	gb.setBackground(new java.awt.Color(224, 74, 74));
	gb.setIcon(new ImageIcon("res/unchecked.png"));
	gb.setFocusPainted(false);
	
	getStandardSettings = new JButton();
	getStandardSettings.setBounds(260, 350, 32, 32);
	getStandardSettings.setBackground(new java.awt.Color(224, 74, 74,0));
	getStandardSettings.setBorderPainted(false);
	getStandardSettings.setBorder(null);
	getStandardSettings.setContentAreaFilled(false);
	getStandardSettings.setIcon(new ImageIcon("res/reset.png"));
	
	description3 = new JLabel ("File Whitelist");
	description3.setBounds(35, 320, 300, 25);
	
	addFileToWL = new JButton();
	addFileToWL.setBounds(25, 335, 50, 50);
	addFileToWL.setBackground(new java.awt.Color(224, 74, 74,0));
	addFileToWL.setBorderPainted(false);
	addFileToWL.setBorder(null);
	addFileToWL.setContentAreaFilled(false);
	addFileToWL.setIcon(new ImageIcon("res/addFile.png"));
	
	removeFileFromWL = new JButton();
	removeFileFromWL.setBounds(60, 335, 50, 50);
	removeFileFromWL.setBackground(new java.awt.Color(224, 74, 74,0));
	removeFileFromWL.setBorderPainted(false);
	removeFileFromWL.setBorder(null);
	removeFileFromWL.setContentAreaFilled(false);
	removeFileFromWL.setIcon(new ImageIcon("res/removeFile.png"));
	
	showWL = new JButton();
	showWL.setBounds(95, 335, 50, 50);
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
	
	description4 = new JLabel ("Program Path");
	description4.setBounds(35, 45, 100, 25);
	
	program_path = new JTextField("C:/CleanDesktop");
	program_path.setBounds((width-530)/2, 70, 500, 25);
	program_path.setEditable(false);
	
	show_program_path = new JButton();
	show_program_path.setBounds(535, 70, 30, 25);
	show_program_path.setBackground(new java.awt.Color(224, 74, 74,0));
	show_program_path.setBorderPainted(false);
	show_program_path.setBorder(null);
	show_program_path.setContentAreaFilled(false);
	show_program_path.setIcon(new ImageIcon("res/showFolder.png"));
	
    try {
    	UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    }catch (Exception ex) {
    	messages.errorMessages((byte) 9, null);
    }
		
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
	add(title);
	add(border);
	add(description4);
	add(program_path);
	add(show_program_path);
	add(jp);
	
	try{    
		setIconImage(ImageIO.read(new File("res/cd_logo.png")));   
	}
	catch (Exception ex){
		messages.errorMessages((byte) 7, null);
	}
	
	show_program_path.addActionListener(new ActionListener()
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				Desktop.getDesktop().open(new File("C:\\CleanDesktop"));
			} catch (IOException e) {
				messages.errorMessages((byte) 8, null);
			}
		}
	});
	
	select_img_destination.addActionListener(new ActionListener()
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			ChooseDestinationFolder desfolder = new ChooseDestinationFolder();
			String destination = desfolder.chooseFolder();
			if (destination != null) {
				changeSettings.changeSettings(destination, (byte) 1);
			}
			getSettings();
		}
	});
	
	select_msc_destination.addActionListener(new ActionListener()
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			ChooseDestinationFolder desfolder = new ChooseDestinationFolder();
			String destination = desfolder.chooseFolder();
			if (destination != null) {
				changeSettings.changeSettings(destination, (byte) 2);
			}
			getSettings();
		}
	});
	
	select_vid_destination.addActionListener(new ActionListener()
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			ChooseDestinationFolder desfolder = new ChooseDestinationFolder();
			String destination = desfolder.chooseFolder();
			if (destination != null) {
				changeSettings.changeSettings(destination, (byte) 3);
			}
			getSettings();
		}
	});
	
	select_doc_destination.addActionListener(new ActionListener()
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			ChooseDestinationFolder desfolder = new ChooseDestinationFolder();
			String destination = desfolder.chooseFolder();
			if (destination != null) {
				changeSettings.changeSettings(destination, (byte) 4);
			}
			getSettings();
		}
	});
	
	customDeleteFiles.addActionListener(new ActionListener()
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			deleteEmptyFiles.setSelected(false);
			changeSettings.changeSettings("false", (byte) 6);
			changeSettings.changeSettings("true", (byte) 7);
			getSettings();
		}
	});
	
	deleteEmptyFiles.addActionListener(new ActionListener()
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			customDeleteFiles.setSelected(false);
			changeSettings.changeSettings("true", (byte) 6);
			changeSettings.changeSettings("false", (byte) 7);
			getSettings();
		}
	});
	
	kb.addActionListener(new ActionListener()
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			gb.setSelected(false);
			mb.setSelected(false);
			changeSettings.changeSettings("kb", (byte) 9);
			getSettings();
		}
	});
	
	mb.addActionListener(new ActionListener()
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			gb.setSelected(false);
			kb.setSelected(false);
			changeSettings.changeSettings("mb", (byte) 9);
			getSettings();
		}
	});
	
	gb.addActionListener(new ActionListener()
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			mb.setSelected(false);
			kb.setSelected(false);
			changeSettings.changeSettings("gb", (byte) 9);
			getSettings();
		}
	});
	
	delete_size_range.addKeyListener(new KeyAdapter() {
		public void keyTyped(KeyEvent e) {
			char input = e.getKeyChar();
			if((input < '0' || input > '9' && input != '\b')) {
				e.consume();
				changeSettings.changeSettings(delete_size_range.getText(),(byte) 8);
			}
		}
		
	});
	
	getStandardSettings.addActionListener(new ActionListener()
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			InitialiseSettings initSettings = new InitialiseSettings();
			initSettings.setStandardSettings();
			getSettings();
		}
	});
	
	getStandardSettings.addMouseListener(new java.awt.event.MouseAdapter() {
	    public void mouseEntered(java.awt.event.MouseEvent evt) {
	    	getStandardSettings.setIcon(new ImageIcon("res/reset_hover.png"));
	    }

	    public void mouseExited(java.awt.event.MouseEvent evt) {
	    	getStandardSettings.setIcon(new ImageIcon("res/reset.png"));
	    }
	});
	
	addFileToWL.addActionListener(new ActionListener()
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			whitelist.selectFiles(false);
		}
	});
	
	removeFileFromWL.addActionListener(new ActionListener()
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			whitelist.selectFiles(true);
		}
	});
	
	showWL.addActionListener(new ActionListener()
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			whitelist.showFileWhitelist();			
		}
	});
	
	closeBtn.addActionListener(new ActionListener()
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			changeSettings.changeSettings(delete_size_range.getText(),(byte) 8);
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
	        	}else if (lineCounter == 11) {
	        		program_path.setText(line.substring(line.indexOf("=")+1, line.length()));
	        	}
	        	lineCounter++;
	           }
	        br.close();
	        
		} catch (IOException e) {
			messages.errorMessages((byte) 1, null);
		}
		  resetGUI();
	}

	public void resetGUI() {
		kb.setIcon(new ImageIcon("res/unchecked.png"));
		mb.setIcon(new ImageIcon("res/unchecked.png"));
		gb.setIcon(new ImageIcon("res/unchecked.png"));
		customDeleteFiles.setIcon(new ImageIcon("res/unchecked.png"));
		deleteEmptyFiles.setIcon(new ImageIcon("res/unchecked.png"));
		
		if (kb.isSelected()) {
			kb.setIcon(new ImageIcon("res/checked.png"));
		}else if (mb.isSelected()) {
			mb.setIcon(new ImageIcon("res/checked.png"));
		}else if (gb.isSelected()){
			gb.setIcon(new ImageIcon("res/checked.png"));
		}
		
		if (deleteEmptyFiles.isSelected()) {
			deleteEmptyFiles.setIcon(new ImageIcon("res/checked.png"));
		}else {
			customDeleteFiles.setIcon(new ImageIcon("res/checked.png"));
		}
	}	
	
	
	public String getProgramPath() {
		dispose();
		return program_path.getText();
	}
}