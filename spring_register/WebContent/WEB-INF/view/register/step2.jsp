<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>ȸ�� ���� �Է�</h2>
		
	<form:form action="step3"  commandName="registerRequest">
		<p>
			<label>�̸���:</label>
			<form:input path="email"/>
			<form:errors path="email"/>
		</p>
		<p>
			<label>�̸�:</label>
			<form:input path="name"/>
			<form:errors path="name"/>
		</p>
		<p>
			<label>��й�ȣ</label>
			<form:password path="password"/>
			<form:errors path="password"/>
		</p>
		<p>
			<label>��й�ȣȮ��</label>
			<form:password path="confirmPassword"/>
			<form:errors path="confirmPassword"/>
		</p>
		<input type="submit" value="���ԿϷ�">
	</form:form>
</body>
</html>








