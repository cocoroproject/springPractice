<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
	<title></title>
</head>
<body>
	<form:form commandName="loginCommand">
	<form:errors />
	<p>		
		이메일: <form:input path="email" />
		<form:errors path="email"/>		
	</p>
	<p>		
		비밀번호: <form:password path="password" />
		<form:errors path="password"/>
		
	</p>
	<p>		
		<form:checkbox path="rememberEmail"/> 		
	</p>
	<input type="submit" value="로그인">
	</form:form>
</body>
</html>