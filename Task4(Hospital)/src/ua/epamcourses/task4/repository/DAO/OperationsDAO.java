package ua.epamcourses.task4.repository.DAO;

import java.util.LinkedList;

import ua.epamcourses.task4.domain.Operations;

public interface OperationsDAO {
	LinkedList<Operations> findAll();
	Operations find(Integer operationsID);
	LinkedList<Operations> findOperationsOfPatient(Integer patientID);
	boolean createNewOperations(String operationsName);
	Integer findIdOfOperations(String operationsName);
	boolean deleteOperation(Integer operationsID);
}
