package ua.epamcourses.task4.service.patient;

import java.util.LinkedList;

import ua.epamcourses.task4.domain.Patient;

public interface PatientService {
	LinkedList<Patient> findAll();
	Patient getPatient(Integer ID);
	LinkedList<Patient> getPatientsBySurname(String surname);
	boolean deletePatient(Integer ID);
	boolean addNewPatient(Patient patient);
	Integer findIdOfPatient(Patient patient);
}
