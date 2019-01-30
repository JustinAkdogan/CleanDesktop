package Functions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class TransferFiles {
	
	FileWhitelist flw = new FileWhitelist();
	
	public TransferFiles(String filename) {		
			String username = System.getProperty("user.name");
			File oldFile = new File ("C:\\Users\\"+username+"\\Desktop\\"+filename);
			
			if(!flw.checkFilesInWhitelist(filename)) {
			if(selectCategory(filename) == 1) {
				oldFile.renameTo(new File("C:\\Users\\"+username+"\\Pictures\\CleanDesktop\\"+ oldFile.getName()));
				new WriteInLogs(true, oldFile.getName(), " TRANSFERED TO ", "C:\\Users\\"+username+"\\Documents\\CleanDesktop\\");
			}else if(selectCategory(filename) == 2) {
				oldFile.renameTo(new File("C:\\Users\\"+username+"\\Music\\CleanDesktop\\"+ oldFile.getName()));
				new WriteInLogs(true, oldFile.getName(), " TRANSFERED TO ", "C:\\Users\\"+username+"\\Music\\CleanDesktop\\");
			}else if(selectCategory(filename) == 3) {
				oldFile.renameTo(new File("C:\\Users\\"+username+"\\Videos\\CleanDesktop\\"+ oldFile.getName()));
				new WriteInLogs(true, oldFile.getName(), " TRANSFERED TO ", "C:\\Users\\"+username+"\\Videos\\CleanDesktop\\");
			}else if(selectCategory(filename) == 4) {
				oldFile.renameTo(new File("C:\\Users\\"+username+"\\Documents\\CleanDesktop\\"+ oldFile.getName()));
				new WriteInLogs(true, oldFile.getName(), " TRANSFERED TO ", "C:\\Users\\"+username+"\\Documents\\CleanDesktop\\");
			}
			}
	}
	
	public int selectCategory(String filename) {
		String file = filename.substring(0,filename.length());
		String extension = null;
		if (file.contains(".")) {
		extension = filename.substring(filename.indexOf("."), filename.length());
		}
		if (extension != null) {
			if (extension.contains(".png") || extension.contains(".jpg") || extension.contains(".gif") || extension.contains(".bmp")) {
				return 1;
			}else if (extension.contains(".mp3")) {
				return 2;
			}else if (extension.contains(".mp4")) {
				return 3;
			}else {
				return 4;
			}
		}else {
			System.out.println("Dateiendung von: "+ file +" Unbekannt");
		}
		return 0;
	}
}
