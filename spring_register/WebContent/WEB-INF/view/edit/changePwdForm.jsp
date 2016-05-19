<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
	<title></title>
</head>
<body>
	<form:form>
	<p>
		<label>현재비밀번호:<br>
		<form:password path="currentPassword" />
		<form:errors path="currentPassword"/>
		</label>
	</p>
	<p>
		<label>새로운비빌번호:<br>
		<form:password path="newPassword" />
		<form:errors path="newPassword"/>
		</label>
	</p>
	<input type="submit" value="변경">
	</form:form>
</body>
</html>