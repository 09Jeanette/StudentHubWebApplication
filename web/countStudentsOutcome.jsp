<%-- 
    Document   : countStudentsOutcome
    Created on : 09 Jun 2024, 7:29:44 PM
    Author     : Jeanette
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>number of students Page</title>
    </head>
    <body>
        <h1>Hello !</h1>
        
        <%
        
        int cnt = (Integer)request.getAttribute("cnt");
        %>
        
        <p>The number of students in the database is <%=cnt%>.<br>
            Click <a href="menu.html">here</a> to go back to the main page.</p>
    </body>
</html>
