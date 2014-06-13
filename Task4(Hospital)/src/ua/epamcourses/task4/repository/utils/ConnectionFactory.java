package ua.epamcourses.task4.repository.utils;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionFactory {
	
	Connection getConnection() throws SQLException;
	void closeConnection(Connection connection);
	
}
