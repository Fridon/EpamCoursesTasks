package ua.epamcourses.task4.web.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.epamcourses.task4.repository.utils.DAOFactory;
import ua.epamcourses.task4.repository.utils.DriverManagerJDBC;
import ua.epamcourses.task4.service.user.UserService;
import ua.epamcourses.task4.service.user.UserServiceImpl;

public class UserLogin implements Action{
	private static final Logger log = Logger.getLogger(UserLogin.class);
	@Override
	public String doAction(HttpServletRequest request,
			HttpServletResponse response) {
		DAOFactory manager = DriverManagerJDBC.getInstance("root","","com.mysql.jdbc.Driver","jdbc:mysql://localhost/hospital");
		UserService users = new UserServiceImpl(manager.getUserDAO());
		String login = (String)request.getParameter("login");
		String password = (String)request.getParameter("password");
		if(users.verify(login, password)){
			request.getSession().setAttribute("user", users.getUser(login));
			log.info("User " + login + " logged in");
			return "main";
		}
			request.getSession().setAttribute("notlogged", true);
		return "login";
	}

}
