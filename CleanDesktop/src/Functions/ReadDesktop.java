package Functions;

import java.io.File;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;


public class ReadDesktop {
	
	String username = System.getProperty("user.name");
	String desktoppath = "C:\\Users\\" + username + "\\Desktop";
	String path;
	
	public ReadDesktop(String prepath) {
		path = prepath;
		reading();
	}
	
	public void reading() {
		File desktopfile = new File(desktoppath);
		String filelist[] = desktopfile.list();
		int counter = filelist.length;
		for(int i = 0; i <= counter - 1; i++) {			
			File file = new File (desktoppath + "\\" + filelist[i]);
			long size = file.length(); //Funktioniert nicht überall
			
			//System.out.println("Name: " + file.getName() + "Size: " + size);
				if(size >= 20) {
					new TransferFiles(filelist[i]); 
				}else {
					file.delete();
				}
		}
	}
}