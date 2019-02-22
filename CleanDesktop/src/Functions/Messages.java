package Functions;

import javax.swing.JOptionPane;

public class Messages {
	
	String [] messageContent = new String[] {"Content","Title"};
		
	public void errorMessages(byte MessageID, String filename) {
		GenerateErrorlog generateErrorlog = new GenerateErrorlog();
		switch(MessageID) {
		case 1: 
			messageContent[0] = "The file 'C:\\CleanDesktop\\Settings.ini' couldn't be found, read or edited.";
			messageContent[1] = "Error " + MessageID;
			break;
		case 2: 
			messageContent[0] = "Files couldn't be created on C:\\CleanDesktop. \n try to run as Administator.";
			messageContent[1] = "Error " + MessageID;
			generateErrorlog.WriteInErrorLog(messageContent);
			break;
		case 3: 
			messageContent[0] = "The file 'C:\\CleanDesktop\\Logs\\Changelog.html' couldn't be edited, created or opened.";
			messageContent[1] = "Error " + MessageID;
			generateErrorlog.WriteInErrorLog(messageContent);
			break;
		case 4: 
			messageContent[0] = "The file 'C:\\CleanDesktop\\Logs\\Errorlog.txt' couldn't be edited, created or opened.";
			messageContent[1] = "Error " + MessageID;
			break;
		case 5: 
			messageContent[0] = "The file 'C:\\CleanDesktop\\Whitelist.html' couldn't be edited, created or opened.";
			messageContent[1] = "Error " + MessageID;
			generateErrorlog.WriteInErrorLog(messageContent);
			break;
		case 6: 
			messageContent[0] = "The file '" +filename+ "' couldn't be edited, created or opened.";
			messageContent[1] = "Error " + MessageID;
			generateErrorlog.WriteInErrorLog(messageContent);
			break;
		case 7: 
			messageContent[0] = "The Program Icon couldn't be loaded.";
			messageContent[1] = "Error " + MessageID;
			generateErrorlog.WriteInErrorLog(messageContent);
			break;
		case 8: 
			messageContent[0] = "File explorer couldn't be opened or the folder 'C:\\CleanDesktop' couldn't be found";
			messageContent[1] = "Error " + MessageID;
			generateErrorlog.WriteInErrorLog(messageContent);
			break;
		case 9: 
			messageContent[0] = "Software Design couldn't be loaded correctly";
			messageContent[1] = "Error " + MessageID;
			generateErrorlog.WriteInErrorLog(messageContent);
			break;
		}
		JOptionPane.showMessageDialog(null, messageContent[0], messageContent[1], JOptionPane.ERROR_MESSAGE);
	}
	
	public int optionMessages(byte optionMessageID, String filename, Object [] options) {
		switch(optionMessageID) {
		case 1:
			messageContent[0] = "The file: '"+filename+"' already exists in the destination folder";
			messageContent[1] = "File already exist";
			break;
		}
		
		int answere = JOptionPane.showOptionDialog(null, 
		messageContent[0],
		messageContent[1],
		JOptionPane.YES_NO_OPTION,
		JOptionPane.QUESTION_MESSAGE,
		null,
		options,
		options[1]);
		
		return answere;
	}

}
