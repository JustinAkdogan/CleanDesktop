package Functions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

public class TransferFiles {
	
	FileWhitelist flw = new FileWhitelist();
	GetCategoryAndProperty gcap = new GetCategoryAndProperty();
	
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
