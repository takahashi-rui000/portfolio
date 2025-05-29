<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="address.User"%>
<%! User user;%>
<%
try{
	if(session.getAttribute("user") != null){
		user = (User)session.getAttribute("user");
	}else {
		//response.sendRedirect("login.jsp");
		%>
		<jsp:forward page="login.jsp" />
		<%
	}
}catch(Exception e){
	e.getMessage();
}

%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>index</title>
		<style>
		.container {
			width: 500px;
			margin: 0 auto;
			text-align: center;
		}
		.menu {
			display: flex;
			flex-direction: column;
		}
		.welcome {
			position: absolute;
			top: 10px;
			left: 30px;
			text-decoration: none;
			color: black;
			font-weight: bold;
		}
		</style>
	</head>
		<body>
		<div class="container">
			<p class="welcome"><%=user.getName()%>さん、ようこそ！</p>
			<h3>ユーザー管理システム</h3>
			<br>
			<div class="menu">
				<a href="create.jsp">新規作成</a>
				<a href="ListAll">一覧表示</a>
				<a href="search.jsp">検索</a>
			</div>
		</div>
	</body>
</html>