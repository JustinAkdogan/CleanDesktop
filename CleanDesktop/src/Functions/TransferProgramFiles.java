package Functions;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class TransferProgramFiles {
	
	GetCategoryAndProperty gcap = new GetCategoryAndProperty();
	String newPath = null;
	
	public TransferProgramFiles(String Path) {
		String username = System.getProperty("user.name");
		String filename = "Logs/Errorlog.txt";
		ChangeSettings changeSettings = new ChangeSettings();
		newPath = Path;
		
		File logDir = new File(newPath+"/Logs/");
		
		File settings = new File(newPath+"/Settings.ini");
		
		if(!logDir.exists())
			logDir.mkdir();
		
		if(!settings.exists())
			try {
				settings.createNewFile();
			} catch (IOException e) {
				e.printStackTrace(); //#TODO
			}
			
		for (int i=0; i < 2; i++) {	
			if (i==0) {filename = "Logs/Changelog.txt";}
			if (i==1) {filename = "Whitelist.html";}
			
			File oldFile = new File (gcap.getSetup("path")+"/"+filename);
			oldFile.renameTo(new File(newPath+"/"+oldFile.getName()));
		}
		changeSettings.changeSettings(newPath, 11);
		//changeSettings.readAndSaveSettings(false);
		transferSettings(changeSettings.getSettingContent());
		
	}
	public void transferSettings(String [] settings) {
		BufferedWriter out;
		try {
			out = new BufferedWriter(new FileWriter(newPath+"\\Settings.ini"));
			for(int i=0; i < settings.length; i++) {
				out.write(settings[i]);
				out.newLine();
			}
			out.close();
		} catch (IOException e) {
			e.printStackTrace(); //#TODO
		}
	}

	}
