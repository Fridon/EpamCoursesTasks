package ua.epamcourses.task4.service.user;

import java.util.LinkedList;

import ua.epamcourses.task4.domain.User;

public interface UserService {
	LinkedList<User> findAll();
	boolean isExist(String login);
	boolean verify(String login, String password);
	User getUser(String login);
	boolean createUser(User user);
}
