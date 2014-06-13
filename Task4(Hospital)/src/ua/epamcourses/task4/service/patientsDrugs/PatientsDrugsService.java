package ua.epamcourses.task4.service.patientsDrugs;

import java.util.LinkedList;

import ua.epamcourses.task4.domain.Drugs;
import ua.epamcourses.task4.domain.Patient;

public interface PatientsDrugsService {
	boolean createPatientsDrug(Patient patient, Drugs drugs);
	LinkedList<Drugs> getPatientDrugs(Patient patient);
	boolean deletePatientDrug(Patient patient, Drugs drugs);
}
