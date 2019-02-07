package GUI;

import java.awt.Frame;
import java.awt.Toolkit;
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

import com.sun.javafx.scene.paint.GradientUtils.Point;

import Functions.CreateWorkspace;
import Functions.FileWhitelist;

public class MainFrame extends JFrame {
	JButton startBtn, whiteBtn, settingsBtn, closeBtn, minimizeBtn;
	CreateWorkspace cw = new CreateWorkspace();
	JPanel jp = new JPanel();
	private java.awt.Point initialClick;
	
	
	
	public MainFrame() {
		try{    
		       setIconImage(ImageIO.read(new File("res/cd_logo.png")));   
		   }
		catch (Exception ex){
		   }
		
		//Layout
		setSize(600, 400);
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		startBtn = new JButton("Clean Desktop");
		startBtn.setBounds(220, 300, 200, 56);
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
		settingsBtn.setBounds(5,5,32,32);
		settingsBtn.setIcon(new ImageIcon("res/settings.png"));
		settingsBtn.setBackground(new java.awt.Color(224, 74, 74,0));
		settingsBtn.setBorderPainted(false);
		settingsBtn.setBorder(null);
		settingsBtn.setContentAreaFilled(false);
		
		//Adding Elements
		add(startBtn);
		add(settingsBtn);
		add(closeBtn);
		add(minimizeBtn);
		add(jp);
		validate();
		
		//getContentPane().setBackground(new java.awt.Color(128, 230, 242));	
		jp.setBackground(new java.awt.Color(224, 74, 74));	
		
		startBtn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cw.cleanDesktop();
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

}

