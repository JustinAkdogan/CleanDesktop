package Functions;

import java.io.File;

public class TransferFiles {
	
	Whitelist flw = new Whitelist();
	ReadSettingsAndGetCategory gcap = new ReadSettingsAndGetCategory();
	
	public TransferFiles(String filename) {		
			String username = System.getProperty("user.name");
			File oldFile = new File ("C:\\Users\\"+username+"\\Desktop\\"+filename);
			if (oldFile.isFile()) {
				if(gcap.selectCategory(filename) == 1) {
					oldFile.renameTo(new File(gcap.getSetup("img_destination")+"/"+oldFile.getName()));
				}else if(gcap.selectCategory(filename) == 2) {
					oldFile.renameTo(new File(gcap.getSetup("msc_destination")+"/"+oldFile.getName()));
				}else if(gcap.selectCategory(filename) == 3) {
					oldFile.renameTo(new File(gcap.getSetup("vid_destination")+"/"+oldFile.getName()));
				}else if(gcap.selectCategory(filename) == 4) {
					oldFile.renameTo(new File(gcap.getSetup("doc_destination")+"/"+oldFile.getName()));
				}
			}
	}

}
