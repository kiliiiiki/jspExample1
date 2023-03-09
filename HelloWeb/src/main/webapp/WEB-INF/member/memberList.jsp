
<%@page import="co.dev.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<jsp:include page="../includes/sidebar.jsp"></jsp:include>
<jsp:include page="../includes/top.jsp"></jsp:include>

	
	<%
	//자바영역
		List<MemberVO> list = (List<MemberVO>)request.getAttribute("members"); //list 주소값 반환
		System.out.print(list);
	%>
	<table class="table">
		<thead>
		<tr><th>Id</th><th>Name</th><th>Pass</th><th>Mail</th></tr>
		</thead>
		<tbody>
	<%
		for(MemberVO member : list){
	%>
		<tr><td><a href='memberSearch.do?job=search&id=<%=member.getId() %>'><%=member.getId() %></a></td>
			<td><%=member.getName() %></td>
			<td><%=member.getPasswd() %></td>
			<td><%=member.getMail() %></td></tr>
	<%
		}
	%>
		</tbody>
	</table>
	
	<p>회원등록으로 이동</p>
	<a href = "memberInsertForm.do">회원등록이동</a>
	
	<%@ include file = "../includes/footer.jsp" %>

