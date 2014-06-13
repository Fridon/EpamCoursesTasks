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
	${lang_logged} ${user.login}.<br>
	<a href="/Task4_Hospital/logout"> ${lang_logout}.</a><br>
	<a href="/Task4_Hospital/viewallpatients"> ${lang_view_all}.</a><br>
	<a href="/Task4_Hospital/viewdischargedpatients"> ${lang_view_discharged}.</a><br>
	<c:if test = "${user.role == 2}">
		<a href="/Task4_Hospital/newpatient"> ${lang_new_patient}.</a>
	</c:if>
	<c:if test = "${user.role > 2}">
		<a href="/Task4_Hospital/administrate"> ${lang_admin_sys}.</a>
	</c:if>
	<jsp:include page="footer.jsp"/>
</body>
</html>