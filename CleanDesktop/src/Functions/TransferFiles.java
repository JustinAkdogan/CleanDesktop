package Functions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class TransferFiles {
	public TransferFiles(String filename) {		
			String username = System.getProperty("user.name");
			File oldFile = new File ("C:\\Users\\"+username+"\\Desktop\\"+filename);
			oldFile.renameTo(new File("C:\\Users\\"+username+"\\Documents\\CleanDesktop\\"+ oldFile.getName()));
			new WriteInLogs(true, oldFile.getName(), " TRANSFERED TO ", "C:\\Users\\"+username+"\\Documents\\CleanDesktop\\");
	}
}
