package ua.epamcourses.task4.repository.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import org.apache.log4j.Logger;

import ua.epamcourses.task4.domain.Patient;
import ua.epamcourses.task4.domain.Procedures;
import ua.epamcourses.task4.repository.DAO.PatientsProceduresDAO;
import ua.epamcourses.task4.repository.utils.ConnectionFactory;
import ua.epamcourses.task4.repository.utils.JDBCUtil;

public class JDBCPatientsProceduresDAO implements PatientsProceduresDAO {

	private ConnectionFactory factory;
	private static final Logger log = Logger.getLogger(JDBCPatientsProceduresDAO.class);
	public JDBCPatientsProceduresDAO(ConnectionFactory factory) {
		this.factory = factory;
	}
	
	@Override
	public boolean createPatientsProcedures(Patient patient,
			Procedures procedures) {
		Connection conn = null;
		PreparedStatement stat = null;
		try {
			conn = factory.getConnection();
			stat = conn.prepareStatement("INSERT INTO patientprocedures (patientID, proceduresID) VALUES (?, ?);");
			stat.setInt(1, patient.getPatientID());
			stat.setInt(2, procedures.getProceduresID());
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
	public LinkedList<Procedures> getPatientProcedures(Patient patient) {
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet res = null;
		LinkedList<Procedures> procedures = null;
		
		try {
			conn = factory.getConnection();
			stat = conn.prepareStatement("SELECT * FROM procedures P WHERE P.ID in" +
					"(SELECT proceduresID FROM patientprocedures WHERE patientID=?);");
			stat.setInt(1, patient.getPatientID());
			res = stat.executeQuery();
			res.beforeFirst();
			procedures = new LinkedList<Procedures>();
			while(res.next()){
				Procedures temp = new Procedures();
				temp.setProceduresID(res.getInt(1));
				temp.setProceduresName(res.getString(2));
				procedures.add(temp);
			}
		} catch (SQLException e) {
			log.error(e);
		}finally{
			JDBCUtil.close(conn);
			JDBCUtil.close(stat);
			JDBCUtil.close(res);
		}	
		return procedures;
	}

	@Override
	public boolean deletePatientProcedures(Patient patient, Procedures procedure) {
		Connection conn = null;
		PreparedStatement stat = null;
		try {
			conn = factory.getConnection();
			stat = conn.prepareStatement("DELETE FROM patientprocedures WHERE patientID=? and proceduresID=?;");
			stat.setInt(1, patient.getPatientID());
			stat.setInt(2, procedure.getProceduresID());
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
