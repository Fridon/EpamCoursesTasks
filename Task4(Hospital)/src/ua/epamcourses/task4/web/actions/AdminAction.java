package ua.epamcourses.task4.web.actions;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

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

public class AdminAction implements Action {
	private static final Logger log = Logger.getLogger(UserLogin.class);
	@Override
	public String doAction(HttpServletRequest request,
			HttpServletResponse response) {
		
		String doAction = (String)request.getAttribute("doaction");
		
		if(request.getSession().getAttribute("user") == null ||
				((User)request.getSession().getAttribute("user")).getRole() != User.ADMINISTRATOR || doAction == null)
			return "login";
		
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		DAOFactory manager = DriverManagerJDBC.getInstance("root","","com.mysql.jdbc.Driver","jdbc:mysql://localhost/hospital");
		DiagnosisService DS = null;
		DrugsService DrugS = null;
		OperationsService OS = null;
		ProceduresService PS = null;
		
		switch(doAction){
		
		case "deletediagnosis":
			Integer diagnosisID = Integer.parseInt(request.getParameter("deletediagnosis"));
			DS = new DiagnosisServiceImpl(manager.getDignosisDAO());
			if(!DS.deleteDiagnosis(diagnosisID))
				log.info("Diagnosis " + diagnosisID + " deleted from database");
			break;
		case "adddiagnosis":
			String diagnosisName = request.getParameter("diagnosis");
			DS = new DiagnosisServiceImpl(manager.getDignosisDAO());
			if(!DS.createNewDiagnosis(diagnosisName))
				log.info("Diagnosis " + diagnosisName + " added to database");
			break;
		case "deletedrug":
			Integer drugsID = Integer.parseInt(request.getParameter("deletedrug"));
			DrugS = new DrugsServiceImpl(manager.getDrugsDAO());
			if(!DrugS.deleteDrugs(drugsID))
				log.info("Drug " + drugsID + " deleted from database");
			break;
		case "adddrug":
			String drugsName = request.getParameter("drug");
			DrugS = new DrugsServiceImpl(manager.getDrugsDAO());;
			if(!DrugS.createNewDrugs(drugsName))
				log.info("Drug " + drugsName + " added to database");
			break;
		case "deleteprocedure":
			Integer proceduresID = Integer.parseInt(request.getParameter("deleteprocedure"));
			PS = new ProceduresServiceImpl(manager.getProceduresDAO());
			if(!PS.deleteProcedures(proceduresID))
				log.info("Procedure " + proceduresID + " deleted from database");
			break;
		case "addprocedure":
			String proceduresName = request.getParameter("procedure");
			PS = new ProceduresServiceImpl(manager.getProceduresDAO());
			if(!PS.createNewProcedures(proceduresName))
				log.info("Procedure " + proceduresName + " added to database");
			break;
		case "deleteoperation":
			Integer operationsID = Integer.parseInt(request.getParameter("deleteoperation"));
			OS = new OperationsServiceImpl(manager.getOperationsDAO());
			if(!OS.deleteOperation(operationsID))
				log.info("Operation " + operationsID + " deleted from database");
			break;
		case "addoperation":
			String operationsName = request.getParameter("operation");
			OS = new OperationsServiceImpl(manager.getOperationsDAO());
			if(!OS.createNewOperations(operationsName))
				log.info("Operation " + operationsName + " added to database");
			break;	
		}	
		return new Administrate().doAction(request, response);
	}

}
