package ua.epamcourses.task4.service.discharged;

import java.util.LinkedList;

import ua.epamcourses.task4.domain.Diagnosis;
import ua.epamcourses.task4.domain.Patient;
import ua.epamcourses.task4.repository.DAO.DischargedDAO;

public class DischargedServiseImpl implements DischargedService {

	private DischargedDAO dischargedDAO;
	
	public DischargedServiseImpl(DischargedDAO dischargedDAO){
		this.dischargedDAO = dischargedDAO;
	}
	
	@Override
	public boolean discargePatient(Patient patient, Diagnosis diagnosis) {
		return dischargedDAO.discargePatient(patient, diagnosis);
	}

	@Override
	public LinkedList<String> getAllDischarged() {
		return dischargedDAO.getAllDischarged();
	}

	@Override
	public LinkedList<String> getAllDischargedBySurname(String surname) {
		return dischargedDAO.getAllDischargedBySurname(surname);
	}

	@Override
	public LinkedList<String> getAllDischargedByFullName(String name,
			String surname, String pathronimic) {
		return dischargedDAO.getAllDischargedByFullName(name, surname, pathronimic);
	}

}
