package ua.epamcourses.task3.parseTests;

import java.io.IOException;
import java.util.LinkedList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import ua.epamcourses.task3.classes.Knife;
import ua.epamcourses.task3.classes.XMLBuilder;
import ua.epamcourses.task3.parsers.MySAXParser;

public class MySAXParserTest {
	public static void main(String[] args) {	
		SAXParser parser;
		try {
		    parser = SAXParserFactory.newInstance().newSAXParser();
			MySAXParser sx = new MySAXParser();
			parser.parse("xml/Knife.xml", sx);
			LinkedList<Knife> knives = sx.getKnives();
			for(Knife knife:knives){
				System.out.println(knife);
			}
			XMLBuilder.formXML("xml/KnifeCreated.xml", knives);
		} catch (ParserConfigurationException | SAXException | IOException e) {
				e.printStackTrace();
		}				
	}
}
