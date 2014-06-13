package ua.epamcourses.task4.web.actions;

import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.epamcourses.task4.domain.Diagnosis;
import ua.epamcourses.task4.domain.User;
import ua.epamcourses.task4.repository.utils.DAOFactory;
import ua.epamcourses.task4.repository.utils.DriverManagerJDBC;
import ua.epamcourses.task4.service.diagnosis.DiagnosisService;
import ua.epamcourses.task4.service.diagnosis.DiagnosisServiceImpl;

public class NewPatient implements Action {

	@Override
	public String doAction(HttpServletRequest request,
			HttpServletResponse response) {
		User user = (User)request.getSession().getAttribute("user");
		if(user == null || user.getRole() != 2)
			return "login";
		DAOFactory manager = DriverManagerJDBC.getInstance("root","","com.mysql.jdbc.Driver","jdbc:mysql://localhost/hospital");
		DiagnosisService DS = new DiagnosisServiceImpl(manager.getDignosisDAO());
		LinkedList<Diagnosis> allDiagnosis = DS.findAll();
		request.setAttribute("alldiagnosis", allDiagnosis);	
		return "newpatient";
	}

}
