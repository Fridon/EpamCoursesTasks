package ua.epamcourses.task4.repository.DAO;

import java.util.LinkedList;

import ua.epamcourses.task4.domain.Procedures;

public interface ProceduresDAO {
	LinkedList<Procedures> findAll();
	Procedures find(Integer proceduresID);
	LinkedList<Procedures> findProceduresOfPatient(Integer patientID);
	boolean createNewProcedures(String proceduresName);
	Integer findIdOfProcedures(String proceduresName);
	boolean deleteProcedures(Integer proceduresID);
}
