package main;
import javax.swing.JButton;

import Functions.CreateWorkspace;
import Functions.TransferFiles;
import Functions.ReadDesktop;
import GUI.MainFrame;

public class main {

	public static void main(String[] args) {	
		MainFrame frame=new MainFrame();
	    frame.setTitle("CleanDesktop");
	    frame.setResizable(false);
	    frame.setVisible(true);
	}
}
