package ua.epamcourses.task4.domain;

public class Procedures {
	
	private Integer proceduresID;
	private String proceduresName;
	
	public Procedures() {	}

	public Procedures(Integer proceduresID, String proceduresName) {
		this.proceduresID = proceduresID;
		this.proceduresName = proceduresName;
	}

	public Integer getProceduresID() {
		return proceduresID;
	}

	public void setProceduresID(Integer proceduresID) {
		this.proceduresID = proceduresID;
	}

	public String getProceduresName() {
		return proceduresName;
	}

	public void setProceduresName(String proceduresName) {
		this.proceduresName = proceduresName;
	}	
}
