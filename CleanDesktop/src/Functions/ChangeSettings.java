package Functions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ChangeSettings {
	
    BufferedWriter out;
    BufferedReader br;
    String fileContent []; 
    ReadSettingsAndGetCategory gcap = new ReadSettingsAndGetCategory();
    ReadAndSaveFileContent readAndSaveFileContent = new ReadAndSaveFileContent();
    GenerateErrorlog generateErrorlog = new GenerateErrorlog();
    
	public void changeSettings(String path, byte lineNo) {
		fileContent = readAndSaveFileContent.readSaveAndGetFileContent("Settings.ini", false);
		String settingString = fileContent[lineNo]; 
		
		if (path.contains("null") && path.length() <= 4) {
			path = getStandardPath (settingString);
		}
		
		fileContent[lineNo] = settingString = settingString.substring(0, settingString.indexOf("=")+1)+path;
		try {
			out = new BufferedWriter(new FileWriter(gcap.getSetup("path")+"\\Settings.ini"));
			//out = new BufferedWriter(new FileWriter("C:\\Users\\justin.akdogan\\Desktop\\system\\Settings.ini"));
			for(byte i=0; i < fileContent.length; i++) {
				out.write(fileContent[i]);
				out.newLine();
			}
			out.close();
		} catch (IOException e) {
			generateErrorlog.WriteInErrorLog(1, this.getClass().getName());
		}
	}
	
	public String getStandardPath(String settingString){
		ReadSettingsAndGetCategory gcap = new ReadSettingsAndGetCategory();
		InitialiseSettings initsettings = new InitialiseSettings();
		return initsettings.getStandardSetting(gcap.getProperty(settingString));
	}
	
	public String[] getSettingContent() {
		return fileContent;
	}
	
	
	
}
