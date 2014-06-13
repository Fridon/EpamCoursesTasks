package ua.epamcourses.task4.web.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.epamcourses.task4.domain.Operations;
import ua.epamcourses.task4.domain.Patient;
import ua.epamcourses.task4.repository.utils.DAOFactory;
import ua.epamcourses.task4.repository.utils.DriverManagerJDBC;
import ua.epamcourses.task4.service.operations.OperationsService;
import ua.epamcourses.task4.service.operations.OperationsServiceImpl;
import ua.epamcourses.task4.service.patientsOperations.PatientsOperationsService;
import ua.epamcourses.task4.service.patientsOperations.PatientsOperationsServiceImpl;

public class PerformOperations implements Action {
	private static final Logger log = Logger.getLogger(PerformOperations.class);
	@Override
	public String doAction(HttpServletRequest request,
			HttpServletResponse response) {
		DAOFactory manager = DriverManagerJDBC.getInstance("root","","com.mysql.jdbc.Driver","jdbc:mysql://localhost/hospital");
		Integer operationsID = Integer.parseInt(request.getParameter("performedoperations"));
		Patient patient = (Patient)request.getSession().getAttribute("patient");
		OperationsService OS = new OperationsServiceImpl(manager.getOperationsDAO());
		PatientsOperationsService POS = new PatientsOperationsServiceImpl(manager.getPatientsOperationDAO());
		Operations operation = OS.find(operationsID);
		if(!POS.deletePatientOperation(patient, operation))
			log.info("Performed " + operation.getOperationsName() + " to patient " + patient.getPatientID());
		return new PatientAction().doAction(request, response);
	}

}
