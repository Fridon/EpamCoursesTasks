package ua.epamcourses.task4.repository.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import org.apache.log4j.Logger;

import ua.epamcourses.task4.domain.Diagnosis;
import ua.epamcourses.task4.domain.Patient;
import ua.epamcourses.task4.repository.DAO.DischargedDAO;
import ua.epamcourses.task4.repository.utils.ConnectionFactory;
import ua.epamcourses.task4.repository.utils.JDBCUtil;

public class JDBCDischargedDAO implements DischargedDAO {

	private ConnectionFactory factory;
	private static final Logger log = Logger.getLogger(JDBCDiagnosisDAO.class);
	
	public JDBCDischargedDAO(ConnectionFactory factory) {
		this.factory = factory;
	}
	
	@Override
	public boolean discargePatient(Patient patient, Diagnosis diagnosis) {
		
		Connection conn = null;
		PreparedStatement stat = null;
		try {
			conn = factory.getConnection();
			stat = conn.prepareStatement("INSERT INTO discharged (patientID, name, surname, pathronimic, diagnosisName)" +
					" VALUES (?,?,?,?,?);");
			stat.setInt(1, patient.getPatientID());
			stat.setString(2, patient.getName());
			stat.setString(3, patient.getSurname());
			stat.setString(4, patient.getPathronimic());
			stat.setString(5, diagnosis.getDiagnosisName());
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
	public LinkedList<String> getAllDischarged() {
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet res = null;
		LinkedList<String> discharged = null;
		
		try {
			conn = factory.getConnection();
			stat = conn.prepareStatement("SELECT * FROM discharged;");
			res = stat.executeQuery();
			discharged = new LinkedList<String>();
			res.beforeFirst();
			while(res.next()){
				StringBuilder sb = new StringBuilder();
				sb.append(res.getInt(1)).append(". ");
				sb.append(res.getString(2)).append(" ");
				sb.append(res.getString(3)).append(" ");
				sb.append(res.getString(4)).append(" - ");
				sb.append(res.getString(5)).append(".");	
				discharged.add(sb.toString());
			}
		} catch (SQLException e) {
			log.error(e);
		}finally{
			JDBCUtil.close(conn);
			JDBCUtil.close(stat);
			JDBCUtil.close(res);
		}	
		return discharged;
	}

	@Override
	public LinkedList<String> getAllDischargedBySurname(String surname) {
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet res = null;
		LinkedList<String> discharged = null;
		
		try {
			conn = factory.getConnection();
			stat = conn.prepareStatement("SELECT * FROM discharged WHERE surname = ?;");
			stat.setString(1, surname);
			res = stat.executeQuery();
			discharged = new LinkedList<String>();
			res.beforeFirst();
			while(res.next()){
				StringBuilder sb = new StringBuilder();
				sb.append(res.getInt(1)).append(". ");
				sb.append(res.getString(2)).append(" ");
				sb.append(res.getString(3)).append(" ");
				sb.append(res.getString(4)).append(" - ");
				sb.append(res.getString(5)).append(".");	
				discharged.add(sb.toString());
			}
		} catch (SQLException e) {
			log.error(e);
		}finally{
			JDBCUtil.close(conn);
			JDBCUtil.close(stat);
			JDBCUtil.close(res);
		}	
		return discharged;
	}

	@Override
	public LinkedList<String> getAllDischargedByFullName(String name,
			String surname, String pathronimic) {
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet res = null;
		LinkedList<String> discharged = null;
		
		try {
			conn = factory.getConnection();
			stat = conn.prepareStatement("SELECT * FROM discharged WHERE name=? and surname=? and pathronimic=?;");
			stat.setString(1, name);
			stat.setString(2, surname);
			stat.setString(3, pathronimic);
			res = stat.executeQuery();
			discharged = new LinkedList<String>();
			res.beforeFirst();
			while(res.next()){
				StringBuilder sb = new StringBuilder();
				sb.append(res.getInt(1)).append(". ");
				sb.append(res.getString(2)).append(" ");
				sb.append(res.getString(3)).append(" ");
				sb.append(res.getString(4)).append(" - ");
				sb.append(res.getString(5)).append(".");	
				discharged.add(sb.toString());
			}
		} catch (SQLException e) {
			log.error(e);
		}finally{
			JDBCUtil.close(conn);
			JDBCUtil.close(stat);
			JDBCUtil.close(res);
		}	
		return discharged;
	}

}
