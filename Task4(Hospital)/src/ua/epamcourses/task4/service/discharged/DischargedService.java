package ua.epamcourses.task4.service.discharged;

import java.util.LinkedList;

import ua.epamcourses.task4.domain.Diagnosis;
import ua.epamcourses.task4.domain.Patient;

public interface DischargedService {
	boolean discargePatient(Patient patient, Diagnosis diagnosis);
	LinkedList<String> getAllDischarged();
	LinkedList<String> getAllDischargedBySurname(String surname);
	LinkedList<String> getAllDischargedByFullName(String name, String surname, String pathronimic);
}
