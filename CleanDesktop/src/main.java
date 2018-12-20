import javax.swing.JButton;

import Functions.CreateFolders;
import Functions.TransferFiles;
import GUI.MainFrame;

public class main {

	public static void main(String[] args) {	
		MainFrame frame=new MainFrame();
		CreateFolders createfolders = new CreateFolders();
		TransferFiles transferFiles = new TransferFiles();
	    frame.setTitle("CleanDesktop");
	    frame.setResizable(false);
	    frame.setVisible(true);
	}

}
