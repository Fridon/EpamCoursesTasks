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
<form method ='POST' action = '/Task4_Hospital/submitpatient'>
	${lang_name}<input name="name" type="text"><br>
	${lang_surname} <input name="surname" type="text"><br>
	${lang_pathronimic} <input name="pathronimic" type="text"><br>
	${lang_select_diagnosis}:<br>
	<select name ="diagnosis">
	<c:forEach var = "diagnos" items="${alldiagnosis}">
	<option value = "${diagnos.diagnosisID}">${diagnos.diagnosisName}</option>
	</c:forEach>
	</select>
    <input type="submit" value='${lang_registration}'>
</form>
<jsp:include page="footer.jsp"/>
</body>
</html>