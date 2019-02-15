package Functions;

import java.io.File;
import java.io.IOException;

public class CreateWorkspace {
	
	InitialiseSettings initSettings = new InitialiseSettings();
	
	String prepath = "C:\\CleanDesktop\\";
	String prepathlog = "C:\\CleanDesktop\\Logs\\";
	
	
	public CreateWorkspace() {
		String username = System.getProperty("user.name");
		
		//Folders
		File doc_folder = new File("C:\\Users\\"+username+"\\Documents\\CleanDesktop");
		File pic_folder = new File("C:\\Users\\"+username+"\\Pictures\\CleanDesktop");
		File mus_folder = new File("C:\\Users\\"+username+"\\Music\\CleanDesktop");
		File vid_folder = new File("C:\\Users\\"+username+"\\Videos\\CleanDesktop");
		File sys_folder = new File("C:\\CleanDesktop");
		File log_folder = new File("C:\\CleanDesktop\\Logs");
		
		//Files
		File err_log = new File(prepathlog + "Errorlog.txt");
		File chg_log = new File(prepathlog + "Changelog.html");
		File whl_log = new File(prepath + "Whitelist.txt");
		File set_log = new File(prepath + "Settings.ini");
		
		if(!doc_folder.exists()) {
			doc_folder.mkdir();
		}
		if(!pic_folder.exists()) {
			pic_folder.mkdir();
		}
		if(!mus_folder.exists()) {
			mus_folder.mkdir();
		}
		if(!vid_folder.exists()) {
			vid_folder.mkdir();
		}
		if(!sys_folder.exists()) {
			sys_folder.mkdir();
		}
		if(!log_folder.exists()) {
			log_folder.mkdir();
		}
		
		//File Creation
		if(!err_log.exists()) {
			try {
				err_log.createNewFile();
			} catch (IOException e) {
				e.printStackTrace(); // #TODO
			}
		}
				
		if(!chg_log.exists()) {
			try {
				chg_log.createNewFile();
			} catch (IOException e) {
				e.printStackTrace(); // #TODO
			}
		}
		
		if(!set_log.exists()) {
			try {
				set_log.createNewFile();
				initSettings.setStandardSettings();
			} catch (IOException e) {
				e.printStackTrace(); // #TODO
			}
		}else if (set_log.length() < 1) {
			initSettings.setStandardSettings();
		}
	}
	
	public void cleanDesktop() {
		ReadDesktop rd = new ReadDesktop(prepathlog); 
	}
	
}

