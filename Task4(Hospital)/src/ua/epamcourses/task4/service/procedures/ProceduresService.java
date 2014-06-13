package ua.epamcourses.task4.service.procedures;

import java.util.LinkedList;

import ua.epamcourses.task4.domain.Procedures;

public interface ProceduresService {
	LinkedList<Procedures> findAll();
	Procedures find(Integer proceduresID);
	LinkedList<Procedures> findProceduresOfPatient(Integer patientID);
	boolean createNewProcedures(String proceduresName);
	Integer findIdOfProcedures(String proceduresName);
	boolean deleteProcedures(Integer proceduresID);
}
