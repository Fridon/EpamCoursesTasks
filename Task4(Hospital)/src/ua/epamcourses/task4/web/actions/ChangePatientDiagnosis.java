package ua.epamcourses.task4.web.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.epamcourses.task4.domain.Diagnosis;
import ua.epamcourses.task4.domain.Patient;
import ua.epamcourses.task4.repository.utils.DAOFactory;
import ua.epamcourses.task4.repository.utils.DriverManagerJDBC;
import ua.epamcourses.task4.service.diagnosis.DiagnosisService;
import ua.epamcourses.task4.service.diagnosis.DiagnosisServiceImpl;
import ua.epamcourses.task4.service.patientsDiagnosis.PatientsDiagnosisService;
import ua.epamcourses.task4.service.patientsDiagnosis.PatientsDiagnosisServiceImpl;

public class ChangePatientDiagnosis implements Action {
	private static final Logger log = Logger.getLogger(ChangePatientDiagnosis.class);
	@Override
	public String doAction(HttpServletRequest request,
			HttpServletResponse response) {
		DAOFactory manager = DriverManagerJDBC.getInstance("root","","com.mysql.jdbc.Driver","jdbc:mysql://localhost/hospital");
		Integer diagnosisID = Integer.parseInt(request.getParameter("changeddiagnosis"));
		Patient patient = (Patient)request.getSession().getAttribute("patient");
		DiagnosisService DS = new DiagnosisServiceImpl(manager.getDignosisDAO());
		PatientsDiagnosisService PDS = new PatientsDiagnosisServiceImpl(manager.getPatientsDiagnosisDAO());
		Diagnosis newDiagnosis = DS.find(diagnosisID);
		Diagnosis oldDiagnosis = PDS.getPatientDiagnosis(patient);
		if(oldDiagnosis != null) {
			if(!PDS.changeDiagnosis(patient, oldDiagnosis, newDiagnosis))
				log.info("Changed diagnosis of patient " + patient.getPatientID() +" to " + newDiagnosis.getDiagnosisName());
		}else{
			if(!PDS.createPatientsDiagnosis(patient, newDiagnosis))
				log.info("Defined diagnosis to patient " + patient.getPatientID() + ": " + newDiagnosis.getDiagnosisName());
		}
		return new PatientAction().doAction(request, response);
	}

}
