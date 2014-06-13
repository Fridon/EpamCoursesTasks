package ua.epamcourses.task4.repository.DAO;

import java.util.LinkedList;

import ua.epamcourses.task4.domain.Patient;
import ua.epamcourses.task4.domain.Procedures;

public interface PatientsProceduresDAO {
	boolean createPatientsProcedures(Patient patient, Procedures procedures);
	LinkedList<Procedures> getPatientProcedures(Patient patient);
	boolean deletePatientProcedures(Patient patient, Procedures procedure);
}
