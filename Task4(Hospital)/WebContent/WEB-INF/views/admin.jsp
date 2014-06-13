<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${lang_hospital}</title>
</head>
<body>
		<a href = "/Task4_Hospital/">${lang_main}</a>
		<form method='POST' action = "/Task4_Hospital/admin/deletediagnosis">
			<select name = "deletediagnosis">
			<c:forEach var = "diagnos" items = "${alldiagnosis}">
			 <option value="${diagnos.diagnosisID}">${diagnos.diagnosisName}</option>
			</c:forEach>
			</select>
			<input type="submit" value='${lang_delete}'>
		</form>
		<form method = 'POST' action = "/Task4_Hospital/admin/adddiagnosis">
		<input type='text' name = "diagnosis">
		<input type="submit" value='${lang_add_diagnosis}'>
		</form>
		<br>
		<form method='POST' action = "/Task4_Hospital/admin/deletedrug">
			<select name = "deletedrug">
			<c:forEach var = "drugz" items = "${alldrugs}">
			 <option value="${drugz.drugsID}">${drugz.drugsName}</option>
			</c:forEach>
			</select>
			<input type="submit" value='${lang_delete}'>
		</form>
		<form method = 'POST' action = "/Task4_Hospital/admin/adddrug">
		<input type='text' name = "drug">
		<input type="submit" value='${lang_add_drug}'>
		</form>
		<br>
		<form method='POST' action = "/Task4_Hospital/admin/deleteprocedure">
			<select name = "deleteprocedure">
			<c:forEach var = "procedure" items = "${allprocedures}">
			 <option value="${procedure.proceduresID}">${procedure.proceduresName}</option>
			</c:forEach>
			</select>
			<input type="submit" value='${lang_delete}'>
		</form>
		<form method = 'POST' action = "/Task4_Hospital/admin/addprocedure">
		<input type='text' name = "procedure">
		<input type="submit" value='${lang_add_procedure}'>
		</form>
		<br>
		<form method='POST' action = "/Task4_Hospital/admin/deleteoperation">
			<select name = "deleteoperation">
			<c:forEach var = "operation" items = "${alloperations}">
			 <option value="${operation.operationsID}">${operation.operationsName}</option>
			</c:forEach>
			</select>
			<input type="submit" value='${lang_delete}'>
		</form>
		<form method = 'POST' action = "/Task4_Hospital/admin/addoperation">
		<input type='text' name = "operation">
		<input type="submit" value='${lang_add_operation}'>
		</form>
		<br>
		<a href="/Task4_Hospital/registration">${lang_new_user}</a>
		
		<jsp:include page="footer.jsp"/>
</body>
</html>