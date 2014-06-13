package ua.epamcourses.task4.repository.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import ua.epamcourses.task4.domain.Diagnosis;
import ua.epamcourses.task4.domain.Patient;
import ua.epamcourses.task4.repository.DAO.PatientsDiagnosisDAO;
import ua.epamcourses.task4.repository.utils.ConnectionFactory;
import ua.epamcourses.task4.repository.utils.JDBCUtil;

public class JDBCPatientsDiagnosisDAO implements PatientsDiagnosisDAO{
	
	
	private ConnectionFactory factory;
	private static final Logger log = Logger.getLogger(JDBCPatientsProceduresDAO.class);
	
	public JDBCPatientsDiagnosisDAO(ConnectionFactory factory) {
		this.factory = factory;
	}
	
	@Override
	public Diagnosis getPatientDiagnosis(Patient patient) {
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet res = null;
		Diagnosis diagnosis = null;
		
		try {
			conn = factory.getConnection();
			stat = conn.prepareStatement("SELECT * FROM diagnosis D WHERE D.ID in(SELECT diagnosisID FROM patientdiagnosis WHERE patientID=?);");
			stat.setInt(1, patient.getPatientID());
			res = stat.executeQuery();
			res.beforeFirst();
			if(res.next()){
				diagnosis = new Diagnosis();
				diagnosis.setDiagnosisID(res.getInt(1));
				diagnosis.setDiagnosisName(res.getString(2));
			}
		} catch (SQLException e) {
			log.error(e);
		}finally{
			JDBCUtil.close(conn);
			JDBCUtil.close(stat);
			JDBCUtil.close(res);
		}	
		return diagnosis;
	}

	@Override
	public boolean deletePatientDiagnosis(Patient patient, Diagnosis diagnosis) {
		Connection conn = null;
		PreparedStatement stat = null;
		try {
			conn = factory.getConnection();
			stat = conn.prepareStatement("DELETE FROM patientdiagnosis WHERE patientID=? and diagnosisID=?;");
			stat.setInt(1, patient.getPatientID());
			stat.setInt(2, diagnosis.getDiagnosisID());
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
	public boolean createPatientsDiagnosis(Patient patient, Diagnosis diagnosis) {
		Connection conn = null;
		PreparedStatement stat = null;
		try {
			conn = factory.getConnection();
			stat = conn.prepareStatement("INSERT INTO patientdiagnosis (patientID, diagnosisID) VALUES (?, ?);");
			stat.setInt(1, patient.getPatientID());
			stat.setInt(2, diagnosis.getDiagnosisID());
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
