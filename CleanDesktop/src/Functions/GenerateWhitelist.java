package Functions;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class GenerateWhitelist {
	
	FileWhitelist whitelist = new FileWhitelist();
	GetCategoryAndProperty gcap = new GetCategoryAndProperty();
	GenerateErrorlog generateErrorlog = new GenerateErrorlog();
	
	public GenerateWhitelist(String [] filenames) {
		
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
				"<h1>Whitelist</h1>",
				"<span style='white-space:nowrap;'>"
		};
		
		generateLog(htmlLogStructureStart,filenames);
	}
	
	public void generateLog(String [] htmlLogStructureStart,String [] filenames) {
		try {
			BufferedWriter writer = new BufferedWriter (new FileWriter(gcap.getSetup("path")+"/Whitelist.html", true));			
			File htmlFile = new File(gcap.getSetup("path")+"/Whitelist.html");
			
			if (htmlFile.length() < 1) {
				for (int a=0; a < htmlLogStructureStart.length; a++) {
					writer.write(""+htmlLogStructureStart[a]);
					writer.newLine();
				}
			}
			
			for (int b=0; b < filenames.length; b++) {
				if (filenames[b] != null && !whitelist.isFileInWhitelist(filenames[b])) {
					writer.write("<a style='color: green'>"+filenames[b]+"</a><br>");
					writer.newLine();
				}
			}
			
			writer.close();
		} catch (IOException e) {
			generateErrorlog.WriteInErrorLog(5, getClass().getName());
		}		
	}
}
