package Functions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JFileChooser;

public class FileWhitelist {
	//#TODO
	String username = System.getProperty("user.name");
	LocalDateTime now = LocalDateTime.now();
	static String thisLine = null;
	
	public void selectFiles(boolean deleteFiles) {
		JFileChooser chooser = new JFileChooser();
        File dir = new File("C:\\Users\\"+username+"\\Desktop");
        chooser.setMultiSelectionEnabled(true);
        chooser.setCurrentDirectory(dir);
        int returnVal = chooser.showOpenDialog(null);
            		
        if(returnVal == JFileChooser.APPROVE_OPTION) {
        	File[] files =  chooser.getSelectedFiles();
        	if(!deleteFiles) {
				saveFilesInWhitelist(files);
        	}else {
        		readAndSaveWhitelist(files);
        	}
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
		
	
	public static boolean checkFilesInWhitelist(String filename) {
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
	
	
	public void readAndSaveWhitelist(File [] files) {
		String [] WLContent = new String[500];
		int counter = 0;
		try {
			BufferedReader reader = new BufferedReader (new FileReader("C:\\CleanDesktop\\Whitelist.txt"));
			
				try {
					while((thisLine = reader.readLine()) != null) {
						WLContent[counter] = thisLine;
						counter++;
					}
					deleteFilesFromWhitelist(files,WLContent);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
	}
	}
	
	public void deleteFilesFromWhitelist(File [] files, String [] WLContent) {
		int counter = 0;
		for (int a=0; a < WLContent.length; a++) {
			if (counter < files.length) {
				if (checkFilesInWhitelist(files[counter].getName())) {
					WLContent[a] = "";
				}
			counter++;
			}
		}
		//saveFilesInWhitelist(null,WLContent);
	}
	
	
	
}

