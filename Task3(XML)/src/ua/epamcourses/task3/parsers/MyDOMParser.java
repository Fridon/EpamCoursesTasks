package ua.epamcourses.task3.parsers;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import ua.epamcourses.task3.classes.Knife;
import ua.epamcourses.task3.classes.Visuals;

public class MyDOMParser {
	
	private LinkedList<Knife> knives;
	private Knife currentKnife;
	private Visuals currentVisuals;
	private boolean knifeCreated;
	private boolean visualsCreated;
	
	public MyDOMParser(){
		knives = new LinkedList<Knife>();
		knifeCreated = false;
		visualsCreated = false;
	}
	
	public LinkedList<Knife> getKnives() {
		return knives;
	}

	private void parseDoc(NodeList list){
		for(int i = 0; i < list.getLength(); i++){
			switch(list.item(i).getNodeName()){		
			case "knife":
				currentKnife= new Knife();
				knifeCreated = true;
				break;
			case "visuals":
				currentVisuals = new Visuals();
				visualsCreated = true;
				break;
			case "ID":
				currentKnife.setName(new String(list.item(i).getTextContent()));
				break;
			case "type":
				currentKnife.setType(new String(list.item(i).getTextContent()));
				break;
			case "handy":
				currentKnife.setHandy(new String(list.item(i).getTextContent()));
				break;
			case "origin":
				currentKnife.setOrigin(new String(list.item(i).getTextContent()));
				break;
			case "length":
				int tempLength = Integer.parseInt(new String(list.item(i).getTextContent()));
				currentVisuals.setLength(tempLength);
				break;
			case "width":
				int tempWidth = Integer.parseInt(new String(list.item(i).getTextContent()));
				currentVisuals.setWidth(tempWidth);
				break;
			case "material":
				currentVisuals.setMaterial(new String(list.item(i).getTextContent()));
				break;
			case "handle":
				currentVisuals.setHandle(new String(list.item(i).getTextContent()));
				boolean wooden = Boolean.valueOf(list.item(i).getAttributes().getNamedItem("wooden").getTextContent());
				currentVisuals.setWoodenHandler(wooden);
				break;
			case "sink":
				currentVisuals.setSink(Boolean.valueOf(new String(list.item(i).getTextContent())));
				break;
			case "value":
				currentKnife.setValue(Boolean.valueOf(new String(list.item(i).getTextContent())));
			}
			if(list.item(i).hasChildNodes())
				parseDoc(list.item(i).getChildNodes());
		}
		if(knifeCreated && visualsCreated){
			currentKnife.setVisuals(currentVisuals);
			knives.add(currentKnife);
			knifeCreated = false;
			visualsCreated = false;
		}
	}
	
	public void parse(String file) throws ParserConfigurationException, SAXException, IOException{
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(new File(file));
		NodeList docList = document.getChildNodes();
		
		for(int i = 0; i < docList.getLength(); i++){
			if(docList.item(i).getNodeName().equals("Knives")){
				parseDoc(docList.item(i).getChildNodes());
			}
		}
	}
}
