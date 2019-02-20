package Functions;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class InitialiseSettings {
	private String username = System.getProperty("user.name");
	private String prepath = "C:/Users/"+username;
	private String [] settingStructure = {
	"[Destination Paths]",
	"img_destination="+prepath+"/Pictures/CleanDesktop",
	"msc_destination="+prepath+"/Music/CleanDesktop",
	"vid_destination="+prepath+"/Videos/CleanDesktop",
	"doc_destination="+prepath+"/Documents/CleanDesktop",
	"[Delete Files]",
	"del_emptyFiles=true",
	"del_customFiles=false",
	"del_customFilesRange=22",
	"del_customFilesSize=kb",
	"[Program]",
	"path=C:/CleanDesktop"
	};
	
	
	public void setStandardSettings() {
		BufferedWriter writer;
		try {
			writer = new BufferedWriter (new FileWriter("C:\\CleanDesktop\\Settings.ini", false));
			for (byte i=0; i < settingStructure.length; i++) {
				writer.write(settingStructure[i]);
				writer.newLine();
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace(); //#TODO
		}
	}
	
	public String getStandardSetting(String property) {
		for (byte i=0; i < settingStructure.length; i++) {
			if (settingStructure[i].contains(property)) {
				String standardSetup = settingStructure[i].substring(settingStructure[i].indexOf("=")+1, settingStructure[i].length());
				return standardSetup;
			}
		}
		return null;
	}
}
