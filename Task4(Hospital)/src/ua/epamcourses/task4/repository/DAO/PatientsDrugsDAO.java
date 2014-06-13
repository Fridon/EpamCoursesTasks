package ua.epamcourses.task4.repository.DAO;

import java.util.LinkedList;

import ua.epamcourses.task4.domain.Drugs;
import ua.epamcourses.task4.domain.Patient;

public interface PatientsDrugsDAO {
	boolean createPatientsDrug(Patient patient, Drugs drugs);
	LinkedList<Drugs> getPatientDrugs(Patient patient);
	boolean deletePatientDrug(Patient patient, Drugs drugs);
}
