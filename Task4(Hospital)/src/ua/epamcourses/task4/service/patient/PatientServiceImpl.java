package ua.epamcourses.task4.service.patient;

import java.util.LinkedList;

import ua.epamcourses.task4.domain.Patient;
import ua.epamcourses.task4.repository.DAO.PatientDAO;

public class PatientServiceImpl implements PatientService {

	private PatientDAO patientDAO;
	
	public PatientServiceImpl(PatientDAO patientDAO){
		this.patientDAO = patientDAO;
	}
	
	@Override
	public LinkedList<Patient> findAll() {
		return patientDAO.findAll();
	}

	@Override
	public Patient getPatient(Integer ID) {
		return patientDAO.find(ID);
	}

	@Override
	public LinkedList<Patient> getPatientsBySurname(String surname) {
		return patientDAO.findPatientsBySurname(surname);
	}

	@Override
	public boolean deletePatient(Integer ID) {
		return patientDAO.deletePatientByID(ID);
	}

	@Override
	public boolean addNewPatient(Patient patient) {
		return patientDAO.addNewPatient(patient);
	}

	@Override
	public Integer findIdOfPatient(Patient patient) {
		return patientDAO.findIdOfPatient(patient);
	}

}
