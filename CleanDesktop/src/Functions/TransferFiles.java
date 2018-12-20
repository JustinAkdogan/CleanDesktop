package Functions;

import java.io.File;

public class TransferFiles {
	public TransferFiles() {
		String filenames [] = null;
		for (int i=0; i < 1; i++) {
			String username = System.getProperty("user.name");
			
			File oldFile = new File ("C:\\Users\\"+username+"\\Desktop\\dfd.png");
			oldFile.renameTo(new File("C:\\Users\\"+username+"\\Documents\\CleanDesktop\\"+ oldFile.getName()));
		}
	}
}
