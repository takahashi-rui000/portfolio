<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>

<%!
ArrayList  errorMessage = null;
%>
<%

if(session.getAttribute("user") != null) {
	response.sendRedirect("index.jsp");
	return;
}
try{
	if(request.getAttribute("errorMessage") != null){
		errorMessage = (ArrayList<String>)request.getAttribute("errorMessage");
	}
}catch(Exception e){
	e.printStackTrace();
} 
%>
<!DOCTYPE html>
<html>
<head>
<style>
.container {
	width: 500px;
	margin: 0 auto;
	text-align: center;
}
strong {
	margin-left: 90px;
}
input[type="text"], input[type="password"] {
	width: 100px;
}
input[type="submit"] {
margin-left: 90px;
}
.error {
	color: red;
	font-weight: bold;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<form action="Login" method="post">
		
		<%
		if(errorMessage != null){
			for(int i=0; i < errorMessage.size(); i++){
				%>
					<div class="error"><%=errorMessage.get(i) %></div>
				<%
			}
		}
		%>
			<strong>ログイン</strong><br>
			ログインID:<input type="text" name="loginId"><br>
			パスワード:<input type="password" name="password"><br>
			<input type="submit" value="ログイン">
		</form>
	</div>
</body>
</html>