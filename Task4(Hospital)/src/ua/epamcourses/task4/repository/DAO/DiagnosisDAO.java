package ua.epamcourses.task4.repository.DAO;

import java.util.LinkedList;

import ua.epamcourses.task4.domain.Diagnosis;

public interface DiagnosisDAO {
	LinkedList<Diagnosis> findAll();
	Diagnosis find(Integer diagnosisID);
	Diagnosis findDiagnosisOfPatient(Integer patientID);
	boolean createNewDiagnosis(String diagnosisName);
	Integer findIdOfDiagnosis(String diagnosisName);
	boolean deleteDiagnosis(Integer diagnosisID);
}
