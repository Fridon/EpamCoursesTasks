package ua.epamcourses.task4.repository.DAO;

import ua.epamcourses.task4.domain.Diagnosis;
import ua.epamcourses.task4.domain.Patient;

public interface PatientsDiagnosisDAO {
	boolean createPatientsDiagnosis(Patient patient, Diagnosis diagnosis);
	Diagnosis getPatientDiagnosis(Patient patient);
	boolean deletePatientDiagnosis(Patient patient, Diagnosis diagnosis);
}
