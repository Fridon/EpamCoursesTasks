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
	<a href = "/Task4_Hospital/">${lang_main}</a><br>
	<c:forEach var = "patient" items="${patients}">
		<a href="/Task4_Hospital/patient/${patient.patientID}">${patient.surname} ${patient.name} ${patient.pathronimic}</a> <br>
	</c:forEach>
	<jsp:include page="footer.jsp"/>
</body>
</html>