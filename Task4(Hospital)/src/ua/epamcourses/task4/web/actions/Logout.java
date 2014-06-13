package ua.epamcourses.task4.web.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Logout implements Action {

	@Override
	public String doAction(HttpServletRequest request,
			HttpServletResponse response) {
		request.getSession().setAttribute("user", null);
		request.getSession().setAttribute("notlogged", false);
		return "login";
	}

}
