package Functions;

import javax.swing.JFileChooser;

public class ChooseDestinationFolder {
	
	public String chooseFolder() {
		JFileChooser chooseFolder = new JFileChooser();
		chooseFolder.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		chooseFolder.showSaveDialog(null);
		if (chooseFolder.getSelectedFile() != null) {
			return(chooseFolder.getSelectedFile().toString());
		}
		return null;
	}	
		
}
