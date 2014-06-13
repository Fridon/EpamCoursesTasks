package ua.epamcourses.task3.parsers;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import ua.epamcourses.task3.classes.Knife;
import ua.epamcourses.task3.classes.Visuals;

public class MySTAXParser {
	private LinkedList<Knife> knives;
	private Knife currentKnife;
	private Visuals currentVisuals;
	private String currentTag;
	
	public MySTAXParser(){
		knives = new LinkedList<Knife>();
	}
	
	public void parse(String file) throws FileNotFoundException, XMLStreamException{
		XMLInputFactory	factory = XMLInputFactory.newInstance();
		XMLStreamReader reader = factory.createXMLStreamReader(new FileReader(file));
		while(reader.hasNext()){
			switch(reader.next()){
			
			case XMLStreamConstants.START_ELEMENT:
				currentTag = reader.getLocalName();
				switch(currentTag){
				case "knife":
					currentKnife = new Knife();
					break;
				case "visuals":
					currentVisuals = new Visuals();
					break;
				case "handle":
					currentVisuals.setWoodenHandler(Boolean.valueOf(reader.getAttributeValue(0)));
					break;
				}
				break;
				
			case XMLStreamConstants.END_ELEMENT:
				switch(reader.getLocalName()){
				
				case "knife":
					knives.add(currentKnife);
					break;
				case "visuals":
					currentKnife.setVisuals(currentVisuals);
					break;
				}
				currentTag = "";
				break;
				
			case XMLStreamConstants.CHARACTERS:
				
				switch(currentTag){
				
				case "ID":
					currentKnife.setName(new String(reader.getText()));
					break;
				case "type":
					currentKnife.setType(new String(reader.getText()));
					break;
				case "handy":
					currentKnife.setHandy(new String(reader.getText()));
					break;
				case "origin":
					currentKnife.setOrigin(new String(reader.getText()));
					break;
				case "length":
					int tempLength = Integer.parseInt(new String(reader.getText()));
					currentVisuals.setLength(tempLength);
					break;
				case "width":
					int tempWidth = Integer.parseInt(new String(reader.getText()));
					currentVisuals.setWidth(tempWidth);
					break;
				case "material":
					currentVisuals.setMaterial(new String(reader.getText()));
					break;
				case "handle":
					currentVisuals.setHandle(new String(reader.getText()));	
					break;
				case "sink":
					currentVisuals.setSink(Boolean.valueOf(new String(reader.getText())));
					break;
				case "value":
					currentKnife.setValue(Boolean.valueOf(new String(reader.getText())));
				}
				break;
			}
		}
	}

	public LinkedList<Knife> getKnives(){
		return knives;
	}
	
}
