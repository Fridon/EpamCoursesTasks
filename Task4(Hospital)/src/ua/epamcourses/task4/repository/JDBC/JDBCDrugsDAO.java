package ua.epamcourses.task4.repository.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import org.apache.log4j.Logger;

import ua.epamcourses.task4.domain.Drugs;
import ua.epamcourses.task4.repository.DAO.DrugsDAO;
import ua.epamcourses.task4.repository.utils.ConnectionFactory;
import ua.epamcourses.task4.repository.utils.JDBCUtil;

public class JDBCDrugsDAO implements DrugsDAO {

	private ConnectionFactory factory;
	private static final Logger log = Logger.getLogger(JDBCDrugsDAO.class);
	public JDBCDrugsDAO(ConnectionFactory factory) {
		this.factory = factory;
	}
	
	@Override
	public LinkedList<Drugs> findAll() {
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet res = null;
		LinkedList<Drugs> drugs = null;
		
		try {
			conn = factory.getConnection();
			stat = conn.prepareStatement("SELECT * FROM drugs;");
			res = stat.executeQuery();
			drugs = new LinkedList<Drugs>();
			res.beforeFirst();
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
	public Drugs find(Integer drugsID) {
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet res = null;
		Drugs drugs = null;
		
		try {
			conn = factory.getConnection();
			stat = conn.prepareStatement("SELECT * FROM drugs WHERE id=?;");
			stat.setInt(1, drugsID);
			res = stat.executeQuery();
			res.beforeFirst();
			if(res.next()){
				drugs = new Drugs();
				drugs.setDrugsID(res.getInt(1));
				drugs.setDrugsName(res.getString(2));
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
	public LinkedList<Drugs> findDrugsOfPatient(Integer patientID) {
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet res = null;
		LinkedList<Drugs> drugs = null;
		
		try {
			conn = factory.getConnection();
			stat = conn.prepareStatement("SELECT * FROM drugs WHERE drugs.ID in(SELECT drugsID FROM patientdrugs WHERE patientID=?);");
			stat.setInt(1, patientID);
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
	public boolean createNewDrugs(String drugsName) {
		Connection conn = null;
		PreparedStatement stat = null;
		try {
			conn = factory.getConnection();
			stat = conn.prepareStatement("INSERT INTO drugs (drugName) VALUES (?);");
			stat.setString(1, drugsName);
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
	public Integer findIdOfDrugs(String drugsName) {
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet res = null;
		Integer result = null;
		
		try {
			conn = factory.getConnection();
			stat = conn.prepareStatement("SELECT id FROM drugs WHERE drugName='?';");
			stat.setString(1, drugsName);
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
	public boolean deleteDrugs(Integer drugsID) {
		Connection conn = null;
		PreparedStatement stat = null;
		try {
			conn = factory.getConnection();
			stat = conn.prepareStatement("DELETE from drugs WHERE id=?;");
			stat.setInt(1, drugsID);
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
