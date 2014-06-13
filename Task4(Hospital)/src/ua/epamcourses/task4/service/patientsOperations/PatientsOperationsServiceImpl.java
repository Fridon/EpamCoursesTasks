package ua.epamcourses.task4.service.patientsOperations;

import java.util.LinkedList;

import ua.epamcourses.task4.domain.Operations;
import ua.epamcourses.task4.domain.Patient;
import ua.epamcourses.task4.repository.DAO.PatientsOperationsDAO;

public class PatientsOperationsServiceImpl implements PatientsOperationsService{

private PatientsOperationsDAO patientsOperationsDAO;
	
	public PatientsOperationsServiceImpl(PatientsOperationsDAO patientsOperationsDAO){
		this.patientsOperationsDAO = patientsOperationsDAO;
	}
	
	@Override
	public boolean createPatientsOperations(Patient patient,
			Operations operation) {
		return patientsOperationsDAO.createPatientsOperations(patient, operation);
	}

	@Override
	public LinkedList<Operations> getPatientOperations(Patient patient) {
		return patientsOperationsDAO.getPatientOperations(patient);
	}

	@Override
	public boolean deletePatientOperation(Patient patient, Operations operation) {
		return patientsOperationsDAO.deletePatientOperation(patient, operation);
	}

}
