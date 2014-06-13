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
<form method ='POST' action = '/Task4_Hospital/submituser'>
	${lang_login}<input name="login" type="text"><br>
	${lang_password} <input name="password" type="Password"><br>
	${lang_rep_pass} <input name="repassword" type="Password"><br>
	${lang_select_role}<br>
	<select name ="role">
	<option  value = "1">${lang_nurse}</option>
	<option  value = "2">${lang_doctor}</option>
	</select>
    <input type="submit" value='${lang_registration}'>
</form>
<jsp:include page="footer.jsp"/>
</body>
</html>