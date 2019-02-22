package Functions;

import java.io.File;


public class ReadDesktop {
	
	String username = System.getProperty("user.name");
	String desktoppath = "C:\\Users\\" + username + "\\Desktop";
	String path;
	int allowedDeleteSize = 22;
	ReadSettingsAndGetCategory gcap = new ReadSettingsAndGetCategory();
	Messages messages = new Messages();
	String [] savedFilesForChangelog;
 	
	public ReadDesktop(String prepath) {
		path = prepath;
		reading();
	}
	
	public void reading() {
		File desktopfile = new File(desktoppath);
		String filelist[] = desktopfile.list();
		savedFilesForChangelog = new String [filelist.length];
		//String transferedFilesDestinations [] = new String [filelist.length];
		int counter = filelist.length;
		for(int i = 0; i <= counter - 1; i++) {			
			File file = new File (desktoppath + "\\" + filelist[i]);
			long size = file.length();
			getDeleteSize();
			
			if (!Whitelist.isFileInWhitelist(file.getName()) && file.getName().contains(".") && file.isFile()) {
				if (Boolean.parseBoolean(gcap.getSetup("del_customFiles")) == true) {
					if (size > allowedDeleteSize) {
						transferFiles(file.getName(), i);
					}else {
						savedFilesForChangelog[i] = "del_"+file.getName();
					file.delete();	
					}
				}else if (size > 1) {
					transferFiles(file.getName(), i);
				}else {
					savedFilesForChangelog[i] = "del_"+file.getName();
					file.delete();
				}
			}
		
		}
		new GenerateChangelog(savedFilesForChangelog);
	}
	
	public void transferFiles(String filename, int counter) {
		if(gcap.selectCategory(filename) == 1) {
			if (!checkIfFileExists(gcap.getSetup("img_destination"), filename)) {
				new TransferFiles(filename, gcap.getSetup("img_destination"));
				savedFilesForChangelog[counter] = filename;
			}else if (checkIfUserWantToReplace(gcap.getSetup("img_destination"), filename)) {
				new TransferFiles(filename, gcap.getSetup("img_destination"));
				savedFilesForChangelog[counter] = "rep_"+filename;
			}
		}else if (gcap.selectCategory(filename) == 2) {
			if (!checkIfFileExists(gcap.getSetup("msc_destination"), filename)) {
				new TransferFiles(filename, gcap.getSetup("msc_destination"));
				savedFilesForChangelog[counter] = filename;
			}else if (checkIfUserWantToReplace(gcap.getSetup("img_destination"), filename)) {
				new TransferFiles(filename, gcap.getSetup("img_destination"));
				savedFilesForChangelog[counter] = "rep_"+filename;
			}
			
		}else if (gcap.selectCategory(filename) == 3) {
			if (!checkIfFileExists(gcap.getSetup("vid_destination"), filename)) {
				new TransferFiles(filename, gcap.getSetup("vid_destination"));
				savedFilesForChangelog[counter] = filename;
			}else if (checkIfUserWantToReplace(gcap.getSetup("img_destination"), filename)) {
				new TransferFiles(filename, gcap.getSetup("img_destination"));
				savedFilesForChangelog[counter] = "rep_"+filename;
			}
		}else {
			if (!checkIfFileExists(gcap.getSetup("doc_destination"), filename)) {
				new TransferFiles(filename, gcap.getSetup("doc_destination"));
				savedFilesForChangelog[counter] = filename;
			}else if (checkIfUserWantToReplace(gcap.getSetup("img_destination"), filename)) {
				new TransferFiles(filename, gcap.getSetup("img_destination"));
				savedFilesForChangelog[counter] = "rep_"+filename;
			}
		}
	}
	
	private boolean checkIfFileExists(String destination, String filename) {
		File file = new File(destination+"/"+filename);
 		if (file.exists()) {
				return true;
		}
 		return false;
	}
	
	private boolean checkIfUserWantToReplace(String destination, String filename) {
		Object [] options = {"Replace","Skip"};
		File file = new File(destination+"/"+filename);
		if (messages.optionMessages((byte) 1, filename, options) == 0) {
			file.delete();
			return true;
		}
		return false;
	}
	
	public void getDeleteSize() {
		if (gcap.getSetup("del_customFilesSize").contains("kb")) {
			allowedDeleteSize = Integer.parseInt(gcap.getSetup("del_customFilesRange"))*1000;
		}else if (gcap.getSetup("del_customFilesSize").contains("mb")) {
			allowedDeleteSize = Integer.parseInt(gcap.getSetup("del_customFilesRange"))*1000000;
		}else if (gcap.getSetup("del_customFilesSize").contains("gb")) {
			allowedDeleteSize = Integer.parseInt(gcap.getSetup("del_customFilesRange"))*1000000000;
		}
	}
}