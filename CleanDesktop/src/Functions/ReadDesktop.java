package Functions;

import java.io.File;

public class ReadDesktop {

	String[] data; 
	
	String username = System.getProperty("user.name");
	String path = "C:\\Users\\" +username+ "\\Desktop";
	
	public ReadDesktop() {
		
		reading();
	}
	
	public void reading() {
		
		File desktopfile = new File(path);
		String filelist[] = desktopfile.list();
		int counter = filelist.length;
		for(int i = 0; i <= counter - 1; i++)
		System.out.println(filelist[i]);
	}
	
	
}
