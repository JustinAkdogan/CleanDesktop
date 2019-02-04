package Functions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ChangeSettings {
    BufferedWriter out;
    BufferedReader br;
    String fileContent [] = new String [10]; //<- Change
    int li;
    
	public void changeSettings(String path, int lineNo) {
		readAndSaveSettings();
		writeInSettings(path, lineNo);
	}
	
	public void generateStringArray() {
		//Generate Here
	}
	
	public void readAndSaveSettings() {
		int li = 0;
		try {
			br = new BufferedReader(new FileReader("C:\\CleanDesktop\\Settings.ini"));
			String line;
			
	        while ((line = br.readLine()) != null) {
	        	fileContent[li] = line; 
	        	li++;
	           }
	        br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void writeInSettings(String path, int lineNo) {
		String settingString = fileContent[lineNo]; 
		fileContent[lineNo] = settingString = settingString.substring(0, settingString.indexOf("=")+1)+path;
		try {
			out = new BufferedWriter(new FileWriter("C:\\CleanDesktop\\Settings.ini"));
			for(int i=0; i < fileContent.length; i++) {
				out.write(fileContent[i]);
				out.newLine();
			}
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
