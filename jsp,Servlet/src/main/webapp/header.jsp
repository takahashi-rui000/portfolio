<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="jakarta.servlet.http.HttpSession"%>

<% String name = request.getParameter("name"); %>
<%
int age = -1;
if(session.getAttribute("age") != null){
	age = Integer.parseInt((String)session.getAttribute("age")); 
}
int count = 0;
Cookie[] cookies = request.getCookies();
for(int i=0; i < cookies.length; i++){
	if("count".equals(cookies[i].getName())){
		count = Integer.parseInt(cookies[i].getValue()) + 1;
		cookies[i].setValue(String.valueOf(count));
        response.addCookie(cookies[i]);
	}
}
%>

<FONT SIZE="+2" style="margin-right: 200px;"><b>出席管理システム(<%=count %>回)</b></FONT>
ログイン者:${param.name}(${user.age})


<HR>