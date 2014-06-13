<%@taglib prefix="my" uri="/WEB-INF/mytag.tld"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${lang_hospital}</title>
</head>
<body>

<a href = "/Task4_Hospital/">${lang_main}</a><br>

${lang_disc_patients}:<br>

<my:discharged listName="discharged"/>

<jsp:include page="footer.jsp"/>

</body>
</html>