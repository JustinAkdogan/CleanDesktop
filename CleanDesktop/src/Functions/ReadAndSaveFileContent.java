package Functions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadAndSaveFileContent {
	
	ReadSettingsAndGetCategory gcap = new ReadSettingsAndGetCategory();
	Messages messages = new Messages();
	String [] fileContent = null;
	
	public String [] readSaveAndGetFileContent(String file) { 
		BufferedReader br;
		int lineNo = 0;
		try {
			br = new BufferedReader(new FileReader(gcap.getSetup("path")+"/"+file));
			fileContent  = generateStringArray(file);
			String line;
			
	        while ((line = br.readLine()) != null) {
	        	fileContent[lineNo] = line;
	        	lineNo++;
	        }
	        br.close();
		} catch (IOException e) {
			messages.errorMessages((byte) 6, null);
		}
		return fileContent;
	}
	
	public boolean isStringInFile(String file, String string) {
		try {
			BufferedReader br = new BufferedReader (new FileReader(gcap.getSetup("path")+"/"+file));
			String line = null;
	        while ((line = br.readLine()) != null) {
	        	if (line.contains(string)) {
	        		return true;
	        	}
	        }
	        br.close();
		} catch (IOException e) {
			messages.errorMessages((byte) 6, null);
		}
		
		return false;
	}
	
	public String [] generateStringArray(String file) {
		BufferedReader br;
		String generatedArray [];
		try {
			br = new BufferedReader (new FileReader(gcap.getSetup("path")+"/"+file));
			String line = null;
			int LineNo = 0;
			try {
				while ((line = br.readLine()) != null) {
					LineNo++;
				}
				generatedArray = new String [LineNo];
				return generatedArray;
			} catch (IOException e) {
				e.printStackTrace(); // #TODO
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace(); // #TODO
		}
		return null;
	}
}
