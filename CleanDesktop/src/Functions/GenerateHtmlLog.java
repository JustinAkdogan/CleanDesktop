package Functions;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GenerateHtmlLog {
	GetCategoryAndProperty gcap = new GetCategoryAndProperty();
	
	public GenerateHtmlLog(String [] htmlLogStructureMid) {
		
		String [] htmlLogStructureStart = {
				"<!DOCTYPE html>",
				"<html lang=\"en\">",
				"<head>",
				"<meta charset=\"UTF-8\">",
				"<title>Changelog</title>",
				"<meta name=viewport content=\"width=device-width, initial-scale=1\">",
				"<script src=\"http://code.jquery.com/jquery-1.10.2.min.js\"></script>",
				"<meta charset=\"utf-8\">",
				"<style>",
				"html {","background: darkgrey;","font-size: 100%;","margin: 0em;","padding: 0em;","}",
				"h1{","font-family: Calibri;","text-decoration: underline;","}",
				"a{","font-family: Calibri;","font-size: 1.3rem;","}",
				"#main{","background: whitesmoke;","max-width: 90%;","text-align: center;","margin-left: auto;","margin-right: auto;","}",
				"</style>",
				"</head>",
				"<body>",
				"<div id=\"main\">",
				"<h1>ChangeLog</h1>",
				"<span style='white-space:nowrap;'>"
		};
		String [] htmlLogStructureEnd = {"</span>","</div>","</body>","</html>"};
		
		generateLog(htmlLogStructureStart,htmlLogStructureMid,htmlLogStructureEnd);
	}
	
	public void generateLog(String [] htmlLogStructureStart,String [] htmlLogStructureMid,String [] htmlLogStructureEnd) {
		try {
			BufferedWriter writer = new BufferedWriter (new FileWriter("C:\\CleanDesktop\\Logs\\Changelog.html", false));			
			
			//Text Writer
			for (int a=0; a < htmlLogStructureStart.length; a++) {
				writer.write(""+htmlLogStructureStart[a]);
				writer.newLine();
			}
			for (int b=0; b < htmlLogStructureMid.length; b++) {
				if (htmlLogStructureMid[b] != null) {
					String path = null;
					
					if(gcap.selectCategory(htmlLogStructureMid[b]) == 1) {path = gcap.getProperty("img_destination");}
					if(gcap.selectCategory(htmlLogStructureMid[b]) == 2) {path = gcap.getProperty("msc_destination");}
					if(gcap.selectCategory(htmlLogStructureMid[b]) == 3) {path = gcap.getProperty("vid_destination");}
					if(gcap.selectCategory(htmlLogStructureMid[b]) == 4) {path = gcap.getProperty("doc_destination");}
					if (htmlLogStructureMid[b].startsWith("del_")) {
						writer.write("<a style='padding-left: 15%; color: orangered'>"+htmlLogStructureMid[b].substring(4, htmlLogStructureMid[b].length())+"</a><a style='color:red'> DELETED</a><br>");
					}else {
					writer.write("<a style='padding-left: 15%; color: orangered'>"+htmlLogStructureMid[b]+"</a><a style='color:green'> TRANSFERED TO: </a><a style='text-decoration: underline; color: blue;'>" + path + "</a><br>");
					}
					writer.newLine();
				}
			}
			for (int c=0; c < htmlLogStructureEnd.length; c++) {
				writer.write(""+htmlLogStructureEnd[c]);
				writer.newLine();
			}
			writer.close();
			File htmlFile = new File("C:\\CleanDesktop\\Logs\\Changelog.html");
			Desktop.getDesktop().browse(htmlFile.toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
}
