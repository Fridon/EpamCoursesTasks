package ua.epamcourses.task4.domain;

public class Operations {

	private Integer operationsID;
	private String operationsName;
	
	public Operations() {}

	public Operations(Integer operationsID, String operationsName) {
		this.operationsID = operationsID;
		this.operationsName = operationsName;
	}

	public Integer getOperationsID() {
		return operationsID;
	}

	public void setOperationsID(Integer operationsID) {
		this.operationsID = operationsID;
	}

	public String getOperationsName() {
		return operationsName;
	}

	public void setOperationsName(String operationsName) {
		this.operationsName = operationsName;
	}
}
