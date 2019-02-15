package Functions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class TransferProgramFiles {
	
	public TransferProgramFiles(String newPath) {
		String username = System.getProperty("user.name");
		String filename = "Logs/Errorlog.txt";
		GetCategoryAndProperty gcap = new GetCategoryAndProperty();
		ChangeSettings changeSettings = new ChangeSettings();
		
		File logDir = new File(newPath+"/Logs/");
		
		File settings = new File(newPath+"/Settings.ini");
		
		if(!logDir.exists())
			logDir.mkdir();
		
		if(!settings.exists())
			try {
				settings.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		for (int i=0; i < 4; i++) {	
			if (i==1) {filename = "Logs/Changelog.html";}
			if (i==2) {filename = "Whitelist.txt";}
			if (i==3) {filename = "Settings.ini";}
			File settingFile = new File(gcap.getSetup("path")+"/"+filename);
			
			//Files.copy((.toPath(), ("C:/"));
			File oldFile = new File (gcap.getSetup("path")+"/"+filename);
			oldFile.renameTo(new File(newPath+"/"+oldFile.getName()));
			
		}
		
		}

	}
