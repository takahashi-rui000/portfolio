<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="address.User" %>
<%
if(session.getAttribute("user") == null) {
	response.sendRedirect("login.jsp");
	return;
}
String str = "";
if(request.getAttribute("like") != null) {
	str = (String)request.getAttribute("like");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<% //User user = null; %>
<style>
	.container{
		width: 600px;
		margin:0 auto;
	}
	p {
		font-size: 24px;
		text-align: center;
		font-weight: bold;
	}
	#search {
		width: 100%;
	}
	#search tr:nth-child(1) td:nth-child(1){
	text-align: right;
	}
	#search tr:nth-child(2){
		text-align: center;
	}
	
	#value {
		width: 100%;
	}
</style>
</head>
<body>
	<div class="container">
		<p>検索</p>
		<table border="1" id="search">
			<form action="Search" method="post">
				<tr>
					<td>名前：</td>
					<td><input name="like" type="text" value=<%= str %>></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit"></td>
				</tr>
			</form>
		</table>
		
		<p>検索結果</p>
		
		<jsp:include page="userList.jsp" />
		<a href="index.jsp">トップメニューへ</a>
	</div>
</body>
</html>