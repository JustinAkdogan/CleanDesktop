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
	GetCategoryAndProperty gcap = new GetCategoryAndProperty();
	
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
			
			if (!FileWhitelist.checkFilesInWhitelist(file.getName()) && file.getName().contains(".")) {
				if (Boolean.parseBoolean(gcap.getProperty("del_customFiles")) == true) {
					if (Integer.parseInt(gcap.getProperty("del_customFilesRange")) > size) {
						new TransferFiles(filelist[i]); 
						//System.out.println("JA" + file.getName());
					}else {
					file.delete();					//System.out.println("Nein" + file.getName());
					}
				}else if (size > 1) {
					new TransferFiles(filelist[i]); 
					transferedFiles[i] = file.getName();
					
				}else {
					file.delete();
					transferedFiles[i] = "del_"+file.getName();
				}
			}
		}
		new GenerateHtmlLog(transferedFiles);
	}
	

}