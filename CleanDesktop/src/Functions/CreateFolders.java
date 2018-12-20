package Functions;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Paths;

public class CreateFolders {

	public CreateFolders() {
		String username = System.getProperty("user.name");
		
		File dir = new File("C:\\Users\\"+username+"\\Documents\\CleanDesktop");
		File dir2 = new File("C:\\Users\\"+username+"\\Pictures\\CleanDesktop");
		File dir3 = new File("C:\\Users\\"+username+"\\Music\\CleanDesktop");
		File dir4 = new File("C:\\Users\\"+username+"\\Videos\\CleanDesktop");
		
		if(!dir.exists())
		dir.mkdir();
		if(!dir2.exists())
		dir2.mkdir();
		if(!dir3.exists())
		dir3.mkdir();
		if(!dir4.exists())
		dir4.mkdir();
		
	}
}

