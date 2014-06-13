package ua.epamcourses.task3.parseTests;

import java.io.FileNotFoundException;
import java.util.LinkedList;

import javax.xml.stream.XMLStreamException;

import ua.epamcourses.task3.classes.Knife;
import ua.epamcourses.task3.parsers.MySTAXParser;

public class MySTAXParserTest {
	public static void main(String[] args) {
		MySTAXParser parser = new MySTAXParser();
		try {
			parser.parse("xml/Knife.xml");			
			LinkedList<Knife> knives= parser.getKnives();
			for(Knife knife:knives){
				System.out.println(knife);	
			}			
		} catch (FileNotFoundException | XMLStreamException e) {
			e.printStackTrace();
		}
	}
}
