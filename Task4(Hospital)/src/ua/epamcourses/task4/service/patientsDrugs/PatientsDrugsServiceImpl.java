package ua.epamcourses.task4.service.patientsDrugs;

import java.util.LinkedList;

import ua.epamcourses.task4.domain.Drugs;
import ua.epamcourses.task4.domain.Patient;
import ua.epamcourses.task4.repository.DAO.PatientsDrugsDAO;

public class PatientsDrugsServiceImpl implements PatientsDrugsService {
	
	private PatientsDrugsDAO patientsDrugsDAO;
	
	public PatientsDrugsServiceImpl(PatientsDrugsDAO patientsDrugsDAO){
		this.patientsDrugsDAO = patientsDrugsDAO;
	}
	
	@Override
	public boolean createPatientsDrug(Patient patient, Drugs drugs) {
		return patientsDrugsDAO.createPatientsDrug(patient, drugs);
	}

	@Override
	public LinkedList<Drugs> getPatientDrugs(Patient patient) {
		return patientsDrugsDAO.getPatientDrugs(patient);
	}

	@Override
	public boolean deletePatientDrug(Patient patient, Drugs drugs) {
		return patientsDrugsDAO.deletePatientDrug(patient, drugs);
	}

}
