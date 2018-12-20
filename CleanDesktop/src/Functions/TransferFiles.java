package Functions;

import java.io.File;

public class TransferFiles {
	public TransferFiles(String filename) {
			String username = System.getProperty("user.name");
			File oldFile = new File ("C:\\Users\\"+username+"\\Desktop\\"+filename);
			
			oldFile.renameTo(new File("C:\\Users\\"+username+"\\Documents\\CleanDesktop\\"+ oldFile.getName()));
	}
}
