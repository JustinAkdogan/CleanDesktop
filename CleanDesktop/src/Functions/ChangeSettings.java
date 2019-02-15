package Functions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ChangeSettings {
	
    BufferedWriter out;
    BufferedReader br;
    String fileContent [];
    GetCategoryAndProperty gcap = new GetCategoryAndProperty();
    //int li;
    
	public void changeSettings(String path, int lineNo) {
		readAndSaveSettings(false);
		writeInSettings(path, lineNo);
	}
	
	public void generateStringArray(int settingsLength) {
		fileContent = new String [settingsLength];
		readAndSaveSettings(true);
	}
		
	
	public void readAndSaveSettings(boolean saveSettings) {
		int lineNo = 0;
		try {
			br = new BufferedReader(new FileReader(gcap.getSetup("path")+"\\Settings.ini"));
			String line;
			
	        while ((line = br.readLine()) != null) {
	        	if (saveSettings) { fileContent[lineNo] = line; }
	        	lineNo++;
	        }
	        br.close();
	        if (!saveSettings) { generateStringArray(lineNo); }
		} catch (IOException e) {
			e.printStackTrace(); //#TODO
		}
	}
	
	public void writeInSettings(String path, int lineNo) {
		String settingString = fileContent[lineNo]; 
		
		if (path.contains("null") && path.length() <= 4) {
			path = getStandardPath (settingString);
		}
		
		fileContent[lineNo] = settingString = settingString.substring(0, settingString.indexOf("=")+1)+path;
		try {
			out = new BufferedWriter(new FileWriter(gcap.getSetup("path")+"\\Settings.ini"));
			for(int i=0; i < fileContent.length; i++) {
				out.write(fileContent[i]);
				out.newLine();
			}
			out.close();
		} catch (IOException e) {
			e.printStackTrace(); //#TODO
		}
	}
	
	public String getStandardPath(String settingString){
		GetCategoryAndProperty gcap = new GetCategoryAndProperty();
		InitialiseSettings initsettings = new InitialiseSettings();
		return initsettings.getStandardSetting(gcap.getProperty(settingString));
	}
	
	public String[] getSettingContent() {
		return fileContent;
	}
	
}
