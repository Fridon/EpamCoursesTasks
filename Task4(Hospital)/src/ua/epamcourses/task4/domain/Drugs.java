package ua.epamcourses.task4.domain;

public class Drugs {
	private Integer drugsID;
	private String drugsName;
	
	public Drugs(){}
	
	public Drugs(Integer drugsID, String drugsName) {
		this.drugsID = drugsID;
		this.drugsName = drugsName;
	}

	public Integer getDrugsID() {
		return drugsID;
	}

	public void setDrugsID(Integer drugsID) {
		this.drugsID = drugsID;
	}

	public String getDrugsName() {
		return drugsName;
	}

	public void setDrugsName(String drugssName) {
		this.drugsName = drugssName;
	}
	
}
