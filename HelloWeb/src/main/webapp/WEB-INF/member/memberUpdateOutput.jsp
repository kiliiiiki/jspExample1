<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정결과</title>
</head>
<body>
	<h3>회원정보수정결과</h3>
	<%
		String message = (String) request.getAttribute("message");
	%>
	<%
		if(message != null){
	%>
		<p><%=message %></p>
	<%
		}
	%>
	<p>회원목록으로 이동</p>
	<a href="memberlist.do">회원목록이동</a>
</body>
</html>