package ua.epamcourses.task4.repository.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import org.apache.log4j.Logger;

import ua.epamcourses.task4.domain.Drugs;
import ua.epamcourses.task4.domain.Patient;
import ua.epamcourses.task4.repository.DAO.PatientsDrugsDAO;
import ua.epamcourses.task4.repository.utils.ConnectionFactory;
import ua.epamcourses.task4.repository.utils.JDBCUtil;

public class JDBCPatientsDrugsDAO implements PatientsDrugsDAO {

	private ConnectionFactory factory;
	private static final Logger log = Logger.getLogger(JDBCPatientsDrugsDAO.class);
	public JDBCPatientsDrugsDAO(ConnectionFactory factory) {
		this.factory = factory;
	}
	
	@Override
	public boolean createPatientsDrug(Patient patient, Drugs drug) {
		Connection conn = null;
		PreparedStatement stat = null;
		try {
			conn = factory.getConnection();
			stat = conn.prepareStatement("INSERT INTO patientdrugs (patientID, drugsID) VALUES (?, ?);");
			stat.setInt(1, patient.getPatientID());
			stat.setInt(2, drug.getDrugsID());
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
	public LinkedList<Drugs> getPatientDrugs(Patient patient) {
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet res = null;
		LinkedList<Drugs> drugs = null;
		
		try {
			conn = factory.getConnection();
			stat = conn.prepareStatement("SELECT * FROM drugs WHERE drugs.ID in(SELECT drugsID FROM patientdrugs WHERE patientID=?);");
			stat.setInt(1, patient.getPatientID());
			res = stat.executeQuery();
			res.beforeFirst();
			drugs = new LinkedList<Drugs>();
			while(res.next()){
				Drugs temp = new Drugs();
				temp.setDrugsID(res.getInt(1));
				temp.setDrugsName(res.getString(2));
				drugs.add(temp);
			}
		} catch (SQLException e) {
			log.error(e);
		}finally{
			JDBCUtil.close(conn);
			JDBCUtil.close(stat);
			JDBCUtil.close(res);
		}	
		return drugs;
	}

	@Override
	public boolean deletePatientDrug(Patient patient, Drugs drug) {
		Connection conn = null;
		PreparedStatement stat = null;
		try {
			conn = factory.getConnection();
			stat = conn.prepareStatement("DELETE FROM patientdrugs WHERE patientID=? and drugsID=?;");
			stat.setInt(1, patient.getPatientID());
			stat.setInt(2, drug.getDrugsID());
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
