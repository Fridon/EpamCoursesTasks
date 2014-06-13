package ua.epamcourses.task4.web.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.epamcourses.task4.domain.Patient;
import ua.epamcourses.task4.domain.Procedures;
import ua.epamcourses.task4.repository.utils.DAOFactory;
import ua.epamcourses.task4.repository.utils.DriverManagerJDBC;
import ua.epamcourses.task4.service.patientsProcedures.PatientsProceduresService;
import ua.epamcourses.task4.service.patientsProcedures.PatientsProceduresServiceImpl;
import ua.epamcourses.task4.service.procedures.ProceduresService;
import ua.epamcourses.task4.service.procedures.ProceduresServiceImpl;

public class AddPatientProcedures implements Action {
	private static final Logger log = Logger.getLogger(AddPatientProcedures.class);
	@Override
	public String doAction(HttpServletRequest request,
			HttpServletResponse response) {
		DAOFactory manager = DriverManagerJDBC.getInstance("root","","com.mysql.jdbc.Driver","jdbc:mysql://localhost/hospital");
		Integer proceduresID = Integer.parseInt(request.getParameter("addprocedure"));
		Patient patient = (Patient)request.getSession().getAttribute("patient");
		ProceduresService PS = new ProceduresServiceImpl(manager.getProceduresDAO());
		PatientsProceduresService PPS = new PatientsProceduresServiceImpl(manager.getPatientsProceduresDAO());
		Procedures procedure = PS.find(proceduresID);
		if(!PPS.createPatientsProcedures(patient, procedure))
			log.info("Prescribed " + procedure.getProceduresName() + " to patient " + patient.getPatientID());
		return new PatientAction().doAction(request, response);
	}

}
