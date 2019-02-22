package Functions;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GenerateErrorlog {
	
	ReadSettingsAndGetCategory gcap = new ReadSettingsAndGetCategory();
	Messages messages = new Messages();
	
	
	public void WriteInErrorLog(String [] errorContent) {
		
		try {
			BufferedWriter writer = new BufferedWriter (new FileWriter(gcap.getSetup("path")+"/Logs/Errorlog.txt", true));			
			File errorLog = new File(gcap.getSetup("path")+"/Logs/Errorlog.txt");
			String errorContentOneLine = errorContent[1] + " " + errorContent[0];			
			
			writer.write(errorContentOneLine);
			writer.newLine();
			writer.close();
			
		} catch (IOException e) {
			messages.errorMessages((byte) 4, null);
		}	
	}
}
