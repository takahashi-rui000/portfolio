<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<style>
	
	.container{
		width: 375px;
	}
	p {
		text-align: center;
		font-weight: bold;
	}
	table td:nth-child(1){
		width: 100px;
	}
	table td:nth-child(2){
		width: 50px;
	}
	table td:nth-child(3){
		width: 50px;
	}
	table td:nth-child(4){
		width: 150px;
	}
	table tr:nth-child(3){
		text-align: center;
	}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<p>以下のデータを削除してもよろしいですか？</p>
		<table border="1">
			<tr>
				<th>ログインID</th>
				<th>名前</th>
				<th>年齢</th>
				<th>コメント</th>
			</tr>
			<tr>
		    <%
			int inpId = Integer.parseInt(request.getParameter("id"));
			UserDAO ud = new UserDAO();
			User u = ud.getUser(inpId);
			%>
			<td><%=u.getLoginId()%></td>
			<td><%=u.getName()%></td>
			<td><%=u.getAge()%></td>
			<td><%=u.getComment()%></td>
			<%
			%>
			</tr>
			<tr>
				<td colspan="4">
					<form action="Delete?id=<%=inpId %>" method="post">
						<input type="submit" value="削除">
					</form>
				</td>
			</tr>
		</table>
		<a href="index.jsp">トップメニューへ</a>
	</div>
</body>
</html>