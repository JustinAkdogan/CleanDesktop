package Functions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

public class TransferFiles {
	
	FileWhitelist flw = new FileWhitelist();
	
	public TransferFiles(String filename) {		
			String username = System.getProperty("user.name");
			File oldFile = new File ("C:\\Users\\"+username+"\\Desktop\\"+filename);
			
			if(!flw.checkFilesInWhitelist(filename)) {
			if(selectCategory(filename) == 1) {
				oldFile.renameTo(new File(getDestination(1)+"/"+oldFile.getName()));
				new WriteInLogs(true, oldFile.getName(), " TRANSFERED TO ", getDestination(1));
			}else if(selectCategory(filename) == 2) {
				oldFile.renameTo(new File(getDestination(2)+"/"+oldFile.getName()));
				new WriteInLogs(true, oldFile.getName(), " TRANSFERED TO ", getDestination(2));
			}else if(selectCategory(filename) == 3) {
				oldFile.renameTo(new File(getDestination(3)+"/"+oldFile.getName()));
				new WriteInLogs(true, oldFile.getName(), " TRANSFERED TO ", getDestination(3));
			}else if(selectCategory(filename) == 4) {
				oldFile.renameTo(new File(getDestination(4)+"/"+oldFile.getName()));
				new WriteInLogs(true, oldFile.getName(), " TRANSFERED TO ", getDestination(4));
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
	
	public String getDestination(int extensionID) {
		String propertyName;
		
		if (extensionID == 1) {
			propertyName = "img_destination";
		}else if (extensionID == 2) {
			propertyName = "msc_destination";
		}else if (extensionID == 3) {
			propertyName = "vid_destination";
		}else {
			propertyName = "doc_destination";
		}
		
        BufferedReader br;
		try {
			br = new BufferedReader(new FileReader("C:\\CleanDesktop\\Settings.ini"));
			String line;
	        while ((line = br.readLine()) != null) {
	        	if(line.contains(propertyName)) {
	        		return line.substring(line.indexOf("=")+1, line.length());
	           }
	        }
               br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
