<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@include file="header.jsp"%>
<%!
	static final String DATE_FORMAT="yyyy年MM月dd日hh時mm分ss秒";
	String getCurrentTime() {
	SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
	Date now = new Date();
	return sdf.format(now);
}
%>
<%

%>

<HTML>
    <BODY>
    	ログイン回数:${sessionScope.loginCount}<br>
        現在は<B><%= getCurrentTime() %></B>です。<br>
        <form action="<%= response.encodeURL("now.jsp") %>" method = "post">
			<input type="hidden" name = "name" value = <%= request.getParameter("name") %>>
			<input type="submit" value = "更新">
		</form>
		
		<a href="<%= response.encodeURL("now.jsp") %>?name=<%= request.getParameter("name") %>">更新</a>
		<br>
		<a href="./name.jsp">入力ページへ戻る</a>

    </BODY>
</HTML>


