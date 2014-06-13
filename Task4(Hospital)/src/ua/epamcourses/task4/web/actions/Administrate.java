package ua.epamcourses.task4.web.actions;

import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.epamcourses.task4.domain.Diagnosis;
import ua.epamcourses.task4.domain.Drugs;
import ua.epamcourses.task4.domain.Operations;
import ua.epamcourses.task4.domain.Procedures;
import ua.epamcourses.task4.domain.User;
import ua.epamcourses.task4.repository.utils.DAOFactory;
import ua.epamcourses.task4.repository.utils.DriverManagerJDBC;
import ua.epamcourses.task4.service.diagnosis.DiagnosisService;
import ua.epamcourses.task4.service.diagnosis.DiagnosisServiceImpl;
import ua.epamcourses.task4.service.drugs.DrugsService;
import ua.epamcourses.task4.service.drugs.DrugsServiceImpl;
import ua.epamcourses.task4.service.operations.OperationsService;
import ua.epamcourses.task4.service.operations.OperationsServiceImpl;
import ua.epamcourses.task4.service.procedures.ProceduresService;
import ua.epamcourses.task4.service.procedures.ProceduresServiceImpl;

public class Administrate implements Action {

	@Override
	public String doAction(HttpServletRequest request,
			HttpServletResponse response) {
		if(request.getSession().getAttribute("user") == null ||
				((User)request.getSession().getAttribute("user")).getRole() != User.ADMINISTRATOR)
			return "main";
		
		DAOFactory manager = DriverManagerJDBC.getInstance("root","","com.mysql.jdbc.Driver","jdbc:mysql://localhost/hospital");
		DiagnosisService DS = new DiagnosisServiceImpl(manager.getDignosisDAO());
		DrugsService DrugS = new DrugsServiceImpl(manager.getDrugsDAO());
		OperationsService OS = new OperationsServiceImpl(manager.getOperationsDAO());
		ProceduresService ProcS = new ProceduresServiceImpl(manager.getProceduresDAO());
		
		LinkedList<Diagnosis> allDiagnosis = DS.findAll();
		LinkedList<Drugs> allDrugs = DrugS.findAll();
		LinkedList<Procedures> allProcedures = ProcS.findAll();
		LinkedList<Operations> allOperations = OS.findAll();
		
		request.setAttribute("alldiagnosis", allDiagnosis);
		request.setAttribute("alldrugs", allDrugs);
		request.setAttribute("allprocedures", allProcedures);
		request.setAttribute("alloperations", allOperations);
		
		return "admin";
	}

}
