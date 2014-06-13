package ua.epamcourses.task4.repository.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import org.apache.log4j.Logger;

import ua.epamcourses.task4.domain.Operations;
import ua.epamcourses.task4.repository.DAO.OperationsDAO;
import ua.epamcourses.task4.repository.utils.ConnectionFactory;
import ua.epamcourses.task4.repository.utils.JDBCUtil;

public class JDBCOperationsDAO implements OperationsDAO {

	private ConnectionFactory factory;
	private static final Logger log = Logger.getLogger(JDBCOperationsDAO.class);
	public JDBCOperationsDAO(ConnectionFactory factory) {
		this.factory = factory;
	}
	
	@Override
	public LinkedList<Operations> findAll() {
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet res = null;
		LinkedList<Operations> operations = null;
		
		try {
			conn = factory.getConnection();
			stat = conn.prepareStatement("SELECT * FROM operations;");
			res = stat.executeQuery();
			operations = new LinkedList<Operations>();
			res.beforeFirst();
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
	public Operations find(Integer operationsID) {
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet res = null;
		Operations operations = null;
		
		try {
			conn = factory.getConnection();
			stat = conn.prepareStatement("SELECT * FROM operations WHERE id=?;");
			stat.setInt(1, operationsID);
			res = stat.executeQuery();
			res.beforeFirst();
			if(res.next()){
				operations = new Operations();
				operations.setOperationsID(res.getInt(1));
				operations.setOperationsName(res.getString(2));
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
	public LinkedList<Operations> findOperationsOfPatient(Integer patientID) {
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet res = null;
		LinkedList<Operations> operations = null;
		
		try {
			conn = factory.getConnection();
			stat = conn.prepareStatement("SELECT * FROM operations WHERE operations.ID in(SELECT operationsID FROM patientoperations WHERE patientID=?);");
			stat.setInt(1, patientID);
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
	public boolean createNewOperations(String operationsName) {
		Connection conn = null;
		PreparedStatement stat = null;
		try {
			conn = factory.getConnection();
			stat = conn.prepareStatement("INSERT INTO operations (operName) VALUES (?);");
			stat.setString(1, operationsName);
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
	public Integer findIdOfOperations(String operationsName) {
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet res = null;
		Integer result = null;
		
		try {
			conn = factory.getConnection();
			stat = conn.prepareStatement("SELECT id FROM operations WHERE operName='?';");
			stat.setString(1, operationsName);
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
	public boolean deleteOperation(Integer operationsID) {
		Connection conn = null;
		PreparedStatement stat = null;
		try {
			conn = factory.getConnection();
			stat = conn.prepareStatement("DELETE from operations WHERE id=?;");
			stat.setInt(1, operationsID);
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
