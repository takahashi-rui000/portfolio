<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	p{
		font-weight: bold;
	}
</style>
</head>
<body>
	<div class="container">
		<%
		if(true){
		%>
		<p>データが削除されました。</p>
		<%
		}else{
		%>
		<p>削除に失敗しました。</p>
		<%
		}
		%>
		<a href="index.jsp">トップメニューへ</a>
	</div>
</body>
</html>