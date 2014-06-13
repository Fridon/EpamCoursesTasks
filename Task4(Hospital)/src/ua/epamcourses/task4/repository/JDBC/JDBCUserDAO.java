package ua.epamcourses.task4.repository.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import org.apache.log4j.Logger;

import ua.epamcourses.task4.domain.User;
import ua.epamcourses.task4.repository.DAO.UserDAO;
import ua.epamcourses.task4.repository.utils.ConnectionFactory;
import ua.epamcourses.task4.repository.utils.JDBCUtil;

public class JDBCUserDAO implements UserDAO{

	private ConnectionFactory factory;
	private static final Logger log = Logger.getLogger(JDBCUserDAO.class);
	public JDBCUserDAO(ConnectionFactory factory) {
		this.factory = factory;
	}
	
	@Override
	public LinkedList<User> findAll() {
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet res = null;
		LinkedList<User> users = null;
		
		try {
			conn = factory.getConnection();
			stat = conn.prepareStatement("select U.id, U.login, U.role, P.password from users U, passwords P" +
					" where U.id = P.userID;");
			res = stat.executeQuery();
			users = new LinkedList<User>();
			res.beforeFirst();
			while(res.next()){
				User temp = new User();
				temp.setUserID(res.getInt(1));
				temp.setLogin(res.getString(2));
				temp.setRole(res.getInt(3));
				temp.setPassword(res.getString(4));
				users.add(temp);
			}
		} catch (SQLException e) {
			log.error(e);
		}finally{
			JDBCUtil.close(conn);
			JDBCUtil.close(stat);
			JDBCUtil.close(res);
		}	
		return users;
	}

	@Override
	public User find(Integer userID) {
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet res = null;
		User user = null;
		
		try {
			conn = factory.getConnection();
			stat = conn.prepareStatement("select U.id, U.login, U.role, P.password from users U, passwords P" +
					" where U.id = ? and P.userID = ?");
			stat.setInt(1, userID);
			stat.setInt(2, userID);
			res = stat.executeQuery();
			res.beforeFirst();
			if(res.next()){
				user = new User();
				user.setUserID(res.getInt(1));
				user.setLogin(res.getString(2));
				user.setRole(res.getInt(3));
				user.setPassword(res.getString(4));
			}
		} catch (SQLException e) {
			log.error(e);
		}finally{
			JDBCUtil.close(conn);
			JDBCUtil.close(stat);
			JDBCUtil.close(res);
		}	
		return user;
	}

	@Override
	public User find(String userLogin) {
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet res = null;
		User user = null;	
		try {
			conn = factory.getConnection();
			stat = conn.prepareStatement("SELECT U.id, U.login, U.role, P.password FROM users U, passwords P " +
					"WHERE U.login = ? AND U.id = P.userID");
			stat.setString(1, userLogin);
			res = stat.executeQuery();
			res.beforeFirst();
			if(res.next()){
				user = new User();
				user.setUserID(res.getInt(1));
				user.setLogin(res.getString(2));
				user.setRole(res.getInt(3));
				user.setPassword(res.getString(4));
			}
		} catch (SQLException e) {
			log.error(e);
		}finally{
			JDBCUtil.close(conn);
			JDBCUtil.close(stat);
			JDBCUtil.close(res);
		}	
		return user;
	}

	@Override
	public boolean createNewUser(User newUser) {
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet res = null;
		try {
			conn = factory.getConnection();
			stat = conn.prepareStatement("INSERT INTO users (login, role) VALUES (?, ?);");
			stat.setString(1, newUser.getLogin());
			stat.setInt(2, newUser.getRole());
			if(!stat.execute()){	
				JDBCUtil.close(stat);
				stat = conn.prepareStatement("SELECT last_insert_id();");
				res = stat.executeQuery();
				res.beforeFirst();
				if(res.next()){
					newUser.setUserID(res.getInt(1));
				}else{
					JDBCUtil.close(res);
					return false;
				}
				JDBCUtil.close(stat);
				JDBCUtil.close(res);
				stat = conn.prepareStatement("INSERT INTO passwords (userID, password) VALUES (?, ?);");
				stat.setInt(1, newUser.getUserID());
				stat.setString(2, newUser.getPassword());
				return !stat.execute();
			}else{
				return false;
			}
		} catch (SQLException e) {
			log.error(e);
		}finally{
			JDBCUtil.close(conn);
			JDBCUtil.close(stat);
		}	
		return false;
	}

	@Override
	public Integer findIdOfUser(String userName) {
		return find(userName).getUserID();
	}

	@Override
	public boolean verifyUser(String login, String password) {
		User user = find(login);
		return(user != null && user.getPassword().equals(password));
	}
		
}
