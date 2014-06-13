package ua.epamcourses.task4.repository.DAO;

import java.util.LinkedList;

import ua.epamcourses.task4.domain.User;

public interface UserDAO {
	LinkedList<User> findAll();
	User find(Integer userID);
	User find(String userLogin);
	boolean createNewUser(User newUser);
	Integer findIdOfUser(String userName);
	boolean verifyUser(String login, String password);
}
