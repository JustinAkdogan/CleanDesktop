package Functions;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileWhitelist {

	public FileWhitelist() {
		
	}
	
	public void selectFiles() {
	    JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif");
        String username = System.getProperty("user.name");
        File dir = new File("C:\\Users\\"+username+"\\Desktop");
        chooser.setFileFilter(filter);
        chooser.setMultiSelectionEnabled(true);
        chooser.setCurrentDirectory(dir);
        int returnVal = chooser.showOpenDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
        	File[] files =  chooser.getSelectedFiles();
        }
	}
}
