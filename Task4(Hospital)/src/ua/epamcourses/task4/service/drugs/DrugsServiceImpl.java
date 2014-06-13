package ua.epamcourses.task4.service.drugs;

import java.util.LinkedList;

import ua.epamcourses.task4.domain.Drugs;
import ua.epamcourses.task4.repository.DAO.DrugsDAO;

public class DrugsServiceImpl implements DrugsService{

	private DrugsDAO drugsDAO;
	
	public DrugsServiceImpl(DrugsDAO drugsDAO){
		this.drugsDAO = drugsDAO;
	}
	
	@Override
	public LinkedList<Drugs> findAll() {
		return drugsDAO.findAll();
	}

	@Override
	public Drugs find(Integer drugsID) {
		return drugsDAO.find(drugsID);
	}

	@Override
	public LinkedList<Drugs> findDrugsOfPatient(Integer patientID) {
		return drugsDAO.findDrugsOfPatient(patientID);
	}

	@Override
	public boolean createNewDrugs(String drugsName) {
		return drugsDAO.createNewDrugs(drugsName);
	}

	@Override
	public Integer findIdOfDrugs(String drugsName) {
		return drugsDAO.findIdOfDrugs(drugsName);
	}

	@Override
	public boolean deleteDrugs(Integer drugsID) {
		return drugsDAO.deleteDrugs(drugsID);
	}

}
