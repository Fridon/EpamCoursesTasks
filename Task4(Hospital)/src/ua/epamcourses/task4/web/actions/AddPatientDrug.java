package ua.epamcourses.task4.web.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.epamcourses.task4.domain.Drugs;
import ua.epamcourses.task4.domain.Patient;
import ua.epamcourses.task4.repository.JDBC.JDBCPatientsDrugsDAO;
import ua.epamcourses.task4.repository.utils.DAOFactory;
import ua.epamcourses.task4.repository.utils.DriverManagerJDBC;
import ua.epamcourses.task4.service.drugs.DrugsService;
import ua.epamcourses.task4.service.drugs.DrugsServiceImpl;
import ua.epamcourses.task4.service.patientsDrugs.PatientsDrugsService;
import ua.epamcourses.task4.service.patientsDrugs.PatientsDrugsServiceImpl;

public class AddPatientDrug implements Action {
	private static final Logger log = Logger.getLogger(AddPatientDrug.class);
	@Override
	public String doAction(HttpServletRequest request,
			HttpServletResponse response) {
		DAOFactory manager = DriverManagerJDBC.getInstance("root","","com.mysql.jdbc.Driver","jdbc:mysql://localhost/hospital");
		Integer drugsID = Integer.parseInt(request.getParameter("adddrug"));
		Patient patient = (Patient)request.getSession().getAttribute("patient");
		DrugsService DS = new DrugsServiceImpl(manager.getDrugsDAO());
		PatientsDrugsService PDS = new PatientsDrugsServiceImpl(manager.getPatientsDrugsDAO());
		Drugs drug = DS.find(drugsID);
		if(!PDS.createPatientsDrug(patient, drug))
			log.info("Prescribed " + drug.getDrugsName() + " to patient " + patient.getPatientID());
		return new PatientAction().doAction(request, response);
	}

}
