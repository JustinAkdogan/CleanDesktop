package Functions;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class InitialiseSettings {
	private String username = System.getProperty("user.name");
	private String prepath = "C:/Users/"+username;
	private String [] settingStructure = {"[Destination Paths]",
	"img_destination="+prepath+"/Pictures/CleanDesktop","msc_destination="+prepath+"/Music/CleanDesktop",
	"vid_destination="+prepath+"/Videos/CleanDesktop","doc_destination="+prepath+"/Documents/CleanDesktop"};
	
	public InitialiseSettings() {
		setStandardSettings();
	}
	
	public void setStandardSettings() {
		BufferedWriter writer;
		try {
			writer = new BufferedWriter (new FileWriter("C:\\CleanDesktop\\Settings.ini", true));
			for (int i=0; i < settingStructure.length; i++) {
				writer.write(settingStructure[i]);
				writer.newLine();
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
