package Functions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Paths;

public class CreateFolders {
	
	public CreateFolders() {
		String username = System.getProperty("user.name");
				
		
		//Folders
		File dir = new File("C:\\Users\\"+username+"\\Documents\\CleanDesktop");
		File dir2 = new File("C:\\Users\\"+username+"\\Pictures\\CleanDesktop");
		File dir3 = new File("C:\\Users\\"+username+"\\Music\\CleanDesktop");
		File dir4 = new File("C:\\Users\\"+username+"\\Videos\\CleanDesktop");
		File dir5 = new File("C:\\CleanDesktop");
		File dir6 = new File("C:\\CleanDesktop\\Logs");
		
		//Files
		File file = new File("C:\\CleanDesktop\\Logs\\Conflicts.txt");
		File file2 = new File("C:\\CleanDesktop\\Logs\\Changelog.txt");
		//File file3 = new File("C:\\CleanDesktop\\Whitelist.txt");
		
		if(!dir.exists())
		dir.mkdir();
		if(!dir2.exists())
		dir2.mkdir();
		if(!dir3.exists())
		dir3.mkdir();
		if(!dir4.exists())
		dir4.mkdir();
		if(!dir5.exists())
		dir5.mkdir();
		if(!dir6.exists())
		dir6.mkdir();
		
		//File Creation
		if(!file.exists()) {
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
		
		if(!file2.exists()) {
		try {
			file2.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
		/*
		if(!file3.exists()) {
		try {
			file3.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
		*/
	}
	
	public void cleanDesktop() {
		ReadDesktop rd = new ReadDesktop();
	}
	
}

