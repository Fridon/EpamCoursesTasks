package ua.epamcourses.task4.web.actions;

import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.epamcourses.task4.domain.Patient;
import ua.epamcourses.task4.repository.utils.DAOFactory;
import ua.epamcourses.task4.repository.utils.DriverManagerJDBC;
import ua.epamcourses.task4.service.patient.PatientService;
import ua.epamcourses.task4.service.patient.PatientServiceImpl;

public class ViewAllPatients implements Action {

	@Override
	public String doAction(HttpServletRequest request,
			HttpServletResponse response) {
		DAOFactory manager = DriverManagerJDBC.getInstance("root","","com.mysql.jdbc.Driver","jdbc:mysql://localhost/hospital");
		PatientService PS = new PatientServiceImpl(manager.getPatientDAO());
		LinkedList<Patient> patients = PS.findAll();
		request.getSession().setAttribute("patients", patients);
		return "patients";
	}

}
