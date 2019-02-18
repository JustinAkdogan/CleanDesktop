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
    ReadAndSaveFileContent readAndSaveFileContent = new ReadAndSaveFileContent();
    GenerateErrorlog generateErrorlog = new GenerateErrorlog();
    
	public void changeSettings(String path, int lineNo) {
		writeInSettings(path, lineNo);
	}
	
	public void writeInSettings(String path, int lineNo) {
		fileContent = readAndSaveFileContent.readSaveAndGetFileContent(gcap.getSetup("path")+"/Settings.ini", false);
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
			generateErrorlog.WriteInErrorLog(1, this.getClass().getName());
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
