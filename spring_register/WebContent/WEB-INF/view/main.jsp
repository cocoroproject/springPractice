<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${empty authInfo }">
		<p>환영합니다.</p>
		<p>
			<a href="<c:url value="/register/step1"></c:url>">[회원가입하기]</a>
			<a href="<c:url value="/login"></c:url>">[로그인]</a>
			<a href="<c:url value="/member/list"></c:url>">[목록보기]</a>
		</p>
	</c:if>
	
	<c:if test="${! empty authInfo }">
		<p>${authInfo.name }님 환영합니다.</p>
		<p>
			<a href='<c:url value="/logout"></c:url>'>[로그아웃]</a>
			<a href='<c:url value="/edit/changePassword"></c:url>'>[비밀번호변경]</a>
		</p>
	</c:if>
	
	
</body>
</html>










