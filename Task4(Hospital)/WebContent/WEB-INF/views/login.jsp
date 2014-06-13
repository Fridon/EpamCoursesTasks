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
	<form method='POST' action='/Task4_Hospital/login'>
		${lang_login} <input name="login" type="text"><br>
		${lang_password} <input name="password" type="Password"><br>
    	<input type="submit" value="${lang_log_in}">
    </form>
    <c:if test="${notlogged}">
    <br>
    	${lang_incorrect}.
    <br>
    </c:if>
    <jsp:include page="footer.jsp"/>
</body>
</html>