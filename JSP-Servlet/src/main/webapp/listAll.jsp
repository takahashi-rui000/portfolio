<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.Connection, java.sql.DriverManager, java.sql.PreparedStatement, java.sql.ResultSet, java.sql.SQLException"%>
<%@ page import="dao.UserDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="address.User" %>

<%
if(session.getAttribute("user") == null) {
	response.sendRedirect("login.jsp");
	return;
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.container {
	width: 675px;
	margin:0 auto;
}
#top {
	text-align: center;
	font-weight: bold;
	font-size: 20px;
}
th:nth-child(1) {
	width: 150px;
}
td:nth-child(2) {
	width: 100px;
}
th:nth-child(3) {
	width: 100px;
}
th:nth-child(4) {
	width: 200px;
}
th:nth-child(5) {
	width: 75px;
}
td:nth-child(5) {
	text-align: center;
}
</style>
</head>
<body>
	<div class="container">
		<p id="top">
			一覧表示
		</p>
		<%
    	request.setAttribute("includeSource", "listAll");
    	request.setAttribute("like", "");
		%>
		<jsp:include page="userList.jsp" />
		<a href="index.jsp">トップメニューへ</a>
	</div>
</body>
</html>