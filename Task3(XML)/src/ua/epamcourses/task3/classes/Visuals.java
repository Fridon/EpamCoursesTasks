package ua.epamcourses.task3.classes;

public class Visuals implements XMLFormated{
	private int length;
	private int width;
	private String material;
	private boolean woodenHandler;
	private String handle;
	private boolean sink;
	
	public Visuals(){}
	
	public int getLength() {
		return length;
	}
	
	public void setLength(int length) {
		this.length = length;
	}
	
	public int getWidth() {
		return width;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public String getMaterial() {
		return material;
	}
	
	public void setMaterial(String material) {
		this.material = material;
	}
	
	public boolean isWoodenHandler() {
		return woodenHandler;
	}
	
	public void setWoodenHandler(boolean woodenHandler) {
		this.woodenHandler = woodenHandler;
	}
	
	public String getHandle() {
		return handle;
	}
	
	public void setHandle(String handle) {
		this.handle = handle;
	}
	
	public boolean hasSink() {
		return sink;
	}
	
	public void setSink(boolean sink) {
		this.sink = sink;
	}
	
	public String toString(){
		StringBuilder temp = new StringBuilder();
		temp.append("Length: ").append(length).append("sm").append("\n");
		temp.append("Width: ").append(width).append("mm").append("\n");
		temp.append("Material: ").append(material).append("\n");
		temp.append("Wooden handle: ").append(woodenHandler).append("\n");
		temp.append("Handle: ").append(handle).append("\n");
		temp.append("Sink: ").append(sink).append("\n");	
		return temp.toString();
	}
	
	public String forXML(){
		StringBuilder temp = new StringBuilder();
		temp.append("\t\t<visuals>\n");
		temp.append("\t\t\t<length>").append(length).append("</length>\n");
		temp.append("\t\t\t<width>").append(width).append("</width>\n");
		temp.append("\t\t\t<material>").append(material).append("</material>\n");
		temp.append("\t\t\t<handle wooden = \"").append(woodenHandler).append("\">").append(handle).append("</handle>\n");
		temp.append("\t\t\t<sink>").append(sink).append("</sink>\n");
		temp.append("\t\t</visuals>\n");
		return temp.toString();
	}
}
