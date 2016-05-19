<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
$(document).ready(function() {
   
    
     jQuery.ajax({
           type:"GET",
           url:"json_list",
           dataType:"JSON", // 옵션이므로 JSON으로 받을게 아니면 안써도 됨
           success : function(data) {
                 // 통신이 성공적으로 이루어졌을 때 이 함수를 타게 된다.
                 // TODO
         
         $.each(data, function(index, entry) {
             var html ='';
           html+= '<tr>';
            html+='<td>'+entry.seq+'</td>';
            html +='<td><a href="board_detail'+entry.seq+'">'+entry.title+'</a></td>';
            html+= '<td>'+entry.writer+'</td>';
            html += '<td>'+entry.hitcount+'</td>';
            html += '<td>'+entry.regdate +'</td>';         
            html+='</tr>';
         
            
            
         $('table').append(html);
            
         });
               
           },
          error : function(xhr, status, error) {
                 alert("에러발생");
           }
     });
});
</script>
</head>
<body>
	<h3>게시판 목록</h3>
	<table border="1">
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>조회수</td>
			<td>등록일</td>
		</tr>
	<!--  
		<c:forEach var="board" items="${list }">
		<tr>
			<td>${board.seq }</td>
			<td><a href="board_detail${board.seq }">${board.title }</a></td>
			<td>${board.writer }</td>
			<td>${board.hitcount }</td>
			<td>${board.regdate }</td>
		</tr>
		</c:forEach>
		-->	
	</table>
</body>
</html>