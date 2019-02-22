package Functions;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import javax.swing.JFileChooser;

public class Whitelist {
	String username = System.getProperty("user.name");
	LocalDateTime now = LocalDateTime.now();
	static String thisLine = null;
	static ReadSettingsAndGetCategory gcap = new ReadSettingsAndGetCategory();
	static ReadAndSaveFileContent readandsave = new ReadAndSaveFileContent();
	Messages messages = new Messages();
	static File whitelist = new File(gcap.getSetup("path")+"/Whitelist.html");
	
	
	
	public void selectFiles(boolean deleteFiles) {
		JFileChooser chooser = new JFileChooser();
        File dir = new File("C:\\Users\\"+username+"\\Desktop");
        chooser.setMultiSelectionEnabled(true);
        chooser.setCurrentDirectory(dir);
        int returnVal = chooser.showOpenDialog(null);
            		
        if(returnVal == JFileChooser.APPROVE_OPTION) {
        	File[] files =  chooser.getSelectedFiles();
        	if(!deleteFiles) {
        		generateFileNameArray(files);
        	}else {
        		deleteFilesFromWhitelist(files);
        	}
        }
	}
	
	public void generateFileNameArray(File [] files) {
		String[] filenames = new String[files.length];
		for (int i=0; i < files.length; i++) {
			filenames[i] = files[i].getName();
		}
		GenerateWhitelist generateWhitelist = new GenerateWhitelist(filenames,true);
	}
	
	public void showFileWhitelist() {
		try {
			Desktop.getDesktop().browse(whitelist.toURI());
		} catch (IOException e) {
			messages.errorMessages((byte) 3, null);
		}
	}
	
	public static boolean isFileInWhitelist(String filename) {
		if (readandsave.isStringInFile("Whitelist.html", filename)) {
			return true;
		}
		return false;
	}
	
	public void deleteFilesFromWhitelist(File[] files) {
		String [] whiteListContent = readandsave.readSaveAndGetFileContent("Whitelist.html");
		String [] whiteListFiles = generateStringArray(whiteListContent);
		
		int counter = 0;

			for (int a=0; a < whiteListContent.length; a++) {
				if (whiteListContent[a].contains("<a style='color: green'>")) {
					whiteListFiles[counter] = whiteListContent[a];
					counter++;
				}
			}
		
		for (int b=0; b < files.length; b++) {
			for (int c=0; c < whiteListFiles.length; c++) {
				if (whiteListFiles[c] != null && whiteListFiles[c].contains("<a style='color: green'>"+files[b].getName()+"</a><br>")) {
					whiteListFiles[c] = null;
				}
			}
		}
	
		
		GenerateWhitelist generateWhitelist = new GenerateWhitelist(whiteListFiles, false);
	}
	
	private String [] generateStringArray(String [] whiteListContent) {
		int counter = 0;
		for (int a=0; a < whiteListContent.length; a++) {
			if (whiteListContent[a].contains("<a style='color: green'>")) {
				counter++;
			}
		}
		String whiteListFiles [] = new String [counter];
		return whiteListFiles;
	}
}

