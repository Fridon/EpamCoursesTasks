package ua.epamcourses.task4.web.actions;

import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.epamcourses.task4.domain.Diagnosis;
import ua.epamcourses.task4.domain.Drugs;
import ua.epamcourses.task4.domain.Operations;
import ua.epamcourses.task4.domain.Patient;
import ua.epamcourses.task4.domain.Procedures;
import ua.epamcourses.task4.repository.utils.DAOFactory;
import ua.epamcourses.task4.repository.utils.DriverManagerJDBC;
import ua.epamcourses.task4.service.diagnosis.DiagnosisService;
import ua.epamcourses.task4.service.diagnosis.DiagnosisServiceImpl;
import ua.epamcourses.task4.service.drugs.DrugsService;
import ua.epamcourses.task4.service.drugs.DrugsServiceImpl;
import ua.epamcourses.task4.service.operations.OperationsService;
import ua.epamcourses.task4.service.operations.OperationsServiceImpl;
import ua.epamcourses.task4.service.patient.PatientService;
import ua.epamcourses.task4.service.patient.PatientServiceImpl;
import ua.epamcourses.task4.service.patientsDiagnosis.PatientsDiagnosisService;
import ua.epamcourses.task4.service.patientsDiagnosis.PatientsDiagnosisServiceImpl;
import ua.epamcourses.task4.service.patientsDrugs.PatientsDrugsService;
import ua.epamcourses.task4.service.patientsDrugs.PatientsDrugsServiceImpl;
import ua.epamcourses.task4.service.patientsOperations.PatientsOperationsService;
import ua.epamcourses.task4.service.patientsOperations.PatientsOperationsServiceImpl;
import ua.epamcourses.task4.service.patientsProcedures.PatientsProceduresService;
import ua.epamcourses.task4.service.patientsProcedures.PatientsProceduresServiceImpl;
import ua.epamcourses.task4.service.procedures.ProceduresService;
import ua.epamcourses.task4.service.procedures.ProceduresServiceImpl;

public class PatientAction implements Action {

	@Override
	public String doAction(HttpServletRequest request,
			HttpServletResponse response) {

		DAOFactory manager = DriverManagerJDBC.getInstance("root","","com.mysql.jdbc.Driver","jdbc:mysql://localhost/hospital");
		PatientService PS = new PatientServiceImpl(manager.getPatientDAO());
		PatientsDiagnosisService PDS = new PatientsDiagnosisServiceImpl(manager.getPatientsDiagnosisDAO());
		PatientsDrugsService PDrugS = new PatientsDrugsServiceImpl(manager.getPatientsDrugsDAO());
		PatientsOperationsService POS = new PatientsOperationsServiceImpl(manager.getPatientsOperationDAO());
		PatientsProceduresService PPS = new PatientsProceduresServiceImpl(manager.getPatientsProceduresDAO());
		DiagnosisService DS = new DiagnosisServiceImpl(manager.getDignosisDAO());
		DrugsService DrugS = new DrugsServiceImpl(manager.getDrugsDAO());
		OperationsService OS = new OperationsServiceImpl(manager.getOperationsDAO());
		ProceduresService ProcS = new ProceduresServiceImpl(manager.getProceduresDAO());
		
		Patient patient = PS.getPatient((Integer)request.getSession().getAttribute("patientID"));
		Diagnosis diagnosis = PDS.getPatientDiagnosis(patient);
		LinkedList<Drugs> drugs = PDrugS.getPatientDrugs(patient);
		LinkedList<Procedures> procedures = PPS.getPatientProcedures(patient);
		LinkedList<Operations> operations = POS.getPatientOperations(patient);
		LinkedList<Diagnosis> allDiagnosis = DS.findAll();
		LinkedList<Drugs> allDrugs = DrugS.findAll();
		LinkedList<Procedures> allProcedures = ProcS.findAll();
		LinkedList<Operations> allOperations = OS.findAll();
		
		request.getSession().setAttribute("patient", patient);
		request.setAttribute("diagnosis", diagnosis);
		request.setAttribute("drugs", drugs);
		request.setAttribute("procedures", procedures);
		request.setAttribute("operations", operations);
		request.setAttribute("alldiagnosis", allDiagnosis);
		request.setAttribute("alldrugs", allDrugs);
		request.setAttribute("allprocedures", allProcedures);
		request.setAttribute("alloperations", allOperations);
		return "patient";
	}

}
