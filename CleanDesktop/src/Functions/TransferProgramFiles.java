package Functions;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Properties;

public class TransferProgramFiles {
	
	GetCategoryAndProperty gcap = new GetCategoryAndProperty();
	ReadAndSaveFileContent readandsave = new ReadAndSaveFileContent();
	ChangeSettings changeSettings = new ChangeSettings();
	String newPath = null;
	
	public TransferProgramFiles(String Path) {
		String [] filesToTransfer = {"Settings.ini","Whitelist.html","Logs\\Changelog.html","Logs\\Errorlog.txt"};
		newPath = Path;
				
		CreateWorkspace createWorkspace = new CreateWorkspace(newPath);
		
		for (byte i=0; i < 4; i++) {
			if (i == 0) {
				transferFile(filesToTransfer[i], setNewProgramPath(readandsave.readSaveAndGetFileContent(filesToTransfer[i], false)));
			}else {
				transferFile(filesToTransfer[i], readandsave.readSaveAndGetFileContent(filesToTransfer[i], false));
			}
		}
		//deleteOldFiles();
		System.setProperty("cleandesktop.path", newPath);
		changeSettings.changeSettings(newPath, (byte) 11);
	}
	public void transferFile(String file, String [] fileContent) {
		BufferedWriter out;
		try {
			out = new BufferedWriter(new FileWriter(newPath+"/"+file));
			for(int i=0; i < fileContent.length; i++) {
				out.write(fileContent[i]);
				out.newLine();
			}
			out.close();
		} catch (IOException e) {
			e.printStackTrace(); //#TODO
		}
	}
	
	public String [] setNewProgramPath(String [] settingContent) {
		for (byte i=0; i < settingContent.length; i++) {
			if (settingContent[i].contains("path")) {
				settingContent[i] = "path="+newPath;
			}
		}
		return settingContent;
	}
	
	public void deleteOldFiles() {
		String currPath = gcap.getSetup("path");
		File sysFolder = new File(currPath);
		String fileList[] = sysFolder.list();
		
		for (byte i=0; i < fileList.length; i++) {
			File file = new File (currPath + "\\" + fileList[i]);
			file.delete();
		}
	}

	}
