package Functions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GetCategoryAndProperty {
	
	public int selectCategory(String filename) {
		String file = filename.substring(0,filename.length());
		String extension = null;
		if (file.contains(".")) {
		extension = filename.substring(filename.indexOf("."), filename.length());
		}
		if (extension != null) {
			if (extension.contains(".png") || extension.contains(".jpg") || extension.contains(".gif") || extension.contains(".bmp")) {
				return 1;
			}else if (extension.contains(".mp3")) {
				return 2;
			}else if (extension.contains(".mp4")) {
				return 3;
			}else {
				return 4;
			}
		}else {
			//System.out.println("Dateiendung von: "+ file +" Unbekannt");
		}
		return 0;
	}
	
	public String getSetup(String Settingline) {
		
        BufferedReader br;
		try {
			br = new BufferedReader(new FileReader("C:\\CleanDesktop\\Settings.ini"));
			String line;
	        while ((line = br.readLine()) != null) {
	        	if(line.contains(Settingline)) {
	        		return line.substring(line.indexOf("=")+1, line.length());
	           }
	        }
               br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String getProperty(String Settingline) {
		
        BufferedReader br;
		try {
			br = new BufferedReader(new FileReader("C:\\CleanDesktop\\Settings.ini"));
			String line;
	        while ((line = br.readLine()) != null) {
	        	if(line.contains(Settingline)) {
	        		return line.substring(0, line.indexOf("=")+0);
	           }
	        }
               br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
