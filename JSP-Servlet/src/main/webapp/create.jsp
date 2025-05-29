<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%!
ArrayList  errorMessage = null;
%>
<%
if(session.getAttribute("user") == null) {
	response.sendRedirect("login.jsp");
	return;
}
try{
	if(request.getAttribute("create_errorMessage") != null){
		errorMessage = (ArrayList<String>)request.getAttribute("create_errorMessage");
//		for(int i=0; i<errorMessage.size(); i++) {
//			System.out.println(errorMessage.get(i));
//		}
	}
}catch(Exception e){
	e.printStackTrace();
}
String loginId = "";
String password = "";
String name = "";
String age = "";
String comment = "";
if(request.getAttribute("inpLogId") != null) {
	loginId = (String)request.getAttribute("inpLogId");
}
if(request.getAttribute("inpPas") != null) {
	password = (String)request.getAttribute("inpPas");
}
if(request.getAttribute("inpNam") != null) {
	name = (String)request.getAttribute("inpNam");
}
if(request.getAttribute("inpAge") != null) {
	age = (String)request.getAttribute("inpAge");
}
if(request.getAttribute("inpComm") != null) {
	comment = (String)request.getAttribute("inpComm");
}
%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	</head>
		<style>
		.wrapper {
			width: 500px;
			margin:0 auto;
		}
		.container {
			width: 400px;
			margin: 0 auto;
			text-align: center;
		}
		.menu {
			display: flex;
			width: 300;
			flex-direction: column;
		}
		label {
			width: 100px;
			text-align: right;
			display: inline-block;
		}
		input[type="submit"] {
			width: 80px;
		}
		#error {
		color: red;
			text-align: left;
		}
		</style>
	</head>
	<body>
		<div class="wrapper">
			<div class="container">
				<h3>新規作成</h3>
				<form action="Create" method="post">
				<div id="error">
					<%
					if(errorMessage != null){
						for(int i=0; i < errorMessage.size(); i++){
							%>
								<div class="error"><%=errorMessage.get(i) %></div>
							<%
						}
					}
					%>
					<br>
				</div>
					<label>ログインID：</label><input type="text" name="loginId" value="<%=loginId %>" required><br>
					<label>パスワード：</label><input type="password" name="password" value="<%=password%>" required><br>
					<label>名前：</label><input type="text" name="name" value="<%=name%>" required><br>
					<label>年齢：</label><input type="text" name="age" value="<%=age%>" required><br>
					<label>コメント：</label><input type="text" name="comment" value="<%=comment%>" required><br>
					<input type="submit" value="登録"><br>
				</form>
			</div>
			<a href="index.jsp" class="return">トップページへ</a>
		</div>
	</body>
</html>