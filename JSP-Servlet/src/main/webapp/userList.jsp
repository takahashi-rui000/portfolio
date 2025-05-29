<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.Connection, java.sql.DriverManager, java.sql.PreparedStatement, java.sql.ResultSet, java.sql.SQLException"%>
<%@ page import="dao.UserDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="address.User" %>

<%
if(session.getAttribute("user") == null || request.getAttribute("like") == null) {
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
	table {
		width: 100%;
	}
	td:nth-child(5) {
	text-align: center;
	}
</style>
</head>
<body>
	<div class="container">
	    <table border="1">
	    	<th>ログインID</th>
	    	<th>名前</th>
	    	<th>年齢</th>
	    	<th>コメント</th>
	    	<th>削除</th>
		    <%
			try {
				UserDAO ud = new UserDAO();
				List<User> users = ud.search((String)request.getAttribute("like"));
				for (User u : users) {
					%> <tr>
						<td><a href="Edit?id=<%=u.getId() %>">
						<%=u.getLoginId()%></a></td><%
						%><td><%=u.getName()%></td><%
						%><td><%=u.getAge()%></td><%
						%><td><%=u.getComment()%></td><%
						%><td><a href="Confirm?id=<%=u.getId()%>">削除</a></td><%
					%> </tr> <%
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		    %>
	    </table>
	</div>
</body>
</html>