package ua.epamcourses.task4.service.patientsDiagnosis;

import ua.epamcourses.task4.domain.Diagnosis;
import ua.epamcourses.task4.domain.Patient;

public interface PatientsDiagnosisService {
	boolean createPatientsDiagnosis(Patient patient, Diagnosis diagnosis);
	Diagnosis getPatientDiagnosis(Patient patient);
	boolean deletePatientDiagnosis(Patient patient, Diagnosis diagnosis);
	boolean changeDiagnosis(Patient patient, Diagnosis oldDiagnosis, Diagnosis newDiagnosis);
}
