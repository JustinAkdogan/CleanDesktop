package Functions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import GUI.SettingsFrame;

public class ReadSettingsAndGetCategory {
		
	public byte selectCategory(String filename) {
		String file = filename.substring(0,filename.length());
		String extension = null;
		if (file.contains(".")) {
		extension = filename.substring(filename.indexOf("."), filename.length());
		}
		if (extension != null) {
			extension = extension.toLowerCase();
			if (extension.contains(".png") || extension.contains(".jpg") || extension.contains(".gif") || extension.contains(".bmp") ||
				extension.contains(".tiff") || extension.contains(".swf") || extension.contains(".svg")) {
				return 1;
			}else if (extension.contains(".wav") || extension.contains(".mp3") || extension.contains(".wma") || extension.contains(".aac") ||
					extension.contains(".ogg") || extension.contains(".flac") || extension.contains(".rm")) {
				return 2;
			}else if (extension.contains(".mpg") || extension.contains(".mpeg") || extension.contains(".vob") || extension.contains(".m2p") ||
					extension.contains(".ts") || extension.contains(".mp4") || extension.contains(".mov") || extension.contains(".avi") ||
					extension.contains(".wmv") || extension.contains(".asf") || extension.contains(".mkv") || extension.contains(".webm") ||
					extension.contains(".flv") || extension.contains(".3gp")) {
				return 3;
			}else {
				return 4;
			}
		}
		return 0;
	}
	
	public String getSetup(String Settingline) {
		SettingsFrame settings = new SettingsFrame();
		String programPath = settings.getProgramPath();
        BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(programPath+"\\Settings.ini"));
			String line;
	        while ((line = br.readLine()) != null) {
	        	if(line.contains(Settingline)) {
	        		return line.substring(line.indexOf("=")+1, line.length());
	           }
	        }
	       br.close();
		} catch (IOException e) {
			//generateErrorlog.WriteInErrorLog(1, getClass().getName());
		}
		
		return null;
	}
	
	public String getProperty(String Settingline) {
		SettingsFrame settings = new SettingsFrame();
		String programPath = settings.getProgramPath();
        BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(programPath+"\\Settings.ini"));
			String line;
	        while ((line = br.readLine()) != null) {
	        	if(line.contains(Settingline)) {
	        		return line.substring(0, line.indexOf("=")+0);
	           }
	        }
               br.close();
		} catch (IOException e) {
			//generateErrorlog.WriteInErrorLog(1, getClass().getName());
		}
		return null;
	}
}
