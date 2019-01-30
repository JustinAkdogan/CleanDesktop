package Functions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ChangeSettings {
	
	
	public void changeSettings() {
	        BufferedWriter out;
	        BufferedReader br;
			try {
				//#TODO
				//Cant Write and Read at the same time 
				//So create a new file and delete the old file
				out = new BufferedWriter(new FileWriter("C:\\CleanDesktop\\Settings.ini",true));
				br = new BufferedReader(new FileReader("C:\\CleanDesktop\\Settings.ini"));
				String line;
		        while ((line = br.readLine()) != null) {
		        	if(line.contains("Test")) {
		        		line = line.replaceAll("Test","tt");
		        		out.write(line = line.replaceAll("Test","tt"));
		           }
		        }
	               out.close();
	               br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
