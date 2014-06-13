package ua.epamcourses.task4.web.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.epamcourses.task4.domain.Diagnosis;
import ua.epamcourses.task4.domain.Patient;
import ua.epamcourses.task4.domain.User;
import ua.epamcourses.task4.repository.utils.DAOFactory;
import ua.epamcourses.task4.repository.utils.DriverManagerJDBC;
import ua.epamcourses.task4.service.discharged.DischargedService;
import ua.epamcourses.task4.service.discharged.DischargedServiseImpl;
import ua.epamcourses.task4.service.patient.PatientService;
import ua.epamcourses.task4.service.patient.PatientServiceImpl;
import ua.epamcourses.task4.service.patientsDiagnosis.PatientsDiagnosisService;
import ua.epamcourses.task4.service.patientsDiagnosis.PatientsDiagnosisServiceImpl;

public class Discharge implements Action {

	@Override
	public String doAction(HttpServletRequest request,
			HttpServletResponse response) {
		User user = (User)request.getSession().getAttribute("user");
		if(user == null || user.getRole() != 2)
			return "login";
		DAOFactory manager = DriverManagerJDBC.getInstance("root","","com.mysql.jdbc.Driver","jdbc:mysql://localhost/hospital");
		PatientService PS = new PatientServiceImpl(manager.getPatientDAO());
		PatientsDiagnosisService PDS = new PatientsDiagnosisServiceImpl(manager.getPatientsDiagnosisDAO());
		DischargedService DS = new DischargedServiseImpl(manager.getDischargedDAO());
		
		Patient patient = (Patient)request.getSession().getAttribute("patient");
		Diagnosis diagnosis = PDS.getPatientDiagnosis(patient);
		DS.discargePatient(patient, diagnosis);
		PS.deletePatient(patient.getPatientID());
		request.getSession().setAttribute("patient", null);
		return "main";
	}

}
