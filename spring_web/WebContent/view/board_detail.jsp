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
<script type="text/javascript">
	function fn_update() {
		location.href="update_form${board.seq}"
	}
	function fn_delete() {
		location.href="delete_form${board.seq}"
	}
</script>
</head>
<body>
<form>
   <h3>게시판 목록</h3>
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
         <td>${board.contents }</td>
      </tr>
      <tr>
         <td>작성일</td>
         <td>${fn:substring(board.regdate,0,10 )}</td>
      </tr>      
    </table>
   	  <tr>
   		<td><input type="button" value="수정" onclick="fn_update()"></td>
   		<td><input type="button" value="삭제" onclick="fn_delete()"></td>
   	  </tr>
  
</form>
</body>
</html>






