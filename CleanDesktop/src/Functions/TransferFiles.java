package Functions;

import java.io.File;

public class TransferFiles {
	public TransferFiles(String filenames[]) {
		for (int i=0; i < filenames.length; i++) {
			
			String username = System.getProperty("user.name");
			File oldFile = new File ("C:\\Users\\"+username+"\\Desktop\\"+filenames[i]);
			
			oldFile.renameTo(new File("C:\\Users\\"+username+"\\Documents\\CleanDesktop\\"+ oldFile.getName()));
		}
	}
}
