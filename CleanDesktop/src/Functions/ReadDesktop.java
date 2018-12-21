package Functions;

import java.io.File;

import LogPackage.TransferLog;

public class ReadDesktop {
	
	String username = System.getProperty("user.name");
	String desktoppath = "C:\\Users\\" + username + "\\Desktop";
	String transpath;
	TransferLog translog;
	
	public ReadDesktop(String prepath) {
		transpath = prepath;
		//reading();
		createTransferLog();
	}
	
	public void reading() {
		
		File desktopfile = new File(desktoppath);
		String filelist[] = desktopfile.list();
		int counter = filelist.length;
		for(int i = 0; i <= counter - 1; i++) {			
			File file = new File (desktoppath + filelist[i]);
			long size = file.length();
			if(size >= 1) {
				new TransferFiles(filelist[i]); 
			}else {
				file.delete();
			}
		}
	}
	
	public void createTransferLog() {
		translog = new TransferLog(transpath);
		translog.createLogFile();
	}
}