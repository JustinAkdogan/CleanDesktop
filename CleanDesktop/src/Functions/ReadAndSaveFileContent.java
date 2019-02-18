package Functions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import GUI.SettingsFrame;

public class ReadAndSaveFileContent {
	
	String [] fileContent = null;
	
	public String [] readSaveAndGetFileContent(String file, Boolean saveSettings) {
		BufferedReader br;
		int lineNo = 0;
		try {
			br = new BufferedReader(new FileReader(file));
			String line;
			
	        while ((line = br.readLine()) != null) {
	        	if (saveSettings) { fileContent[lineNo] = line; }
	        	lineNo++;
	        }
	        br.close();
	        if (!saveSettings) { generateStringArray(file, lineNo); }
		} catch (IOException e) {
			e.printStackTrace(); 
		}
		return fileContent;
	}
	
	public boolean isStringInFile(String file, String string) {
		try {
			BufferedReader br = new BufferedReader (new FileReader(file));
			String line = null;
	        while ((line = br.readLine()) != null) {
	        	if (line.contains(string)) {
	        		return true;
	        	}
	        }
		} catch (IOException e) {
			e.printStackTrace(); 
		}
		
		return false;
	}
	
	public void generateStringArray(String file, int FileLines) {
		fileContent = new String[FileLines];
		readSaveAndGetFileContent(file,true);
	}
}
