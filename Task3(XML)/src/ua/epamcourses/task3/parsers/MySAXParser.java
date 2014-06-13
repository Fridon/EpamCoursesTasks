package ua.epamcourses.task3.parsers;

import java.util.LinkedList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import ua.epamcourses.task3.classes.Knife;
import ua.epamcourses.task3.classes.Visuals;

public class MySAXParser extends DefaultHandler{
	
	private LinkedList<Knife> knives;
	private Knife currentKnife;
	private Visuals currentVisuals;
	private String currentTag;
	

	public LinkedList<Knife> getKnives() {
		return knives;
	}

	public MySAXParser(){
		knives  = new LinkedList<Knife>();
	}
		
	@Override
	public void startElement(String namespaceURI, String localName, String qName, Attributes attrs) throws SAXException{
		currentTag = qName;
		switch(currentTag){
		
		case "knife":
			currentKnife = new Knife();
			break;
		case "visuals":
			currentVisuals = new Visuals();
			break;
		case "handle":
			currentVisuals.setWoodenHandler(Boolean.valueOf(attrs.getValue(0)));
			break;
		}			
	}
	
	@Override
	public void endElement(String namespaceURI, String localName, String qName) throws SAXException{
		
		switch(qName){
		
		case "knife":
			knives.add(currentKnife);
			break;
		case "visuals":
			currentKnife.setVisuals(currentVisuals);
			break;
		}
		currentTag = "";
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException{
		switch(currentTag){
		
		case "ID":
			currentKnife.setName(new String(ch, start, length));
			break;
		case "type":
			currentKnife.setType(new String(ch, start, length));
			break;
		case "handy":
			currentKnife.setHandy(new String(ch, start, length));
			break;
		case "origin":
			currentKnife.setOrigin(new String(ch, start, length));
			break;
		case "length":
			int tempLength = Integer.parseInt(new String(ch, start, length));
			currentVisuals.setLength(tempLength);
			break;
		case "width":
			int tempWidth = Integer.parseInt(new String(ch, start, length));
			currentVisuals.setWidth(tempWidth);
			break;
		case "material":
			currentVisuals.setMaterial(new String(ch, start, length));
			break;
		case "handle":
			currentVisuals.setHandle(new String(ch, start, length));	
			break;
		case "sink":
			currentVisuals.setSink(Boolean.valueOf(new String(ch, start, length)));
			break;
		case "value":
			currentKnife.setValue(Boolean.valueOf(new String(ch, start, length)));
		}
		
	}
	
}
