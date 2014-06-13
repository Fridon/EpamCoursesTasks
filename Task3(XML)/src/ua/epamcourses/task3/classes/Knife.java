package ua.epamcourses.task3.classes;

public class Knife implements XMLFormated{
	private String name;
	private String type;
	private String handy;
	private String origin;
	private boolean value;
	private Visuals visuals;
	
	public Knife(){}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getHandy() {
		return handy;
	}
	
	public void setHandy(String handy) {
		this.handy = handy;
	}
	
	public String getOrigin() {
		return origin;
	}
	
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	
	public boolean isValue() {
		return value;
	}
	public void setValue(boolean value) {
		this.value = value;
	}
	
	public Visuals getVisuals() {
		return visuals;
	}
	
	public void setVisuals(Visuals visuals) {
		this.visuals = visuals;
	}
	
	public String toString(){
		StringBuilder temp = new StringBuilder();
		temp.append("Name: ").append(name).append("\n");
		temp.append("Type: ").append(type).append("\n");
		temp.append("Handy: ").append(handy).append("\n");
		temp.append("Origin: ").append(origin).append("\n");
		temp.append("Value: ").append(value).append("\n");
		temp.append(visuals);
		return temp.toString();
	}
	
	public String forXML(){
		StringBuilder temp = new StringBuilder();
		temp.append("\t<knife>\n");
		temp.append("\t\t<ID>").append(name).append("</ID>\n");
		temp.append("\t\t<type>").append(type).append("</type>\n");
		temp.append("\t\t<handy>").append(handy).append("</handy>\n");
		temp.append("\t\t<origin>").append(origin).append("</origin>\n");
		temp.append(visuals.forXML());
		temp.append("\t\t<value>").append(value).append("</value>\n");
		temp.append("\t</knife>\n\n");
		return temp.toString();
	}
	
}
