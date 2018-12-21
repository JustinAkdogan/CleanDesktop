package Logs;

import java.io.*;

public class ErrorLog extends MainLog {

	String targetfile;
	
	public ErrorLog(String targetfile) {
		this.targetfile = targetfile + "ErrorLog.txt";
	}
	
	
	@Override
	public void createLogFile() {
		// TODO Auto-generated method stub
		File transfile = new File(targetfile);
		if(!transfile.exists()) {
			try {
				transfile.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void writeLogFile() {
		// TODO Auto-generated method stub
		
	}

}
