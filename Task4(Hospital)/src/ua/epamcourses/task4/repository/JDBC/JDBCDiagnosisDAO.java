package ua.epamcourses.task4.repository.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import org.apache.log4j.Logger;

import ua.epamcourses.task4.domain.Diagnosis;
import ua.epamcourses.task4.repository.DAO.DiagnosisDAO;
import ua.epamcourses.task4.repository.utils.ConnectionFactory;
import ua.epamcourses.task4.repository.utils.JDBCUtil;

public class JDBCDiagnosisDAO implements DiagnosisDAO {

	private ConnectionFactory factory;
	private static final Logger log = Logger.getLogger(JDBCDiagnosisDAO.class);
	public JDBCDiagnosisDAO(ConnectionFactory factory) {
		this.factory = factory;
	}

	@Override
	public LinkedList<Diagnosis> findAll() {
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet res = null;
		LinkedList<Diagnosis> diagnosis = null;
		
		try {
			conn = factory.getConnection();
			stat = conn.prepareStatement("SELECT * FROM diagnosis;");
			res = stat.executeQuery();
			diagnosis = new LinkedList<Diagnosis>();
			res.beforeFirst();
			while(res.next()){
				Diagnosis temp = new Diagnosis();
				temp.setDiagnosisID(res.getInt(1));
				temp.setDiagnosisName(res.getString(2));
				diagnosis.add(temp);
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
	public Diagnosis find(Integer diagnosisID) {
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet res = null;
		Diagnosis diagnosis = null;
		
		try {
			conn = factory.getConnection();
			stat = conn.prepareStatement("SELECT * FROM diagnosis WHERE id=?;");
			stat.setInt(1, diagnosisID);
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
	public Diagnosis findDiagnosisOfPatient(Integer patientID) {
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet res = null;
		Diagnosis diagnosis = null;
		
		try {
			conn = factory.getConnection();
			stat = conn.prepareStatement("SELECT * FROM diagnosis WHERE diagnosis.ID in(SELECT diagnosisID FROM patientdiagnosis WHERE patientID=?);");
			stat.setInt(1, patientID);
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
	public boolean createNewDiagnosis(String diagnosisName) {
		Connection conn = null;
		PreparedStatement stat = null;
		try {
			conn = factory.getConnection();
			stat = conn.prepareStatement("INSERT INTO diagnosis (diaName) VALUES (?);");
			stat.setString(1, diagnosisName);
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
	public Integer findIdOfDiagnosis(String diagnosisName) {
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet res = null;
		Integer result = null;
		
		try {
			conn = factory.getConnection();
			stat = conn.prepareStatement("SELECT id FROM diagnosis WHERE diaName='?';");
			stat.setString(1, diagnosisName);
			res = stat.executeQuery();
			res.beforeFirst();
			if(res.next()){
				result = res.getInt(1);
			}
		} catch (SQLException e) {
			log.error(e);
		}finally{
			JDBCUtil.close(conn);
			JDBCUtil.close(stat);
			JDBCUtil.close(res);
		}	
		return result;
	}

	
	@Override
	public boolean deleteDiagnosis(Integer diagnosisID) {
		Connection conn = null;
		PreparedStatement stat = null;
		try {
			conn = factory.getConnection();
			stat = conn.prepareStatement("DELETE from diagnosis WHERE id=?;");
			stat.setInt(1, diagnosisID);
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
