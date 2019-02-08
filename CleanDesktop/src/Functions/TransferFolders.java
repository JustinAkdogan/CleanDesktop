package Functions;

import static java.nio.file.StandardCopyOption.*;

import java.io.File;

public class TransferFolders {
	
	public void TransferFiles(String filename) {		
		String username = System.getProperty("user.name");
		File oldFolder = new File ("C:\\Users\\"+username+"\\Desktop\\"+filename);
		//FileUtils.moveDirectory(oldDir, newDir);
			//Files.move(oldFolder.toPath(),new File("C:\\Test").toPath(),StandardCopyOption.REPLACE_EXISTING );

	}
}
