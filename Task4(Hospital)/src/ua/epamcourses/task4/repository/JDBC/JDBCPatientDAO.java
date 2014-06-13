package ua.epamcourses.task4.repository.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import org.apache.log4j.Logger;

import ua.epamcourses.task4.domain.Patient;
import ua.epamcourses.task4.repository.DAO.PatientDAO;
import ua.epamcourses.task4.repository.utils.ConnectionFactory;
import ua.epamcourses.task4.repository.utils.JDBCUtil;

public class JDBCPatientDAO implements PatientDAO {

	private ConnectionFactory factory;
	private static final Logger log = Logger.getLogger(JDBCPatientDAO.class);
	public JDBCPatientDAO(ConnectionFactory factory) {
		this.factory = factory;
	}
	
	@Override
	public LinkedList<Patient> findAll() {
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet res = null;
		LinkedList<Patient> patients = null;
		
		try {
			conn = factory.getConnection();
			stat = conn.prepareStatement("SELECT * FROM patients;");
			res = stat.executeQuery();
			patients = new LinkedList<Patient>();
			res.beforeFirst();
			while(res.next()){
				Patient temp = new Patient();
				temp.setPatientID(res.getInt(1));
				temp.setName(res.getString(2));
				temp.setSurname(res.getString(3));
				temp.setPathronimic(res.getString(4));
				patients.add(temp);
			}		
		} catch (SQLException e) {
			log.error(e);
		}finally{
			JDBCUtil.close(conn);
			JDBCUtil.close(stat);
			JDBCUtil.close(res);
		}	
		return patients;
	}

	@Override
	public Patient find(Integer patientID) {
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet res = null;
		Patient patient = null;
		
		try {
			conn = factory.getConnection();
			stat = conn.prepareStatement("SELECT * FROM patients WHERE id=?;");
			stat.setInt(1, patientID);
			res = stat.executeQuery();
			res.beforeFirst();
			if(res.next()){
				patient = new Patient();
				patient.setPatientID(res.getInt(1));
				patient.setName(res.getString(2));
				patient.setSurname(res.getString(3));
				patient.setPathronimic(res.getString(4));
			}
		} catch (SQLException e) {
			log.error(e);
		}finally{
			JDBCUtil.close(conn);
			JDBCUtil.close(stat);
			JDBCUtil.close(res);
		}	
		return patient;
	}

	@Override
	public LinkedList<Patient> findPatientsBySurname(String surname) {
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet res = null;
		LinkedList<Patient> patients = null;
		
		try {
			conn = factory.getConnection();
			stat = conn.prepareStatement("SELECT * FROM patients WHERE surname = ?;");
			stat.setString(1, surname);
			res = stat.executeQuery();
			patients = new LinkedList<Patient>();
			res.beforeFirst();
			while(res.next()){
				Patient temp = new Patient();
				temp.setPatientID(res.getInt(1));
				temp.setName(res.getString(2));
				temp.setSurname(res.getString(3));
				temp.setPathronimic(res.getString(4));
				patients.add(temp);
			}		
		} catch (SQLException e) {
			log.error(e);
		}finally{
			JDBCUtil.close(conn);
			JDBCUtil.close(stat);
			JDBCUtil.close(res);
		}	
		return patients;
	}

	@Override
	public boolean addNewPatient(Patient patient) {
		Connection conn = null;
		PreparedStatement stat = null;
		try {
			conn = factory.getConnection();
			stat = conn.prepareStatement("INSERT INTO patients (Name, Surname, Pathronimic) VALUES (?,?,?);");
			stat.setString(1, patient.getName());
			stat.setString(2, patient.getSurname());
			stat.setString(3, patient.getPathronimic());
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
	public boolean updatePatient(Patient patient) {
		Connection conn = null;
		PreparedStatement stat = null;
		try {
			conn = factory.getConnection();
			stat = conn.prepareStatement("UPDATE patients SET Name=?, Surname=?, Pathronimic=? WHERE id=?;");
			stat.setString(1, patient.getName());
			stat.setString(2, patient.getSurname());
			stat.setString(3, patient.getPathronimic());
			stat.setInt(4, patient.getPatientID());
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
	public boolean deletePatient(Patient patient) {	
		return deletePatientByID(patient.getPatientID());
	}

	@Override
	public boolean deletePatientByID(Integer ID) {
		Connection conn = null;
		PreparedStatement stat = null;
		try {
			conn = factory.getConnection();
			stat = conn.prepareStatement("DELETE from patients WHERE id=?;");
			stat.setInt(1, ID);
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
	public Integer findIdOfPatient(Patient patient) {
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet res = null;
		Integer result = null;
		
		try {
			conn = factory.getConnection();
			stat = conn.prepareStatement("SELECT id FROM patients WHERE name=? and surname=? and pathronimic=?;");
			stat.setString(1, patient.getName());
			stat.setString(2, patient.getSurname());
			stat.setString(3, patient.getPathronimic());
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
	
}
