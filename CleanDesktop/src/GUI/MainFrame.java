package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Functions.CreateWorkspace;
import Functions.ReadSettingsAndGetCategory;
import Functions.ReadDesktop;

public class MainFrame extends JFrame {
	JButton startBtn, whiteBtn, settingsBtn, closeBtn, minimizeBtn, infoBtn;
	JLabel title,border;
	JPanel jp = new JPanel();
	int width = 600;
	int height = 400;
	private java.awt.Point initialClick;
	String systemPath = "";
	
	
	public MainFrame() {
		
		checkIfWorkspaceAlreadyExists();
		
		try{    
		       setIconImage(ImageIO.read(new File("res/cd_logo.png")));   
		   }
		catch (Exception ex){
		   }
		
		
		
		//Layout
		setSize(width, height);
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		startBtn = new JButton("Clean Desktop");
		startBtn.setBounds((width-200)/2, 300, 200, 56);
		startBtn.setBorderPainted(false);
		startBtn.setBorder(null);
		startBtn.setContentAreaFilled(false);
		startBtn.setIcon(new ImageIcon("res/clean.png"));
		
		closeBtn = new JButton();
		closeBtn.setBounds(568, 0, 32, 32);
		closeBtn.setBorderPainted(false);
		closeBtn.setBorder(null);
		closeBtn.setContentAreaFilled(false);
		closeBtn.setIcon(new ImageIcon("res/close_operation.png"));
		
		minimizeBtn = new JButton();
		minimizeBtn.setBounds(532, 0, 32, 32);
		minimizeBtn.setBorderPainted(false);
		minimizeBtn.setBorder(null);
		minimizeBtn.setContentAreaFilled(false);
		minimizeBtn.setIcon(new ImageIcon("res/minimize_operation.png"));
		
		settingsBtn = new JButton();
		settingsBtn.setBounds(2,2,32,32);
		settingsBtn.setIcon(new ImageIcon("res/settings.png"));
		settingsBtn.setBackground(new java.awt.Color(224, 74, 74,0));
		settingsBtn.setBorderPainted(false);
		settingsBtn.setBorder(null);
		settingsBtn.setContentAreaFilled(false);
		
		infoBtn = new JButton();
		infoBtn.setBounds(42,2,32,32);
		infoBtn.setIcon(new ImageIcon("res/information.png"));
		infoBtn.setBackground(new java.awt.Color(224, 74, 74,0));
		infoBtn.setBorderPainted(false);
		infoBtn.setBorder(null);
		infoBtn.setContentAreaFilled(false);
		
		title = new JLabel("CleanDesktop");
		title.setBounds((width-126)/2,0,126,32);
		title.setFont(new Font("Calibri",Font.PLAIN,22));
		title.setForeground(Color.WHITE);
		
		border = new JLabel("_____________________________________________________________________________________________________________________________");
		border.setBounds(0,12,width+100,32);
		border.setHorizontalAlignment(JLabel.CENTER);
		border.setFont(new Font("Calibri",Font.PLAIN,22));
		border.setForeground(Color.WHITE);
		
		//Adding Elements
		add(startBtn);
		add(settingsBtn);
		add(closeBtn);
		add(infoBtn);
		add(minimizeBtn);
		add(title);
		add(border);
		add(jp);
		validate();
		
		//getContentPane().setBackground(new java.awt.Color(128, 230, 242));	
		jp.setBackground(new java.awt.Color(224, 74, 74));	
		
		startBtn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cleanDesktop();
			}
		});
		
		startBtn.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	startBtn.setIcon(new ImageIcon("res/clean_hover.png"));
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	startBtn.setIcon(new ImageIcon("res/clean.png"));
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
				//setVisible(false);
				//dipose();
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
		
		
		infoBtn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				InformationFrame infoFrame = new InformationFrame();
				//setSize(1200,600);
			}
		});
		
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
	
	private void checkIfWorkspaceAlreadyExists() {
		ReadSettingsAndGetCategory gcap = new ReadSettingsAndGetCategory();
		String systemPath = gcap.getSetup("path");
		if (systemPath != null) {
			CreateWorkspace cw = new CreateWorkspace(systemPath); 
		}else {
			systemPath = "C:\\CleanDesktop";
			CreateWorkspace cw = new CreateWorkspace(systemPath); 
		}
	}
	
	public void cleanDesktop() {
		ReadDesktop rd = new ReadDesktop(systemPath); 
	}

}

