package ua.epamcourses.task4.service.patientsDiagnosis;

import ua.epamcourses.task4.domain.Diagnosis;
import ua.epamcourses.task4.domain.Patient;
import ua.epamcourses.task4.repository.DAO.PatientsDiagnosisDAO;


public class PatientsDiagnosisServiceImpl implements PatientsDiagnosisService{
	private PatientsDiagnosisDAO patientsDiagnosisDAO;
	
	public PatientsDiagnosisServiceImpl(PatientsDiagnosisDAO patientsDiagnosisDAO){
		this.patientsDiagnosisDAO = patientsDiagnosisDAO;
	}

	@Override
	public boolean createPatientsDiagnosis(Patient patient, Diagnosis diagnosis) {
		return patientsDiagnosisDAO.createPatientsDiagnosis(patient, diagnosis);
	}

	@Override
	public Diagnosis getPatientDiagnosis(Patient patient) {
		return patientsDiagnosisDAO.getPatientDiagnosis(patient);
	}

	@Override
	public boolean deletePatientDiagnosis(Patient patient, Diagnosis diagnosis) {
		return patientsDiagnosisDAO.deletePatientDiagnosis(patient, diagnosis);
	}

	@Override
	public boolean changeDiagnosis(Patient patient, Diagnosis oldDiagnosis,
			Diagnosis newDiagnosis) {
		deletePatientDiagnosis(patient, oldDiagnosis);
		return createPatientsDiagnosis(patient, newDiagnosis);
	}
}
