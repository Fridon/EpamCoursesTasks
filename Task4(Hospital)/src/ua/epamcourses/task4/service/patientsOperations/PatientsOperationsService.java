package ua.epamcourses.task4.service.patientsOperations;

import java.util.LinkedList;

import ua.epamcourses.task4.domain.Operations;
import ua.epamcourses.task4.domain.Patient;

public interface PatientsOperationsService {
	
	boolean createPatientsOperations(Patient patient, Operations operation);
	LinkedList<Operations> getPatientOperations(Patient patient);
	boolean deletePatientOperation(Patient patient, Operations operation);
}
