package ua.epamcourses.task4.service.operations;

import java.util.LinkedList;

import ua.epamcourses.task4.domain.Operations;
import ua.epamcourses.task4.repository.DAO.OperationsDAO;

public class OperationsServiceImpl implements OperationsService{

	private OperationsDAO operationsDAO;
	
	public OperationsServiceImpl(OperationsDAO operationsDAO){
		this.operationsDAO = operationsDAO;
	}
	
	@Override
	public LinkedList<Operations> findAll() {
		return operationsDAO.findAll();
	}

	@Override
	public Operations find(Integer operationsID) {
		return operationsDAO.find(operationsID);
	}

	@Override
	public LinkedList<Operations> findOperationsOfPatient(Integer patientID) {
		return operationsDAO.findOperationsOfPatient(patientID);
	}

	@Override
	public boolean createNewOperations(String operationsName) {
		return operationsDAO.createNewOperations(operationsName);
	}

	@Override
	public Integer findIdOfOperations(String operationsName) {
		return operationsDAO.findIdOfOperations(operationsName);
	}

	@Override
	public boolean deleteOperation(Integer operationsID) {
		return operationsDAO.deleteOperation(operationsID);
	}

}
