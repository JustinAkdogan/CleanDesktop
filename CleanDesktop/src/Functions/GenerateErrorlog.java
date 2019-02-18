package Functions;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GenerateErrorlog {
	
	GetCategoryAndProperty gcap = new GetCategoryAndProperty();
	
	
	public void WriteInErrorLog(int ErrorID, String Classname) {
		
		try {
			BufferedWriter writer = new BufferedWriter (new FileWriter(gcap.getSetup("path")+"/Logs/Errorlog.txt", true));			
			File errorLog = new File(gcap.getSetup("path")+"/Logs/Errorlog.txt");
						
			writer.write(getErrorMessage(ErrorID, Classname));
			writer.newLine();
			writer.close();
			
		} catch (IOException e) {
			// #TODO
		}	
	}
	
	public String getErrorMessage(int ErrorID, String Classname) {
		if (ErrorID == 1 ) {
			return "Error "+ErrorID+ " in Class: "+Classname+" Settings.ini couldn't be found or read";
		}else if (ErrorID == 2) {
			return "Error "+ErrorID+ " in Class: "+Classname+" The Systemfiles couldn't be created on C:/CleanDesktop/";				
		}else if (ErrorID == 3) {
			return "Error "+ErrorID+ " in Class: "+Classname+"The File 'Whitelist.html' couldn't be opened or found";
		}else if (ErrorID == 4) {
			return "Error "+ErrorID+ " in Class: "+Classname+"The File 'Changelog.html' couldn't be found or read";
		}else if (ErrorID == 5) {
			return "Error "+ErrorID+ " in Class: "+Classname+"The File 'Whitelist.html' couldn't be read";
		}
		
		return null;
	}
}
