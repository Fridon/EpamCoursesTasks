package ua.epamcourses.task4.web.actions;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

public class ActionFactory {
	private HashMap<String, Action> actions;
	
	public ActionFactory(){
		actions = new HashMap<String, Action>();
		actions.put("/registration", new UserRegistration());
		actions.put("/login", new UserLogin());
		actions.put("/logout", new Logout());
		actions.put("/", new Index());
		actions.put("/viewallpatients", new ViewAllPatients());
		actions.put("/administrate", new Administrate());
		actions.put("/patient", new PatientAction());
		actions.put("/performdrugs", new PerformDrugs());
		actions.put("/performprocedures", new PerformProcedures());
		actions.put("/performoperations", new PerformOperations());
		actions.put("/adddrug", new AddPatientDrug());
		actions.put("/addoperation", new AddPatientOperations());
		actions.put("/addprocedure", new AddPatientProcedures());
		actions.put("/changediagnosis", new ChangePatientDiagnosis());
		actions.put("/submituser", new SubmitUser());
		actions.put("/newpatient", new NewPatient());
		actions.put("/submitpatient", new SubmitPatient());
		actions.put("/admin", new AdminAction());
		actions.put("/dischargepatient", new Discharge());
		actions.put("/viewdischargedpatients", new ViewDischarged());
		
		
	}
	
	public Action getAction(HttpServletRequest request){
		String path = request.getRequestURI().substring(request.getContextPath().length());
		return actions.get(path);
	}
}
