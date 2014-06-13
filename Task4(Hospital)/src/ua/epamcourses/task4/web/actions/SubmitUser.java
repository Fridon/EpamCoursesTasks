package ua.epamcourses.task4.web.actions;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.epamcourses.task4.domain.User;
import ua.epamcourses.task4.repository.utils.DAOFactory;
import ua.epamcourses.task4.repository.utils.DriverManagerJDBC;
import ua.epamcourses.task4.service.user.UserService;
import ua.epamcourses.task4.service.user.UserServiceImpl;

public class SubmitUser implements Action {
	private static final Logger log = Logger.getLogger(SubmitUser.class);
	@Override
	public String doAction(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		DAOFactory manager = DriverManagerJDBC.getInstance("root","","com.mysql.jdbc.Driver","jdbc:mysql://localhost/hospital");
		UserService US = new UserServiceImpl(manager.getUserDAO());
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String repassword = request.getParameter("repassword");
		Integer role = Integer.parseInt(request.getParameter("role"));
		if(login != null && password != null && password.equals(repassword) && role != null && !US.isExist(login)){
			User newUser = new User();
			newUser.setLogin(login);
			newUser.setPassword(password);
			newUser.setRole(role);
			if(US.createUser(newUser)){
				log.info("added new user. Login = " + newUser.getLogin());
				return "main";
			}
		}	
		return "userregistration";
	}

}
