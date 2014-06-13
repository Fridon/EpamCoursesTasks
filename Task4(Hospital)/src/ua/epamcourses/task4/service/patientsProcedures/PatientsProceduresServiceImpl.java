package ua.epamcourses.task4.service.patientsProcedures;

import java.util.LinkedList;

import ua.epamcourses.task4.domain.Patient;
import ua.epamcourses.task4.domain.Procedures;
import ua.epamcourses.task4.repository.DAO.PatientsProceduresDAO;

public class PatientsProceduresServiceImpl implements PatientsProceduresService{
	
	private PatientsProceduresDAO patientsProceduresDAO;
	
	public PatientsProceduresServiceImpl(PatientsProceduresDAO patientsProceduresDAO){
		this.patientsProceduresDAO = patientsProceduresDAO;
	}
	
	@Override
	public boolean createPatientsProcedures(Patient patient,
			Procedures procedures) {
		return patientsProceduresDAO.createPatientsProcedures(patient, procedures);
	}

	@Override
	public LinkedList<Procedures> getPatientProcedures(Patient patient) {
		return patientsProceduresDAO.getPatientProcedures(patient);
	}

	@Override
	public boolean deletePatientProcedures(Patient patient, Procedures procedure) {
		return patientsProceduresDAO.deletePatientProcedures(patient, procedure);
	}

}
