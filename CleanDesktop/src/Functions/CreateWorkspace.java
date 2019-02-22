package Functions;

import java.io.File;
import java.io.IOException;

public class CreateWorkspace {
	
	InitialiseSettings initSettings = new InitialiseSettings();
	GenerateErrorlog generateErrorlog = new GenerateErrorlog();
	Messages messages = new Messages();
	
	String systemPath = "";
	
	
	public CreateWorkspace(String programPath) {
		String username = System.getProperty("user.name");
		systemPath = programPath;
		
		//Folders
		File doc_folder = new File("C:\\Users\\"+username+"\\Documents\\CleanDesktop");
		File pic_folder = new File("C:\\Users\\"+username+"\\Pictures\\CleanDesktop");
		File mus_folder = new File("C:\\Users\\"+username+"\\Music\\CleanDesktop");
		File vid_folder = new File("C:\\Users\\"+username+"\\Videos\\CleanDesktop");
		File sys_folder = new File(programPath);
		File log_folder = new File(programPath+"\\Logs");

		//Files
		File err_log = new File(programPath + "\\Logs\\Errorlog.txt");
		File set_log = new File(programPath + "\\Settings.ini");
		
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
		
		if(!err_log.exists()) {
			try {
				err_log.createNewFile();
			} catch (IOException e) {
				messages.errorMessages((byte) 2, null);
			}
		}
				
		
		if(!set_log.exists()) {
			try {
				set_log.createNewFile();
				initSettings.setStandardSettings();
			} catch (IOException e) {
				messages.errorMessages((byte) 2, null);
			}
		}else if (set_log.length() < 1) {
			initSettings.setStandardSettings();
		}
	}	
	
}

