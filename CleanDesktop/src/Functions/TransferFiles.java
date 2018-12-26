package Functions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class TransferFiles {
	public TransferFiles(String filename) {		
			String username = System.getProperty("user.name");
			File oldFile = new File ("C:\\Users\\"+username+"\\Desktop\\"+filename);
			
			if(selectCategory(filename) == 1)
			oldFile.renameTo(new File("C:\\Users\\"+username+"\\Documents\\CleanDesktop\\"+ oldFile.getName()));
			
			new WriteInLogs(true, oldFile.getName(), " TRANSFERED TO ", "C:\\Users\\"+username+"\\Documents\\CleanDesktop\\");
	}
	
	public int selectCategory(String filename) {
		System.out.println(filename);
		String extension = filename.substring(filename.indexOf("."), filename.length());
		if (extension != null) {
		if (extension == ".png" || extension ==  ".jpg" || extension == "bmp") {
			System.out.println("S");
		return 1;
		}
		}
		
		return 0;
	}
}
