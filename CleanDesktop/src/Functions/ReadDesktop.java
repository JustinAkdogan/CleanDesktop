package Functions;

import java.io.File;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;


public class ReadDesktop {
	
	String username = System.getProperty("user.name");
	String desktoppath = "C:\\Users\\" + username + "\\Desktop";
	String path;
	int allowedDeleteSize = 22;
	GetCategoryAndProperty gcap = new GetCategoryAndProperty();
	TransferFolders transFolders = new TransferFolders();
	
	public ReadDesktop(String prepath) {
		path = prepath;
		reading();
	}
	
	public void reading() {
		File desktopfile = new File(desktoppath);
		String filelist[] = desktopfile.list();
		String transferedFiles [] = new String [filelist.length];
		String transferedFilesDestinations [] = new String [filelist.length];
		int counter = filelist.length;
		for(int i = 0; i <= counter - 1; i++) {			
			File file = new File (desktoppath + "\\" + filelist[i]);
			long size = file.length(); //Funktioniert nicht überall
			//int size = (int) file.length();
			getDeleteSize();
			
			if (!FileWhitelist.checkFilesInWhitelist(file.getName()) && file.getName().contains(".")) {
				if (Boolean.parseBoolean(gcap.getSetup("del_customFiles")) == true) {
					if (size > allowedDeleteSize) {
						transferedFiles[i] = file.getName();
						//new TransferFiles(filelist[i]); 
						transFolders.TransferFiles(filelist[i]);
					}else {
					transferedFiles[i] = "del_"+file.getName();
					file.delete();	
					}
				}else if (size > 1) {
					//transferedFiles[i] = file.getName();
					new TransferFiles(filelist[i]); 
					transFolders.TransferFiles(filelist[i]);
					
				}else {
					transferedFiles[i] = "del_"+file.getName();
					file.delete();
				}
			}
		
		}
		new GenerateChangelog(transferedFiles);
	}
	
	public void getDeleteSize() {
		if (gcap.getSetup("del_customFilesSize").contains("kb")) {
			allowedDeleteSize = Integer.parseInt(gcap.getSetup("del_customFilesRange"))*1000;
		}else if (gcap.getSetup("del_customFilesSize").contains("mb")) {
			allowedDeleteSize = Integer.parseInt(gcap.getSetup("del_customFilesRange"))*1000000;
		}else if (gcap.getSetup("del_customFilesSize").contains("gb")) {
			allowedDeleteSize = Integer.parseInt(gcap.getSetup("del_customFilesRange"))*1000000000;
		}
	}

}