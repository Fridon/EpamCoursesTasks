package ua.epamcourses.task4.repository.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import org.apache.log4j.Logger;

import ua.epamcourses.task4.domain.Operations;
import ua.epamcourses.task4.domain.Patient;
import ua.epamcourses.task4.repository.DAO.PatientsOperationsDAO;
import ua.epamcourses.task4.repository.utils.ConnectionFactory;
import ua.epamcourses.task4.repository.utils.JDBCUtil;

public class JDBCPatientsOperationsDAO implements PatientsOperationsDAO{

	private ConnectionFactory factory;
	private static final Logger log = Logger.getLogger(JDBCPatientsDiagnosisDAO.class);
	public JDBCPatientsOperationsDAO(ConnectionFactory factory) {
		this.factory = factory;
	}
	
	@Override
	public boolean createPatientsOperations(Patient patient,
			Operations operation) {
		Connection conn = null;
		PreparedStatement stat = null;
		try {
			conn = factory.getConnection();
			stat = conn.prepareStatement("INSERT INTO patientoperations (patientID, operationsID) VALUES (?, ?);");
			stat.setInt(1, patient.getPatientID());
			stat.setInt(2, operation.getOperationsID());
			return stat.execute();
		} catch (SQLException e) {
			log.error(e);
		}finally{
			JDBCUtil.close(conn);
			JDBCUtil.close(stat);
		}	
		return false;
	}

	@Override
	public LinkedList<Operations> getPatientOperations(Patient patient) {
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet res = null;
		LinkedList<Operations> operations = null;
		
		try {
			conn = factory.getConnection();
			stat = conn.prepareStatement("SELECT * FROM operations O WHERE O.ID in" +
					"(SELECT operationsID FROM patientoperations WHERE patientID=?);");
			stat.setInt(1, patient.getPatientID());
			res = stat.executeQuery();
			res.beforeFirst();
			operations = new LinkedList<Operations>();
			while(res.next()){
				Operations temp = new Operations();
				temp.setOperationsID(res.getInt(1));
				temp.setOperationsName(res.getString(2));
				operations.add(temp);
			}
		} catch (SQLException e) {
			log.error(e);
		}finally{
			JDBCUtil.close(conn);
			JDBCUtil.close(stat);
			JDBCUtil.close(res);
		}	
		return operations;
	}

	@Override
	public boolean deletePatientOperation(Patient patient, Operations operation) {
		Connection conn = null;
		PreparedStatement stat = null;
		try {
			conn = factory.getConnection();
			stat = conn.prepareStatement("DELETE FROM patientoperations WHERE patientID=? and operationsID=?;");
			stat.setInt(1, patient.getPatientID());
			stat.setInt(2, operation.getOperationsID());
			return stat.execute();
		} catch (SQLException e) {
			log.error(e);
		}finally{
			JDBCUtil.close(conn);
			JDBCUtil.close(stat);
		}	
		return false;
	}

}
