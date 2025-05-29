<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="jakarta.servlet.*"%>
<%@page import="jakarta.servlet.https.*"%>
<%@page import="java.util.Objects"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<% String[] msg = (String[])request.getAttribute("msg"); %>

    <%!
    boolean jud = false;
    String errMsg;
    %>
    
    <%
    if(msg != null){
        for(int i=0; i < msg.length; i++){
            if(msg[i] != null) {
                    errMsg = msg[i];
    %>
        <span style="color:red"><%= errMsg %></span>
        <br>
    <%
            }
        }
    }
    %>


<%
String name = (String)request.getAttribute("name");
String age = (String)request.getAttribute("age");
%>


    <form action="InputCheck" method="post">
    名前:<input type="text" name="name"
    value="<c:if test="${name != null}"><c:out value="name" /></c:if>">

        <br>
    年齢:<input type="text" name="age"

    <%
    if(msg != null){
        if(msg[1] == null){
    %>

    value="<%= age == null ? "" : age %>" style="width: 60px;">

    <%
        }
    }else{
    %>

    value="">

    <%
    }
    %>
    
    <br>
        <input type="submit" value="確定">
    </form>