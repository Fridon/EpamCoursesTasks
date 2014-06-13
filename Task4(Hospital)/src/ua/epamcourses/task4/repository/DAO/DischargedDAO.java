package ua.epamcourses.task4.repository.DAO;

import java.util.LinkedList;

import ua.epamcourses.task4.domain.Diagnosis;
import ua.epamcourses.task4.domain.Patient;

public interface DischargedDAO {

	boolean discargePatient(Patient patient, Diagnosis diagnosis);
	LinkedList<String> getAllDischarged();
	LinkedList<String> getAllDischargedBySurname(String surname);
	LinkedList<String> getAllDischargedByFullName(String name, String surname, String pathronimic);
}
