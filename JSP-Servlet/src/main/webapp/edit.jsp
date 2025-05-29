<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.Connection, java.sql.DriverManager, java.sql.PreparedStatement, java.sql.ResultSet, java.sql.SQLException"%>
<%@ page import="address.User" %>
<%@ page import="dao.UserDAO" %>
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
	width: 300px;
}
#heading{
	text-align: center;
	font-weight: bold;
}
form {
	text-align: center;
}
label {
	width: 44%;
	text-align: right;
}
.item {
	height: 25px;
	width: 100%;
	display: flex;
}
input[type="text"], input[type="password"] {
	width: 56%;
}
input[type="submit"] {
	margin: 0 auto;
	text-align: center;
}
</style>
</head>
<body>
	<div class="container">
		<p id="heading">更新</p>
	    <%
		int inpId = Integer.parseInt(request.getParameter("id"));
	    UserDAO ud = new UserDAO();
	    User u = ud.getUser(inpId);
		%>
		<form action="Update?id=<%=inpId %>" method="post">
			<div class="item">
				<label>ログインID:</label>
				<input name="loginId" type="text" value="<%=u.getLoginId()%>"><br>
			</div>
			<div class="item">
				<label>パスワード:</label>
				<input name="password" type="password" value="<%=u.getPassword()%>"><br>
			</div>
			<div class="item">
				<label>名前:</label>
				<input name="name" type="text" value="<%=u.getName()%>"><br>
			</div>
			<div class="item">
				<label>年齢:</label>
				<input name="age" type="text" value="<%=u.getAge()%>"><br>
			</div>
			<div class="item">
				<label>コメント:</label>
				<input name="comment" type="text" value="<%=u.getComment()%>"><br>
			</div>
			<input type="submit">
			
		</form>
		<br>
		<a href="index.jsp">トップページへ戻る</p>
	</div>
</body>
</html>