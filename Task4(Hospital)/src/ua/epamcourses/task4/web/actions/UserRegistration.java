package ua.epamcourses.task4.web.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserRegistration implements Action {

	@Override
	public String doAction(HttpServletRequest request,
			HttpServletResponse response) {
		return "userregistration";
	}

}
