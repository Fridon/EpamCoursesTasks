package ua.epamcourses.task4.web.actions;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.epamcourses.task4.domain.Diagnosis;
import ua.epamcourses.task4.domain.Patient;
import ua.epamcourses.task4.repository.utils.DAOFactory;
import ua.epamcourses.task4.repository.utils.DriverManagerJDBC;
import ua.epamcourses.task4.service.diagnosis.DiagnosisService;
import ua.epamcourses.task4.service.diagnosis.DiagnosisServiceImpl;
import ua.epamcourses.task4.service.patient.PatientService;
import ua.epamcourses.task4.service.patient.PatientServiceImpl;
import ua.epamcourses.task4.service.patientsDiagnosis.PatientsDiagnosisService;
import ua.epamcourses.task4.service.patientsDiagnosis.PatientsDiagnosisServiceImpl;

public class SubmitPatient implements Action {

	private static final Logger log = Logger.getLogger(SubmitPatient.class);
	
	@Override
	public String doAction(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String name = (String)request.getParameter("name");
		String surname = (String)request.getParameter("surname");
		String pathronimic = (String)request.getParameter("pathronimic");
		Integer diagnosisID = Integer.parseInt(request.getParameter("diagnosis"));
		if(name != null && surname != null && pathronimic != null && diagnosisID != null){
			DAOFactory manager = DriverManagerJDBC.getInstance("root","","com.mysql.jdbc.Driver","jdbc:mysql://localhost/hospital");
			PatientService PS = new PatientServiceImpl(manager.getPatientDAO());
			PatientsDiagnosisService PDS = new PatientsDiagnosisServiceImpl(manager.getPatientsDiagnosisDAO());
			DiagnosisService DS = new DiagnosisServiceImpl(manager.getDignosisDAO());
		
			Patient patient = new Patient();
			patient.setName(name);
			patient.setSurname(surname);
			patient.setPathronimic(pathronimic);
		
			PS.addNewPatient(patient);
			Integer patientID = PS.findIdOfPatient(patient);
			patient = PS.getPatient(patientID);
			Diagnosis diagnosis = DS.find(diagnosisID);
			if(!PDS.createPatientsDiagnosis(patient, diagnosis))
				log.info("added new patient. id = " + patient.getPatientID());
			return "main";
		}
		return "newpatient";
	}

}
