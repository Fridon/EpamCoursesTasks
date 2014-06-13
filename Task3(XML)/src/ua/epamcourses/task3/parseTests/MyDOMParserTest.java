package ua.epamcourses.task3.parseTests;

import java.io.IOException;
import java.util.LinkedList;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import ua.epamcourses.task3.classes.Knife;
import ua.epamcourses.task3.parsers.MyDOMParser;

public class MyDOMParserTest {
	public static void main(String[] args) {
		MyDOMParser parser = new MyDOMParser();
		try {			
			parser.parse("xml/Knife.xml");
			LinkedList<Knife> knives= parser.getKnives();
			for(Knife knife:knives){
				System.out.println(knife);
			}
			
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
	}
}
