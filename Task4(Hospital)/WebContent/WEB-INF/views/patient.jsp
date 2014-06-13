<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${lang_hospital}</title>
</head>
<body>
	<a href = "/Task4_Hospital/">${lang_main}</a> <a href = "/Task4_Hospital/viewallpatients">${lang_back}</a><br>
	${lang_patient_number} ${patient.patientID}:<br>
	${patient.surname} ${patient.name} ${patient.pathronimic}.<br>
	${lang_diagnosis}: ${diagnosis.diagnosisName}.<br>
	<c:if test = "${user.role == 2}">
		${lang_select_diagnosis}.<br>
		<form method='POST' action = '/Task4_Hospital/changediagnosis'>
			<select name = "changeddiagnosis">
			<c:forEach var = "diagnos" items = "${alldiagnosis}">
			 <option value="${diagnos.diagnosisID}">${diagnos.diagnosisName}</option>
			</c:forEach>
			</select>
			<input type="submit" value='${lang_change}'>
		</form>
	</c:if>
	<br>${lang_prescr_drugs}: <br>
	<c:forEach var = "drug" items = "${drugs}">
		<form method='POST' action='/Task4_Hospital/performdrugs' >
		${drug.drugsName}.
			<c:if test="${user.role > 0 && user.role < 3}">
				<input type ="hidden" name ="performeddrug" value = "${drug.drugsID}">	
				<input type="submit" value='${lang_give}'>
			</c:if>
		</form>
	</c:forEach>
	<c:if test = "${user.role == 2}">
		${lang_select_drug}<br>
		<form method='POST' action = '/Task4_Hospital/adddrug'>
			<select name = "adddrug">
			<c:forEach var = "drugz" items = "${alldrugs}">
			 <option value="${drugz.drugsID}">${drugz.drugsName}</option>
			</c:forEach>
			</select>
			<input type="submit" value='${lang_prescr}'>
		</form>
	</c:if>
	<br>${lang_prescr_proc }: <br>
	<c:forEach var = "procedure" items = "${procedures}">
	<form method='POST' action='/Task4_Hospital/performprocedures'>
		${procedure.proceduresName}.
		<c:if test="${user.role > 0 && user.role < 3}">	
				<input type ="hidden" name ="performedprocedures" value = "${procedure.proceduresID}">
				<input type="submit" value='${lang_perform}'>
			</c:if>
		</form>
	</c:forEach>
	<c:if test = "${user.role == 2}">
		${lang_select_proc}<br>
		<form method='POST' action = '/Task4_Hospital/addprocedure'>
			<select name = "addprocedure">
			<c:forEach var = "procedure" items = "${allprocedures}">
			 <option value="${procedure.proceduresID}">${procedure.proceduresName}</option>
			</c:forEach>
			</select>
			<input type="submit" value='${lang_prescr}'>
		</form>
	</c:if>
	<br>${lang_prescr_oper}: <br>
	<c:forEach var = "operation" items = "${operations}">
	<form method='POST' action='/Task4_Hospital/performoperations'>
		${operation.operationsName}.
		<c:if test="${user.role == 2}">
				<input type ="hidden" name ="performedoperations" value = "${operation.operationsID}">	
				<input type="submit" value='${lang_perform}'>
			</c:if>
		</form>
	</c:forEach>
	<c:if test = "${user.role == 2}">
		${lang_select_oper}.<br>
		<form method='POST' action = '/Task4_Hospital/addoperation'>
			<select name = "addoperation">
			<c:forEach var = "operation" items = "${alloperations}">
			 <option value="${operation.operationsID}">${operation.operationsName}</option>
			</c:forEach>
			</select>
			<input type="submit" value='${lang_prescr}'>
		</form>
	</c:if>	
	
	<c:if test = "${user.role == 2}">
		<a href="/Task4_Hospital/dischargepatient">${lang_discharge}</a>
	</c:if>
	
    <jsp:include page="footer.jsp"/>

</body>
</html>