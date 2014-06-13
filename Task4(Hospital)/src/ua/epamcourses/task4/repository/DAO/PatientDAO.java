package ua.epamcourses.task4.repository.DAO;

import java.util.LinkedList;

import ua.epamcourses.task4.domain.Patient;

public interface PatientDAO {
	LinkedList<Patient> findAll();
	Patient find(Integer patientID);
	LinkedList<Patient> findPatientsBySurname(String surname);
	Integer findIdOfPatient(Patient patient);
	boolean addNewPatient(Patient patient);
	boolean updatePatient(Patient patient);
	boolean deletePatient(Patient patient);
	boolean deletePatientByID(Integer ID);
}
