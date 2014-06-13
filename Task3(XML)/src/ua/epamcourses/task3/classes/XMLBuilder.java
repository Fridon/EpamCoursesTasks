package ua.epamcourses.task3.classes;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class XMLBuilder {

	public static void formXML(String file, LinkedList<Knife> list) throws IOException{
		File f = new File(file);	
		FileWriter wrt = new FileWriter(f);
		StringBuilder sb = new StringBuilder();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
		sb.append("<?xml-stylesheet type=\"text/xsl\" href=\"Knife.xsl\"?>\n\n");
		sb.append("<Knives xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:noNamespaceSchemaLocation=\"Knife.xsd\">\n");
		for(XMLFormated temp:list){
			sb.append(temp.forXML());
		}
		sb.append("</Knives>\n");
		wrt.append(sb);
		wrt.flush();	
		wrt.close();
	}	
}
