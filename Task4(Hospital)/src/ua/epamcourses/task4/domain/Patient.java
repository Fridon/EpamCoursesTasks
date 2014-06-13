package ua.epamcourses.task4.domain;

public class Patient {

	private Integer patientID;
	private String name;
	private String surname;
	private String pathronimic;

	public Patient() {}

	public Patient(Integer patientID, String name, String surname,
			String pathronimic) {
		this.patientID = patientID;
		this.name = name;
		this.surname = surname;
		this.pathronimic = pathronimic;
	}

	public Integer getPatientID() {
		return patientID;
	}

	public void setPatientID(Integer patientID) {
		this.patientID = patientID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPathronimic() {
		return pathronimic;
	}

	public void setPathronimic(String pathronimic) {
		this.pathronimic = pathronimic;
	}

}
