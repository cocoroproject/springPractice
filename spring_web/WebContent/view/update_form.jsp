<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="update_board" method="post">
   <h3>수정 하기</h3>
   <table border="1">
      <tr>
         <td>번호</td>
         <td>${board.seq }</td>
      </tr>
      <tr>
         <td>제목</td>
         <td>${board.title }</td>
      </tr>
      <tr>
         <td>작성자</td>
         <td>${board.writer }</td>
      </tr>
      <tr>
         <td>조회수</td>
         <td>${board.hitcount }</td>
      </tr>
      <tr>
         <td>내용</td>
         <td><textarea rows="6" cols="70" name="contents">${board.contents }</textarea></td>
      </tr>
      <tr>
         <td>작성일</td>
         <td>${fn:substring(board.regdate,0,10 )}</td>
      </tr>      
    </table>
    <input type="hidden" value="${board.seq}" name="seq">
    <input type="submit" value="수정완료">
</form>
</body>
</html>