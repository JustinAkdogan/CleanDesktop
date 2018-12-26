package Functions;

import java.io.File;


public class ReadDesktop {
	
	String username = System.getProperty("user.name");
	String desktoppath = "C:\\Users\\" + username + "\\Desktop";
	String path;
	
	public ReadDesktop(String prepath) {
		path = prepath;
		reading();
	}
	
	public void reading() {
		File desktopfile = new File(desktoppath);
		String filelist[] = desktopfile.list();
		int counter = filelist.length;
		for(int i = 0; i <= counter - 1; i++) {			
			File file = new File (desktoppath + filelist[i]);
			long size = filelist[i].length(); //Funktioniert nicht überall
			System.out.println("Name: " + file.getName() + "Size: " + size + " " + filelist[i].length());
			if(size >= 1) {
				new TransferFiles(filelist[i]); 
			}else {
				file.delete();
			}
		}
	}
}