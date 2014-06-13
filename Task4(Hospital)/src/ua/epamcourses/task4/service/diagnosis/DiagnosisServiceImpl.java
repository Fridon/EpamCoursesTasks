package ua.epamcourses.task4.service.diagnosis;

import java.util.LinkedList;

import ua.epamcourses.task4.domain.Diagnosis;
import ua.epamcourses.task4.repository.DAO.DiagnosisDAO;

public class DiagnosisServiceImpl implements DiagnosisService{

	private DiagnosisDAO diagnosisDAO;
	
	public DiagnosisServiceImpl(DiagnosisDAO diagnosisDAO){
		this.diagnosisDAO = diagnosisDAO;
	}
	
	@Override
	public LinkedList<Diagnosis> findAll() {
		return diagnosisDAO.findAll();
	}

	@Override
	public Diagnosis find(Integer diagnosisID) {
		return diagnosisDAO.find(diagnosisID);
	}

	@Override
	public Diagnosis findDiagnosisOfPatient(Integer patientID) {
		return diagnosisDAO.find(patientID);
	}

	@Override
	public boolean createNewDiagnosis(String diagnosisName) {
		return diagnosisDAO.createNewDiagnosis(diagnosisName);
	}

	@Override
	public Integer findIdOfDiagnosis(String diagnosisName) {
		return diagnosisDAO.findIdOfDiagnosis(diagnosisName);
	}

	@Override
	public boolean deleteDiagnosis(Integer diagnosisID) {
		return diagnosisDAO.deleteDiagnosis(diagnosisID);
	}

}
