package LogPackage;

import java.io.*;

public class TransferLog extends MainLog {

	String targetfile;
	
	public TransferLog(String targetfile) {
		this.targetfile = targetfile + "TransferLog.txt";
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
