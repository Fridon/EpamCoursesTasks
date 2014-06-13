package ua.epamcourses.task4.web.actions;

import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.epamcourses.task4.domain.Patient;
import ua.epamcourses.task4.repository.utils.DAOFactory;
import ua.epamcourses.task4.repository.utils.DriverManagerJDBC;
import ua.epamcourses.task4.service.discharged.DischargedService;
import ua.epamcourses.task4.service.discharged.DischargedServiseImpl;

public class ViewDischarged implements Action {

	@Override
	public String doAction(HttpServletRequest request,
			HttpServletResponse response) {

		DAOFactory manager = DriverManagerJDBC.getInstance("root","","com.mysql.jdbc.Driver","jdbc:mysql://localhost/hospital");
		DischargedService DS = new DischargedServiseImpl(manager.getDischargedDAO());
		LinkedList<String> discharged = DS.getAllDischarged();
		request.getSession().setAttribute("discharged", discharged);
		
		return "discharged";
	}

}
