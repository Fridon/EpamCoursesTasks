package ua.epamcourses.task4.service.user;

import java.util.LinkedList;

import ua.epamcourses.task4.domain.User;
import ua.epamcourses.task4.repository.DAO.UserDAO;

public class UserServiceImpl implements UserService {

	private UserDAO userDAO;
	
	public UserServiceImpl(UserDAO userDAO){
		this.userDAO = userDAO;
	}
	
	@Override
	public LinkedList<User> findAll() {
		return userDAO.findAll();
	}

	@Override
	public boolean isExist(String login) {
		return userDAO.find(login) != null;
	}

	@Override
	public boolean verify(String login, String password) {
		return userDAO.verifyUser(login, password);
	}

	@Override
	public User getUser(String login) {
		return userDAO.find(login);
	}

	@Override
	public boolean createUser(User user) {
		return userDAO.createNewUser(user);
	}

}
