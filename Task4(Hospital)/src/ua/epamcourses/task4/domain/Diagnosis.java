package ua.epamcourses.task4.domain;

public class Diagnosis {
	private Integer diagnosisID;
	private String diagnosisName;
	
	public Diagnosis(){};
	
	public Diagnosis(Integer diagnosisID, String diagnosisName){
		this.diagnosisID = diagnosisID;
		this.diagnosisName = diagnosisName;
	}

	public Integer getDiagnosisID() {
		return diagnosisID;
	}

	public void setDiagnosisID(Integer diagnosisID) {
		this.diagnosisID = diagnosisID;
	}

	public String getDiagnosisName() {
		return diagnosisName;
	}

	public void setDiagnosisName(String diagnosisName) {
		this.diagnosisName = diagnosisName;
	}
	
}
