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
    Messages messages = new Messages();
    
	public void changeSettings(String path, byte lineNo) {
		fileContent = readAndSaveFileContent.readSaveAndGetFileContent("Settings.ini");
		String settingString = fileContent[lineNo]; 
		
		
		fileContent[lineNo] = settingString = settingString.substring(0, settingString.indexOf("=")+1)+path;
		try {
			out = new BufferedWriter(new FileWriter(gcap.getSetup("path")+"\\Settings.ini"));
			for(byte i=0; i < fileContent.length; i++) {
				out.write(fileContent[i]);
				out.newLine();
			}
			out.close();
		} catch (IOException e) {
			messages.errorMessages((byte) 1, null);
		}
	}
	
	public String[] getSettingContent() {
		return fileContent;
	}
	
	
	
}
