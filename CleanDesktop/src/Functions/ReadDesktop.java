package Functions;

import java.io.File;

import Logs.ChangeLog;
import Logs.ErrorLog;

public class ReadDesktop {
	
	String username = System.getProperty("user.name");
	String desktoppath = "C:\\Users\\" + username + "\\Desktop";
	String path;
	ChangeLog translog;
	ErrorLog errorlog;
	
	public ReadDesktop(String prepath) {
		path = prepath;
		reading();
		//createTransferLog();
		//createErrorLog();
	}
	
	public void reading() {
		File desktopfile = new File(desktoppath);
		String filelist[] = desktopfile.list();
		int counter = filelist.length;
		for(int i = 0; i <= counter - 1; i++) {			
			File file = new File (desktoppath + filelist[i]);
			long size = filelist[i].length();
			System.out.println("Name: " + file.getName() + "Size: " + size);
			//if(size >= 1) {
				//new TransferFiles(filelist[i]); 
				//System.out.println("xD");
			//}else {
				//file.delete();
			//}
		}
	}
	
	public void createTransferLog() {
		translog = new ChangeLog(path);
		translog.createLogFile();
	}
	
	public void createErrorLog() {
		errorlog = new ErrorLog(path);
		errorlog.createLogFile();
	}
}