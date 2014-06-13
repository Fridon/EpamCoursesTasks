package ua.epamcourses.task4.service.procedures;

import java.util.LinkedList;

import ua.epamcourses.task4.domain.Procedures;
import ua.epamcourses.task4.repository.DAO.ProceduresDAO;

public class ProceduresServiceImpl implements ProceduresService{

	private ProceduresDAO proceduresDAO;
	
	public ProceduresServiceImpl(ProceduresDAO proceduresDAO){
		this.proceduresDAO = proceduresDAO;
	}
	
	@Override
	public LinkedList<Procedures> findAll() {
		return proceduresDAO.findAll();
	}

	@Override
	public Procedures find(Integer proceduresID) {
		return proceduresDAO.find(proceduresID);
	}

	@Override
	public LinkedList<Procedures> findProceduresOfPatient(Integer patientID) {
		return proceduresDAO.findProceduresOfPatient(patientID);
	}

	@Override
	public boolean createNewProcedures(String proceduresName) {
		return proceduresDAO.createNewProcedures(proceduresName);
	}

	@Override
	public Integer findIdOfProcedures(String proceduresName) {
		return proceduresDAO.findIdOfProcedures(proceduresName);
	}

	@Override
	public boolean deleteProcedures(Integer proceduresID) {
		return proceduresDAO.deleteProcedures(proceduresID);
	}

}
