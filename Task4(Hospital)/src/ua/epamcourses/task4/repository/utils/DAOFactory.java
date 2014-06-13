package ua.epamcourses.task4.repository.utils;

import ua.epamcourses.task4.repository.DAO.DiagnosisDAO;
import ua.epamcourses.task4.repository.DAO.DischargedDAO;
import ua.epamcourses.task4.repository.DAO.DrugsDAO;
import ua.epamcourses.task4.repository.DAO.OperationsDAO;
import ua.epamcourses.task4.repository.DAO.PatientDAO;
import ua.epamcourses.task4.repository.DAO.PatientsDiagnosisDAO;
import ua.epamcourses.task4.repository.DAO.PatientsDrugsDAO;
import ua.epamcourses.task4.repository.DAO.PatientsOperationsDAO;
import ua.epamcourses.task4.repository.DAO.PatientsProceduresDAO;
import ua.epamcourses.task4.repository.DAO.ProceduresDAO;
import ua.epamcourses.task4.repository.DAO.UserDAO;

public abstract class DAOFactory implements ConnectionFactory {
	
	public abstract DiagnosisDAO getDignosisDAO();
	public abstract DrugsDAO getDrugsDAO();
	public abstract OperationsDAO getOperationsDAO();
	public abstract PatientDAO getPatientDAO();
	public abstract PatientsDiagnosisDAO getPatientsDiagnosisDAO();
	public abstract PatientsDrugsDAO getPatientsDrugsDAO();
	public abstract PatientsOperationsDAO getPatientsOperationDAO();
	public abstract PatientsProceduresDAO getPatientsProceduresDAO();
	public abstract ProceduresDAO getProceduresDAO();
	public abstract UserDAO getUserDAO();
	public abstract DischargedDAO getDischargedDAO();
}
