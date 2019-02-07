//package Functions;
//
//import java.io.BufferedWriter;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//
//public class WriteInLogs {
//	
//	LocalDateTime now = LocalDateTime.now();
//	
//	public WriteInLogs(boolean writeInChangelog, String file, String note, String targetpath) {
//		if (writeInChangelog) {
//			Changelog(file, note, targetpath);
//		}else {
//			//Errorlog(file, note, targetpath);
//		}
//	}
//	
//	public void Changelog(String file, String note, String targetpath) {
//		DateTimeFormatter df;
//		df = DateTimeFormatter.ofPattern("dd.MM.yyyy kk:mm");  
//		BufferedWriter writer;
//		try {
//			writer = new BufferedWriter (new FileWriter("C:\\CleanDesktop\\Logs\\Changelog.txt", true));
//			writer.write(now.format(df)+ " " + file + note + targetpath);
//			writer.newLine();
//			writer.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}	
//	}
//	
//	public void Errorlog(String file) {
//		
//	}
//}
