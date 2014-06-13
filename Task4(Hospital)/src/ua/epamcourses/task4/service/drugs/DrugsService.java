package ua.epamcourses.task4.service.drugs;

import java.util.LinkedList;

import ua.epamcourses.task4.domain.Drugs;

public interface DrugsService {
	LinkedList<Drugs> findAll();
	Drugs find(Integer drugsID);
	LinkedList<Drugs> findDrugsOfPatient(Integer patientID);
	boolean createNewDrugs(String drugsName);
	Integer findIdOfDrugs(String drugsName);
	boolean deleteDrugs(Integer drugsID);
}
