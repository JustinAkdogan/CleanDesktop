package Functions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileWhitelist {

	String username = System.getProperty("user.name");
	LocalDateTime now = LocalDateTime.now();
	String thisLine = null;
	
	//public FileWhitelist() {
		//selectFiles();
	//}
	
	public void selectFiles() {
	    JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif");
        File dir = new File("C:\\Users\\"+username+"\\Desktop");
        chooser.setFileFilter(filter);
        chooser.setMultiSelectionEnabled(true);
        chooser.setCurrentDirectory(dir);
        int returnVal = chooser.showOpenDialog(null);
            		
        if(returnVal == JFileChooser.APPROVE_OPTION) {
        	File[] files =  chooser.getSelectedFiles();
				saveFilesInWhitelist(files);
        }
	}
	
	public void saveFilesInWhitelist(File [] files) {
		try {
			BufferedWriter writer = new BufferedWriter (new FileWriter("C:\\CleanDesktop\\Whitelist.txt", true));			
			DateTimeFormatter df;
			df = DateTimeFormatter.ofPattern("dd.MM.yyyy kk:mm");  
			
			//Text Writer
			writer.write(""+now.format(df));
			writer.newLine();
			for (int i=0; i < files.length; i++) {
				checkFilesInWhitelist(""+files[i]);
				writer.write(""+files[i].getName());
				writer.newLine();
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	public boolean checkFilesInWhitelist(String filename) {
		try {
			BufferedReader reader = new BufferedReader (new FileReader("C:\\CleanDesktop\\Whitelist.txt"));

			try {
				while((thisLine = reader.readLine()) != null) {
			
					if (thisLine.contains(filename)) {
						return true;
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}
}

