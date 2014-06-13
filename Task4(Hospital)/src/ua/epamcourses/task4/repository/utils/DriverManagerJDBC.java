package ua.epamcourses.task4.repository.utils;

import java.sql.Connection;
import java.sql.SQLException;

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
import ua.epamcourses.task4.repository.JDBC.JDBCDiagnosisDAO;
import ua.epamcourses.task4.repository.JDBC.JDBCDischargedDAO;
import ua.epamcourses.task4.repository.JDBC.JDBCDrugsDAO;
import ua.epamcourses.task4.repository.JDBC.JDBCOperationsDAO;
import ua.epamcourses.task4.repository.JDBC.JDBCPatientDAO;
import ua.epamcourses.task4.repository.JDBC.JDBCPatientsDiagnosisDAO;
import ua.epamcourses.task4.repository.JDBC.JDBCPatientsDrugsDAO;
import ua.epamcourses.task4.repository.JDBC.JDBCPatientsOperationsDAO;
import ua.epamcourses.task4.repository.JDBC.JDBCPatientsProceduresDAO;
import ua.epamcourses.task4.repository.JDBC.JDBCProceduresDAO;
import ua.epamcourses.task4.repository.JDBC.JDBCUserDAO;

import com.jolbox.bonecp.BoneCP;
import com.jolbox.bonecp.BoneCPConfig;

public class DriverManagerJDBC extends DAOFactory {

	private String dataBaseURL;

	BoneCP connectionPool = null;
	private static DriverManagerJDBC instance = null;
	
	private DriverManagerJDBC() {}
	
	private DriverManagerJDBC(String login, String password, String driver,
			String dataBaseURL) {

		this.dataBaseURL = dataBaseURL + "?useUnicode=true&characterEncoding=UTF-8";
		BoneCPConfig config = new BoneCPConfig();
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
	 	config.setJdbcUrl(this.dataBaseURL);
		config.setUsername(login);
		config.setPassword(password);	
		config.setMinConnectionsPerPartition(5);
        config.setMaxConnectionsPerPartition(10);
        config.setPartitionCount(1);
		try {
			connectionPool = new BoneCP(config);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public static DriverManagerJDBC getInstance(String login, String password, String driverClass,
			String dataBaseURL){
		if(instance == null)
			instance = new DriverManagerJDBC(login, password, driverClass, dataBaseURL);
		return instance;
	}
	

	public void setDataBaseURL(String dataBaseURL) {
		this.dataBaseURL = dataBaseURL;
	}

	@Override
	public Connection getConnection() throws SQLException {
	
		return connectionPool.getConnection();
	}
	
	@Override
	public void closeConnection(Connection connection) {
		JDBCUtil.close(connection);
	}

	@Override
	public DiagnosisDAO getDignosisDAO() {
		return new JDBCDiagnosisDAO(this);
	}

	@Override
	public DrugsDAO getDrugsDAO() {
		return new JDBCDrugsDAO(this);
	}

	@Override
	public OperationsDAO getOperationsDAO() {
		return new JDBCOperationsDAO(this);
	}

	@Override
	public PatientDAO getPatientDAO() {
		return new JDBCPatientDAO(this);
	}

	@Override
	public PatientsDiagnosisDAO getPatientsDiagnosisDAO() {
		return new JDBCPatientsDiagnosisDAO(this);
	}

	@Override
	public PatientsDrugsDAO getPatientsDrugsDAO() {
		return new JDBCPatientsDrugsDAO(this);
	}

	@Override
	public PatientsOperationsDAO getPatientsOperationDAO() {
		return new JDBCPatientsOperationsDAO(this);
	}

	@Override
	public PatientsProceduresDAO getPatientsProceduresDAO() {
		return new JDBCPatientsProceduresDAO(this);
	}

	@Override
	public ProceduresDAO getProceduresDAO() {
		return new JDBCProceduresDAO(this);
	}

	@Override
	public UserDAO getUserDAO() {
		return new JDBCUserDAO(this);
	}

	@Override
	public DischargedDAO getDischargedDAO() {
		return new JDBCDischargedDAO(this);
	}
	
	
}
