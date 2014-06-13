package ua.epamcourses.task4.repository.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import org.apache.log4j.Logger;

import ua.epamcourses.task4.domain.Procedures;
import ua.epamcourses.task4.repository.DAO.ProceduresDAO;
import ua.epamcourses.task4.repository.utils.ConnectionFactory;
import ua.epamcourses.task4.repository.utils.JDBCUtil;

public class JDBCProceduresDAO implements ProceduresDAO {

	private ConnectionFactory factory;
	private static final Logger log = Logger.getLogger(JDBCProceduresDAO.class);
	public JDBCProceduresDAO(ConnectionFactory factory) {
		this.factory = factory;
	}
	
	@Override
	public LinkedList<Procedures> findAll() {
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet res = null;
		LinkedList<Procedures> procedures = null;
		
		try {
			conn = factory.getConnection();
			stat = conn.prepareStatement("SELECT * FROM procedures;");
			res = stat.executeQuery();
			procedures = new LinkedList<Procedures>();
			res.beforeFirst();
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
	public Procedures find(Integer proceduresID) {
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet res = null;
		Procedures procedures = null;
		
		try {
			conn = factory.getConnection();
			stat = conn.prepareStatement("SELECT * FROM procedures WHERE id=?;");
			stat.setInt(1, proceduresID);
			res = stat.executeQuery();
			res.beforeFirst();
			if(res.next()){
				procedures = new Procedures();
				procedures.setProceduresID(res.getInt(1));
				procedures.setProceduresName(res.getString(2));
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
	public LinkedList<Procedures> findProceduresOfPatient(Integer patientID) {
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet res = null;
		LinkedList<Procedures> procedures = null;
		
		try {
			conn = factory.getConnection();
			stat = conn.prepareStatement("SELECT * FROM procedures WHERE procedures.ID in(SELECT proceduresID FROM patientprocedures WHERE patientID=?);");
			stat.setInt(1, patientID);
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
	public boolean createNewProcedures(String proceduresName) {
		Connection conn = null;
		PreparedStatement stat = null;
		try {
			conn = factory.getConnection();
			stat = conn.prepareStatement("INSERT INTO procedures (procName) VALUES (?);");
			stat.setString(1, proceduresName);
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
	public Integer findIdOfProcedures(String proceduresName) {
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet res = null;
		Integer result = null;
		
		try {
			conn = factory.getConnection();
			stat = conn.prepareStatement("SELECT id FROM procedures WHERE procName='?';");
			stat.setString(1, proceduresName);
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
	public boolean deleteProcedures(Integer proceduresID) {
		Connection conn = null;
		PreparedStatement stat = null;
		try {
			conn = factory.getConnection();
			stat = conn.prepareStatement("DELETE from procedures WHERE id=?;");
			stat.setInt(1, proceduresID);
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
